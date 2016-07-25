// Generated from src/main/antlr4/com/michaelsnowden/yalcil/Yalcil.g4 by ANTLR 4.5.3
// jshint ignore: start
var antlr4 = require('antlr4/index');
var YalcilListener = require('./YalcilListener').YalcilListener;
var grammarFileName = "Yalcil.g4";

var serializedATN = ["\u0003\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd",
    "\u0003\n;\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t\u0004",
    "\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0003\u0002\u0003\u0002\u0003",
    "\u0002\u0003\u0003\u0003\u0003\u0003\u0003\u0005\u0003\u0013\n\u0003",
    "\u0003\u0004\u0003\u0004\u0005\u0004\u0017\n\u0004\u0003\u0004\u0003",
    "\u0004\u0003\u0004\u0007\u0004\u001c\n\u0004\f\u0004\u000e\u0004\u001f",
    "\u000b\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0005\u0004$\n\u0004",
    "\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0005\u0005*\n\u0005",
    "\u0003\u0005\u0003\u0005\u0003\u0005\u0007\u0005/\n\u0005\f\u0005\u000e",
    "\u00052\u000b\u0005\u0003\u0005\u0005\u00055\n\u0005\u0003\u0005\u0003",
    "\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0002\u0002\u0007\u0002\u0004",
    "\u0006\b\n\u0002\u0003\u0003\u0002\u0003\u0006=\u0002\f\u0003\u0002",
    "\u0002\u0002\u0004\u0012\u0003\u0002\u0002\u0002\u0006\u0014\u0003\u0002",
    "\u0002\u0002\b\'\u0003\u0002\u0002\u0002\n8\u0003\u0002\u0002\u0002",
    "\f\r\u0005\u0004\u0003\u0002\r\u000e\u0007\u0002\u0002\u0003\u000e\u0003",
    "\u0003\u0002\u0002\u0002\u000f\u0013\u0005\u0006\u0004\u0002\u0010\u0013",
    "\u0005\b\u0005\u0002\u0011\u0013\u0005\n\u0006\u0002\u0012\u000f\u0003",
    "\u0002\u0002\u0002\u0012\u0010\u0003\u0002\u0002\u0002\u0012\u0011\u0003",
    "\u0002\u0002\u0002\u0013\u0005\u0003\u0002\u0002\u0002\u0014\u0016\u0007",
    "\b\u0002\u0002\u0015\u0017\u0007\n\u0002\u0002\u0016\u0015\u0003\u0002",
    "\u0002\u0002\u0016\u0017\u0003\u0002\u0002\u0002\u0017\u0018\u0003\u0002",
    "\u0002\u0002\u0018\u001d\u0007\u0007\u0002\u0002\u0019\u001a\u0007\n",
    "\u0002\u0002\u001a\u001c\u0007\u0006\u0002\u0002\u001b\u0019\u0003\u0002",
    "\u0002\u0002\u001c\u001f\u0003\u0002\u0002\u0002\u001d\u001b\u0003\u0002",
    "\u0002\u0002\u001d\u001e\u0003\u0002\u0002\u0002\u001e \u0003\u0002",
    "\u0002\u0002\u001f\u001d\u0003\u0002\u0002\u0002 !\u0007\n\u0002\u0002",
    "!#\u0005\u0004\u0003\u0002\"$\u0007\n\u0002\u0002#\"\u0003\u0002\u0002",
    "\u0002#$\u0003\u0002\u0002\u0002$%\u0003\u0002\u0002\u0002%&\u0007\t",
    "\u0002\u0002&\u0007\u0003\u0002\u0002\u0002\')\u0007\b\u0002\u0002(",
    "*\u0007\n\u0002\u0002)(\u0003\u0002\u0002\u0002)*\u0003\u0002\u0002",
    "\u0002*+\u0003\u0002\u0002\u0002+0\u0005\u0004\u0003\u0002,-\u0007\n",
    "\u0002\u0002-/\u0005\u0004\u0003\u0002.,\u0003\u0002\u0002\u0002/2\u0003",
    "\u0002\u0002\u00020.\u0003\u0002\u0002\u000201\u0003\u0002\u0002\u0002",
    "14\u0003\u0002\u0002\u000220\u0003\u0002\u0002\u000235\u0007\n\u0002",
    "\u000243\u0003\u0002\u0002\u000245\u0003\u0002\u0002\u000256\u0003\u0002",
    "\u0002\u000267\u0007\t\u0002\u00027\t\u0003\u0002\u0002\u000289\t\u0002",
    "\u0002\u00029\u000b\u0003\u0002\u0002\u0002\t\u0012\u0016\u001d#)04"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

var sharedContextCache = new antlr4.PredictionContextCache();

var literalNames = [ null, null, null, null, null, "'\\'", "'('", "')'" ];

var symbolicNames = [ null, "STRING_LITERAL", "FLOAT_LITERAL", "INTEGER_LITERAL", 
                      "IDENTIFIER", "LAMBDA", "LP", "RP", "WS" ];

var ruleNames =  [ "program", "expression", "lambdaAbstraction", "application", 
                   "literal" ];

function YalcilParser (input) {
	antlr4.Parser.call(this, input);
    this._interp = new antlr4.atn.ParserATNSimulator(this, atn, decisionsToDFA, sharedContextCache);
    this.ruleNames = ruleNames;
    this.literalNames = literalNames;
    this.symbolicNames = symbolicNames;
    return this;
}

YalcilParser.prototype = Object.create(antlr4.Parser.prototype);
YalcilParser.prototype.constructor = YalcilParser;

Object.defineProperty(YalcilParser.prototype, "atn", {
	get : function() {
		return atn;
	}
});

YalcilParser.EOF = antlr4.Token.EOF;
YalcilParser.STRING_LITERAL = 1;
YalcilParser.FLOAT_LITERAL = 2;
YalcilParser.INTEGER_LITERAL = 3;
YalcilParser.IDENTIFIER = 4;
YalcilParser.LAMBDA = 5;
YalcilParser.LP = 6;
YalcilParser.RP = 7;
YalcilParser.WS = 8;

YalcilParser.RULE_program = 0;
YalcilParser.RULE_expression = 1;
YalcilParser.RULE_lambdaAbstraction = 2;
YalcilParser.RULE_application = 3;
YalcilParser.RULE_literal = 4;

function ProgramContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = YalcilParser.RULE_program;
    return this;
}

ProgramContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ProgramContext.prototype.constructor = ProgramContext;

ProgramContext.prototype.expression = function() {
    return this.getTypedRuleContext(ExpressionContext,0);
};

ProgramContext.prototype.EOF = function() {
    return this.getToken(YalcilParser.EOF, 0);
};

ProgramContext.prototype.enterRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.enterProgram(this);
	}
};

ProgramContext.prototype.exitRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.exitProgram(this);
	}
};




YalcilParser.ProgramContext = ProgramContext;

YalcilParser.prototype.program = function() {

    var localctx = new ProgramContext(this, this._ctx, this.state);
    this.enterRule(localctx, 0, YalcilParser.RULE_program);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 10;
        this.expression();
        this.state = 11;
        this.match(YalcilParser.EOF);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function ExpressionContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = YalcilParser.RULE_expression;
    return this;
}

ExpressionContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ExpressionContext.prototype.constructor = ExpressionContext;

ExpressionContext.prototype.lambdaAbstraction = function() {
    return this.getTypedRuleContext(LambdaAbstractionContext,0);
};

ExpressionContext.prototype.application = function() {
    return this.getTypedRuleContext(ApplicationContext,0);
};

ExpressionContext.prototype.literal = function() {
    return this.getTypedRuleContext(LiteralContext,0);
};

ExpressionContext.prototype.enterRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.enterExpression(this);
	}
};

ExpressionContext.prototype.exitRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.exitExpression(this);
	}
};




YalcilParser.ExpressionContext = ExpressionContext;

YalcilParser.prototype.expression = function() {

    var localctx = new ExpressionContext(this, this._ctx, this.state);
    this.enterRule(localctx, 2, YalcilParser.RULE_expression);
    try {
        this.state = 16;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,0,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 13;
            this.lambdaAbstraction();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 14;
            this.application();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 15;
            this.literal();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function LambdaAbstractionContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = YalcilParser.RULE_lambdaAbstraction;
    return this;
}

LambdaAbstractionContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
LambdaAbstractionContext.prototype.constructor = LambdaAbstractionContext;

LambdaAbstractionContext.prototype.LP = function() {
    return this.getToken(YalcilParser.LP, 0);
};

LambdaAbstractionContext.prototype.LAMBDA = function() {
    return this.getToken(YalcilParser.LAMBDA, 0);
};

LambdaAbstractionContext.prototype.WS = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(YalcilParser.WS);
    } else {
        return this.getToken(YalcilParser.WS, i);
    }
};


LambdaAbstractionContext.prototype.expression = function() {
    return this.getTypedRuleContext(ExpressionContext,0);
};

LambdaAbstractionContext.prototype.RP = function() {
    return this.getToken(YalcilParser.RP, 0);
};

LambdaAbstractionContext.prototype.IDENTIFIER = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(YalcilParser.IDENTIFIER);
    } else {
        return this.getToken(YalcilParser.IDENTIFIER, i);
    }
};


LambdaAbstractionContext.prototype.enterRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.enterLambdaAbstraction(this);
	}
};

