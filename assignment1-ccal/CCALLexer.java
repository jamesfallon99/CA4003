// Generated from CCAL.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CCALLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, CONST=2, RETURN=3, INTEGER=4, BOOLEAN=5, VOID=6, MAIN=7, IF=8, 
		ELSE=9, TRUE=10, FALSE=11, WHILE=12, SKIPS=13, COMMA=14, SEMI=15, COLON=16, 
		EQUALS=17, CURLY_LBR=18, CURLY_RBR=19, LBR=20, RBR=21, PLUS=22, MINUS=23, 
		NEGATION=24, OR=25, AND=26, EQUAL_TO=27, NOT_EQUAL_TO=28, LESS_THAN=29, 
		LESS_THAN_EQUAL_TO=30, GREATER_THAN=31, GREATER_THAN_EQUAL_TO=32, NUMBER=33, 
		ID=34, WS=35, COMMENT=36, LINE_COMMENT=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
		"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Integer", 
		"Letter", "UnderScore", "VAR", "CONST", "RETURN", "INTEGER", "BOOLEAN", 
		"VOID", "MAIN", "IF", "ELSE", "TRUE", "FALSE", "WHILE", "SKIPS", "COMMA", 
		"SEMI", "COLON", "EQUALS", "CURLY_LBR", "CURLY_RBR", "LBR", "RBR", "PLUS", 
		"MINUS", "NEGATION", "OR", "AND", "EQUAL_TO", "NOT_EQUAL_TO", "LESS_THAN", 
		"LESS_THAN_EQUAL_TO", "GREATER_THAN", "GREATER_THAN_EQUAL_TO", "NUMBER", 
		"ID", "WS", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "','", "';'", "':'", "'='", "'{'", "'}'", "'('", "')'", "'+'", 
		"'-'", "'~'", "'||'", "'&&'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "VAR", "CONST", "RETURN", "INTEGER", "BOOLEAN", "VOID", "MAIN", 
		"IF", "ELSE", "TRUE", "FALSE", "WHILE", "SKIPS", "COMMA", "SEMI", "COLON", 
		"EQUALS", "CURLY_LBR", "CURLY_RBR", "LBR", "RBR", "PLUS", "MINUS", "NEGATION", 
		"OR", "AND", "EQUAL_TO", "NOT_EQUAL_TO", "LESS_THAN", "LESS_THAN_EQUAL_TO", 
		"GREATER_THAN", "GREATER_THAN_EQUAL_TO", "NUMBER", "ID", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CCALLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CCAL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\7\34\u00c0\n\34\f\34\16\34\u00c3\13\34\3\34\3\34\7\34"+
		"\u00c7\n\34\f\34\16\34\u00ca\13\34\5\34\u00cc\n\34\3\35\6\35\u00cf\n\35"+
		"\r\35\16\35\u00d0\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3"+
		"!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3-\3"+
		"-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3"+
		"\65\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\39\3:\3:\3:\3;\3;\3<\3<\3"+
		"<\3=\3=\3>\3>\3>\3?\3?\3@\3@\3@\3@\7@\u0150\n@\f@\16@\u0153\13@\3A\6A"+
		"\u0156\nA\rA\16A\u0157\3A\3A\3B\3B\3B\3B\3B\7B\u0161\nB\fB\16B\u0164\13"+
		"B\3B\3B\3B\3B\3B\3C\3C\3C\3C\7C\u016f\nC\fC\16C\u0172\13C\3C\3C\3C\3C"+
		"\4\u0162\u0170\2D\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31"+
		"\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2="+
		"\3?\4A\5C\6E\7G\bI\tK\nM\13O\fQ\rS\16U\17W\20Y\21[\22]\23_\24a\25c\26"+
		"e\27g\30i\31k\32m\33o\34q\35s\36u\37w y!{\"}#\177$\u0081%\u0083&\u0085"+
		"\'\3\2 \4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJ"+
		"jj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2"+
		"SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4"+
		"\2\\\\||\3\2\63;\3\2\62;\4\2C\\c|\5\2\13\f\17\17\"\"\2\u0165\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2"+
		"q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3"+
		"\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\3"+
		"\u0087\3\2\2\2\5\u0089\3\2\2\2\7\u008b\3\2\2\2\t\u008d\3\2\2\2\13\u008f"+
		"\3\2\2\2\r\u0091\3\2\2\2\17\u0093\3\2\2\2\21\u0095\3\2\2\2\23\u0097\3"+
		"\2\2\2\25\u0099\3\2\2\2\27\u009b\3\2\2\2\31\u009d\3\2\2\2\33\u009f\3\2"+
		"\2\2\35\u00a1\3\2\2\2\37\u00a3\3\2\2\2!\u00a5\3\2\2\2#\u00a7\3\2\2\2%"+
		"\u00a9\3\2\2\2\'\u00ab\3\2\2\2)\u00ad\3\2\2\2+\u00af\3\2\2\2-\u00b1\3"+
		"\2\2\2/\u00b3\3\2\2\2\61\u00b5\3\2\2\2\63\u00b7\3\2\2\2\65\u00b9\3\2\2"+
		"\2\67\u00cb\3\2\2\29\u00ce\3\2\2\2;\u00d2\3\2\2\2=\u00d4\3\2\2\2?\u00d8"+
		"\3\2\2\2A\u00de\3\2\2\2C\u00e5\3\2\2\2E\u00ed\3\2\2\2G\u00f5\3\2\2\2I"+
		"\u00fa\3\2\2\2K\u00ff\3\2\2\2M\u0102\3\2\2\2O\u0107\3\2\2\2Q\u010c\3\2"+
		"\2\2S\u0112\3\2\2\2U\u0118\3\2\2\2W\u011d\3\2\2\2Y\u011f\3\2\2\2[\u0121"+
		"\3\2\2\2]\u0123\3\2\2\2_\u0125\3\2\2\2a\u0127\3\2\2\2c\u0129\3\2\2\2e"+
		"\u012b\3\2\2\2g\u012d\3\2\2\2i\u012f\3\2\2\2k\u0131\3\2\2\2m\u0133\3\2"+
		"\2\2o\u0136\3\2\2\2q\u0139\3\2\2\2s\u013c\3\2\2\2u\u013f\3\2\2\2w\u0141"+
		"\3\2\2\2y\u0144\3\2\2\2{\u0146\3\2\2\2}\u0149\3\2\2\2\177\u014b\3\2\2"+
		"\2\u0081\u0155\3\2\2\2\u0083\u015b\3\2\2\2\u0085\u016a\3\2\2\2\u0087\u0088"+
		"\t\2\2\2\u0088\4\3\2\2\2\u0089\u008a\t\3\2\2\u008a\6\3\2\2\2\u008b\u008c"+
		"\t\4\2\2\u008c\b\3\2\2\2\u008d\u008e\t\5\2\2\u008e\n\3\2\2\2\u008f\u0090"+
		"\t\6\2\2\u0090\f\3\2\2\2\u0091\u0092\t\7\2\2\u0092\16\3\2\2\2\u0093\u0094"+
		"\t\b\2\2\u0094\20\3\2\2\2\u0095\u0096\t\t\2\2\u0096\22\3\2\2\2\u0097\u0098"+
		"\t\n\2\2\u0098\24\3\2\2\2\u0099\u009a\t\13\2\2\u009a\26\3\2\2\2\u009b"+
		"\u009c\t\f\2\2\u009c\30\3\2\2\2\u009d\u009e\t\r\2\2\u009e\32\3\2\2\2\u009f"+
		"\u00a0\t\16\2\2\u00a0\34\3\2\2\2\u00a1\u00a2\t\17\2\2\u00a2\36\3\2\2\2"+
		"\u00a3\u00a4\t\20\2\2\u00a4 \3\2\2\2\u00a5\u00a6\t\21\2\2\u00a6\"\3\2"+
		"\2\2\u00a7\u00a8\t\22\2\2\u00a8$\3\2\2\2\u00a9\u00aa\t\23\2\2\u00aa&\3"+
		"\2\2\2\u00ab\u00ac\t\24\2\2\u00ac(\3\2\2\2\u00ad\u00ae\t\25\2\2\u00ae"+
		"*\3\2\2\2\u00af\u00b0\t\26\2\2\u00b0,\3\2\2\2\u00b1\u00b2\t\27\2\2\u00b2"+
		".\3\2\2\2\u00b3\u00b4\t\30\2\2\u00b4\60\3\2\2\2\u00b5\u00b6\t\31\2\2\u00b6"+
		"\62\3\2\2\2\u00b7\u00b8\t\32\2\2\u00b8\64\3\2\2\2\u00b9\u00ba\t\33\2\2"+
		"\u00ba\66\3\2\2\2\u00bb\u00cc\7\62\2\2\u00bc\u00bd\5i\65\2\u00bd\u00c1"+
		"\t\34\2\2\u00be\u00c0\t\35\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2"+
		"\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00cc\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\u00c8\t\34\2\2\u00c5\u00c7\t\35\2\2\u00c6\u00c5\3\2\2\2"+
		"\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cc"+
		"\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00bb\3\2\2\2\u00cb\u00bc\3\2\2\2\u00cb"+
		"\u00c4\3\2\2\2\u00cc8\3\2\2\2\u00cd\u00cf\t\36\2\2\u00ce\u00cd\3\2\2\2"+
		"\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1:\3"+
		"\2\2\2\u00d2\u00d3\7a\2\2\u00d3<\3\2\2\2\u00d4\u00d5\5-\27\2\u00d5\u00d6"+
		"\5\3\2\2\u00d6\u00d7\5%\23\2\u00d7>\3\2\2\2\u00d8\u00d9\5\7\4\2\u00d9"+
		"\u00da\5\37\20\2\u00da\u00db\5\35\17\2\u00db\u00dc\5\'\24\2\u00dc\u00dd"+
		"\5)\25\2\u00dd@\3\2\2\2\u00de\u00df\5%\23\2\u00df\u00e0\5\13\6\2\u00e0"+
		"\u00e1\5)\25\2\u00e1\u00e2\5+\26\2\u00e2\u00e3\5%\23\2\u00e3\u00e4\5\35"+
		"\17\2\u00e4B\3\2\2\2\u00e5\u00e6\5\23\n\2\u00e6\u00e7\5\35\17\2\u00e7"+
		"\u00e8\5)\25\2\u00e8\u00e9\5\13\6\2\u00e9\u00ea\5\17\b\2\u00ea\u00eb\5"+
		"\13\6\2\u00eb\u00ec\5%\23\2\u00ecD\3\2\2\2\u00ed\u00ee\5\5\3\2\u00ee\u00ef"+
		"\5\37\20\2\u00ef\u00f0\5\37\20\2\u00f0\u00f1\5\31\r\2\u00f1\u00f2\5\13"+
		"\6\2\u00f2\u00f3\5\3\2\2\u00f3\u00f4\5\35\17\2\u00f4F\3\2\2\2\u00f5\u00f6"+
		"\5-\27\2\u00f6\u00f7\5\37\20\2\u00f7\u00f8\5\23\n\2\u00f8\u00f9\5\t\5"+
		"\2\u00f9H\3\2\2\2\u00fa\u00fb\5\33\16\2\u00fb\u00fc\5\3\2\2\u00fc\u00fd"+
		"\5\23\n\2\u00fd\u00fe\5\35\17\2\u00feJ\3\2\2\2\u00ff\u0100\5\23\n\2\u0100"+
		"\u0101\5\r\7\2\u0101L\3\2\2\2\u0102\u0103\5\13\6\2\u0103\u0104\5\31\r"+
		"\2\u0104\u0105\5\'\24\2\u0105\u0106\5\13\6\2\u0106N\3\2\2\2\u0107\u0108"+
		"\5)\25\2\u0108\u0109\5%\23\2\u0109\u010a\5+\26\2\u010a\u010b\5\13\6\2"+
		"\u010bP\3\2\2\2\u010c\u010d\5\r\7\2\u010d\u010e\5\3\2\2\u010e\u010f\5"+
		"\31\r\2\u010f\u0110\5\'\24\2\u0110\u0111\5\13\6\2\u0111R\3\2\2\2\u0112"+
		"\u0113\5/\30\2\u0113\u0114\5\21\t\2\u0114\u0115\5\23\n\2\u0115\u0116\5"+
		"\31\r\2\u0116\u0117\5\13\6\2\u0117T\3\2\2\2\u0118\u0119\5\'\24\2\u0119"+
		"\u011a\5\27\f\2\u011a\u011b\5\23\n\2\u011b\u011c\5!\21\2\u011cV\3\2\2"+
		"\2\u011d\u011e\7.\2\2\u011eX\3\2\2\2\u011f\u0120\7=\2\2\u0120Z\3\2\2\2"+
		"\u0121\u0122\7<\2\2\u0122\\\3\2\2\2\u0123\u0124\7?\2\2\u0124^\3\2\2\2"+
		"\u0125\u0126\7}\2\2\u0126`\3\2\2\2\u0127\u0128\7\177\2\2\u0128b\3\2\2"+
		"\2\u0129\u012a\7*\2\2\u012ad\3\2\2\2\u012b\u012c\7+\2\2\u012cf\3\2\2\2"+
		"\u012d\u012e\7-\2\2\u012eh\3\2\2\2\u012f\u0130\7/\2\2\u0130j\3\2\2\2\u0131"+
		"\u0132\7\u0080\2\2\u0132l\3\2\2\2\u0133\u0134\7~\2\2\u0134\u0135\7~\2"+
		"\2\u0135n\3\2\2\2\u0136\u0137\7(\2\2\u0137\u0138\7(\2\2\u0138p\3\2\2\2"+
		"\u0139\u013a\7?\2\2\u013a\u013b\7?\2\2\u013br\3\2\2\2\u013c\u013d\7#\2"+
		"\2\u013d\u013e\7?\2\2\u013et\3\2\2\2\u013f\u0140\7>\2\2\u0140v\3\2\2\2"+
		"\u0141\u0142\7>\2\2\u0142\u0143\7?\2\2\u0143x\3\2\2\2\u0144\u0145\7@\2"+
		"\2\u0145z\3\2\2\2\u0146\u0147\7@\2\2\u0147\u0148\7?\2\2\u0148|\3\2\2\2"+
		"\u0149\u014a\5\67\34\2\u014a~\3\2\2\2\u014b\u0151\59\35\2\u014c\u0150"+
		"\59\35\2\u014d\u0150\5\67\34\2\u014e\u0150\5;\36\2\u014f\u014c\3\2\2\2"+
		"\u014f\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f"+
		"\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0080\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0156\t\37\2\2\u0155\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0155\3"+
		"\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\bA\2\2\u015a"+
		"\u0082\3\2\2\2\u015b\u015c\7\61\2\2\u015c\u015d\7,\2\2\u015d\u0162\3\2"+
		"\2\2\u015e\u0161\5\u0083B\2\u015f\u0161\13\2\2\2\u0160\u015e\3\2\2\2\u0160"+
		"\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0163\3\2\2\2\u0162\u0160\3\2"+
		"\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\7,\2\2\u0166"+
		"\u0167\7\61\2\2\u0167\u0168\3\2\2\2\u0168\u0169\bB\2\2\u0169\u0084\3\2"+
		"\2\2\u016a\u016b\7\61\2\2\u016b\u016c\7\61\2\2\u016c\u0170\3\2\2\2\u016d"+
		"\u016f\13\2\2\2\u016e\u016d\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u0171\3"+
		"\2\2\2\u0170\u016e\3\2\2\2\u0171\u0173\3\2\2\2\u0172\u0170\3\2\2\2\u0173"+
		"\u0174\7\f\2\2\u0174\u0175\3\2\2\2\u0175\u0176\bC\2\2\u0176\u0086\3\2"+
		"\2\2\r\2\u00c1\u00c8\u00cb\u00d0\u014f\u0151\u0157\u0160\u0162\u0170\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}