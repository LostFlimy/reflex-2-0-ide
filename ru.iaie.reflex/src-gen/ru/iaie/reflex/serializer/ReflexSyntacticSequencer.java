/*
 * generated by Xtext 2.29.0
 */
package ru.iaie.reflex.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import ru.iaie.reflex.services.ReflexGrammarAccess;

@SuppressWarnings("all")
public class ReflexSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ReflexGrammarAccess grammarAccess;
	protected AbstractElementAlias match_TimeoutFunction_LeftParenthesisKeyword_1_1_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ReflexGrammarAccess) access;
		match_TimeoutFunction_LeftParenthesisKeyword_1_1_0_q = new TokenAlias(false, true, grammarAccess.getTimeoutFunctionAccess().getLeftParenthesisKeyword_1_1_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getBIT_ANDRule())
			return getBIT_ANDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getBIT_ORRule())
			return getBIT_ORToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getBIT_XORRule())
			return getBIT_XORToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getBreakStatRule())
			return getBreakStatToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getLOGICAL_ANDRule())
			return getLOGICAL_ANDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getLOGICAL_ORRule())
			return getLOGICAL_ORToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal BIT_AND:
	 * 	"&";
	 */
	protected String getBIT_ANDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "&";
	}
	
	/**
	 * terminal BIT_OR:
	 * 	"|";
	 */
	protected String getBIT_ORToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "|";
	}
	
	/**
	 * terminal BIT_XOR:
	 * 	"^";
	 */
	protected String getBIT_XORToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "^";
	}
	
	/**
	 * BreakStat:
	 * 	"break" ";";
	 */
	protected String getBreakStatToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "break ;";
	}
	
	/**
	 * terminal LOGICAL_AND:
	 * 	"&&";
	 */
	protected String getLOGICAL_ANDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "&&";
	}
	
	/**
	 * terminal LOGICAL_OR:
	 * 	"||";
	 */
	protected String getLOGICAL_ORToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "||";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_TimeoutFunction_LeftParenthesisKeyword_1_1_0_q.equals(syntax))
				emit_TimeoutFunction_LeftParenthesisKeyword_1_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'timeout' (ambiguity) intTime=INTEGER
	 *     (rule start) 'timeout' (ambiguity) ref=[IdReference|ID]
	 *     (rule start) 'timeout' (ambiguity) time=TIME
	 
	 * </pre>
	 */
	protected void emit_TimeoutFunction_LeftParenthesisKeyword_1_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}