LambdaAbstractionContext.prototype.exitRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.exitLambdaAbstraction(this);
	}
};




YalcilParser.LambdaAbstractionContext = LambdaAbstractionContext;

YalcilParser.prototype.lambdaAbstraction = function() {

    var localctx = new LambdaAbstractionContext(this, this._ctx, this.state);
    this.enterRule(localctx, 4, YalcilParser.RULE_lambdaAbstraction);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 18;
        this.match(YalcilParser.LP);
        this.state = 20;
        _la = this._input.LA(1);
        if(_la===YalcilParser.WS) {
            this.state = 19;
            this.match(YalcilParser.WS);
        }

        this.state = 22;
        this.match(YalcilParser.LAMBDA);
        this.state = 27;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,2,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 23;
                this.match(YalcilParser.WS);
                this.state = 24;
                this.match(YalcilParser.IDENTIFIER); 
            }
            this.state = 29;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,2,this._ctx);
        }

        this.state = 30;
        this.match(YalcilParser.WS);
        this.state = 31;
        this.expression();
        this.state = 33;
        _la = this._input.LA(1);
        if(_la===YalcilParser.WS) {
            this.state = 32;
            this.match(YalcilParser.WS);
        }

        this.state = 35;
        this.match(YalcilParser.RP);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function ApplicationContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = YalcilParser.RULE_application;
    return this;
}

ApplicationContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ApplicationContext.prototype.constructor = ApplicationContext;

ApplicationContext.prototype.LP = function() {
    return this.getToken(YalcilParser.LP, 0);
};

ApplicationContext.prototype.expression = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ExpressionContext);
    } else {
        return this.getTypedRuleContext(ExpressionContext,i);
    }
};

ApplicationContext.prototype.RP = function() {
    return this.getToken(YalcilParser.RP, 0);
};

ApplicationContext.prototype.WS = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(YalcilParser.WS);
    } else {
        return this.getToken(YalcilParser.WS, i);
    }
};


ApplicationContext.prototype.enterRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.enterApplication(this);
	}
};

ApplicationContext.prototype.exitRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.exitApplication(this);
	}
};




YalcilParser.ApplicationContext = ApplicationContext;

YalcilParser.prototype.application = function() {

    var localctx = new ApplicationContext(this, this._ctx, this.state);
    this.enterRule(localctx, 6, YalcilParser.RULE_application);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 37;
        this.match(YalcilParser.LP);
        this.state = 39;
        _la = this._input.LA(1);
        if(_la===YalcilParser.WS) {
            this.state = 38;
            this.match(YalcilParser.WS);
        }

        this.state = 41;
        this.expression();
        this.state = 46;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,5,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 42;
                this.match(YalcilParser.WS);
                this.state = 43;
                this.expression(); 
            }
            this.state = 48;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,5,this._ctx);
        }

        this.state = 50;
        _la = this._input.LA(1);
        if(_la===YalcilParser.WS) {
            this.state = 49;
            this.match(YalcilParser.WS);
        }

        this.state = 52;
        this.match(YalcilParser.RP);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function LiteralContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = YalcilParser.RULE_literal;
    return this;
}

LiteralContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
LiteralContext.prototype.constructor = LiteralContext;

LiteralContext.prototype.FLOAT_LITERAL = function() {
    return this.getToken(YalcilParser.FLOAT_LITERAL, 0);
};

LiteralContext.prototype.INTEGER_LITERAL = function() {
    return this.getToken(YalcilParser.INTEGER_LITERAL, 0);
};

LiteralContext.prototype.IDENTIFIER = function() {
    return this.getToken(YalcilParser.IDENTIFIER, 0);
};

LiteralContext.prototype.STRING_LITERAL = function() {
    return this.getToken(YalcilParser.STRING_LITERAL, 0);
};

LiteralContext.prototype.enterRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.enterLiteral(this);
	}
};

LiteralContext.prototype.exitRule = function(listener) {
    if(listener instanceof YalcilListener ) {
        listener.exitLiteral(this);
	}
};




YalcilParser.LiteralContext = LiteralContext;

YalcilParser.prototype.literal = function() {

    var localctx = new LiteralContext(this, this._ctx, this.state);
    this.enterRule(localctx, 8, YalcilParser.RULE_literal);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 54;
        _la = this._input.LA(1);
        if(!((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << YalcilParser.STRING_LITERAL) | (1 << YalcilParser.FLOAT_LITERAL) | (1 << YalcilParser.INTEGER_LITERAL) | (1 << YalcilParser.IDENTIFIER))) !== 0))) {
        this._errHandler.recoverInline(this);
        }
        else {
            this.consume();
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


exports.YalcilParser = YalcilParser;
