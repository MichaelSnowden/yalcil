// Generated from src/main/antlr4/com/michaelsnowden/yalcil/Yalcil.g4 by ANTLR 4.5.3
// jshint ignore: start
var antlr4 = require('antlr4/index');


var serializedATN = ["\u0003\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd",
    "\u0002\nE\b\u0001\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004",
    "\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007",
    "\u0004\b\t\b\u0004\t\t\t\u0003\u0002\u0003\u0002\u0007\u0002\u0016\n",
    "\u0002\f\u0002\u000e\u0002\u0019\u000b\u0002\u0003\u0002\u0003\u0002",
    "\u0003\u0002\u0007\u0002\u001e\n\u0002\f\u0002\u000e\u0002!\u000b\u0002",
    "\u0003\u0002\u0005\u0002$\n\u0002\u0003\u0003\u0006\u0003\'\n\u0003",
    "\r\u0003\u000e\u0003(\u0003\u0003\u0003\u0003\u0006\u0003-\n\u0003\r",
    "\u0003\u000e\u0003.\u0003\u0004\u0006\u00042\n\u0004\r\u0004\u000e\u0004",
    "3\u0003\u0005\u0006\u00057\n\u0005\r\u0005\u000e\u00058\u0003\u0006",
    "\u0003\u0006\u0003\u0007\u0003\u0007\u0003\b\u0003\b\u0003\t\u0006\t",
    "B\n\t\r\t\u000e\tC\u0002\u0002\n\u0003\u0003\u0005\u0004\u0007\u0005",
    "\t\u0006\u000b\u0007\r\b\u000f\t\u0011\n\u0003\u0002\u0007\u0003\u0002",
    "$$\u0003\u0002))\u0003\u00022;\u0005\u0002,?A\\c|\u0005\u0002\u000b",
    "\f\u000f\u000f\"\"L\u0002\u0003\u0003\u0002\u0002\u0002\u0002\u0005",
    "\u0003\u0002\u0002\u0002\u0002\u0007\u0003\u0002\u0002\u0002\u0002\t",
    "\u0003\u0002\u0002\u0002\u0002\u000b\u0003\u0002\u0002\u0002\u0002\r",
    "\u0003\u0002\u0002\u0002\u0002\u000f\u0003\u0002\u0002\u0002\u0002\u0011",
    "\u0003\u0002\u0002\u0002\u0003#\u0003\u0002\u0002\u0002\u0005&\u0003",
    "\u0002\u0002\u0002\u00071\u0003\u0002\u0002\u0002\t6\u0003\u0002\u0002",
    "\u0002\u000b:\u0003\u0002\u0002\u0002\r<\u0003\u0002\u0002\u0002\u000f",
    ">\u0003\u0002\u0002\u0002\u0011A\u0003\u0002\u0002\u0002\u0013\u0017",
    "\u0007$\u0002\u0002\u0014\u0016\n\u0002\u0002\u0002\u0015\u0014\u0003",
    "\u0002\u0002\u0002\u0016\u0019\u0003\u0002\u0002\u0002\u0017\u0015\u0003",
    "\u0002\u0002\u0002\u0017\u0018\u0003\u0002\u0002\u0002\u0018\u001a\u0003",
    "\u0002\u0002\u0002\u0019\u0017\u0003\u0002\u0002\u0002\u001a$\u0007",
    "$\u0002\u0002\u001b\u001f\u0007)\u0002\u0002\u001c\u001e\n\u0003\u0002",
    "\u0002\u001d\u001c\u0003\u0002\u0002\u0002\u001e!\u0003\u0002\u0002",
    "\u0002\u001f\u001d\u0003\u0002\u0002\u0002\u001f \u0003\u0002\u0002",
    "\u0002 \"\u0003\u0002\u0002\u0002!\u001f\u0003\u0002\u0002\u0002\"$",
    "\u0007)\u0002\u0002#\u0013\u0003\u0002\u0002\u0002#\u001b\u0003\u0002",
    "\u0002\u0002$\u0004\u0003\u0002\u0002\u0002%\'\t\u0004\u0002\u0002&",
    "%\u0003\u0002\u0002\u0002\'(\u0003\u0002\u0002\u0002(&\u0003\u0002\u0002",
    "\u0002()\u0003\u0002\u0002\u0002)*\u0003\u0002\u0002\u0002*,\u00070",
    "\u0002\u0002+-\t\u0004\u0002\u0002,+\u0003\u0002\u0002\u0002-.\u0003",
    "\u0002\u0002\u0002.,\u0003\u0002\u0002\u0002./\u0003\u0002\u0002\u0002",
    "/\u0006\u0003\u0002\u0002\u000202\t\u0004\u0002\u000210\u0003\u0002",
    "\u0002\u000223\u0003\u0002\u0002\u000231\u0003\u0002\u0002\u000234\u0003",
    "\u0002\u0002\u00024\b\u0003\u0002\u0002\u000257\t\u0005\u0002\u0002",
    "65\u0003\u0002\u0002\u000278\u0003\u0002\u0002\u000286\u0003\u0002\u0002",
    "\u000289\u0003\u0002\u0002\u00029\n\u0003\u0002\u0002\u0002:;\u0007",
    "^\u0002\u0002;\f\u0003\u0002\u0002\u0002<=\u0007*\u0002\u0002=\u000e",
    "\u0003\u0002\u0002\u0002>?\u0007+\u0002\u0002?\u0010\u0003\u0002\u0002",
    "\u0002@B\t\u0006\u0002\u0002A@\u0003\u0002\u0002\u0002BC\u0003\u0002",
    "\u0002\u0002CA\u0003\u0002\u0002\u0002CD\u0003\u0002\u0002\u0002D\u0012",
    "\u0003\u0002\u0002\u0002\u000b\u0002\u0017\u001f#(.38C\u0002"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

function YalcilLexer(input) {
	antlr4.Lexer.call(this, input);
    this._interp = new antlr4.atn.LexerATNSimulator(this, atn, decisionsToDFA, new antlr4.PredictionContextCache());
    return this;
}

YalcilLexer.prototype = Object.create(antlr4.Lexer.prototype);
YalcilLexer.prototype.constructor = YalcilLexer;

YalcilLexer.EOF = antlr4.Token.EOF;
YalcilLexer.STRING_LITERAL = 1;
YalcilLexer.FLOAT_LITERAL = 2;
YalcilLexer.INTEGER_LITERAL = 3;
YalcilLexer.IDENTIFIER = 4;
YalcilLexer.LAMBDA = 5;
YalcilLexer.LP = 6;
YalcilLexer.RP = 7;
YalcilLexer.WS = 8;


YalcilLexer.modeNames = [ "DEFAULT_MODE" ];

YalcilLexer.literalNames = [ null, null, null, null, null, "'\\'", "'('", 
                             "')'" ];

YalcilLexer.symbolicNames = [ null, "STRING_LITERAL", "FLOAT_LITERAL", "INTEGER_LITERAL", 
                              "IDENTIFIER", "LAMBDA", "LP", "RP", "WS" ];

YalcilLexer.ruleNames = [ "STRING_LITERAL", "FLOAT_LITERAL", "INTEGER_LITERAL", 
                          "IDENTIFIER", "LAMBDA", "LP", "RP", "WS" ];

YalcilLexer.grammarFileName = "Yalcil.g4";



exports.YalcilLexer = YalcilLexer;

