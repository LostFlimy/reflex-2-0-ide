package ru.iaie.reflex.generator.r2c.common

import org.eclipse.emf.ecore.EObject
import ru.iaie.reflex.reflex.Expression
import ru.iaie.reflex.reflex.IfElseStat
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.ResetStat
import ru.iaie.reflex.reflex.RestartStat
import ru.iaie.reflex.reflex.SetStateStat
import ru.iaie.reflex.reflex.StartProcStat
import ru.iaie.reflex.reflex.State
import ru.iaie.reflex.reflex.StopProcStat
import ru.iaie.reflex.reflex.SwitchStat
import ru.iaie.reflex.reflex.TimeoutFunction

import static extension ru.iaie.reflex.utils.ReflexModelUtil.*

import ru.iaie.reflex.reflex.CompoundStatement
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper
import ru.iaie.reflex.generator.r2c.helpers.ExpressionGenerationHelper
import ru.iaie.reflex.generator.r2c.util.LiteralGenerationUtil

class ProcessGenerator {

	Process proc
	IReflexIdentifiersHelper identifiersHelper
	ExpressionGenerationHelper expressionGenerator
	
	new(Process process, IReflexIdentifiersHelper identifiersHelper) {
		this.proc = process
		this.identifiersHelper = identifiersHelper
		expressionGenerator = new ExpressionGenerationHelper(identifiersHelper)
	}

	def generate() {
		return '''
			void «identifiersHelper.getProcessFuncId(proc)»() { /* Process: «proc.name» */
				switch («proc.name»_state) {
					«FOR state : proc.states»
						«translateState(state)»
					«ENDFOR»
				}
			}
		'''
	}

	def translateState(State state) {
		return '''
			case «state.name»: { /* State: «state.name» */
				«FOR stat : state.stateFunction.statements»
					«translateStatement(state, stat)»
				«ENDFOR»
				«IF state.timeoutFunction !== null »
					«translateTimeoutFunction(proc, state, state.timeoutFunction)»
				«ENDIF»
				break;
			}
		'''
	}

	def translateTimeoutFunction(Process proc, State state, TimeoutFunction func) {
		return '''
			if (timeout(«proc.name», «translateTimeout(func)»))
				«translateStatement(state, func.body)»
		'''
	}

	def translateTimeout(TimeoutFunction func) {
		if(func.isClearTimeout) return LiteralGenerationUtil.translateTime(func.time)
		if(func.isReferencedTimeout) identifiersHelper.getMapping(func.ref);
	}

	def String translateStatement(State state, EObject statement) {
		switch statement {
			StopProcStat:
				return translateStopProcStat(statement)
			SetStateStat:
				return translateSetStateStat(state, statement)
			IfElseStat:
				return translateIfElseStat(state, statement)
			Expression:
				return '''«expressionGenerator.translateExpr(statement)»;'''
			SwitchStat:
				return translateSwitchCaseStat(state, statement)
			StartProcStat:
				return translateStartProcStat(statement)
			ResetStat:
				return translateResetTimer()
			RestartStat:
				return translateRestartProcStat()
			CompoundStatement:
				return ''' 
					{
					«FOR stat : statement.statements»
						«translateStatement(state, stat)»
					«ENDFOR»
					}
				'''
		}
	}

	def translateIfElseStat(State state, IfElseStat stat) {
		return '''
			if («expressionGenerator.translateExpr(stat.cond)») 
				«translateStatement(state, stat.then)»
			«IF stat.getElse !== null»	
				else «translateStatement(state, stat.getElse)»
			«ENDIF»
		'''
	}

	def translateSwitchCaseStat(State state, SwitchStat stat) {
		return '''
			switch («expressionGenerator.translateExpr(stat.expr)») {
				«FOR variant : stat.options»
					case («expressionGenerator.translateExpr(variant.option)»): {
						«FOR statement: variant.statements» 
							«translateStatement(state, statement)»
						«ENDFOR»
						«IF variant.hasBreak»break;«ENDIF»
						}
				«ENDFOR»
				«IF stat.hasDefaultOption»default: {
						«FOR statement: stat.defaultOption.statements» 
							«translateStatement(state, statement)»
						«ENDFOR»
						«IF stat.defaultOption.hasBreak»break;«ENDIF»
					}
				«ENDIF»
			}
		'''
	}

	def translateResetTimer() {
		return '''«proc.name»_time = _r_cur_time;'''
	}

	def translateSetStateStat(State state, SetStateStat sss) {
		if (sss.isNext) {
			return '''
			«proc.name»_state = «proc.getStates().get(state.index + 1).name»;
			«proc.name»_time = _r_cur_time;
			'''
		}
		return '''
		«proc.name»_state = «sss.state.name»);
		«proc.name»_time = _r_cur_time;
		'''
	}

	def translateStopProcStat(StopProcStat sps) {
		val procToStop = sps.selfStop ? proc : sps.process
		return '''
			«procToStop.name»_state = STOP;
		'''
	}

	def translateStartProcStat(StartProcStat sps) {
		return '''
			«sps.process.name»_state = START;
			«sps.process.name»_time = _r_cur_time;
		'''
	}

	def translateRestartProcStat() {
		return '''
			«proc.name»_state = START;
		'''
	}
}
