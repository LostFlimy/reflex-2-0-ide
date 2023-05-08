package ru.iaie.reflex.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ru.iaie.reflex.services.ReflexGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalReflexParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGER", "RULE_TIME", "RULE_STRING", "RULE_FLOAT", "RULE_BOOL_LITERAL", "RULE_BIT_AND", "RULE_BIT_XOR", "RULE_BIT_OR", "RULE_LOGICAL_AND", "RULE_LOGICAL_OR", "RULE_SIGN", "RULE_HEX", "RULE_OCTAL", "RULE_DECIMAL", "RULE_LONG", "RULE_UNSIGNED", "RULE_DEC_FLOAT", "RULE_HEX_FLOAT", "RULE_DEC_SEQUENCE", "RULE_EXPONENT", "RULE_FLOAT_SUFFIX", "RULE_HEX_SEQUENCE", "RULE_BIN_EXPONENT", "RULE_HEX_PREFIX", "RULE_DAY", "RULE_HOUR", "RULE_MINUTE", "RULE_SECOND", "RULE_MILLISECOND", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'program'", "'{'", "'}'", "'clock'", "';'", "'process'", "'interrupted'", "'state'", "'looped'", "':'", "'.'", "'shared'", "','", "'from'", "'='", "'timeout'", "'('", "')'", "'vector'", "'bit'", "'register'", "'const'", "'enum'", "'if'", "'else'", "'switch'", "'case'", "'default'", "'break'", "'start'", "'stop'", "'error'", "'restart'", "'reset'", "'timer'", "'set'", "'next'", "'in'", "'input'", "'output'", "'active'", "'inactive'", "'++'", "'--'", "'*='", "'/='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'+'", "'-'", "'~'", "'!'", "'<'", "'>'", "'=<'", "'>='", "'=='", "'!='", "'>>'", "'<<'", "'*'", "'/'", "'%'", "'void'", "'float'", "'double'", "'int8'", "'uint8'", "'int16'", "'uint16'", "'int32'", "'uint32'", "'int64'", "'uint64'", "'bool'", "'time'"
    };
    public static final int RULE_HEX=16;
    public static final int T__50=50;
    public static final int RULE_SIGN=15;
    public static final int RULE_DEC_SEQUENCE=23;
    public static final int RULE_MINUTE=31;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RULE_TIME=6;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_HEX_FLOAT=22;
    public static final int RULE_INT=34;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=35;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__39=39;
    public static final int RULE_MILLISECOND=33;
    public static final int RULE_HEX_SEQUENCE=26;
    public static final int RULE_HOUR=30;
    public static final int RULE_UNSIGNED=20;
    public static final int RULE_BOOL_LITERAL=9;
    public static final int RULE_BIN_EXPONENT=27;
    public static final int RULE_LOGICAL_AND=13;
    public static final int RULE_EXPONENT=24;
    public static final int T__48=48;
    public static final int RULE_DEC_FLOAT=21;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=8;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int RULE_BIT_AND=10;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int RULE_DAY=29;
    public static final int T__90=90;
    public static final int RULE_OCTAL=17;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DECIMAL=18;
    public static final int RULE_SECOND=32;
    public static final int RULE_LOGICAL_OR=14;
    public static final int RULE_FLOAT_SUFFIX=25;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__120=120;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=36;
    public static final int RULE_HEX_PREFIX=28;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=37;
    public static final int RULE_ANY_OTHER=38;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int RULE_BIT_XOR=11;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_BIT_OR=12;
    public static final int RULE_LONG=19;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=5;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalReflexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReflexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReflexParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReflex.g"; }



     	private ReflexGrammarAccess grammarAccess;

        public InternalReflexParser(TokenStream input, ReflexGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Program";
       	}

       	@Override
       	protected ReflexGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgram"
    // InternalReflex.g:65:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalReflex.g:65:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalReflex.g:66:2: iv_ruleProgram= ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgram; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalReflex.g:72:1: ruleProgram returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_vectors_12_0= ruleVector ) ) | ( (lv_registers_13_0= ruleRegister ) ) | ( (lv_bits_14_0= ruleBit ) ) | ( (lv_processes_15_0= ruleProcess ) ) )* otherlv_16= '}' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_16=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_clock_6_0 = null;

        EObject lv_consts_7_0 = null;

        EObject lv_enums_8_0 = null;

        EObject lv_functions_9_0 = null;

        EObject lv_globalVars_10_0 = null;

        EObject lv_ports_11_0 = null;

        EObject lv_vectors_12_0 = null;

        EObject lv_registers_13_0 = null;

        EObject lv_bits_14_0 = null;

        EObject lv_processes_15_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:78:2: ( ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_vectors_12_0= ruleVector ) ) | ( (lv_registers_13_0= ruleRegister ) ) | ( (lv_bits_14_0= ruleBit ) ) | ( (lv_processes_15_0= ruleProcess ) ) )* otherlv_16= '}' ) )
            // InternalReflex.g:79:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_vectors_12_0= ruleVector ) ) | ( (lv_registers_13_0= ruleRegister ) ) | ( (lv_bits_14_0= ruleBit ) ) | ( (lv_processes_15_0= ruleProcess ) ) )* otherlv_16= '}' )
            {
            // InternalReflex.g:79:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_vectors_12_0= ruleVector ) ) | ( (lv_registers_13_0= ruleRegister ) ) | ( (lv_bits_14_0= ruleBit ) ) | ( (lv_processes_15_0= ruleProcess ) ) )* otherlv_16= '}' )
            // InternalReflex.g:80:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_vectors_12_0= ruleVector ) ) | ( (lv_registers_13_0= ruleRegister ) ) | ( (lv_bits_14_0= ruleBit ) ) | ( (lv_processes_15_0= ruleProcess ) ) )* otherlv_16= '}'
            {
            // InternalReflex.g:80:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==39) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalReflex.g:81:4: otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']'
            	    {
            	    otherlv_0=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_0, grammarAccess.getProgramAccess().getLeftSquareBracketKeyword_0_0());
            	      			
            	    }
            	    // InternalReflex.g:85:4: ( (lv_annotations_1_0= ruleAnnotation ) )
            	    // InternalReflex.g:86:5: (lv_annotations_1_0= ruleAnnotation )
            	    {
            	    // InternalReflex.g:86:5: (lv_annotations_1_0= ruleAnnotation )
            	    // InternalReflex.g:87:6: lv_annotations_1_0= ruleAnnotation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getAnnotationsAnnotationParserRuleCall_0_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_annotations_1_0=ruleAnnotation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"annotations",
            	      							lv_annotations_1_0,
            	      							"ru.iaie.reflex.Reflex.Annotation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getProgramAccess().getRightSquareBracketKeyword_0_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_3=(Token)match(input,41,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getProgramAccess().getProgramKeyword_1());
              		
            }
            // InternalReflex.g:113:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalReflex.g:114:4: (lv_name_4_0= RULE_ID )
            {
            // InternalReflex.g:114:4: (lv_name_4_0= RULE_ID )
            // InternalReflex.g:115:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getProgramAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProgramAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalReflex.g:135:3: ( (lv_clock_6_0= ruleClockDefinition ) )
            // InternalReflex.g:136:4: (lv_clock_6_0= ruleClockDefinition )
            {
            // InternalReflex.g:136:4: (lv_clock_6_0= ruleClockDefinition )
            // InternalReflex.g:137:5: lv_clock_6_0= ruleClockDefinition
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProgramAccess().getClockClockDefinitionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_clock_6_0=ruleClockDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProgramRule());
              					}
              					set(
              						current,
              						"clock",
              						lv_clock_6_0,
              						"ru.iaie.reflex.Reflex.ClockDefinition");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:154:3: ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_vectors_12_0= ruleVector ) ) | ( (lv_registers_13_0= ruleRegister ) ) | ( (lv_bits_14_0= ruleBit ) ) | ( (lv_processes_15_0= ruleProcess ) ) )*
            loop2:
            do {
                int alt2=10;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalReflex.g:155:4: ( (lv_consts_7_0= ruleConst ) )
            	    {
            	    // InternalReflex.g:155:4: ( (lv_consts_7_0= ruleConst ) )
            	    // InternalReflex.g:156:5: (lv_consts_7_0= ruleConst )
            	    {
            	    // InternalReflex.g:156:5: (lv_consts_7_0= ruleConst )
            	    // InternalReflex.g:157:6: lv_consts_7_0= ruleConst
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getConstsConstParserRuleCall_5_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_consts_7_0=ruleConst();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"consts",
            	      							lv_consts_7_0,
            	      							"ru.iaie.reflex.Reflex.Const");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalReflex.g:175:4: ( (lv_enums_8_0= ruleEnum ) )
            	    {
            	    // InternalReflex.g:175:4: ( (lv_enums_8_0= ruleEnum ) )
            	    // InternalReflex.g:176:5: (lv_enums_8_0= ruleEnum )
            	    {
            	    // InternalReflex.g:176:5: (lv_enums_8_0= ruleEnum )
            	    // InternalReflex.g:177:6: lv_enums_8_0= ruleEnum
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getEnumsEnumParserRuleCall_5_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_enums_8_0=ruleEnum();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enums",
            	      							lv_enums_8_0,
            	      							"ru.iaie.reflex.Reflex.Enum");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalReflex.g:195:4: ( (lv_functions_9_0= ruleFunction ) )
            	    {
            	    // InternalReflex.g:195:4: ( (lv_functions_9_0= ruleFunction ) )
            	    // InternalReflex.g:196:5: (lv_functions_9_0= ruleFunction )
            	    {
            	    // InternalReflex.g:196:5: (lv_functions_9_0= ruleFunction )
            	    // InternalReflex.g:197:6: lv_functions_9_0= ruleFunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getFunctionsFunctionParserRuleCall_5_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_functions_9_0=ruleFunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"functions",
            	      							lv_functions_9_0,
            	      							"ru.iaie.reflex.Reflex.Function");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalReflex.g:215:4: ( (lv_globalVars_10_0= ruleGlobalVariable ) )
            	    {
            	    // InternalReflex.g:215:4: ( (lv_globalVars_10_0= ruleGlobalVariable ) )
            	    // InternalReflex.g:216:5: (lv_globalVars_10_0= ruleGlobalVariable )
            	    {
            	    // InternalReflex.g:216:5: (lv_globalVars_10_0= ruleGlobalVariable )
            	    // InternalReflex.g:217:6: lv_globalVars_10_0= ruleGlobalVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getGlobalVarsGlobalVariableParserRuleCall_5_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_globalVars_10_0=ruleGlobalVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"globalVars",
            	      							lv_globalVars_10_0,
            	      							"ru.iaie.reflex.Reflex.GlobalVariable");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalReflex.g:235:4: ( (lv_ports_11_0= rulePort ) )
            	    {
            	    // InternalReflex.g:235:4: ( (lv_ports_11_0= rulePort ) )
            	    // InternalReflex.g:236:5: (lv_ports_11_0= rulePort )
            	    {
            	    // InternalReflex.g:236:5: (lv_ports_11_0= rulePort )
            	    // InternalReflex.g:237:6: lv_ports_11_0= rulePort
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getPortsPortParserRuleCall_5_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_ports_11_0=rulePort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"ports",
            	      							lv_ports_11_0,
            	      							"ru.iaie.reflex.Reflex.Port");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalReflex.g:255:4: ( (lv_vectors_12_0= ruleVector ) )
            	    {
            	    // InternalReflex.g:255:4: ( (lv_vectors_12_0= ruleVector ) )
            	    // InternalReflex.g:256:5: (lv_vectors_12_0= ruleVector )
            	    {
            	    // InternalReflex.g:256:5: (lv_vectors_12_0= ruleVector )
            	    // InternalReflex.g:257:6: lv_vectors_12_0= ruleVector
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getVectorsVectorParserRuleCall_5_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_vectors_12_0=ruleVector();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"vectors",
            	      							lv_vectors_12_0,
            	      							"ru.iaie.reflex.Reflex.Vector");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalReflex.g:275:4: ( (lv_registers_13_0= ruleRegister ) )
            	    {
            	    // InternalReflex.g:275:4: ( (lv_registers_13_0= ruleRegister ) )
            	    // InternalReflex.g:276:5: (lv_registers_13_0= ruleRegister )
            	    {
            	    // InternalReflex.g:276:5: (lv_registers_13_0= ruleRegister )
            	    // InternalReflex.g:277:6: lv_registers_13_0= ruleRegister
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getRegistersRegisterParserRuleCall_5_6_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_registers_13_0=ruleRegister();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"registers",
            	      							lv_registers_13_0,
            	      							"ru.iaie.reflex.Reflex.Register");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalReflex.g:295:4: ( (lv_bits_14_0= ruleBit ) )
            	    {
            	    // InternalReflex.g:295:4: ( (lv_bits_14_0= ruleBit ) )
            	    // InternalReflex.g:296:5: (lv_bits_14_0= ruleBit )
            	    {
            	    // InternalReflex.g:296:5: (lv_bits_14_0= ruleBit )
            	    // InternalReflex.g:297:6: lv_bits_14_0= ruleBit
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getBitsBitParserRuleCall_5_7_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_bits_14_0=ruleBit();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"bits",
            	      							lv_bits_14_0,
            	      							"ru.iaie.reflex.Reflex.Bit");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalReflex.g:315:4: ( (lv_processes_15_0= ruleProcess ) )
            	    {
            	    // InternalReflex.g:315:4: ( (lv_processes_15_0= ruleProcess ) )
            	    // InternalReflex.g:316:5: (lv_processes_15_0= ruleProcess )
            	    {
            	    // InternalReflex.g:316:5: (lv_processes_15_0= ruleProcess )
            	    // InternalReflex.g:317:6: lv_processes_15_0= ruleProcess
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getProcessesProcessParserRuleCall_5_8_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_processes_15_0=ruleProcess();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"processes",
            	      							lv_processes_15_0,
            	      							"ru.iaie.reflex.Reflex.Process");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_16=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_16, grammarAccess.getProgramAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleClockDefinition"
    // InternalReflex.g:343:1: entryRuleClockDefinition returns [EObject current=null] : iv_ruleClockDefinition= ruleClockDefinition EOF ;
    public final EObject entryRuleClockDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClockDefinition = null;


        try {
            // InternalReflex.g:343:56: (iv_ruleClockDefinition= ruleClockDefinition EOF )
            // InternalReflex.g:344:2: iv_ruleClockDefinition= ruleClockDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClockDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClockDefinition=ruleClockDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClockDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClockDefinition"


    // $ANTLR start "ruleClockDefinition"
    // InternalReflex.g:350:1: ruleClockDefinition returns [EObject current=null] : (otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';' ) ;
    public final EObject ruleClockDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_intValue_1_0=null;
        Token lv_timeValue_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:356:2: ( (otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';' ) )
            // InternalReflex.g:357:2: (otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:357:2: (otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';' )
            // InternalReflex.g:358:3: otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClockDefinitionAccess().getClockKeyword_0());
              		
            }
            // InternalReflex.g:362:3: ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INTEGER) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_TIME) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalReflex.g:363:4: ( (lv_intValue_1_0= RULE_INTEGER ) )
                    {
                    // InternalReflex.g:363:4: ( (lv_intValue_1_0= RULE_INTEGER ) )
                    // InternalReflex.g:364:5: (lv_intValue_1_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:364:5: (lv_intValue_1_0= RULE_INTEGER )
                    // InternalReflex.g:365:6: lv_intValue_1_0= RULE_INTEGER
                    {
                    lv_intValue_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_intValue_1_0, grammarAccess.getClockDefinitionAccess().getIntValueINTEGERTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getClockDefinitionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"intValue",
                      							lv_intValue_1_0,
                      							"ru.iaie.reflex.Reflex.INTEGER");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:382:4: ( (lv_timeValue_2_0= RULE_TIME ) )
                    {
                    // InternalReflex.g:382:4: ( (lv_timeValue_2_0= RULE_TIME ) )
                    // InternalReflex.g:383:5: (lv_timeValue_2_0= RULE_TIME )
                    {
                    // InternalReflex.g:383:5: (lv_timeValue_2_0= RULE_TIME )
                    // InternalReflex.g:384:6: lv_timeValue_2_0= RULE_TIME
                    {
                    lv_timeValue_2_0=(Token)match(input,RULE_TIME,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_timeValue_2_0, grammarAccess.getClockDefinitionAccess().getTimeValueTIMETerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getClockDefinitionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"timeValue",
                      							lv_timeValue_2_0,
                      							"ru.iaie.reflex.Reflex.TIME");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getClockDefinitionAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClockDefinition"


    // $ANTLR start "entryRuleProcess"
    // InternalReflex.g:409:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalReflex.g:409:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalReflex.g:410:2: iv_ruleProcess= ruleProcess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcess; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalReflex.g:416:1: ruleProcess returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_interrupted_9_0= ruleInterrupted ) )* ( (lv_states_10_0= ruleState ) )* otherlv_11= '}' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_imports_6_0 = null;

        EObject lv_variables_7_0 = null;

        EObject lv_interrupted_9_0 = null;

        EObject lv_states_10_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:422:2: ( ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_interrupted_9_0= ruleInterrupted ) )* ( (lv_states_10_0= ruleState ) )* otherlv_11= '}' ) )
            // InternalReflex.g:423:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_interrupted_9_0= ruleInterrupted ) )* ( (lv_states_10_0= ruleState ) )* otherlv_11= '}' )
            {
            // InternalReflex.g:423:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_interrupted_9_0= ruleInterrupted ) )* ( (lv_states_10_0= ruleState ) )* otherlv_11= '}' )
            // InternalReflex.g:424:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_interrupted_9_0= ruleInterrupted ) )* ( (lv_states_10_0= ruleState ) )* otherlv_11= '}'
            {
            // InternalReflex.g:424:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==39) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalReflex.g:425:4: otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']'
            	    {
            	    otherlv_0=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_0_0());
            	      			
            	    }
            	    // InternalReflex.g:429:4: ( (lv_annotations_1_0= ruleAnnotation ) )
            	    // InternalReflex.g:430:5: (lv_annotations_1_0= ruleAnnotation )
            	    {
            	    // InternalReflex.g:430:5: (lv_annotations_1_0= ruleAnnotation )
            	    // InternalReflex.g:431:6: lv_annotations_1_0= ruleAnnotation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProcessAccess().getAnnotationsAnnotationParserRuleCall_0_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_annotations_1_0=ruleAnnotation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProcessRule());
            	      						}
            	      						add(
            	      							current,
            	      							"annotations",
            	      							lv_annotations_1_0,
            	      							"ru.iaie.reflex.Reflex.Annotation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getRightSquareBracketKeyword_0_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_3=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getProcessAccess().getProcessKeyword_1());
              		
            }
            // InternalReflex.g:457:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalReflex.g:458:4: (lv_name_4_0= RULE_ID )
            {
            // InternalReflex.g:458:4: (lv_name_4_0= RULE_ID )
            // InternalReflex.g:459:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProcessRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalReflex.g:479:3: ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==52||(LA6_0>=109 && LA6_0<=121)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReflex.g:480:4: ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';'
            	    {
            	    // InternalReflex.g:480:4: ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==52) ) {
            	        alt5=1;
            	    }
            	    else if ( ((LA5_0>=109 && LA5_0<=121)) ) {
            	        alt5=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // InternalReflex.g:481:5: ( (lv_imports_6_0= ruleImportedVariableList ) )
            	            {
            	            // InternalReflex.g:481:5: ( (lv_imports_6_0= ruleImportedVariableList ) )
            	            // InternalReflex.g:482:6: (lv_imports_6_0= ruleImportedVariableList )
            	            {
            	            // InternalReflex.g:482:6: (lv_imports_6_0= ruleImportedVariableList )
            	            // InternalReflex.g:483:7: lv_imports_6_0= ruleImportedVariableList
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getProcessAccess().getImportsImportedVariableListParserRuleCall_4_0_0_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_10);
            	            lv_imports_6_0=ruleImportedVariableList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getProcessRule());
            	              							}
            	              							add(
            	              								current,
            	              								"imports",
            	              								lv_imports_6_0,
            	              								"ru.iaie.reflex.Reflex.ImportedVariableList");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalReflex.g:501:5: ( (lv_variables_7_0= ruleProcessVariable ) )
            	            {
            	            // InternalReflex.g:501:5: ( (lv_variables_7_0= ruleProcessVariable ) )
            	            // InternalReflex.g:502:6: (lv_variables_7_0= ruleProcessVariable )
            	            {
            	            // InternalReflex.g:502:6: (lv_variables_7_0= ruleProcessVariable )
            	            // InternalReflex.g:503:7: lv_variables_7_0= ruleProcessVariable
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getProcessAccess().getVariablesProcessVariableParserRuleCall_4_0_1_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_10);
            	            lv_variables_7_0=ruleProcessVariable();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getProcessRule());
            	              							}
            	              							add(
            	              								current,
            	              								"variables",
            	              								lv_variables_7_0,
            	              								"ru.iaie.reflex.Reflex.ProcessVariable");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    otherlv_8=(Token)match(input,45,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_8, grammarAccess.getProcessAccess().getSemicolonKeyword_4_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalReflex.g:526:3: ( (lv_interrupted_9_0= ruleInterrupted ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==47) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalReflex.g:527:4: (lv_interrupted_9_0= ruleInterrupted )
            	    {
            	    // InternalReflex.g:527:4: (lv_interrupted_9_0= ruleInterrupted )
            	    // InternalReflex.g:528:5: lv_interrupted_9_0= ruleInterrupted
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getInterruptedInterruptedParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_interrupted_9_0=ruleInterrupted();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"interrupted",
            	      						lv_interrupted_9_0,
            	      						"ru.iaie.reflex.Reflex.Interrupted");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalReflex.g:545:3: ( (lv_states_10_0= ruleState ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==39||LA8_0==48) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalReflex.g:546:4: (lv_states_10_0= ruleState )
            	    {
            	    // InternalReflex.g:546:4: (lv_states_10_0= ruleState )
            	    // InternalReflex.g:547:5: lv_states_10_0= ruleState
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_6_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_states_10_0=ruleState();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"states",
            	      						lv_states_10_0,
            	      						"ru.iaie.reflex.Reflex.State");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_11=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleInterrupted"
    // InternalReflex.g:572:1: entryRuleInterrupted returns [EObject current=null] : iv_ruleInterrupted= ruleInterrupted EOF ;
    public final EObject entryRuleInterrupted() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterrupted = null;


        try {
            // InternalReflex.g:572:52: (iv_ruleInterrupted= ruleInterrupted EOF )
            // InternalReflex.g:573:2: iv_ruleInterrupted= ruleInterrupted EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterruptedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInterrupted=ruleInterrupted();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterrupted; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterrupted"


    // $ANTLR start "ruleInterrupted"
    // InternalReflex.g:579:1: ruleInterrupted returns [EObject current=null] : (otherlv_0= 'interrupted' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_stateFunction_5_0= ruleStatementSequence ) ) otherlv_6= '}' ) ;
    public final EObject ruleInterrupted() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_stateFunction_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:585:2: ( (otherlv_0= 'interrupted' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_stateFunction_5_0= ruleStatementSequence ) ) otherlv_6= '}' ) )
            // InternalReflex.g:586:2: (otherlv_0= 'interrupted' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_stateFunction_5_0= ruleStatementSequence ) ) otherlv_6= '}' )
            {
            // InternalReflex.g:586:2: (otherlv_0= 'interrupted' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_stateFunction_5_0= ruleStatementSequence ) ) otherlv_6= '}' )
            // InternalReflex.g:587:3: otherlv_0= 'interrupted' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_stateFunction_5_0= ruleStatementSequence ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInterruptedAccess().getInterruptedKeyword_0());
              		
            }
            // InternalReflex.g:591:3: ( (otherlv_1= RULE_ID ) )
            // InternalReflex.g:592:4: (otherlv_1= RULE_ID )
            {
            // InternalReflex.g:592:4: (otherlv_1= RULE_ID )
            // InternalReflex.g:593:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInterruptedRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getInterruptedAccess().getVecVectorCrossReference_1_0());
              				
            }

            }


            }

            // InternalReflex.g:604:3: ( (otherlv_2= RULE_ID ) )
            // InternalReflex.g:605:4: (otherlv_2= RULE_ID )
            {
            // InternalReflex.g:605:4: (otherlv_2= RULE_ID )
            // InternalReflex.g:606:5: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInterruptedRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getInterruptedAccess().getRegRegisterCrossReference_2_0());
              				
            }

            }


            }

            // InternalReflex.g:617:3: ( (otherlv_3= RULE_ID ) )
            // InternalReflex.g:618:4: (otherlv_3= RULE_ID )
            {
            // InternalReflex.g:618:4: (otherlv_3= RULE_ID )
            // InternalReflex.g:619:5: otherlv_3= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInterruptedRule());
              					}
              				
            }
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_3, grammarAccess.getInterruptedAccess().getBitBitCrossReference_3_0());
              				
            }

            }


            }

            otherlv_4=(Token)match(input,42,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInterruptedAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:634:3: ( (lv_stateFunction_5_0= ruleStatementSequence ) )
            // InternalReflex.g:635:4: (lv_stateFunction_5_0= ruleStatementSequence )
            {
            // InternalReflex.g:635:4: (lv_stateFunction_5_0= ruleStatementSequence )
            // InternalReflex.g:636:5: lv_stateFunction_5_0= ruleStatementSequence
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInterruptedAccess().getStateFunctionStatementSequenceParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_stateFunction_5_0=ruleStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInterruptedRule());
              					}
              					set(
              						current,
              						"stateFunction",
              						lv_stateFunction_5_0,
              						"ru.iaie.reflex.Reflex.StatementSequence");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getInterruptedAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterrupted"


    // $ANTLR start "entryRuleState"
    // InternalReflex.g:661:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalReflex.g:661:46: (iv_ruleState= ruleState EOF )
            // InternalReflex.g:662:2: iv_ruleState= ruleState EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleState; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalReflex.g:668:1: ruleState returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token lv_looped_5_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_stateFunction_7_0 = null;

        EObject lv_timeoutFunction_8_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:674:2: ( ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' ) )
            // InternalReflex.g:675:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' )
            {
            // InternalReflex.g:675:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' )
            // InternalReflex.g:676:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}'
            {
            // InternalReflex.g:676:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==39) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalReflex.g:677:4: otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']'
            	    {
            	    otherlv_0=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_0, grammarAccess.getStateAccess().getLeftSquareBracketKeyword_0_0());
            	      			
            	    }
            	    // InternalReflex.g:681:4: ( (lv_annotations_1_0= ruleAnnotation ) )
            	    // InternalReflex.g:682:5: (lv_annotations_1_0= ruleAnnotation )
            	    {
            	    // InternalReflex.g:682:5: (lv_annotations_1_0= ruleAnnotation )
            	    // InternalReflex.g:683:6: lv_annotations_1_0= ruleAnnotation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getStateAccess().getAnnotationsAnnotationParserRuleCall_0_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_annotations_1_0=ruleAnnotation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getStateRule());
            	      						}
            	      						add(
            	      							current,
            	      							"annotations",
            	      							lv_annotations_1_0,
            	      							"ru.iaie.reflex.Reflex.Annotation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getStateAccess().getRightSquareBracketKeyword_0_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_3=(Token)match(input,48,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStateAccess().getStateKeyword_1());
              		
            }
            // InternalReflex.g:709:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalReflex.g:710:4: (lv_name_4_0= RULE_ID )
            {
            // InternalReflex.g:710:4: (lv_name_4_0= RULE_ID )
            // InternalReflex.g:711:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStateRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:727:3: ( (lv_looped_5_0= 'looped' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==49) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalReflex.g:728:4: (lv_looped_5_0= 'looped' )
                    {
                    // InternalReflex.g:728:4: (lv_looped_5_0= 'looped' )
                    // InternalReflex.g:729:5: lv_looped_5_0= 'looped'
                    {
                    lv_looped_5_0=(Token)match(input,49,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_looped_5_0, grammarAccess.getStateAccess().getLoopedLoopedKeyword_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getStateRule());
                      					}
                      					setWithLastConsumed(current, "looped", lv_looped_5_0 != null, "looped");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,42,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:745:3: ( (lv_stateFunction_7_0= ruleStatementSequence ) )
            // InternalReflex.g:746:4: (lv_stateFunction_7_0= ruleStatementSequence )
            {
            // InternalReflex.g:746:4: (lv_stateFunction_7_0= ruleStatementSequence )
            // InternalReflex.g:747:5: lv_stateFunction_7_0= ruleStatementSequence
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStateAccess().getStateFunctionStatementSequenceParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_20);
            lv_stateFunction_7_0=ruleStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStateRule());
              					}
              					set(
              						current,
              						"stateFunction",
              						lv_stateFunction_7_0,
              						"ru.iaie.reflex.Reflex.StatementSequence");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:764:3: ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==56) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalReflex.g:765:4: (lv_timeoutFunction_8_0= ruleTimeoutFunction )
                    {
                    // InternalReflex.g:765:4: (lv_timeoutFunction_8_0= ruleTimeoutFunction )
                    // InternalReflex.g:766:5: lv_timeoutFunction_8_0= ruleTimeoutFunction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStateAccess().getTimeoutFunctionTimeoutFunctionParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_16);
                    lv_timeoutFunction_8_0=ruleTimeoutFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStateRule());
                      					}
                      					set(
                      						current,
                      						"timeoutFunction",
                      						lv_timeoutFunction_8_0,
                      						"ru.iaie.reflex.Reflex.TimeoutFunction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleAnnotation"
    // InternalReflex.g:791:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalReflex.g:791:51: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalReflex.g:792:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnotationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalReflex.g:798:1: ruleAnnotation returns [EObject current=null] : ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:804:2: ( ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) ) )
            // InternalReflex.g:805:2: ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) )
            {
            // InternalReflex.g:805:2: ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 51:
                    {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==RULE_ID) ) {
                        int LA12_5 = input.LA(4);

                        if ( (LA12_5==EOF||LA12_5==40) ) {
                            alt12=2;
                        }
                        else if ( (LA12_5==50) ) {
                            alt12=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case 50:
                    {
                    alt12=1;
                    }
                    break;
                case EOF:
                case 40:
                    {
                    alt12=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalReflex.g:806:3: ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
                    {
                    // InternalReflex.g:806:3: ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
                    // InternalReflex.g:807:4: ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
                    {
                    // InternalReflex.g:807:4: ( (lv_key_0_0= ruleAnnotationKey ) )
                    // InternalReflex.g:808:5: (lv_key_0_0= ruleAnnotationKey )
                    {
                    // InternalReflex.g:808:5: (lv_key_0_0= ruleAnnotationKey )
                    // InternalReflex.g:809:6: lv_key_0_0= ruleAnnotationKey
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAnnotationAccess().getKeyAnnotationKeyParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_key_0_0=ruleAnnotationKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAnnotationRule());
                      						}
                      						set(
                      							current,
                      							"key",
                      							lv_key_0_0,
                      							"ru.iaie.reflex.Reflex.AnnotationKey");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,50,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAnnotationAccess().getColonKeyword_0_1());
                      			
                    }
                    // InternalReflex.g:830:4: ( (lv_value_2_0= RULE_STRING ) )
                    // InternalReflex.g:831:5: (lv_value_2_0= RULE_STRING )
                    {
                    // InternalReflex.g:831:5: (lv_value_2_0= RULE_STRING )
                    // InternalReflex.g:832:6: lv_value_2_0= RULE_STRING
                    {
                    lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_0, grammarAccess.getAnnotationAccess().getValueSTRINGTerminalRuleCall_0_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAnnotationRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:850:3: ( (lv_key_3_0= ruleAnnotationKey ) )
                    {
                    // InternalReflex.g:850:3: ( (lv_key_3_0= ruleAnnotationKey ) )
                    // InternalReflex.g:851:4: (lv_key_3_0= ruleAnnotationKey )
                    {
                    // InternalReflex.g:851:4: (lv_key_3_0= ruleAnnotationKey )
                    // InternalReflex.g:852:5: lv_key_3_0= ruleAnnotationKey
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAnnotationAccess().getKeyAnnotationKeyParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_key_3_0=ruleAnnotationKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAnnotationRule());
                      					}
                      					set(
                      						current,
                      						"key",
                      						lv_key_3_0,
                      						"ru.iaie.reflex.Reflex.AnnotationKey");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleAnnotationKey"
    // InternalReflex.g:873:1: entryRuleAnnotationKey returns [String current=null] : iv_ruleAnnotationKey= ruleAnnotationKey EOF ;
    public final String entryRuleAnnotationKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationKey = null;


        try {
            // InternalReflex.g:873:53: (iv_ruleAnnotationKey= ruleAnnotationKey EOF )
            // InternalReflex.g:874:2: iv_ruleAnnotationKey= ruleAnnotationKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnotationKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationKey=ruleAnnotationKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotationKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotationKey"


    // $ANTLR start "ruleAnnotationKey"
    // InternalReflex.g:880:1: ruleAnnotationKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleAnnotationKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_3=null;


        	enterRule();

        try {
            // InternalReflex.g:886:2: ( ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID ) )
            // InternalReflex.g:887:2: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID )
            {
            // InternalReflex.g:887:2: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==51) ) {
                    alt13=1;
                }
                else if ( (LA13_1==EOF||LA13_1==40||LA13_1==50) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalReflex.g:888:3: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
                    {
                    // InternalReflex.g:888:3: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
                    // InternalReflex.g:889:4: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_0, grammarAccess.getAnnotationKeyAccess().getIDTerminalRuleCall_0_0());
                      			
                    }
                    kw=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getAnnotationKeyAccess().getFullStopKeyword_0_1());
                      			
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_2, grammarAccess.getAnnotationKeyAccess().getIDTerminalRuleCall_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:910:3: this_ID_3= RULE_ID
                    {
                    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_3);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_3, grammarAccess.getAnnotationKeyAccess().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationKey"


    // $ANTLR start "entryRuleImportedVariableList"
    // InternalReflex.g:921:1: entryRuleImportedVariableList returns [EObject current=null] : iv_ruleImportedVariableList= ruleImportedVariableList EOF ;
    public final EObject entryRuleImportedVariableList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedVariableList = null;


        try {
            // InternalReflex.g:921:61: (iv_ruleImportedVariableList= ruleImportedVariableList EOF )
            // InternalReflex.g:922:2: iv_ruleImportedVariableList= ruleImportedVariableList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportedVariableListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportedVariableList=ruleImportedVariableList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportedVariableList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedVariableList"


    // $ANTLR start "ruleImportedVariableList"
    // InternalReflex.g:928:1: ruleImportedVariableList returns [EObject current=null] : (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleImportedVariableList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalReflex.g:934:2: ( (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) ) )
            // InternalReflex.g:935:2: (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalReflex.g:935:2: (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) )
            // InternalReflex.g:936:3: otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportedVariableListAccess().getSharedKeyword_0());
              		
            }
            // InternalReflex.g:940:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalReflex.g:941:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            {
            // InternalReflex.g:941:4: ( (otherlv_1= RULE_ID ) )
            // InternalReflex.g:942:5: (otherlv_1= RULE_ID )
            {
            // InternalReflex.g:942:5: (otherlv_1= RULE_ID )
            // InternalReflex.g:943:6: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getImportedVariableListRule());
              						}
              					
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(otherlv_1, grammarAccess.getImportedVariableListAccess().getVariablesProcessVariableCrossReference_1_0_0());
              					
            }

            }


            }

            // InternalReflex.g:954:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==53) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalReflex.g:955:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,53,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getImportedVariableListAccess().getCommaKeyword_1_1_0());
            	      				
            	    }
            	    // InternalReflex.g:959:5: ( (otherlv_3= RULE_ID ) )
            	    // InternalReflex.g:960:6: (otherlv_3= RULE_ID )
            	    {
            	    // InternalReflex.g:960:6: (otherlv_3= RULE_ID )
            	    // InternalReflex.g:961:7: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getImportedVariableListRule());
            	      							}
            	      						
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(otherlv_3, grammarAccess.getImportedVariableListAccess().getVariablesProcessVariableCrossReference_1_1_1_0());
            	      						
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            otherlv_4=(Token)match(input,54,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getImportedVariableListAccess().getFromKeyword_2());
              		
            }
            otherlv_5=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getImportedVariableListAccess().getProcessKeyword_3());
              		
            }
            // InternalReflex.g:982:3: ( (otherlv_6= RULE_ID ) )
            // InternalReflex.g:983:4: (otherlv_6= RULE_ID )
            {
            // InternalReflex.g:983:4: (otherlv_6= RULE_ID )
            // InternalReflex.g:984:5: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportedVariableListRule());
              					}
              				
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_6, grammarAccess.getImportedVariableListAccess().getProcessProcessCrossReference_4_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedVariableList"


    // $ANTLR start "entryRuleProcessVariable"
    // InternalReflex.g:999:1: entryRuleProcessVariable returns [EObject current=null] : iv_ruleProcessVariable= ruleProcessVariable EOF ;
    public final EObject entryRuleProcessVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVariable = null;


        try {
            // InternalReflex.g:999:56: (iv_ruleProcessVariable= ruleProcessVariable EOF )
            // InternalReflex.g:1000:2: iv_ruleProcessVariable= ruleProcessVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcessVariable=ruleProcessVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessVariable"


    // $ANTLR start "ruleProcessVariable"
    // InternalReflex.g:1006:1: ruleProcessVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? ) ;
    public final EObject ruleProcessVariable() throws RecognitionException {
        EObject current = null;

        Token lv_shared_2_0=null;
        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:1012:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? ) )
            // InternalReflex.g:1013:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? )
            {
            // InternalReflex.g:1013:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? )
            // InternalReflex.g:1014:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )?
            {
            // InternalReflex.g:1014:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalReflex.g:1015:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getProcessVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_26);
                    this_PhysicalVariable_0=rulePhysicalVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_PhysicalVariable_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:1024:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getProcessVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_26);
                    this_ProgramVariable_1=ruleProgramVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ProgramVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalReflex.g:1033:3: ( (lv_shared_2_0= 'shared' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==52) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalReflex.g:1034:4: (lv_shared_2_0= 'shared' )
                    {
                    // InternalReflex.g:1034:4: (lv_shared_2_0= 'shared' )
                    // InternalReflex.g:1035:5: lv_shared_2_0= 'shared'
                    {
                    lv_shared_2_0=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_shared_2_0, grammarAccess.getProcessVariableAccess().getSharedSharedKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getProcessVariableRule());
                      					}
                      					setWithLastConsumed(current, "shared", lv_shared_2_0 != null, "shared");
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessVariable"


    // $ANTLR start "entryRuleGlobalVariable"
    // InternalReflex.g:1051:1: entryRuleGlobalVariable returns [EObject current=null] : iv_ruleGlobalVariable= ruleGlobalVariable EOF ;
    public final EObject entryRuleGlobalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVariable = null;


        try {
            // InternalReflex.g:1051:55: (iv_ruleGlobalVariable= ruleGlobalVariable EOF )
            // InternalReflex.g:1052:2: iv_ruleGlobalVariable= ruleGlobalVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGlobalVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGlobalVariable=ruleGlobalVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGlobalVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalVariable"


    // $ANTLR start "ruleGlobalVariable"
    // InternalReflex.g:1058:1: ruleGlobalVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' ) ;
    public final EObject ruleGlobalVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:1064:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' ) )
            // InternalReflex.g:1065:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' )
            {
            // InternalReflex.g:1065:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' )
            // InternalReflex.g:1066:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';'
            {
            // InternalReflex.g:1066:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalReflex.g:1067:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getGlobalVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_10);
                    this_PhysicalVariable_0=rulePhysicalVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_PhysicalVariable_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:1076:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getGlobalVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_10);
                    this_ProgramVariable_1=ruleProgramVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ProgramVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getGlobalVariableAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalVariable"


    // $ANTLR start "entryRulePhysicalVariable"
    // InternalReflex.g:1093:1: entryRulePhysicalVariable returns [EObject current=null] : iv_rulePhysicalVariable= rulePhysicalVariable EOF ;
    public final EObject entryRulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalVariable = null;


        try {
            // InternalReflex.g:1093:57: (iv_rulePhysicalVariable= rulePhysicalVariable EOF )
            // InternalReflex.g:1094:2: iv_rulePhysicalVariable= rulePhysicalVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPhysicalVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePhysicalVariable=rulePhysicalVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePhysicalVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysicalVariable"


    // $ANTLR start "rulePhysicalVariable"
    // InternalReflex.g:1100:1: rulePhysicalVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) ) ) ;
    public final EObject rulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_mapping_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1106:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) ) ) )
            // InternalReflex.g:1107:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) ) )
            {
            // InternalReflex.g:1107:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) ) )
            // InternalReflex.g:1108:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) )
            {
            // InternalReflex.g:1108:3: ( (lv_type_0_0= ruleType ) )
            // InternalReflex.g:1109:4: (lv_type_0_0= ruleType )
            {
            // InternalReflex.g:1109:4: (lv_type_0_0= ruleType )
            // InternalReflex.g:1110:5: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getTypeTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1127:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1128:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1128:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1129:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPhysicalVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPhysicalVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,55,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPhysicalVariableAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalReflex.g:1149:3: ( (lv_mapping_3_0= rulePortMapping ) )
            // InternalReflex.g:1150:4: (lv_mapping_3_0= rulePortMapping )
            {
            // InternalReflex.g:1150:4: (lv_mapping_3_0= rulePortMapping )
            // InternalReflex.g:1151:5: lv_mapping_3_0= rulePortMapping
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getMappingPortMappingParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_mapping_3_0=rulePortMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					set(
              						current,
              						"mapping",
              						lv_mapping_3_0,
              						"ru.iaie.reflex.Reflex.PortMapping");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysicalVariable"


    // $ANTLR start "entryRulePortMapping"
    // InternalReflex.g:1172:1: entryRulePortMapping returns [EObject current=null] : iv_rulePortMapping= rulePortMapping EOF ;
    public final EObject entryRulePortMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortMapping = null;


        try {
            // InternalReflex.g:1172:52: (iv_rulePortMapping= rulePortMapping EOF )
            // InternalReflex.g:1173:2: iv_rulePortMapping= rulePortMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePortMapping=rulePortMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortMapping; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortMapping"


    // $ANTLR start "rulePortMapping"
    // InternalReflex.g:1179:1: rulePortMapping returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']' ) ;
    public final EObject rulePortMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_bit_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1185:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']' ) )
            // InternalReflex.g:1186:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']' )
            {
            // InternalReflex.g:1186:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']' )
            // InternalReflex.g:1187:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']'
            {
            // InternalReflex.g:1187:3: ( (otherlv_0= RULE_ID ) )
            // InternalReflex.g:1188:4: (otherlv_0= RULE_ID )
            {
            // InternalReflex.g:1188:4: (otherlv_0= RULE_ID )
            // InternalReflex.g:1189:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortMappingRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getPortMappingAccess().getPortPortCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPortMappingAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalReflex.g:1204:3: ( (lv_bit_2_0= RULE_INTEGER ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INTEGER) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalReflex.g:1205:4: (lv_bit_2_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:1205:4: (lv_bit_2_0= RULE_INTEGER )
                    // InternalReflex.g:1206:5: lv_bit_2_0= RULE_INTEGER
                    {
                    lv_bit_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_bit_2_0, grammarAccess.getPortMappingAccess().getBitINTEGERTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPortMappingRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"bit",
                      						lv_bit_2_0,
                      						"ru.iaie.reflex.Reflex.INTEGER");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getPortMappingAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortMapping"


    // $ANTLR start "entryRuleProgramVariable"
    // InternalReflex.g:1230:1: entryRuleProgramVariable returns [EObject current=null] : iv_ruleProgramVariable= ruleProgramVariable EOF ;
    public final EObject entryRuleProgramVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramVariable = null;


        try {
            // InternalReflex.g:1230:56: (iv_ruleProgramVariable= ruleProgramVariable EOF )
            // InternalReflex.g:1231:2: iv_ruleProgramVariable= ruleProgramVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgramVariable=ruleProgramVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgramVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramVariable"


    // $ANTLR start "ruleProgramVariable"
    // InternalReflex.g:1237:1: ruleProgramVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProgramVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1243:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:1244:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:1244:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalReflex.g:1245:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalReflex.g:1245:3: ( (lv_type_0_0= ruleType ) )
            // InternalReflex.g:1246:4: (lv_type_0_0= ruleType )
            {
            // InternalReflex.g:1246:4: (lv_type_0_0= ruleType )
            // InternalReflex.g:1247:5: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProgramVariableAccess().getTypeTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProgramVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1264:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1265:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1265:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1266:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProgramVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramVariable"


    // $ANTLR start "entryRuleTimeoutFunction"
    // InternalReflex.g:1286:1: entryRuleTimeoutFunction returns [EObject current=null] : iv_ruleTimeoutFunction= ruleTimeoutFunction EOF ;
    public final EObject entryRuleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutFunction = null;


        try {
            // InternalReflex.g:1286:56: (iv_ruleTimeoutFunction= ruleTimeoutFunction EOF )
            // InternalReflex.g:1287:2: iv_ruleTimeoutFunction= ruleTimeoutFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeoutFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTimeoutFunction=ruleTimeoutFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimeoutFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeoutFunction"


    // $ANTLR start "ruleTimeoutFunction"
    // InternalReflex.g:1293:1: ruleTimeoutFunction returns [EObject current=null] : (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) ) ;
    public final EObject ruleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_TimeAmountOrRef_1 = null;

        EObject this_TimeAmountOrRef_3 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1299:2: ( (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) ) )
            // InternalReflex.g:1300:2: (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) )
            {
            // InternalReflex.g:1300:2: (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) )
            // InternalReflex.g:1301:3: otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTimeoutFunctionAccess().getTimeoutKeyword_0());
              		
            }
            // InternalReflex.g:1305:3: (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_TIME)) ) {
                alt19=1;
            }
            else if ( (LA19_0==57) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalReflex.g:1306:4: this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getTimeoutFunctionRule());
                      				}
                      				newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getTimeAmountOrRefParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_31);
                    this_TimeAmountOrRef_1=ruleTimeAmountOrRef(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_TimeAmountOrRef_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:1318:4: (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' )
                    {
                    // InternalReflex.g:1318:4: (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' )
                    // InternalReflex.g:1319:5: otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,57,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getTimeoutFunctionAccess().getLeftParenthesisKeyword_1_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeoutFunctionRule());
                      					}
                      					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getTimeAmountOrRefParserRuleCall_1_1_1());
                      				
                    }
                    pushFollow(FOLLOW_33);
                    this_TimeAmountOrRef_3=ruleTimeAmountOrRef(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_TimeAmountOrRef_3;
                      					afterParserOrEnumRuleCall();
                      				
                    }
                    otherlv_4=(Token)match(input,58,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getTimeoutFunctionAccess().getRightParenthesisKeyword_1_1_2());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:1340:3: ( (lv_body_5_0= ruleStatement ) )
            // InternalReflex.g:1341:4: (lv_body_5_0= ruleStatement )
            {
            // InternalReflex.g:1341:4: (lv_body_5_0= ruleStatement )
            // InternalReflex.g:1342:5: lv_body_5_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getBodyStatementParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTimeoutFunctionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"ru.iaie.reflex.Reflex.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeoutFunction"


    // $ANTLR start "ruleTimeAmountOrRef"
    // InternalReflex.g:1364:1: ruleTimeAmountOrRef[EObject in_current] returns [EObject current=in_current] : ( ( (lv_time_0_0= RULE_TIME ) ) | ( (lv_intTime_1_0= RULE_INTEGER ) ) | ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleTimeAmountOrRef(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_time_0_0=null;
        Token lv_intTime_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1370:2: ( ( ( (lv_time_0_0= RULE_TIME ) ) | ( (lv_intTime_1_0= RULE_INTEGER ) ) | ( (otherlv_2= RULE_ID ) ) ) )
            // InternalReflex.g:1371:2: ( ( (lv_time_0_0= RULE_TIME ) ) | ( (lv_intTime_1_0= RULE_INTEGER ) ) | ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalReflex.g:1371:2: ( ( (lv_time_0_0= RULE_TIME ) ) | ( (lv_intTime_1_0= RULE_INTEGER ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case RULE_TIME:
                {
                alt20=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt20=2;
                }
                break;
            case RULE_ID:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalReflex.g:1372:3: ( (lv_time_0_0= RULE_TIME ) )
                    {
                    // InternalReflex.g:1372:3: ( (lv_time_0_0= RULE_TIME ) )
                    // InternalReflex.g:1373:4: (lv_time_0_0= RULE_TIME )
                    {
                    // InternalReflex.g:1373:4: (lv_time_0_0= RULE_TIME )
                    // InternalReflex.g:1374:5: lv_time_0_0= RULE_TIME
                    {
                    lv_time_0_0=(Token)match(input,RULE_TIME,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_time_0_0, grammarAccess.getTimeAmountOrRefAccess().getTimeTIMETerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeAmountOrRefRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"time",
                      						lv_time_0_0,
                      						"ru.iaie.reflex.Reflex.TIME");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1391:3: ( (lv_intTime_1_0= RULE_INTEGER ) )
                    {
                    // InternalReflex.g:1391:3: ( (lv_intTime_1_0= RULE_INTEGER ) )
                    // InternalReflex.g:1392:4: (lv_intTime_1_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:1392:4: (lv_intTime_1_0= RULE_INTEGER )
                    // InternalReflex.g:1393:5: lv_intTime_1_0= RULE_INTEGER
                    {
                    lv_intTime_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_intTime_1_0, grammarAccess.getTimeAmountOrRefAccess().getIntTimeINTEGERTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeAmountOrRefRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"intTime",
                      						lv_intTime_1_0,
                      						"ru.iaie.reflex.Reflex.INTEGER");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:1410:3: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalReflex.g:1410:3: ( (otherlv_2= RULE_ID ) )
                    // InternalReflex.g:1411:4: (otherlv_2= RULE_ID )
                    {
                    // InternalReflex.g:1411:4: (otherlv_2= RULE_ID )
                    // InternalReflex.g:1412:5: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeAmountOrRefRule());
                      					}
                      				
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getTimeAmountOrRefAccess().getRefIdReferenceCrossReference_2_0());
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeAmountOrRef"


    // $ANTLR start "entryRuleFunction"
    // InternalReflex.g:1427:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalReflex.g:1427:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalReflex.g:1428:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalReflex.g:1434:1: ruleFunction returns [EObject current=null] : ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Enumerator lv_returnType_0_0 = null;

        Enumerator lv_argTypes_3_0 = null;

        Enumerator lv_argTypes_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1440:2: ( ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' ) )
            // InternalReflex.g:1441:2: ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            {
            // InternalReflex.g:1441:2: ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            // InternalReflex.g:1442:3: ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';'
            {
            // InternalReflex.g:1442:3: ( (lv_returnType_0_0= ruleType ) )
            // InternalReflex.g:1443:4: (lv_returnType_0_0= ruleType )
            {
            // InternalReflex.g:1443:4: (lv_returnType_0_0= ruleType )
            // InternalReflex.g:1444:5: lv_returnType_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_returnType_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					set(
              						current,
              						"returnType",
              						lv_returnType_0_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1461:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1462:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1462:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1463:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,57,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalReflex.g:1483:3: ( (lv_argTypes_3_0= ruleType ) )
            // InternalReflex.g:1484:4: (lv_argTypes_3_0= ruleType )
            {
            // InternalReflex.g:1484:4: (lv_argTypes_3_0= ruleType )
            // InternalReflex.g:1485:5: lv_argTypes_3_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesTypeEnumRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_36);
            lv_argTypes_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					add(
              						current,
              						"argTypes",
              						lv_argTypes_3_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1502:3: (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==53) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalReflex.g:1503:4: otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) )
            	    {
            	    otherlv_4=(Token)match(input,53,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:1507:4: ( (lv_argTypes_5_0= ruleType ) )
            	    // InternalReflex.g:1508:5: (lv_argTypes_5_0= ruleType )
            	    {
            	    // InternalReflex.g:1508:5: (lv_argTypes_5_0= ruleType )
            	    // InternalReflex.g:1509:6: lv_argTypes_5_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesTypeEnumRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_argTypes_5_0=ruleType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"argTypes",
            	      							lv_argTypes_5_0,
            	      							"ru.iaie.reflex.Reflex.Type");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,58,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_7=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionAccess().getSemicolonKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRulePort"
    // InternalReflex.g:1539:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalReflex.g:1539:45: (iv_rulePort= rulePort EOF )
            // InternalReflex.g:1540:2: iv_rulePort= rulePort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePort=rulePort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePort; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // InternalReflex.g:1546:1: rulePort returns [EObject current=null] : ( ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';' ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_addr1_2_0=null;
        Token lv_addr2_3_0=null;
        Token lv_size_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1552:2: ( ( ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1553:2: ( ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1553:2: ( ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';' )
            // InternalReflex.g:1554:3: ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';'
            {
            // InternalReflex.g:1554:3: ( (lv_type_0_0= rulePortType ) )
            // InternalReflex.g:1555:4: (lv_type_0_0= rulePortType )
            {
            // InternalReflex.g:1555:4: (lv_type_0_0= rulePortType )
            // InternalReflex.g:1556:5: lv_type_0_0= rulePortType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPortAccess().getTypePortTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=rulePortType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPortRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.PortType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1573:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1574:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1574:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1575:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPortAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:1591:3: ( (lv_addr1_2_0= RULE_INTEGER ) )
            // InternalReflex.g:1592:4: (lv_addr1_2_0= RULE_INTEGER )
            {
            // InternalReflex.g:1592:4: (lv_addr1_2_0= RULE_INTEGER )
            // InternalReflex.g:1593:5: lv_addr1_2_0= RULE_INTEGER
            {
            lv_addr1_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_addr1_2_0, grammarAccess.getPortAccess().getAddr1INTEGERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"addr1",
              						lv_addr1_2_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            // InternalReflex.g:1609:3: ( (lv_addr2_3_0= RULE_INTEGER ) )
            // InternalReflex.g:1610:4: (lv_addr2_3_0= RULE_INTEGER )
            {
            // InternalReflex.g:1610:4: (lv_addr2_3_0= RULE_INTEGER )
            // InternalReflex.g:1611:5: lv_addr2_3_0= RULE_INTEGER
            {
            lv_addr2_3_0=(Token)match(input,RULE_INTEGER,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_addr2_3_0, grammarAccess.getPortAccess().getAddr2INTEGERTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"addr2",
              						lv_addr2_3_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            // InternalReflex.g:1627:3: ( (lv_size_4_0= RULE_INTEGER ) )
            // InternalReflex.g:1628:4: (lv_size_4_0= RULE_INTEGER )
            {
            // InternalReflex.g:1628:4: (lv_size_4_0= RULE_INTEGER )
            // InternalReflex.g:1629:5: lv_size_4_0= RULE_INTEGER
            {
            lv_size_4_0=(Token)match(input,RULE_INTEGER,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_size_4_0, grammarAccess.getPortAccess().getSizeINTEGERTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"size",
              						lv_size_4_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getPortAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePort"


    // $ANTLR start "entryRuleVector"
    // InternalReflex.g:1653:1: entryRuleVector returns [EObject current=null] : iv_ruleVector= ruleVector EOF ;
    public final EObject entryRuleVector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVector = null;


        try {
            // InternalReflex.g:1653:47: (iv_ruleVector= ruleVector EOF )
            // InternalReflex.g:1654:2: iv_ruleVector= ruleVector EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVectorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVector=ruleVector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVector; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVector"


    // $ANTLR start "ruleVector"
    // InternalReflex.g:1660:1: ruleVector returns [EObject current=null] : (otherlv_0= 'vector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleVector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1666:2: ( (otherlv_0= 'vector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalReflex.g:1667:2: (otherlv_0= 'vector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalReflex.g:1667:2: (otherlv_0= 'vector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalReflex.g:1668:3: otherlv_0= 'vector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVectorAccess().getVectorKeyword_0());
              		
            }
            // InternalReflex.g:1672:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1673:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1673:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1674:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getVectorAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVectorRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getVectorAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVector"


    // $ANTLR start "entryRuleBit"
    // InternalReflex.g:1698:1: entryRuleBit returns [EObject current=null] : iv_ruleBit= ruleBit EOF ;
    public final EObject entryRuleBit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBit = null;


        try {
            // InternalReflex.g:1698:44: (iv_ruleBit= ruleBit EOF )
            // InternalReflex.g:1699:2: iv_ruleBit= ruleBit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBit=ruleBit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBit"


    // $ANTLR start "ruleBit"
    // InternalReflex.g:1705:1: ruleBit returns [EObject current=null] : (otherlv_0= 'bit' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleBit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1711:2: ( (otherlv_0= 'bit' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalReflex.g:1712:2: (otherlv_0= 'bit' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalReflex.g:1712:2: (otherlv_0= 'bit' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalReflex.g:1713:3: otherlv_0= 'bit' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBitAccess().getBitKeyword_0());
              		
            }
            // InternalReflex.g:1717:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1718:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1718:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1719:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getBitAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBitRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getBitAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBit"


    // $ANTLR start "entryRuleRegister"
    // InternalReflex.g:1743:1: entryRuleRegister returns [EObject current=null] : iv_ruleRegister= ruleRegister EOF ;
    public final EObject entryRuleRegister() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegister = null;


        try {
            // InternalReflex.g:1743:49: (iv_ruleRegister= ruleRegister EOF )
            // InternalReflex.g:1744:2: iv_ruleRegister= ruleRegister EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegister=ruleRegister();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegister; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegister"


    // $ANTLR start "ruleRegister"
    // InternalReflex.g:1750:1: ruleRegister returns [EObject current=null] : (otherlv_0= 'register' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleRegister() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1756:2: ( (otherlv_0= 'register' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalReflex.g:1757:2: (otherlv_0= 'register' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalReflex.g:1757:2: (otherlv_0= 'register' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalReflex.g:1758:3: otherlv_0= 'register' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRegisterAccess().getRegisterKeyword_0());
              		
            }
            // InternalReflex.g:1762:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1763:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1763:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1764:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRegisterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRegisterAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegister"


    // $ANTLR start "entryRuleConst"
    // InternalReflex.g:1788:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalReflex.g:1788:46: (iv_ruleConst= ruleConst EOF )
            // InternalReflex.g:1789:2: iv_ruleConst= ruleConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConst=ruleConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConst; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConst"


    // $ANTLR start "ruleConst"
    // InternalReflex.g:1795:1: ruleConst returns [EObject current=null] : (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1801:2: ( (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1802:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1802:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalReflex.g:1803:3: otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstAccess().getConstKeyword_0());
              		
            }
            // InternalReflex.g:1807:3: ( (lv_type_1_0= ruleType ) )
            // InternalReflex.g:1808:4: (lv_type_1_0= ruleType )
            {
            // InternalReflex.g:1808:4: (lv_type_1_0= ruleType )
            // InternalReflex.g:1809:5: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getTypeTypeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1826:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalReflex.g:1827:4: (lv_name_2_0= RULE_ID )
            {
            // InternalReflex.g:1827:4: (lv_name_2_0= RULE_ID )
            // InternalReflex.g:1828:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getConstAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,55,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstAccess().getEqualsSignKeyword_3());
              		
            }
            // InternalReflex.g:1848:3: ( (lv_value_4_0= ruleExpression ) )
            // InternalReflex.g:1849:4: (lv_value_4_0= ruleExpression )
            {
            // InternalReflex.g:1849:4: (lv_value_4_0= ruleExpression )
            // InternalReflex.g:1850:5: lv_value_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getValueExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_value_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_4_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getConstAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConst"


    // $ANTLR start "entryRuleEnum"
    // InternalReflex.g:1875:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // InternalReflex.g:1875:45: (iv_ruleEnum= ruleEnum EOF )
            // InternalReflex.g:1876:2: iv_ruleEnum= ruleEnum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnum=ruleEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnum; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnum"


    // $ANTLR start "ruleEnum"
    // InternalReflex.g:1882:1: ruleEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_enumMembers_3_0 = null;

        EObject lv_enumMembers_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1888:2: ( (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) )
            // InternalReflex.g:1889:2: (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:1889:2: (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            // InternalReflex.g:1890:3: otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalReflex.g:1894:3: ( (lv_identifier_1_0= RULE_ID ) )
            // InternalReflex.g:1895:4: (lv_identifier_1_0= RULE_ID )
            {
            // InternalReflex.g:1895:4: (lv_identifier_1_0= RULE_ID )
            // InternalReflex.g:1896:5: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_identifier_1_0, grammarAccess.getEnumAccess().getIdentifierIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumRule());
              					}
              					setWithLastConsumed(
              						current,
              						"identifier",
              						lv_identifier_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:1916:3: ( (lv_enumMembers_3_0= ruleEnumMember ) )
            // InternalReflex.g:1917:4: (lv_enumMembers_3_0= ruleEnumMember )
            {
            // InternalReflex.g:1917:4: (lv_enumMembers_3_0= ruleEnumMember )
            // InternalReflex.g:1918:5: lv_enumMembers_3_0= ruleEnumMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_38);
            lv_enumMembers_3_0=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumRule());
              					}
              					add(
              						current,
              						"enumMembers",
              						lv_enumMembers_3_0,
              						"ru.iaie.reflex.Reflex.EnumMember");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1935:3: (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==53) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalReflex.g:1936:4: otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    {
            	    otherlv_4=(Token)match(input,53,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getEnumAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:1940:4: ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    // InternalReflex.g:1941:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    {
            	    // InternalReflex.g:1941:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    // InternalReflex.g:1942:6: lv_enumMembers_5_0= ruleEnumMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_enumMembers_5_0=ruleEnumMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEnumRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enumMembers",
            	      							lv_enumMembers_5_0,
            	      							"ru.iaie.reflex.Reflex.EnumMember");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_6=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEnumAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnum"


    // $ANTLR start "entryRuleEnumMember"
    // InternalReflex.g:1968:1: entryRuleEnumMember returns [EObject current=null] : iv_ruleEnumMember= ruleEnumMember EOF ;
    public final EObject entryRuleEnumMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumMember = null;


        try {
            // InternalReflex.g:1968:51: (iv_ruleEnumMember= ruleEnumMember EOF )
            // InternalReflex.g:1969:2: iv_ruleEnumMember= ruleEnumMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumMemberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumMember=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumMember; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumMember"


    // $ANTLR start "ruleEnumMember"
    // InternalReflex.g:1975:1: ruleEnumMember returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEnumMember() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1981:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? ) )
            // InternalReflex.g:1982:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? )
            {
            // InternalReflex.g:1982:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? )
            // InternalReflex.g:1983:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )?
            {
            // InternalReflex.g:1983:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalReflex.g:1984:4: (lv_name_0_0= RULE_ID )
            {
            // InternalReflex.g:1984:4: (lv_name_0_0= RULE_ID )
            // InternalReflex.g:1985:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getEnumMemberAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumMemberRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:2001:3: (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==55) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalReflex.g:2002:4: otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,55,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getEnumMemberAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:2006:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalReflex.g:2007:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalReflex.g:2007:5: (lv_value_2_0= ruleExpression )
                    // InternalReflex.g:2008:6: lv_value_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEnumMemberAccess().getValueExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEnumMemberRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumMember"


    // $ANTLR start "entryRuleStatement"
    // InternalReflex.g:2030:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalReflex.g:2030:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalReflex.g:2031:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalReflex.g:2037:1: ruleStatement returns [EObject current=null] : ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_12=null;
        EObject this_CompoundStatement_2 = null;

        EObject this_StartProcStat_3 = null;

        EObject this_StopProcStat_4 = null;

        EObject this_ErrorStat_5 = null;

        EObject this_RestartStat_6 = null;

        EObject this_ResetStat_7 = null;

        EObject this_SetStateStat_8 = null;

        EObject this_IfElseStat_9 = null;

        EObject this_SwitchStat_10 = null;

        EObject this_Expression_11 = null;



        	enterRule();

        try {
            // InternalReflex.g:2043:2: ( ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) ) )
            // InternalReflex.g:2044:2: ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) )
            {
            // InternalReflex.g:2044:2: ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) )
            int alt24=11;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt24=1;
                }
                break;
            case 42:
                {
                alt24=2;
                }
                break;
            case 70:
                {
                alt24=3;
                }
                break;
            case 71:
                {
                alt24=4;
                }
                break;
            case 72:
                {
                alt24=5;
                }
                break;
            case 73:
                {
                alt24=6;
                }
                break;
            case 74:
                {
                alt24=7;
                }
                break;
            case 76:
                {
                alt24=8;
                }
                break;
            case 64:
                {
                alt24=9;
                }
                break;
            case 66:
                {
                alt24=10;
                }
                break;
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_TIME:
            case RULE_FLOAT:
            case RULE_BOOL_LITERAL:
            case 46:
            case 57:
            case 83:
            case 84:
            case 94:
            case 95:
            case 96:
            case 97:
                {
                alt24=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalReflex.g:2045:3: ( () otherlv_1= ';' )
                    {
                    // InternalReflex.g:2045:3: ( () otherlv_1= ';' )
                    // InternalReflex.g:2046:4: () otherlv_1= ';'
                    {
                    // InternalReflex.g:2046:4: ()
                    // InternalReflex.g:2047:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getStatementAccess().getStatementAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2059:3: this_CompoundStatement_2= ruleCompoundStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getCompoundStatementParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CompoundStatement_2=ruleCompoundStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CompoundStatement_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:2068:3: this_StartProcStat_3= ruleStartProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getStartProcStatParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StartProcStat_3=ruleStartProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StartProcStat_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:2077:3: this_StopProcStat_4= ruleStopProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getStopProcStatParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StopProcStat_4=ruleStopProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StopProcStat_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalReflex.g:2086:3: this_ErrorStat_5= ruleErrorStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getErrorStatParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ErrorStat_5=ruleErrorStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ErrorStat_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalReflex.g:2095:3: this_RestartStat_6= ruleRestartStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getRestartStatParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RestartStat_6=ruleRestartStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RestartStat_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalReflex.g:2104:3: this_ResetStat_7= ruleResetStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getResetStatParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ResetStat_7=ruleResetStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ResetStat_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalReflex.g:2113:3: this_SetStateStat_8= ruleSetStateStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSetStateStatParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SetStateStat_8=ruleSetStateStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetStateStat_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalReflex.g:2122:3: this_IfElseStat_9= ruleIfElseStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getIfElseStatParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfElseStat_9=ruleIfElseStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfElseStat_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalReflex.g:2131:3: this_SwitchStat_10= ruleSwitchStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSwitchStatParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SwitchStat_10=ruleSwitchStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SwitchStat_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalReflex.g:2140:3: (this_Expression_11= ruleExpression otherlv_12= ';' )
                    {
                    // InternalReflex.g:2140:3: (this_Expression_11= ruleExpression otherlv_12= ';' )
                    // InternalReflex.g:2141:4: this_Expression_11= ruleExpression otherlv_12= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStatementAccess().getExpressionParserRuleCall_10_0());
                      			
                    }
                    pushFollow(FOLLOW_10);
                    this_Expression_11=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_11;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_12=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getStatementAccess().getSemicolonKeyword_10_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleStatementSequence"
    // InternalReflex.g:2158:1: entryRuleStatementSequence returns [EObject current=null] : iv_ruleStatementSequence= ruleStatementSequence EOF ;
    public final EObject entryRuleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementSequence = null;


        try {
            // InternalReflex.g:2158:58: (iv_ruleStatementSequence= ruleStatementSequence EOF )
            // InternalReflex.g:2159:2: iv_ruleStatementSequence= ruleStatementSequence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatementSequence=ruleStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementSequence; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementSequence"


    // $ANTLR start "ruleStatementSequence"
    // InternalReflex.g:2165:1: ruleStatementSequence returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2171:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalReflex.g:2172:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalReflex.g:2172:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalReflex.g:2173:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalReflex.g:2173:3: ()
            // InternalReflex.g:2174:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStatementSequenceAccess().getStatementSequenceAction_0(),
              					current);
              			
            }

            }

            // InternalReflex.g:2180:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_TIME)||(LA25_0>=RULE_FLOAT && LA25_0<=RULE_BOOL_LITERAL)||LA25_0==42||(LA25_0>=45 && LA25_0<=46)||LA25_0==57||LA25_0==64||LA25_0==66||(LA25_0>=70 && LA25_0<=74)||LA25_0==76||(LA25_0>=83 && LA25_0<=84)||(LA25_0>=94 && LA25_0<=97)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalReflex.g:2181:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalReflex.g:2181:4: (lv_statements_1_0= ruleStatement )
            	    // InternalReflex.g:2182:5: lv_statements_1_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStatementSequenceAccess().getStatementsStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_statements_1_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getStatementSequenceRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_1_0,
            	      						"ru.iaie.reflex.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementSequence"


    // $ANTLR start "entryRuleCompoundStatement"
    // InternalReflex.g:2203:1: entryRuleCompoundStatement returns [EObject current=null] : iv_ruleCompoundStatement= ruleCompoundStatement EOF ;
    public final EObject entryRuleCompoundStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundStatement = null;


        try {
            // InternalReflex.g:2203:58: (iv_ruleCompoundStatement= ruleCompoundStatement EOF )
            // InternalReflex.g:2204:2: iv_ruleCompoundStatement= ruleCompoundStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompoundStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompoundStatement=ruleCompoundStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompoundStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompoundStatement"


    // $ANTLR start "ruleCompoundStatement"
    // InternalReflex.g:2210:1: ruleCompoundStatement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleCompoundStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2216:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // InternalReflex.g:2217:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // InternalReflex.g:2217:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // InternalReflex.g:2218:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // InternalReflex.g:2218:3: ()
            // InternalReflex.g:2219:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCompoundStatementAccess().getCompoundStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalReflex.g:2229:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_TIME)||(LA26_0>=RULE_FLOAT && LA26_0<=RULE_BOOL_LITERAL)||LA26_0==42||(LA26_0>=45 && LA26_0<=46)||LA26_0==57||LA26_0==64||LA26_0==66||(LA26_0>=70 && LA26_0<=74)||LA26_0==76||(LA26_0>=83 && LA26_0<=84)||(LA26_0>=94 && LA26_0<=97)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalReflex.g:2230:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalReflex.g:2230:4: (lv_statements_2_0= ruleStatement )
            	    // InternalReflex.g:2231:5: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundStatementAccess().getStatementsStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCompoundStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"ru.iaie.reflex.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_3=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCompoundStatementAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompoundStatement"


    // $ANTLR start "entryRuleIfElseStat"
    // InternalReflex.g:2256:1: entryRuleIfElseStat returns [EObject current=null] : iv_ruleIfElseStat= ruleIfElseStat EOF ;
    public final EObject entryRuleIfElseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfElseStat = null;


        try {
            // InternalReflex.g:2256:51: (iv_ruleIfElseStat= ruleIfElseStat EOF )
            // InternalReflex.g:2257:2: iv_ruleIfElseStat= ruleIfElseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfElseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfElseStat=ruleIfElseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfElseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfElseStat"


    // $ANTLR start "ruleIfElseStat"
    // InternalReflex.g:2263:1: ruleIfElseStat returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) ;
    public final EObject ruleIfElseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_cond_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2269:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) )
            // InternalReflex.g:2270:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            {
            // InternalReflex.g:2270:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            // InternalReflex.g:2271:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,64,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfElseStatAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,57,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfElseStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:2279:3: ( (lv_cond_2_0= ruleExpression ) )
            // InternalReflex.g:2280:4: (lv_cond_2_0= ruleExpression )
            {
            // InternalReflex.g:2280:4: (lv_cond_2_0= ruleExpression )
            // InternalReflex.g:2281:5: lv_cond_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getCondExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_33);
            lv_cond_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,58,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfElseStatAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalReflex.g:2302:3: ( (lv_then_4_0= ruleStatement ) )
            // InternalReflex.g:2303:4: (lv_then_4_0= ruleStatement )
            {
            // InternalReflex.g:2303:4: (lv_then_4_0= ruleStatement )
            // InternalReflex.g:2304:5: lv_then_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getThenStatementParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_41);
            lv_then_4_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"ru.iaie.reflex.Reflex.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2321:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==65) ) {
                int LA27_1 = input.LA(2);

                if ( (synpred1_InternalReflex()) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // InternalReflex.g:2322:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) )
                    {
                    // InternalReflex.g:2322:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalReflex.g:2323:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,65,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfElseStatAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalReflex.g:2329:4: ( (lv_else_6_0= ruleStatement ) )
                    // InternalReflex.g:2330:5: (lv_else_6_0= ruleStatement )
                    {
                    // InternalReflex.g:2330:5: (lv_else_6_0= ruleStatement )
                    // InternalReflex.g:2331:6: lv_else_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfElseStatAccess().getElseStatementParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_6_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfElseStatRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_6_0,
                      							"ru.iaie.reflex.Reflex.Statement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfElseStat"


    // $ANTLR start "entryRuleSwitchStat"
    // InternalReflex.g:2353:1: entryRuleSwitchStat returns [EObject current=null] : iv_ruleSwitchStat= ruleSwitchStat EOF ;
    public final EObject entryRuleSwitchStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStat = null;


        try {
            // InternalReflex.g:2353:51: (iv_ruleSwitchStat= ruleSwitchStat EOF )
            // InternalReflex.g:2354:2: iv_ruleSwitchStat= ruleSwitchStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitchStat=ruleSwitchStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchStat"


    // $ANTLR start "ruleSwitchStat"
    // InternalReflex.g:2360:1: ruleSwitchStat returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}' ) ;
    public final EObject ruleSwitchStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_expr_2_0 = null;

        EObject lv_options_5_0 = null;

        EObject lv_defaultOption_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2366:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}' ) )
            // InternalReflex.g:2367:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}' )
            {
            // InternalReflex.g:2367:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}' )
            // InternalReflex.g:2368:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,57,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:2376:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalReflex.g:2377:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalReflex.g:2377:4: (lv_expr_2_0= ruleExpression )
            // InternalReflex.g:2378:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_33);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,58,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,42,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:2403:3: ( (lv_options_5_0= ruleCaseStat ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==67) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalReflex.g:2404:4: (lv_options_5_0= ruleCaseStat )
            	    {
            	    // InternalReflex.g:2404:4: (lv_options_5_0= ruleCaseStat )
            	    // InternalReflex.g:2405:5: lv_options_5_0= ruleCaseStat
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchStatAccess().getOptionsCaseStatParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_options_5_0=ruleCaseStat();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
            	      					}
            	      					add(
            	      						current,
            	      						"options",
            	      						lv_options_5_0,
            	      						"ru.iaie.reflex.Reflex.CaseStat");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            // InternalReflex.g:2422:3: ( (lv_defaultOption_6_0= ruleDefaultStat ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==68) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalReflex.g:2423:4: (lv_defaultOption_6_0= ruleDefaultStat )
                    {
                    // InternalReflex.g:2423:4: (lv_defaultOption_6_0= ruleDefaultStat )
                    // InternalReflex.g:2424:5: lv_defaultOption_6_0= ruleDefaultStat
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSwitchStatAccess().getDefaultOptionDefaultStatParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_16);
                    lv_defaultOption_6_0=ruleDefaultStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
                      					}
                      					set(
                      						current,
                      						"defaultOption",
                      						lv_defaultOption_6_0,
                      						"ru.iaie.reflex.Reflex.DefaultStat");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getSwitchStatAccess().getRightCurlyBracketKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchStat"


    // $ANTLR start "entryRuleCaseStat"
    // InternalReflex.g:2449:1: entryRuleCaseStat returns [EObject current=null] : iv_ruleCaseStat= ruleCaseStat EOF ;
    public final EObject entryRuleCaseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStat = null;


        try {
            // InternalReflex.g:2449:49: (iv_ruleCaseStat= ruleCaseStat EOF )
            // InternalReflex.g:2450:2: iv_ruleCaseStat= ruleCaseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCaseStat=ruleCaseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseStat"


    // $ANTLR start "ruleCaseStat"
    // InternalReflex.g:2456:1: ruleCaseStat returns [EObject current=null] : (otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}' ) ;
    public final EObject ruleCaseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_option_1_0 = null;

        EObject this_SwitchOptionStatSequence_4 = null;



        	enterRule();

        try {
            // InternalReflex.g:2462:2: ( (otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}' ) )
            // InternalReflex.g:2463:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}' )
            {
            // InternalReflex.g:2463:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}' )
            // InternalReflex.g:2464:3: otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCaseStatAccess().getCaseKeyword_0());
              		
            }
            // InternalReflex.g:2468:3: ( (lv_option_1_0= ruleExpression ) )
            // InternalReflex.g:2469:4: (lv_option_1_0= ruleExpression )
            {
            // InternalReflex.g:2469:4: (lv_option_1_0= ruleExpression )
            // InternalReflex.g:2470:5: lv_option_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getOptionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_option_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"option",
              						lv_option_1_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,50,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCaseStatAccess().getColonKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,42,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCaseStatAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getCaseStatRule());
              			}
              			newCompositeNode(grammarAccess.getCaseStatAccess().getSwitchOptionStatSequenceParserRuleCall_4());
              		
            }
            pushFollow(FOLLOW_16);
            this_SwitchOptionStatSequence_4=ruleSwitchOptionStatSequence(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SwitchOptionStatSequence_4;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCaseStatAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseStat"


    // $ANTLR start "entryRuleDefaultStat"
    // InternalReflex.g:2514:1: entryRuleDefaultStat returns [EObject current=null] : iv_ruleDefaultStat= ruleDefaultStat EOF ;
    public final EObject entryRuleDefaultStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultStat = null;


        try {
            // InternalReflex.g:2514:52: (iv_ruleDefaultStat= ruleDefaultStat EOF )
            // InternalReflex.g:2515:2: iv_ruleDefaultStat= ruleDefaultStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefaultStat=ruleDefaultStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefaultStat"


    // $ANTLR start "ruleDefaultStat"
    // InternalReflex.g:2521:1: ruleDefaultStat returns [EObject current=null] : (otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}' ) ;
    public final EObject ruleDefaultStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_SwitchOptionStatSequence_3 = null;



        	enterRule();

        try {
            // InternalReflex.g:2527:2: ( (otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}' ) )
            // InternalReflex.g:2528:2: (otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}' )
            {
            // InternalReflex.g:2528:2: (otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}' )
            // InternalReflex.g:2529:3: otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDefaultStatAccess().getDefaultKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,50,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDefaultStatAccess().getColonKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,42,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDefaultStatAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getDefaultStatRule());
              			}
              			newCompositeNode(grammarAccess.getDefaultStatAccess().getSwitchOptionStatSequenceParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_16);
            this_SwitchOptionStatSequence_3=ruleSwitchOptionStatSequence(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SwitchOptionStatSequence_3;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_4=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getDefaultStatAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefaultStat"


    // $ANTLR start "ruleSwitchOptionStatSequence"
    // InternalReflex.g:2561:1: ruleSwitchOptionStatSequence[EObject in_current] returns [EObject current=in_current] : ( ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )? ) ;
    public final EObject ruleSwitchOptionStatSequence(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject lv_statements_0_0 = null;

        AntlrDatatypeRuleToken lv_hasBreak_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2567:2: ( ( ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )? ) )
            // InternalReflex.g:2568:2: ( ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )? )
            {
            // InternalReflex.g:2568:2: ( ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )? )
            // InternalReflex.g:2569:3: ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )?
            {
            // InternalReflex.g:2569:3: ( (lv_statements_0_0= ruleStatement ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_TIME)||(LA30_0>=RULE_FLOAT && LA30_0<=RULE_BOOL_LITERAL)||LA30_0==42||(LA30_0>=45 && LA30_0<=46)||LA30_0==57||LA30_0==64||LA30_0==66||(LA30_0>=70 && LA30_0<=74)||LA30_0==76||(LA30_0>=83 && LA30_0<=84)||(LA30_0>=94 && LA30_0<=97)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalReflex.g:2570:4: (lv_statements_0_0= ruleStatement )
            	    {
            	    // InternalReflex.g:2570:4: (lv_statements_0_0= ruleStatement )
            	    // InternalReflex.g:2571:5: lv_statements_0_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchOptionStatSequenceAccess().getStatementsStatementParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_44);
            	    lv_statements_0_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSwitchOptionStatSequenceRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_0_0,
            	      						"ru.iaie.reflex.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // InternalReflex.g:2588:3: ( (lv_hasBreak_1_0= ruleBreakStat ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==69) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalReflex.g:2589:4: (lv_hasBreak_1_0= ruleBreakStat )
                    {
                    // InternalReflex.g:2589:4: (lv_hasBreak_1_0= ruleBreakStat )
                    // InternalReflex.g:2590:5: lv_hasBreak_1_0= ruleBreakStat
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSwitchOptionStatSequenceAccess().getHasBreakBreakStatParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_hasBreak_1_0=ruleBreakStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSwitchOptionStatSequenceRule());
                      					}
                      					set(
                      						current,
                      						"hasBreak",
                      						lv_hasBreak_1_0 != null,
                      						"ru.iaie.reflex.Reflex.BreakStat");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchOptionStatSequence"


    // $ANTLR start "entryRuleBreakStat"
    // InternalReflex.g:2611:1: entryRuleBreakStat returns [String current=null] : iv_ruleBreakStat= ruleBreakStat EOF ;
    public final String entryRuleBreakStat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBreakStat = null;


        try {
            // InternalReflex.g:2611:49: (iv_ruleBreakStat= ruleBreakStat EOF )
            // InternalReflex.g:2612:2: iv_ruleBreakStat= ruleBreakStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBreakStat=ruleBreakStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreakStat.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBreakStat"


    // $ANTLR start "ruleBreakStat"
    // InternalReflex.g:2618:1: ruleBreakStat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'break' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleBreakStat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalReflex.g:2624:2: ( (kw= 'break' kw= ';' ) )
            // InternalReflex.g:2625:2: (kw= 'break' kw= ';' )
            {
            // InternalReflex.g:2625:2: (kw= 'break' kw= ';' )
            // InternalReflex.g:2626:3: kw= 'break' kw= ';'
            {
            kw=(Token)match(input,69,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getBreakStatAccess().getBreakKeyword_0());
              		
            }
            kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getBreakStatAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBreakStat"


    // $ANTLR start "entryRuleStartProcStat"
    // InternalReflex.g:2640:1: entryRuleStartProcStat returns [EObject current=null] : iv_ruleStartProcStat= ruleStartProcStat EOF ;
    public final EObject entryRuleStartProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcStat = null;


        try {
            // InternalReflex.g:2640:54: (iv_ruleStartProcStat= ruleStartProcStat EOF )
            // InternalReflex.g:2641:2: iv_ruleStartProcStat= ruleStartProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStartProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStartProcStat=ruleStartProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStartProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartProcStat"


    // $ANTLR start "ruleStartProcStat"
    // InternalReflex.g:2647:1: ruleStartProcStat returns [EObject current=null] : (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleStartProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:2653:2: ( (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalReflex.g:2654:2: (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:2654:2: (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            // InternalReflex.g:2655:3: otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,70,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStartProcStatAccess().getStartKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStartProcStatAccess().getProcessKeyword_1());
              		
            }
            // InternalReflex.g:2663:3: ( (otherlv_2= RULE_ID ) )
            // InternalReflex.g:2664:4: (otherlv_2= RULE_ID )
            {
            // InternalReflex.g:2664:4: (otherlv_2= RULE_ID )
            // InternalReflex.g:2665:5: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStartProcStatRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getStartProcStatAccess().getProcessProcessCrossReference_2_0());
              				
            }

            }


            }

            otherlv_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStartProcStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartProcStat"


    // $ANTLR start "entryRuleStopProcStat"
    // InternalReflex.g:2684:1: entryRuleStopProcStat returns [EObject current=null] : iv_ruleStopProcStat= ruleStopProcStat EOF ;
    public final EObject entryRuleStopProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcStat = null;


        try {
            // InternalReflex.g:2684:53: (iv_ruleStopProcStat= ruleStopProcStat EOF )
            // InternalReflex.g:2685:2: iv_ruleStopProcStat= ruleStopProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStopProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStopProcStat=ruleStopProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStopProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStopProcStat"


    // $ANTLR start "ruleStopProcStat"
    // InternalReflex.g:2691:1: ruleStopProcStat returns [EObject current=null] : ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleStopProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalReflex.g:2697:2: ( ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) )
            // InternalReflex.g:2698:2: ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            {
            // InternalReflex.g:2698:2: ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            // InternalReflex.g:2699:3: () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';'
            {
            // InternalReflex.g:2699:3: ()
            // InternalReflex.g:2700:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStopProcStatAccess().getStopProcStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStopProcStatAccess().getStopKeyword_1());
              		
            }
            // InternalReflex.g:2710:3: (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==46) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalReflex.g:2711:4: otherlv_2= 'process' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getStopProcStatAccess().getProcessKeyword_2_0());
                      			
                    }
                    // InternalReflex.g:2715:4: ( (otherlv_3= RULE_ID ) )
                    // InternalReflex.g:2716:5: (otherlv_3= RULE_ID )
                    {
                    // InternalReflex.g:2716:5: (otherlv_3= RULE_ID )
                    // InternalReflex.g:2717:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getStopProcStatRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getStopProcStatAccess().getProcessProcessCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getStopProcStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStopProcStat"


    // $ANTLR start "entryRuleErrorStat"
    // InternalReflex.g:2737:1: entryRuleErrorStat returns [EObject current=null] : iv_ruleErrorStat= ruleErrorStat EOF ;
    public final EObject entryRuleErrorStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorStat = null;


        try {
            // InternalReflex.g:2737:50: (iv_ruleErrorStat= ruleErrorStat EOF )
            // InternalReflex.g:2738:2: iv_ruleErrorStat= ruleErrorStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleErrorStat=ruleErrorStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorStat"


    // $ANTLR start "ruleErrorStat"
    // InternalReflex.g:2744:1: ruleErrorStat returns [EObject current=null] : ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleErrorStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalReflex.g:2750:2: ( ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) )
            // InternalReflex.g:2751:2: ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            {
            // InternalReflex.g:2751:2: ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            // InternalReflex.g:2752:3: () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';'
            {
            // InternalReflex.g:2752:3: ()
            // InternalReflex.g:2753:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getErrorStatAccess().getErrorStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,72,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getErrorStatAccess().getErrorKeyword_1());
              		
            }
            // InternalReflex.g:2763:3: (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==46) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalReflex.g:2764:4: otherlv_2= 'process' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getErrorStatAccess().getProcessKeyword_2_0());
                      			
                    }
                    // InternalReflex.g:2768:4: ( (otherlv_3= RULE_ID ) )
                    // InternalReflex.g:2769:5: (otherlv_3= RULE_ID )
                    {
                    // InternalReflex.g:2769:5: (otherlv_3= RULE_ID )
                    // InternalReflex.g:2770:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getErrorStatRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getErrorStatAccess().getProcessProcessCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getErrorStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErrorStat"


    // $ANTLR start "entryRuleRestartStat"
    // InternalReflex.g:2790:1: entryRuleRestartStat returns [EObject current=null] : iv_ruleRestartStat= ruleRestartStat EOF ;
    public final EObject entryRuleRestartStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestartStat = null;


        try {
            // InternalReflex.g:2790:52: (iv_ruleRestartStat= ruleRestartStat EOF )
            // InternalReflex.g:2791:2: iv_ruleRestartStat= ruleRestartStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRestartStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRestartStat=ruleRestartStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRestartStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestartStat"


    // $ANTLR start "ruleRestartStat"
    // InternalReflex.g:2797:1: ruleRestartStat returns [EObject current=null] : ( () otherlv_1= 'restart' otherlv_2= ';' ) ;
    public final EObject ruleRestartStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:2803:2: ( ( () otherlv_1= 'restart' otherlv_2= ';' ) )
            // InternalReflex.g:2804:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            {
            // InternalReflex.g:2804:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            // InternalReflex.g:2805:3: () otherlv_1= 'restart' otherlv_2= ';'
            {
            // InternalReflex.g:2805:3: ()
            // InternalReflex.g:2806:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRestartStatAccess().getRestartStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,73,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRestartStatAccess().getRestartKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRestartStatAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestartStat"


    // $ANTLR start "entryRuleResetStat"
    // InternalReflex.g:2824:1: entryRuleResetStat returns [EObject current=null] : iv_ruleResetStat= ruleResetStat EOF ;
    public final EObject entryRuleResetStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetStat = null;


        try {
            // InternalReflex.g:2824:50: (iv_ruleResetStat= ruleResetStat EOF )
            // InternalReflex.g:2825:2: iv_ruleResetStat= ruleResetStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResetStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleResetStat=ruleResetStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResetStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResetStat"


    // $ANTLR start "ruleResetStat"
    // InternalReflex.g:2831:1: ruleResetStat returns [EObject current=null] : ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' ) ;
    public final EObject ruleResetStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:2837:2: ( ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' ) )
            // InternalReflex.g:2838:2: ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' )
            {
            // InternalReflex.g:2838:2: ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' )
            // InternalReflex.g:2839:3: () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';'
            {
            // InternalReflex.g:2839:3: ()
            // InternalReflex.g:2840:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getResetStatAccess().getResetStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,74,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getResetStatAccess().getResetKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,75,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getResetStatAccess().getTimerKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getResetStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResetStat"


    // $ANTLR start "entryRuleSetStateStat"
    // InternalReflex.g:2862:1: entryRuleSetStateStat returns [EObject current=null] : iv_ruleSetStateStat= ruleSetStateStat EOF ;
    public final EObject entryRuleSetStateStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStat = null;


        try {
            // InternalReflex.g:2862:53: (iv_ruleSetStateStat= ruleSetStateStat EOF )
            // InternalReflex.g:2863:2: iv_ruleSetStateStat= ruleSetStateStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetStateStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetStateStat=ruleSetStateStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetStateStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetStateStat"


    // $ANTLR start "ruleSetStateStat"
    // InternalReflex.g:2869:1: ruleSetStateStat returns [EObject current=null] : ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' ) ;
    public final EObject ruleSetStateStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_next_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalReflex.g:2875:2: ( ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' ) )
            // InternalReflex.g:2876:2: ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' )
            {
            // InternalReflex.g:2876:2: ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' )
            // InternalReflex.g:2877:3: () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';'
            {
            // InternalReflex.g:2877:3: ()
            // InternalReflex.g:2878:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetStateStatAccess().getSetStateStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,76,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetStateStatAccess().getSetKeyword_1());
              		
            }
            // InternalReflex.g:2888:3: ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==77) ) {
                alt34=1;
            }
            else if ( (LA34_0==48) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalReflex.g:2889:4: ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' )
                    {
                    // InternalReflex.g:2889:4: ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' )
                    // InternalReflex.g:2890:5: ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state'
                    {
                    // InternalReflex.g:2890:5: ( (lv_next_2_0= 'next' ) )
                    // InternalReflex.g:2891:6: (lv_next_2_0= 'next' )
                    {
                    // InternalReflex.g:2891:6: (lv_next_2_0= 'next' )
                    // InternalReflex.g:2892:7: lv_next_2_0= 'next'
                    {
                    lv_next_2_0=(Token)match(input,77,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_next_2_0, grammarAccess.getSetStateStatAccess().getNextNextKeyword_2_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getSetStateStatRule());
                      							}
                      							setWithLastConsumed(current, "next", lv_next_2_0 != null, "next");
                      						
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,48,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getSetStateStatAccess().getStateKeyword_2_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2910:4: (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalReflex.g:2910:4: (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) )
                    // InternalReflex.g:2911:5: otherlv_4= 'state' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,48,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getSetStateStatAccess().getStateKeyword_2_1_0());
                      				
                    }
                    // InternalReflex.g:2915:5: ( (otherlv_5= RULE_ID ) )
                    // InternalReflex.g:2916:6: (otherlv_5= RULE_ID )
                    {
                    // InternalReflex.g:2916:6: (otherlv_5= RULE_ID )
                    // InternalReflex.g:2917:7: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getSetStateStatRule());
                      							}
                      						
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_5, grammarAccess.getSetStateStatAccess().getStateStateCrossReference_2_1_1_0());
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSetStateStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetStateStat"


    // $ANTLR start "entryRuleInfixOp"
    // InternalReflex.g:2938:1: entryRuleInfixOp returns [EObject current=null] : iv_ruleInfixOp= ruleInfixOp EOF ;
    public final EObject entryRuleInfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOp = null;


        try {
            // InternalReflex.g:2938:48: (iv_ruleInfixOp= ruleInfixOp EOF )
            // InternalReflex.g:2939:2: iv_ruleInfixOp= ruleInfixOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInfixOp=ruleInfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixOp"


    // $ANTLR start "ruleInfixOp"
    // InternalReflex.g:2945:1: ruleInfixOp returns [EObject current=null] : ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleInfixOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_op_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2951:2: ( ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) ) ) )
            // InternalReflex.g:2952:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalReflex.g:2952:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) ) )
            // InternalReflex.g:2953:3: ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) )
            {
            // InternalReflex.g:2953:3: ( (lv_op_0_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2954:4: (lv_op_0_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2954:4: (lv_op_0_0= ruleInfixPostfixOp )
            // InternalReflex.g:2955:5: lv_op_0_0= ruleInfixPostfixOp
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInfixOpAccess().getOpInfixPostfixOpEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_op_0_0=ruleInfixPostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInfixOpRule());
              					}
              					set(
              						current,
              						"op",
              						lv_op_0_0,
              						"ru.iaie.reflex.Reflex.InfixPostfixOp");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2972:3: ( (otherlv_1= RULE_ID ) )
            // InternalReflex.g:2973:4: (otherlv_1= RULE_ID )
            {
            // InternalReflex.g:2973:4: (otherlv_1= RULE_ID )
            // InternalReflex.g:2974:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInfixOpRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getInfixOpAccess().getRefIdReferenceCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixOp"


    // $ANTLR start "entryRulePostfixOp"
    // InternalReflex.g:2989:1: entryRulePostfixOp returns [EObject current=null] : iv_rulePostfixOp= rulePostfixOp EOF ;
    public final EObject entryRulePostfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOp = null;


        try {
            // InternalReflex.g:2989:50: (iv_rulePostfixOp= rulePostfixOp EOF )
            // InternalReflex.g:2990:2: iv_rulePostfixOp= rulePostfixOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixOp=rulePostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixOp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostfixOp"


    // $ANTLR start "rulePostfixOp"
    // InternalReflex.g:2996:1: rulePostfixOp returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) ;
    public final EObject rulePostfixOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_op_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3002:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) )
            // InternalReflex.g:3003:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            {
            // InternalReflex.g:3003:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            // InternalReflex.g:3004:3: ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) )
            {
            // InternalReflex.g:3004:3: ( (otherlv_0= RULE_ID ) )
            // InternalReflex.g:3005:4: (otherlv_0= RULE_ID )
            {
            // InternalReflex.g:3005:4: (otherlv_0= RULE_ID )
            // InternalReflex.g:3006:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPostfixOpRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getPostfixOpAccess().getRefIdReferenceCrossReference_0_0());
              				
            }

            }


            }

            // InternalReflex.g:3017:3: ( (lv_op_1_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:3018:4: (lv_op_1_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:3018:4: (lv_op_1_0= ruleInfixPostfixOp )
            // InternalReflex.g:3019:5: lv_op_1_0= ruleInfixPostfixOp
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPostfixOpAccess().getOpInfixPostfixOpEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_op_1_0=ruleInfixPostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPostfixOpRule());
              					}
              					set(
              						current,
              						"op",
              						lv_op_1_0,
              						"ru.iaie.reflex.Reflex.InfixPostfixOp");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostfixOp"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalReflex.g:3040:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalReflex.g:3040:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalReflex.g:3041:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalReflex.g:3047:1: ruleFunctionCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3053:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalReflex.g:3054:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalReflex.g:3054:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            // InternalReflex.g:3055:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalReflex.g:3055:3: ( (otherlv_0= RULE_ID ) )
            // InternalReflex.g:3056:4: (otherlv_0= RULE_ID )
            {
            // InternalReflex.g:3056:4: (otherlv_0= RULE_ID )
            // InternalReflex.g:3057:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionCallRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getFunctionCallAccess().getFunctionFunctionCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,57,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:3072:3: ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_ID && LA36_0<=RULE_TIME)||(LA36_0>=RULE_FLOAT && LA36_0<=RULE_BOOL_LITERAL)||LA36_0==46||LA36_0==57||(LA36_0>=83 && LA36_0<=84)||(LA36_0>=94 && LA36_0<=97)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalReflex.g:3073:4: ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    {
                    // InternalReflex.g:3073:4: ( (lv_args_2_0= ruleExpression ) )
                    // InternalReflex.g:3074:5: (lv_args_2_0= ruleExpression )
                    {
                    // InternalReflex.g:3074:5: (lv_args_2_0= ruleExpression )
                    // InternalReflex.g:3075:6: lv_args_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_36);
                    lv_args_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                      						}
                      						add(
                      							current,
                      							"args",
                      							lv_args_2_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3092:4: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==53) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalReflex.g:3093:5: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,53,FOLLOW_31); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalReflex.g:3097:5: ( (lv_args_4_0= ruleExpression ) )
                    	    // InternalReflex.g:3098:6: (lv_args_4_0= ruleExpression )
                    	    {
                    	    // InternalReflex.g:3098:6: (lv_args_4_0= ruleExpression )
                    	    // InternalReflex.g:3099:7: lv_args_4_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_36);
                    	    lv_args_4_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"args",
                    	      								lv_args_4_0,
                    	      								"ru.iaie.reflex.Reflex.Expression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleCheckStateExpression"
    // InternalReflex.g:3126:1: entryRuleCheckStateExpression returns [EObject current=null] : iv_ruleCheckStateExpression= ruleCheckStateExpression EOF ;
    public final EObject entryRuleCheckStateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckStateExpression = null;


        try {
            // InternalReflex.g:3126:61: (iv_ruleCheckStateExpression= ruleCheckStateExpression EOF )
            // InternalReflex.g:3127:2: iv_ruleCheckStateExpression= ruleCheckStateExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCheckStateExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCheckStateExpression=ruleCheckStateExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCheckStateExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCheckStateExpression"


    // $ANTLR start "ruleCheckStateExpression"
    // InternalReflex.g:3133:1: ruleCheckStateExpression returns [EObject current=null] : (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) ) ;
    public final EObject ruleCheckStateExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_qualfier_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3139:2: ( (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) ) )
            // InternalReflex.g:3140:2: (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) )
            {
            // InternalReflex.g:3140:2: (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) )
            // InternalReflex.g:3141:3: otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCheckStateExpressionAccess().getProcessKeyword_0());
              		
            }
            // InternalReflex.g:3145:3: ( (otherlv_1= RULE_ID ) )
            // InternalReflex.g:3146:4: (otherlv_1= RULE_ID )
            {
            // InternalReflex.g:3146:4: (otherlv_1= RULE_ID )
            // InternalReflex.g:3147:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCheckStateExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getCheckStateExpressionAccess().getProcessProcessCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,78,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCheckStateExpressionAccess().getInKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,48,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCheckStateExpressionAccess().getStateKeyword_3());
              		
            }
            // InternalReflex.g:3166:3: ( (lv_qualfier_4_0= ruleStateQualifier ) )
            // InternalReflex.g:3167:4: (lv_qualfier_4_0= ruleStateQualifier )
            {
            // InternalReflex.g:3167:4: (lv_qualfier_4_0= ruleStateQualifier )
            // InternalReflex.g:3168:5: lv_qualfier_4_0= ruleStateQualifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCheckStateExpressionAccess().getQualfierStateQualifierEnumRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_qualfier_4_0=ruleStateQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCheckStateExpressionRule());
              					}
              					set(
              						current,
              						"qualfier",
              						lv_qualfier_4_0,
              						"ru.iaie.reflex.Reflex.StateQualifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCheckStateExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalReflex.g:3189:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalReflex.g:3189:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalReflex.g:3190:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalReflex.g:3196:1: rulePrimaryExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) ) | ( () ( (lv_time_8_0= RULE_TIME ) ) ) | (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_integer_2_0=null;
        Token lv_floating_4_0=null;
        Token lv_bool_6_0=null;
        Token lv_time_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_nestedExpr_10_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3202:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) ) | ( () ( (lv_time_8_0= RULE_TIME ) ) ) | (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' ) ) )
            // InternalReflex.g:3203:2: ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) ) | ( () ( (lv_time_8_0= RULE_TIME ) ) ) | (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            {
            // InternalReflex.g:3203:2: ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) ) | ( () ( (lv_time_8_0= RULE_TIME ) ) ) | (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            int alt37=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt37=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt37=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt37=3;
                }
                break;
            case RULE_BOOL_LITERAL:
                {
                alt37=4;
                }
                break;
            case RULE_TIME:
                {
                alt37=5;
                }
                break;
            case 57:
                {
                alt37=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalReflex.g:3204:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalReflex.g:3204:3: ( (otherlv_0= RULE_ID ) )
                    // InternalReflex.g:3205:4: (otherlv_0= RULE_ID )
                    {
                    // InternalReflex.g:3205:4: (otherlv_0= RULE_ID )
                    // InternalReflex.g:3206:5: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      					}
                      				
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getReferenceIdReferenceCrossReference_0_0());
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3218:3: ( () ( (lv_integer_2_0= RULE_INTEGER ) ) )
                    {
                    // InternalReflex.g:3218:3: ( () ( (lv_integer_2_0= RULE_INTEGER ) ) )
                    // InternalReflex.g:3219:4: () ( (lv_integer_2_0= RULE_INTEGER ) )
                    {
                    // InternalReflex.g:3219:4: ()
                    // InternalReflex.g:3220:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:3226:4: ( (lv_integer_2_0= RULE_INTEGER ) )
                    // InternalReflex.g:3227:5: (lv_integer_2_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:3227:5: (lv_integer_2_0= RULE_INTEGER )
                    // InternalReflex.g:3228:6: lv_integer_2_0= RULE_INTEGER
                    {
                    lv_integer_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_integer_2_0, grammarAccess.getPrimaryExpressionAccess().getIntegerINTEGERTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"integer",
                      							lv_integer_2_0,
                      							"ru.iaie.reflex.Reflex.INTEGER");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:3246:3: ( () ( (lv_floating_4_0= RULE_FLOAT ) ) )
                    {
                    // InternalReflex.g:3246:3: ( () ( (lv_floating_4_0= RULE_FLOAT ) ) )
                    // InternalReflex.g:3247:4: () ( (lv_floating_4_0= RULE_FLOAT ) )
                    {
                    // InternalReflex.g:3247:4: ()
                    // InternalReflex.g:3248:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:3254:4: ( (lv_floating_4_0= RULE_FLOAT ) )
                    // InternalReflex.g:3255:5: (lv_floating_4_0= RULE_FLOAT )
                    {
                    // InternalReflex.g:3255:5: (lv_floating_4_0= RULE_FLOAT )
                    // InternalReflex.g:3256:6: lv_floating_4_0= RULE_FLOAT
                    {
                    lv_floating_4_0=(Token)match(input,RULE_FLOAT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_floating_4_0, grammarAccess.getPrimaryExpressionAccess().getFloatingFLOATTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"floating",
                      							lv_floating_4_0,
                      							"ru.iaie.reflex.Reflex.FLOAT");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:3274:3: ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) )
                    {
                    // InternalReflex.g:3274:3: ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) )
                    // InternalReflex.g:3275:4: () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) )
                    {
                    // InternalReflex.g:3275:4: ()
                    // InternalReflex.g:3276:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:3282:4: ( (lv_bool_6_0= RULE_BOOL_LITERAL ) )
                    // InternalReflex.g:3283:5: (lv_bool_6_0= RULE_BOOL_LITERAL )
                    {
                    // InternalReflex.g:3283:5: (lv_bool_6_0= RULE_BOOL_LITERAL )
                    // InternalReflex.g:3284:6: lv_bool_6_0= RULE_BOOL_LITERAL
                    {
                    lv_bool_6_0=(Token)match(input,RULE_BOOL_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_bool_6_0, grammarAccess.getPrimaryExpressionAccess().getBoolBOOL_LITERALTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"bool",
                      							lv_bool_6_0,
                      							"ru.iaie.reflex.Reflex.BOOL_LITERAL");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:3302:3: ( () ( (lv_time_8_0= RULE_TIME ) ) )
                    {
                    // InternalReflex.g:3302:3: ( () ( (lv_time_8_0= RULE_TIME ) ) )
                    // InternalReflex.g:3303:4: () ( (lv_time_8_0= RULE_TIME ) )
                    {
                    // InternalReflex.g:3303:4: ()
                    // InternalReflex.g:3304:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:3310:4: ( (lv_time_8_0= RULE_TIME ) )
                    // InternalReflex.g:3311:5: (lv_time_8_0= RULE_TIME )
                    {
                    // InternalReflex.g:3311:5: (lv_time_8_0= RULE_TIME )
                    // InternalReflex.g:3312:6: lv_time_8_0= RULE_TIME
                    {
                    lv_time_8_0=(Token)match(input,RULE_TIME,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_time_8_0, grammarAccess.getPrimaryExpressionAccess().getTimeTIMETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"time",
                      							lv_time_8_0,
                      							"ru.iaie.reflex.Reflex.TIME");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:3330:3: (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' )
                    {
                    // InternalReflex.g:3330:3: (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' )
                    // InternalReflex.g:3331:4: otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,57,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_5_0());
                      			
                    }
                    // InternalReflex.g:3335:4: ( (lv_nestedExpr_10_0= ruleExpression ) )
                    // InternalReflex.g:3336:5: (lv_nestedExpr_10_0= ruleExpression )
                    {
                    // InternalReflex.g:3336:5: (lv_nestedExpr_10_0= ruleExpression )
                    // InternalReflex.g:3337:6: lv_nestedExpr_10_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNestedExprExpressionParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
                    lv_nestedExpr_10_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"nestedExpr",
                      							lv_nestedExpr_10_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_11=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_5_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalReflex.g:3363:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalReflex.g:3363:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalReflex.g:3364:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalReflex.g:3370:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject this_FunctionCall_1 = null;

        EObject this_PostfixOp_2 = null;

        EObject this_InfixOp_3 = null;

        Enumerator lv_unaryOp_4_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3376:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:3377:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:3377:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) )
            int alt38=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case EOF:
                case RULE_BIT_AND:
                case RULE_BIT_XOR:
                case RULE_BIT_OR:
                case RULE_LOGICAL_AND:
                case RULE_LOGICAL_OR:
                case 43:
                case 45:
                case 50:
                case 53:
                case 58:
                case 94:
                case 95:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                    {
                    alt38=1;
                    }
                    break;
                case 83:
                case 84:
                    {
                    alt38=3;
                    }
                    break;
                case 57:
                    {
                    alt38=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_INTEGER:
            case RULE_TIME:
            case RULE_FLOAT:
            case RULE_BOOL_LITERAL:
            case 57:
                {
                alt38=1;
                }
                break;
            case 83:
            case 84:
                {
                alt38=4;
                }
                break;
            case 94:
            case 95:
            case 96:
            case 97:
                {
                alt38=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalReflex.g:3378:3: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrimaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3387:3: this_FunctionCall_1= ruleFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getFunctionCallParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionCall_1=ruleFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionCall_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:3396:3: this_PostfixOp_2= rulePostfixOp
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixOpParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostfixOp_2=rulePostfixOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostfixOp_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:3405:3: this_InfixOp_3= ruleInfixOp
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getInfixOpParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InfixOp_3=ruleInfixOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InfixOp_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalReflex.g:3414:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:3414:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) )
                    // InternalReflex.g:3415:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) )
                    {
                    // InternalReflex.g:3415:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) )
                    // InternalReflex.g:3416:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    {
                    // InternalReflex.g:3416:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    // InternalReflex.g:3417:6: lv_unaryOp_4_0= ruleUnaryOp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryOpUnaryOpEnumRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
                    lv_unaryOp_4_0=ruleUnaryOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"unaryOp",
                      							lv_unaryOp_4_0,
                      							"ru.iaie.reflex.Reflex.UnaryOp");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3434:4: ( (lv_right_5_0= ruleCastExpression ) )
                    // InternalReflex.g:3435:5: (lv_right_5_0= ruleCastExpression )
                    {
                    // InternalReflex.g:3435:5: (lv_right_5_0= ruleCastExpression )
                    // InternalReflex.g:3436:6: lv_right_5_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getRightCastExpressionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_5_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_5_0,
                      							"ru.iaie.reflex.Reflex.CastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleCastExpression"
    // InternalReflex.g:3458:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalReflex.g:3458:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalReflex.g:3459:2: iv_ruleCastExpression= ruleCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCastExpression=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCastExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCastExpression"


    // $ANTLR start "ruleCastExpression"
    // InternalReflex.g:3465:1: ruleCastExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_UnaryExpression_0 = null;

        Enumerator lv_type_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3471:2: ( (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:3472:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:3472:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_TIME)||(LA39_0>=RULE_FLOAT && LA39_0<=RULE_BOOL_LITERAL)||(LA39_0>=83 && LA39_0<=84)||(LA39_0>=94 && LA39_0<=97)) ) {
                alt39=1;
            }
            else if ( (LA39_0==57) ) {
                int LA39_2 = input.LA(2);

                if ( ((LA39_2>=109 && LA39_2<=121)) ) {
                    alt39=2;
                }
                else if ( ((LA39_2>=RULE_ID && LA39_2<=RULE_TIME)||(LA39_2>=RULE_FLOAT && LA39_2<=RULE_BOOL_LITERAL)||LA39_2==46||LA39_2==57||(LA39_2>=83 && LA39_2<=84)||(LA39_2>=94 && LA39_2<=97)) ) {
                    alt39=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalReflex.g:3473:3: this_UnaryExpression_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCastExpressionAccess().getUnaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpression_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3482:3: (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:3482:3: (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    // InternalReflex.g:3483:4: otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,57,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:3487:4: ( (lv_type_2_0= ruleType ) )
                    // InternalReflex.g:3488:5: (lv_type_2_0= ruleType )
                    {
                    // InternalReflex.g:3488:5: (lv_type_2_0= ruleType )
                    // InternalReflex.g:3489:6: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeTypeEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
                    lv_type_2_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_2_0,
                      							"ru.iaie.reflex.Reflex.Type");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,58,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalReflex.g:3510:4: ( (lv_right_4_0= ruleCastExpression ) )
                    // InternalReflex.g:3511:5: (lv_right_4_0= ruleCastExpression )
                    {
                    // InternalReflex.g:3511:5: (lv_right_4_0= ruleCastExpression )
                    // InternalReflex.g:3512:6: lv_right_4_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getRightCastExpressionParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_4_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_4_0,
                      							"ru.iaie.reflex.Reflex.CastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCastExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalReflex.g:3534:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalReflex.g:3534:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalReflex.g:3535:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalReflex.g:3541:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CastExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3547:2: ( (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) )
            // InternalReflex.g:3548:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            {
            // InternalReflex.g:3548:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            // InternalReflex.g:3549:3: this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_53);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3557:3: ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=106 && LA40_0<=108)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalReflex.g:3558:4: () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) )
            	    {
            	    // InternalReflex.g:3558:4: ()
            	    // InternalReflex.g:3559:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3565:4: ( (lv_mulOp_2_0= ruleMultiplicativeOp ) )
            	    // InternalReflex.g:3566:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    {
            	    // InternalReflex.g:3566:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    // InternalReflex.g:3567:6: lv_mulOp_2_0= ruleMultiplicativeOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getMulOpMultiplicativeOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_mulOp_2_0=ruleMultiplicativeOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"mulOp",
            	      							lv_mulOp_2_0,
            	      							"ru.iaie.reflex.Reflex.MultiplicativeOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3584:4: ( (lv_right_3_0= ruleCastExpression ) )
            	    // InternalReflex.g:3585:5: (lv_right_3_0= ruleCastExpression )
            	    {
            	    // InternalReflex.g:3585:5: (lv_right_3_0= ruleCastExpression )
            	    // InternalReflex.g:3586:6: lv_right_3_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightCastExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_53);
            	    lv_right_3_0=ruleCastExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.CastExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalReflex.g:3608:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalReflex.g:3608:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalReflex.g:3609:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalReflex.g:3615:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3621:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalReflex.g:3622:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalReflex.g:3622:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalReflex.g:3623:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_54);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3631:3: ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==94) ) {
                    alt41=1;
                }
                else if ( (LA41_0==95) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalReflex.g:3632:4: () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalReflex.g:3632:4: ()
            	    // InternalReflex.g:3633:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3639:4: ( (lv_addOp_2_0= ruleAdditiveOp ) )
            	    // InternalReflex.g:3640:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    {
            	    // InternalReflex.g:3640:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    // InternalReflex.g:3641:6: lv_addOp_2_0= ruleAdditiveOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getAddOpAdditiveOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_addOp_2_0=ruleAdditiveOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"addOp",
            	      							lv_addOp_2_0,
            	      							"ru.iaie.reflex.Reflex.AdditiveOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3658:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalReflex.g:3659:5: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalReflex.g:3659:5: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalReflex.g:3660:6: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_54);
            	    lv_right_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.AdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalReflex.g:3682:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalReflex.g:3682:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalReflex.g:3683:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // InternalReflex.g:3689:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        Enumerator lv_shiftOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3695:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) )
            // InternalReflex.g:3696:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            {
            // InternalReflex.g:3696:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            // InternalReflex.g:3697:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_55);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3705:3: ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==104) ) {
                    alt42=1;
                }
                else if ( (LA42_0==105) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalReflex.g:3706:4: () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalReflex.g:3706:4: ()
            	    // InternalReflex.g:3707:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3713:4: ( (lv_shiftOp_2_0= ruleShiftOp ) )
            	    // InternalReflex.g:3714:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    {
            	    // InternalReflex.g:3714:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    // InternalReflex.g:3715:6: lv_shiftOp_2_0= ruleShiftOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getShiftOpShiftOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_shiftOp_2_0=ruleShiftOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"shiftOp",
            	      							lv_shiftOp_2_0,
            	      							"ru.iaie.reflex.Reflex.ShiftOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3732:4: ( (lv_right_3_0= ruleShiftExpression ) )
            	    // InternalReflex.g:3733:5: (lv_right_3_0= ruleShiftExpression )
            	    {
            	    // InternalReflex.g:3733:5: (lv_right_3_0= ruleShiftExpression )
            	    // InternalReflex.g:3734:6: lv_right_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightShiftExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_55);
            	    lv_right_3_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.ShiftExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleCompareExpression"
    // InternalReflex.g:3756:1: entryRuleCompareExpression returns [EObject current=null] : iv_ruleCompareExpression= ruleCompareExpression EOF ;
    public final EObject entryRuleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpression = null;


        try {
            // InternalReflex.g:3756:58: (iv_ruleCompareExpression= ruleCompareExpression EOF )
            // InternalReflex.g:3757:2: iv_ruleCompareExpression= ruleCompareExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompareExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompareExpression=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompareExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompareExpression"


    // $ANTLR start "ruleCompareExpression"
    // InternalReflex.g:3763:1: ruleCompareExpression returns [EObject current=null] : (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) ) ;
    public final EObject ruleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CheckStateExpression_0 = null;

        EObject this_ShiftExpression_1 = null;

        Enumerator lv_cmpOp_3_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3769:2: ( (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) ) )
            // InternalReflex.g:3770:2: (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) )
            {
            // InternalReflex.g:3770:2: (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==46) ) {
                alt44=1;
            }
            else if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_TIME)||(LA44_0>=RULE_FLOAT && LA44_0<=RULE_BOOL_LITERAL)||LA44_0==57||(LA44_0>=83 && LA44_0<=84)||(LA44_0>=94 && LA44_0<=97)) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalReflex.g:3771:3: this_CheckStateExpression_0= ruleCheckStateExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCompareExpressionAccess().getCheckStateExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CheckStateExpression_0=ruleCheckStateExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CheckStateExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3780:3: (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* )
                    {
                    // InternalReflex.g:3780:3: (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* )
                    // InternalReflex.g:3781:4: this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCompareExpressionAccess().getShiftExpressionParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_56);
                    this_ShiftExpression_1=ruleShiftExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ShiftExpression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalReflex.g:3789:4: ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        switch ( input.LA(1) ) {
                        case 98:
                            {
                            alt43=1;
                            }
                            break;
                        case 99:
                            {
                            alt43=1;
                            }
                            break;
                        case 100:
                            {
                            alt43=1;
                            }
                            break;
                        case 101:
                            {
                            alt43=1;
                            }
                            break;

                        }

                        switch (alt43) {
                    	case 1 :
                    	    // InternalReflex.g:3790:5: () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) )
                    	    {
                    	    // InternalReflex.g:3790:5: ()
                    	    // InternalReflex.g:3791:6: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						current = forceCreateModelElementAndSet(
                    	      							grammarAccess.getCompareExpressionAccess().getCompareExpressionLeftAction_1_1_0(),
                    	      							current);
                    	      					
                    	    }

                    	    }

                    	    // InternalReflex.g:3797:5: ( (lv_cmpOp_3_0= ruleCompareOp ) )
                    	    // InternalReflex.g:3798:6: (lv_cmpOp_3_0= ruleCompareOp )
                    	    {
                    	    // InternalReflex.g:3798:6: (lv_cmpOp_3_0= ruleCompareOp )
                    	    // InternalReflex.g:3799:7: lv_cmpOp_3_0= ruleCompareOp
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCompareExpressionAccess().getCmpOpCompareOpEnumRuleCall_1_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_31);
                    	    lv_cmpOp_3_0=ruleCompareOp();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getCompareExpressionRule());
                    	      							}
                    	      							set(
                    	      								current,
                    	      								"cmpOp",
                    	      								lv_cmpOp_3_0,
                    	      								"ru.iaie.reflex.Reflex.CompareOp");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // InternalReflex.g:3816:5: ( (lv_right_4_0= ruleCompareExpression ) )
                    	    // InternalReflex.g:3817:6: (lv_right_4_0= ruleCompareExpression )
                    	    {
                    	    // InternalReflex.g:3817:6: (lv_right_4_0= ruleCompareExpression )
                    	    // InternalReflex.g:3818:7: lv_right_4_0= ruleCompareExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCompareExpressionAccess().getRightCompareExpressionParserRuleCall_1_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_56);
                    	    lv_right_4_0=ruleCompareExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getCompareExpressionRule());
                    	      							}
                    	      							set(
                    	      								current,
                    	      								"right",
                    	      								lv_right_4_0,
                    	      								"ru.iaie.reflex.Reflex.CompareExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalReflex.g:3841:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalReflex.g:3841:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalReflex.g:3842:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalReflex.g:3848:1: ruleEqualityExpression returns [EObject current=null] : (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpression_0 = null;

        Enumerator lv_eqCmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3854:2: ( (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalReflex.g:3855:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalReflex.g:3855:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalReflex.g:3856:3: this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getCompareExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_57);
            this_CompareExpression_0=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CompareExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3864:3: ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==102) ) {
                    alt45=1;
                }
                else if ( (LA45_0==103) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalReflex.g:3865:4: () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalReflex.g:3865:4: ()
            	    // InternalReflex.g:3866:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3872:4: ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) )
            	    // InternalReflex.g:3873:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    {
            	    // InternalReflex.g:3873:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    // InternalReflex.g:3874:6: lv_eqCmpOp_2_0= ruleCompareEqOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getEqCmpOpCompareEqOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_eqCmpOp_2_0=ruleCompareEqOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"eqCmpOp",
            	      							lv_eqCmpOp_2_0,
            	      							"ru.iaie.reflex.Reflex.CompareEqOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3891:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalReflex.g:3892:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalReflex.g:3892:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalReflex.g:3893:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_57);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.EqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleBitAndExpression"
    // InternalReflex.g:3915:1: entryRuleBitAndExpression returns [EObject current=null] : iv_ruleBitAndExpression= ruleBitAndExpression EOF ;
    public final EObject entryRuleBitAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitAndExpression = null;


        try {
            // InternalReflex.g:3915:57: (iv_ruleBitAndExpression= ruleBitAndExpression EOF )
            // InternalReflex.g:3916:2: iv_ruleBitAndExpression= ruleBitAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitAndExpression=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitAndExpression"


    // $ANTLR start "ruleBitAndExpression"
    // InternalReflex.g:3922:1: ruleBitAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) ;
    public final EObject ruleBitAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_AND_2=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3928:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) )
            // InternalReflex.g:3929:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            {
            // InternalReflex.g:3929:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            // InternalReflex.g:3930:3: this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_58);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3938:3: ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_BIT_AND) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalReflex.g:3939:4: () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) )
            	    {
            	    // InternalReflex.g:3939:4: ()
            	    // InternalReflex.g:3940:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitAndExpressionAccess().getBitAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_AND_2=(Token)match(input,RULE_BIT_AND,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_AND_2, grammarAccess.getBitAndExpressionAccess().getBIT_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3950:4: ( (lv_right_3_0= ruleBitAndExpression ) )
            	    // InternalReflex.g:3951:5: (lv_right_3_0= ruleBitAndExpression )
            	    {
            	    // InternalReflex.g:3951:5: (lv_right_3_0= ruleBitAndExpression )
            	    // InternalReflex.g:3952:6: lv_right_3_0= ruleBitAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitAndExpressionAccess().getRightBitAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_58);
            	    lv_right_3_0=ruleBitAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.BitAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitAndExpression"


    // $ANTLR start "entryRuleBitXorExpression"
    // InternalReflex.g:3974:1: entryRuleBitXorExpression returns [EObject current=null] : iv_ruleBitXorExpression= ruleBitXorExpression EOF ;
    public final EObject entryRuleBitXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitXorExpression = null;


        try {
            // InternalReflex.g:3974:57: (iv_ruleBitXorExpression= ruleBitXorExpression EOF )
            // InternalReflex.g:3975:2: iv_ruleBitXorExpression= ruleBitXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitXorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitXorExpression=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitXorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitXorExpression"


    // $ANTLR start "ruleBitXorExpression"
    // InternalReflex.g:3981:1: ruleBitXorExpression returns [EObject current=null] : (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) ;
    public final EObject ruleBitXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_XOR_2=null;
        EObject this_BitAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3987:2: ( (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) )
            // InternalReflex.g:3988:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            {
            // InternalReflex.g:3988:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            // InternalReflex.g:3989:3: this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitXorExpressionAccess().getBitAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_59);
            this_BitAndExpression_0=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3997:3: ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_BIT_XOR) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalReflex.g:3998:4: () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) )
            	    {
            	    // InternalReflex.g:3998:4: ()
            	    // InternalReflex.g:3999:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitXorExpressionAccess().getBitXorExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_XOR_2=(Token)match(input,RULE_BIT_XOR,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_XOR_2, grammarAccess.getBitXorExpressionAccess().getBIT_XORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:4009:4: ( (lv_right_3_0= ruleBitXorExpression ) )
            	    // InternalReflex.g:4010:5: (lv_right_3_0= ruleBitXorExpression )
            	    {
            	    // InternalReflex.g:4010:5: (lv_right_3_0= ruleBitXorExpression )
            	    // InternalReflex.g:4011:6: lv_right_3_0= ruleBitXorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitXorExpressionAccess().getRightBitXorExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_59);
            	    lv_right_3_0=ruleBitXorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitXorExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.BitXorExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitXorExpression"


    // $ANTLR start "entryRuleBitOrExpression"
    // InternalReflex.g:4033:1: entryRuleBitOrExpression returns [EObject current=null] : iv_ruleBitOrExpression= ruleBitOrExpression EOF ;
    public final EObject entryRuleBitOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitOrExpression = null;


        try {
            // InternalReflex.g:4033:56: (iv_ruleBitOrExpression= ruleBitOrExpression EOF )
            // InternalReflex.g:4034:2: iv_ruleBitOrExpression= ruleBitOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitOrExpression=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitOrExpression"


    // $ANTLR start "ruleBitOrExpression"
    // InternalReflex.g:4040:1: ruleBitOrExpression returns [EObject current=null] : (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) ;
    public final EObject ruleBitOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_OR_2=null;
        EObject this_BitXorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:4046:2: ( (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) )
            // InternalReflex.g:4047:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            {
            // InternalReflex.g:4047:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            // InternalReflex.g:4048:3: this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitOrExpressionAccess().getBitXorExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_60);
            this_BitXorExpression_0=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitXorExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:4056:3: ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_BIT_OR) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalReflex.g:4057:4: () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) )
            	    {
            	    // InternalReflex.g:4057:4: ()
            	    // InternalReflex.g:4058:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitOrExpressionAccess().getBitOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_OR_2=(Token)match(input,RULE_BIT_OR,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_OR_2, grammarAccess.getBitOrExpressionAccess().getBIT_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:4068:4: ( (lv_right_3_0= ruleBitOrExpression ) )
            	    // InternalReflex.g:4069:5: (lv_right_3_0= ruleBitOrExpression )
            	    {
            	    // InternalReflex.g:4069:5: (lv_right_3_0= ruleBitOrExpression )
            	    // InternalReflex.g:4070:6: lv_right_3_0= ruleBitOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitOrExpressionAccess().getRightBitOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_60);
            	    lv_right_3_0=ruleBitOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.BitOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalReflex.g:4092:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalReflex.g:4092:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalReflex.g:4093:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // InternalReflex.g:4099:1: ruleLogicalAndExpression returns [EObject current=null] : (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_AND_2=null;
        EObject this_BitOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:4105:2: ( (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalReflex.g:4106:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalReflex.g:4106:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalReflex.g:4107:3: this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getBitOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_61);
            this_BitOrExpression_0=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:4115:3: ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_LOGICAL_AND) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalReflex.g:4116:4: () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalReflex.g:4116:4: ()
            	    // InternalReflex.g:4117:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_AND_2=(Token)match(input,RULE_LOGICAL_AND,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_AND_2, grammarAccess.getLogicalAndExpressionAccess().getLOGICAL_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:4127:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    // InternalReflex.g:4128:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalReflex.g:4128:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    // InternalReflex.g:4129:6: lv_right_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_61);
            	    lv_right_3_0=ruleLogicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.LogicalAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalReflex.g:4151:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalReflex.g:4151:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalReflex.g:4152:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // InternalReflex.g:4158:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_OR_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:4164:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) )
            // InternalReflex.g:4165:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            {
            // InternalReflex.g:4165:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            // InternalReflex.g:4166:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_62);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:4174:3: ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_LOGICAL_OR) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalReflex.g:4175:4: () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    {
            	    // InternalReflex.g:4175:4: ()
            	    // InternalReflex.g:4176:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_OR_2=(Token)match(input,RULE_LOGICAL_OR,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_OR_2, grammarAccess.getLogicalOrExpressionAccess().getLOGICAL_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:4186:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    // InternalReflex.g:4187:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    {
            	    // InternalReflex.g:4187:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    // InternalReflex.g:4188:6: lv_right_3_0= ruleLogicalOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_62);
            	    lv_right_3_0=ruleLogicalOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.LogicalOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalReflex.g:4210:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalReflex.g:4210:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalReflex.g:4211:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalReflex.g:4217:1: ruleAssignmentExpression returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_assignOp_1_0 = null;

        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:4223:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) ) )
            // InternalReflex.g:4224:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) )
            {
            // InternalReflex.g:4224:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) )
            // InternalReflex.g:4225:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) )
            {
            // InternalReflex.g:4225:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==55||(LA51_1>=85 && LA51_1<=93)) ) {
                    alt51=1;
                }
            }
            switch (alt51) {
                case 1 :
                    // InternalReflex.g:4226:4: ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) )
                    {
                    // InternalReflex.g:4226:4: ( (otherlv_0= RULE_ID ) )
                    // InternalReflex.g:4227:5: (otherlv_0= RULE_ID )
                    {
                    // InternalReflex.g:4227:5: (otherlv_0= RULE_ID )
                    // InternalReflex.g:4228:6: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      					
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_0, grammarAccess.getAssignmentExpressionAccess().getAssignVarIdReferenceCrossReference_0_0_0());
                      					
                    }

                    }


                    }

                    // InternalReflex.g:4239:4: ( (lv_assignOp_1_0= ruleAssignOperator ) )
                    // InternalReflex.g:4240:5: (lv_assignOp_1_0= ruleAssignOperator )
                    {
                    // InternalReflex.g:4240:5: (lv_assignOp_1_0= ruleAssignOperator )
                    // InternalReflex.g:4241:6: lv_assignOp_1_0= ruleAssignOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getAssignOpAssignOperatorEnumRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
                    lv_assignOp_1_0=ruleAssignOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"assignOp",
                      							lv_assignOp_1_0,
                      							"ru.iaie.reflex.Reflex.AssignOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:4259:3: ( (lv_expr_2_0= ruleLogicalOrExpression ) )
            // InternalReflex.g:4260:4: (lv_expr_2_0= ruleLogicalOrExpression )
            {
            // InternalReflex.g:4260:4: (lv_expr_2_0= ruleLogicalOrExpression )
            // InternalReflex.g:4261:5: lv_expr_2_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"ru.iaie.reflex.Reflex.LogicalOrExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalReflex.g:4282:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalReflex.g:4282:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalReflex.g:4283:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalReflex.g:4289:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:4295:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalReflex.g:4296:2: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AssignmentExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "rulePortType"
    // InternalReflex.g:4307:1: rulePortType returns [Enumerator current=null] : ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) ;
    public final Enumerator rulePortType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4313:2: ( ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) )
            // InternalReflex.g:4314:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            {
            // InternalReflex.g:4314:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==79) ) {
                alt52=1;
            }
            else if ( (LA52_0==80) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalReflex.g:4315:3: (enumLiteral_0= 'input' )
                    {
                    // InternalReflex.g:4315:3: (enumLiteral_0= 'input' )
                    // InternalReflex.g:4316:4: enumLiteral_0= 'input'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPortTypeAccess().getINPUTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getPortTypeAccess().getINPUTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4323:3: (enumLiteral_1= 'output' )
                    {
                    // InternalReflex.g:4323:3: (enumLiteral_1= 'output' )
                    // InternalReflex.g:4324:4: enumLiteral_1= 'output'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPortTypeAccess().getOUTPUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getPortTypeAccess().getOUTPUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortType"


    // $ANTLR start "ruleStateQualifier"
    // InternalReflex.g:4334:1: ruleStateQualifier returns [Enumerator current=null] : ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) ) ;
    public final Enumerator ruleStateQualifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4340:2: ( ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) ) )
            // InternalReflex.g:4341:2: ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) )
            {
            // InternalReflex.g:4341:2: ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) )
            int alt53=4;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt53=1;
                }
                break;
            case 82:
                {
                alt53=2;
                }
                break;
            case 71:
                {
                alt53=3;
                }
                break;
            case 72:
                {
                alt53=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalReflex.g:4342:3: (enumLiteral_0= 'active' )
                    {
                    // InternalReflex.g:4342:3: (enumLiteral_0= 'active' )
                    // InternalReflex.g:4343:4: enumLiteral_0= 'active'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getACTIVEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStateQualifierAccess().getACTIVEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4350:3: (enumLiteral_1= 'inactive' )
                    {
                    // InternalReflex.g:4350:3: (enumLiteral_1= 'inactive' )
                    // InternalReflex.g:4351:4: enumLiteral_1= 'inactive'
                    {
                    enumLiteral_1=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getINACTIVEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getStateQualifierAccess().getINACTIVEEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4358:3: (enumLiteral_2= 'stop' )
                    {
                    // InternalReflex.g:4358:3: (enumLiteral_2= 'stop' )
                    // InternalReflex.g:4359:4: enumLiteral_2= 'stop'
                    {
                    enumLiteral_2=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getSTOPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getStateQualifierAccess().getSTOPEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4366:3: (enumLiteral_3= 'error' )
                    {
                    // InternalReflex.g:4366:3: (enumLiteral_3= 'error' )
                    // InternalReflex.g:4367:4: enumLiteral_3= 'error'
                    {
                    enumLiteral_3=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getERROREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getStateQualifierAccess().getERROREnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateQualifier"


    // $ANTLR start "ruleInfixPostfixOp"
    // InternalReflex.g:4377:1: ruleInfixPostfixOp returns [Enumerator current=null] : ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) ;
    public final Enumerator ruleInfixPostfixOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4383:2: ( ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) )
            // InternalReflex.g:4384:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            {
            // InternalReflex.g:4384:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==83) ) {
                alt54=1;
            }
            else if ( (LA54_0==84) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalReflex.g:4385:3: (enumLiteral_0= '++' )
                    {
                    // InternalReflex.g:4385:3: (enumLiteral_0= '++' )
                    // InternalReflex.g:4386:4: enumLiteral_0= '++'
                    {
                    enumLiteral_0=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4393:3: (enumLiteral_1= '--' )
                    {
                    // InternalReflex.g:4393:3: (enumLiteral_1= '--' )
                    // InternalReflex.g:4394:4: enumLiteral_1= '--'
                    {
                    enumLiteral_1=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getDECEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getInfixPostfixOpAccess().getDECEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixPostfixOp"


    // $ANTLR start "ruleAssignOperator"
    // InternalReflex.g:4404:1: ruleAssignOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) ;
    public final Enumerator ruleAssignOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;


        	enterRule();

        try {
            // InternalReflex.g:4410:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) )
            // InternalReflex.g:4411:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            {
            // InternalReflex.g:4411:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            int alt55=10;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt55=1;
                }
                break;
            case 85:
                {
                alt55=2;
                }
                break;
            case 86:
                {
                alt55=3;
                }
                break;
            case 87:
                {
                alt55=4;
                }
                break;
            case 88:
                {
                alt55=5;
                }
                break;
            case 89:
                {
                alt55=6;
                }
                break;
            case 90:
                {
                alt55=7;
                }
                break;
            case 91:
                {
                alt55=8;
                }
                break;
            case 92:
                {
                alt55=9;
                }
                break;
            case 93:
                {
                alt55=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalReflex.g:4412:3: (enumLiteral_0= '=' )
                    {
                    // InternalReflex.g:4412:3: (enumLiteral_0= '=' )
                    // InternalReflex.g:4413:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4420:3: (enumLiteral_1= '*=' )
                    {
                    // InternalReflex.g:4420:3: (enumLiteral_1= '*=' )
                    // InternalReflex.g:4421:4: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4428:3: (enumLiteral_2= '/=' )
                    {
                    // InternalReflex.g:4428:3: (enumLiteral_2= '/=' )
                    // InternalReflex.g:4429:4: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4436:3: (enumLiteral_3= '+=' )
                    {
                    // InternalReflex.g:4436:3: (enumLiteral_3= '+=' )
                    // InternalReflex.g:4437:4: enumLiteral_3= '+='
                    {
                    enumLiteral_3=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:4444:3: (enumLiteral_4= '-=' )
                    {
                    // InternalReflex.g:4444:3: (enumLiteral_4= '-=' )
                    // InternalReflex.g:4445:4: enumLiteral_4= '-='
                    {
                    enumLiteral_4=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:4452:3: (enumLiteral_5= '<<=' )
                    {
                    // InternalReflex.g:4452:3: (enumLiteral_5= '<<=' )
                    // InternalReflex.g:4453:4: enumLiteral_5= '<<='
                    {
                    enumLiteral_5=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:4460:3: (enumLiteral_6= '>>=' )
                    {
                    // InternalReflex.g:4460:3: (enumLiteral_6= '>>=' )
                    // InternalReflex.g:4461:4: enumLiteral_6= '>>='
                    {
                    enumLiteral_6=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalReflex.g:4468:3: (enumLiteral_7= '&=' )
                    {
                    // InternalReflex.g:4468:3: (enumLiteral_7= '&=' )
                    // InternalReflex.g:4469:4: enumLiteral_7= '&='
                    {
                    enumLiteral_7=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalReflex.g:4476:3: (enumLiteral_8= '^=' )
                    {
                    // InternalReflex.g:4476:3: (enumLiteral_8= '^=' )
                    // InternalReflex.g:4477:4: enumLiteral_8= '^='
                    {
                    enumLiteral_8=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:4484:3: (enumLiteral_9= '|=' )
                    {
                    // InternalReflex.g:4484:3: (enumLiteral_9= '|=' )
                    // InternalReflex.g:4485:4: enumLiteral_9= '|='
                    {
                    enumLiteral_9=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_OREnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getAssignOperatorAccess().getBIT_OREnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignOperator"


    // $ANTLR start "ruleUnaryOp"
    // InternalReflex.g:4495:1: ruleUnaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) ;
    public final Enumerator ruleUnaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4501:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) )
            // InternalReflex.g:4502:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            {
            // InternalReflex.g:4502:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            int alt56=4;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt56=1;
                }
                break;
            case 95:
                {
                alt56=2;
                }
                break;
            case 96:
                {
                alt56=3;
                }
                break;
            case 97:
                {
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalReflex.g:4503:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4503:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4504:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4511:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4511:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4512:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4519:3: (enumLiteral_2= '~' )
                    {
                    // InternalReflex.g:4519:3: (enumLiteral_2= '~' )
                    // InternalReflex.g:4520:4: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4527:3: (enumLiteral_3= '!' )
                    {
                    // InternalReflex.g:4527:3: (enumLiteral_3= '!' )
                    // InternalReflex.g:4528:4: enumLiteral_3= '!'
                    {
                    enumLiteral_3=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getLOGICAL_NOTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getUnaryOpAccess().getLOGICAL_NOTEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOp"


    // $ANTLR start "ruleCompareOp"
    // InternalReflex.g:4538:1: ruleCompareOp returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4544:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) )
            // InternalReflex.g:4545:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalReflex.g:4545:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            int alt57=4;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt57=1;
                }
                break;
            case 99:
                {
                alt57=2;
                }
                break;
            case 100:
                {
                alt57=3;
                }
                break;
            case 101:
                {
                alt57=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalReflex.g:4546:3: (enumLiteral_0= '<' )
                    {
                    // InternalReflex.g:4546:3: (enumLiteral_0= '<' )
                    // InternalReflex.g:4547:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4554:3: (enumLiteral_1= '>' )
                    {
                    // InternalReflex.g:4554:3: (enumLiteral_1= '>' )
                    // InternalReflex.g:4555:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4562:3: (enumLiteral_2= '=<' )
                    {
                    // InternalReflex.g:4562:3: (enumLiteral_2= '=<' )
                    // InternalReflex.g:4563:4: enumLiteral_2= '=<'
                    {
                    enumLiteral_2=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4570:3: (enumLiteral_3= '>=' )
                    {
                    // InternalReflex.g:4570:3: (enumLiteral_3= '>=' )
                    // InternalReflex.g:4571:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATER_EQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getCompareOpAccess().getGREATER_EQEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareOp"


    // $ANTLR start "ruleCompareEqOp"
    // InternalReflex.g:4581:1: ruleCompareEqOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleCompareEqOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4587:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // InternalReflex.g:4588:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // InternalReflex.g:4588:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==102) ) {
                alt58=1;
            }
            else if ( (LA58_0==103) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalReflex.g:4589:3: (enumLiteral_0= '==' )
                    {
                    // InternalReflex.g:4589:3: (enumLiteral_0= '==' )
                    // InternalReflex.g:4590:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4597:3: (enumLiteral_1= '!=' )
                    {
                    // InternalReflex.g:4597:3: (enumLiteral_1= '!=' )
                    // InternalReflex.g:4598:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getNOT_EQEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareEqOpAccess().getNOT_EQEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareEqOp"


    // $ANTLR start "ruleShiftOp"
    // InternalReflex.g:4608:1: ruleShiftOp returns [Enumerator current=null] : ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) ;
    public final Enumerator ruleShiftOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4614:2: ( ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) )
            // InternalReflex.g:4615:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            {
            // InternalReflex.g:4615:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==104) ) {
                alt59=1;
            }
            else if ( (LA59_0==105) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalReflex.g:4616:3: (enumLiteral_0= '>>' )
                    {
                    // InternalReflex.g:4616:3: (enumLiteral_0= '>>' )
                    // InternalReflex.g:4617:4: enumLiteral_0= '>>'
                    {
                    enumLiteral_0=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4624:3: (enumLiteral_1= '<<' )
                    {
                    // InternalReflex.g:4624:3: (enumLiteral_1= '<<' )
                    // InternalReflex.g:4625:4: enumLiteral_1= '<<'
                    {
                    enumLiteral_1=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getRIGHT_SHIFTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getShiftOpAccess().getRIGHT_SHIFTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftOp"


    // $ANTLR start "ruleAdditiveOp"
    // InternalReflex.g:4635:1: ruleAdditiveOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4641:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalReflex.g:4642:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalReflex.g:4642:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==94) ) {
                alt60=1;
            }
            else if ( (LA60_0==95) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalReflex.g:4643:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4643:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4644:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4651:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4651:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4652:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAdditiveOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOp"


    // $ANTLR start "ruleMultiplicativeOp"
    // InternalReflex.g:4662:1: ruleMultiplicativeOp returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalReflex.g:4668:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalReflex.g:4669:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalReflex.g:4669:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt61=3;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt61=1;
                }
                break;
            case 107:
                {
                alt61=2;
                }
                break;
            case 108:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalReflex.g:4670:3: (enumLiteral_0= '*' )
                    {
                    // InternalReflex.g:4670:3: (enumLiteral_0= '*' )
                    // InternalReflex.g:4671:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4678:3: (enumLiteral_1= '/' )
                    {
                    // InternalReflex.g:4678:3: (enumLiteral_1= '/' )
                    // InternalReflex.g:4679:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4686:3: (enumLiteral_2= '%' )
                    {
                    // InternalReflex.g:4686:3: (enumLiteral_2= '%' )
                    // InternalReflex.g:4687:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMODEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getMultiplicativeOpAccess().getMODEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOp"


    // $ANTLR start "ruleType"
    // InternalReflex.g:4697:1: ruleType returns [Enumerator current=null] : ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'int8' ) | (enumLiteral_4= 'uint8' ) | (enumLiteral_5= 'int16' ) | (enumLiteral_6= 'uint16' ) | (enumLiteral_7= 'int32' ) | (enumLiteral_8= 'uint32' ) | (enumLiteral_9= 'int64' ) | (enumLiteral_10= 'uint64' ) | (enumLiteral_11= 'bool' ) | (enumLiteral_12= 'time' ) ) ;
    public final Enumerator ruleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;


        	enterRule();

        try {
            // InternalReflex.g:4703:2: ( ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'int8' ) | (enumLiteral_4= 'uint8' ) | (enumLiteral_5= 'int16' ) | (enumLiteral_6= 'uint16' ) | (enumLiteral_7= 'int32' ) | (enumLiteral_8= 'uint32' ) | (enumLiteral_9= 'int64' ) | (enumLiteral_10= 'uint64' ) | (enumLiteral_11= 'bool' ) | (enumLiteral_12= 'time' ) ) )
            // InternalReflex.g:4704:2: ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'int8' ) | (enumLiteral_4= 'uint8' ) | (enumLiteral_5= 'int16' ) | (enumLiteral_6= 'uint16' ) | (enumLiteral_7= 'int32' ) | (enumLiteral_8= 'uint32' ) | (enumLiteral_9= 'int64' ) | (enumLiteral_10= 'uint64' ) | (enumLiteral_11= 'bool' ) | (enumLiteral_12= 'time' ) )
            {
            // InternalReflex.g:4704:2: ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'int8' ) | (enumLiteral_4= 'uint8' ) | (enumLiteral_5= 'int16' ) | (enumLiteral_6= 'uint16' ) | (enumLiteral_7= 'int32' ) | (enumLiteral_8= 'uint32' ) | (enumLiteral_9= 'int64' ) | (enumLiteral_10= 'uint64' ) | (enumLiteral_11= 'bool' ) | (enumLiteral_12= 'time' ) )
            int alt62=13;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt62=1;
                }
                break;
            case 110:
                {
                alt62=2;
                }
                break;
            case 111:
                {
                alt62=3;
                }
                break;
            case 112:
                {
                alt62=4;
                }
                break;
            case 113:
                {
                alt62=5;
                }
                break;
            case 114:
                {
                alt62=6;
                }
                break;
            case 115:
                {
                alt62=7;
                }
                break;
            case 116:
                {
                alt62=8;
                }
                break;
            case 117:
                {
                alt62=9;
                }
                break;
            case 118:
                {
                alt62=10;
                }
                break;
            case 119:
                {
                alt62=11;
                }
                break;
            case 120:
                {
                alt62=12;
                }
                break;
            case 121:
                {
                alt62=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalReflex.g:4705:3: (enumLiteral_0= 'void' )
                    {
                    // InternalReflex.g:4705:3: (enumLiteral_0= 'void' )
                    // InternalReflex.g:4706:4: enumLiteral_0= 'void'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getVOID_C_TYPEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTypeAccess().getVOID_C_TYPEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4713:3: (enumLiteral_1= 'float' )
                    {
                    // InternalReflex.g:4713:3: (enumLiteral_1= 'float' )
                    // InternalReflex.g:4714:4: enumLiteral_1= 'float'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getFLOATEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getTypeAccess().getFLOATEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4721:3: (enumLiteral_2= 'double' )
                    {
                    // InternalReflex.g:4721:3: (enumLiteral_2= 'double' )
                    // InternalReflex.g:4722:4: enumLiteral_2= 'double'
                    {
                    enumLiteral_2=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getDOUBLEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getTypeAccess().getDOUBLEEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4729:3: (enumLiteral_3= 'int8' )
                    {
                    // InternalReflex.g:4729:3: (enumLiteral_3= 'int8' )
                    // InternalReflex.g:4730:4: enumLiteral_3= 'int8'
                    {
                    enumLiteral_3=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT8EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getTypeAccess().getINT8EnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:4737:3: (enumLiteral_4= 'uint8' )
                    {
                    // InternalReflex.g:4737:3: (enumLiteral_4= 'uint8' )
                    // InternalReflex.g:4738:4: enumLiteral_4= 'uint8'
                    {
                    enumLiteral_4=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT8_UEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getTypeAccess().getINT8_UEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:4745:3: (enumLiteral_5= 'int16' )
                    {
                    // InternalReflex.g:4745:3: (enumLiteral_5= 'int16' )
                    // InternalReflex.g:4746:4: enumLiteral_5= 'int16'
                    {
                    enumLiteral_5=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT16EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getTypeAccess().getINT16EnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:4753:3: (enumLiteral_6= 'uint16' )
                    {
                    // InternalReflex.g:4753:3: (enumLiteral_6= 'uint16' )
                    // InternalReflex.g:4754:4: enumLiteral_6= 'uint16'
                    {
                    enumLiteral_6=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT16_UEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getTypeAccess().getINT16_UEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalReflex.g:4761:3: (enumLiteral_7= 'int32' )
                    {
                    // InternalReflex.g:4761:3: (enumLiteral_7= 'int32' )
                    // InternalReflex.g:4762:4: enumLiteral_7= 'int32'
                    {
                    enumLiteral_7=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT32EnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getTypeAccess().getINT32EnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalReflex.g:4769:3: (enumLiteral_8= 'uint32' )
                    {
                    // InternalReflex.g:4769:3: (enumLiteral_8= 'uint32' )
                    // InternalReflex.g:4770:4: enumLiteral_8= 'uint32'
                    {
                    enumLiteral_8=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT32_UEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getTypeAccess().getINT32_UEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:4777:3: (enumLiteral_9= 'int64' )
                    {
                    // InternalReflex.g:4777:3: (enumLiteral_9= 'int64' )
                    // InternalReflex.g:4778:4: enumLiteral_9= 'int64'
                    {
                    enumLiteral_9=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT64EnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getTypeAccess().getINT64EnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalReflex.g:4785:3: (enumLiteral_10= 'uint64' )
                    {
                    // InternalReflex.g:4785:3: (enumLiteral_10= 'uint64' )
                    // InternalReflex.g:4786:4: enumLiteral_10= 'uint64'
                    {
                    enumLiteral_10=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT64_UEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getTypeAccess().getINT64_UEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalReflex.g:4793:3: (enumLiteral_11= 'bool' )
                    {
                    // InternalReflex.g:4793:3: (enumLiteral_11= 'bool' )
                    // InternalReflex.g:4794:4: enumLiteral_11= 'bool'
                    {
                    enumLiteral_11=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getBOOLEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getTypeAccess().getBOOLEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalReflex.g:4801:3: (enumLiteral_12= 'time' )
                    {
                    // InternalReflex.g:4801:3: (enumLiteral_12= 'time' )
                    // InternalReflex.g:4802:4: enumLiteral_12= 'time'
                    {
                    enumLiteral_12=(Token)match(input,121,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getTIMEEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getTypeAccess().getTIMEEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"

    // $ANTLR start synpred1_InternalReflex
    public final void synpred1_InternalReflex_fragment() throws RecognitionException {   
        // InternalReflex.g:2323:5: ( 'else' )
        // InternalReflex.g:2323:6: 'else'
        {
        match(input,65,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalReflex

    // Delegated rules

    public final boolean synpred1_InternalReflex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalReflex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String dfa_1s = "\31\uffff";
    static final String dfa_2s = "\1\47\3\uffff\15\4\5\uffff\1\55\2\uffff";
    static final String dfa_3s = "\1\171\3\uffff\15\4\5\uffff\1\71\2\uffff";
    static final String dfa_4s = "\1\uffff\1\12\1\1\1\2\15\uffff\1\5\1\6\1\7\1\10\1\11\1\uffff\1\4\1\3";
    static final String dfa_5s = "\31\uffff}>";
    static final String[] dfa_6s = {
            "\1\25\3\uffff\1\1\2\uffff\1\25\14\uffff\1\22\1\24\1\23\1\2\1\3\17\uffff\2\21\34\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20",
            "",
            "",
            "",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "\1\26",
            "",
            "",
            "",
            "",
            "",
            "\1\27\11\uffff\1\27\1\uffff\1\30",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 154:3: ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_vectors_12_0= ruleVector ) ) | ( (lv_registers_13_0= ruleRegister ) ) | ( (lv_bits_14_0= ruleBit ) ) | ( (lv_processes_15_0= ruleProcess ) ) )*";
        }
    }
    static final String dfa_7s = "\21\uffff";
    static final String dfa_8s = "\16\uffff\1\20\2\uffff";
    static final String dfa_9s = "\1\155\15\4\1\55\2\uffff";
    static final String dfa_10s = "\1\171\15\4\1\67\2\uffff";
    static final String dfa_11s = "\17\uffff\1\1\1\2";
    static final String dfa_12s = "\21\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\20\6\uffff\1\20\2\uffff\1\17",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1014:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )";
        }
    }
    static final String dfa_14s = "\17\uffff\1\2\1\1";
    static final String[] dfa_15s = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\17\11\uffff\1\20",
            "",
            ""
    };
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_14;
            this.special = dfa_12;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "1066:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000028000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xF800488000000000L,0x03FFE00000018000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000408000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0011888000000000L,0x03FFE00000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0001888000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x02006C0000000370L,0x00000003C01817C5L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0001008000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0002040000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x03006C0000000370L,0x00000003C01817C5L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000010000000020L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0200000000000070L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0200640000000370L,0x00000003C01817C5L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x03FFE00000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0420000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0020080000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0200640000000372L,0x00000003C01817C5L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x02006C0000000370L,0x00000003C01817E5L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0200640000000372L,0x00000003C01817E5L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0001000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000180000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0600640000000370L,0x00000003C01817C5L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000060180L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x00001C0000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000030000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000003C00000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x000000C000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0080000000000000L,0x000000003FE00000L});

}