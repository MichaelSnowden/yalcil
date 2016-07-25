// Generated from src/main/antlr4/com/michaelsnowden/yalcil/Yalcil.g4 by ANTLR 4.5.3
// jshint ignore: start
var antlr4 = require('antlr4/index');

// This class defines a complete listener for a parse tree produced by YalcilParser.
function YalcilListener() {
	antlr4.tree.ParseTreeListener.call(this);
	return this;
}

YalcilListener.prototype = Object.create(antlr4.tree.ParseTreeListener.prototype);
YalcilListener.prototype.constructor = YalcilListener;

// Enter a parse tree produced by YalcilParser#program.
YalcilListener.prototype.enterProgram = function(ctx) {
};

// Exit a parse tree produced by YalcilParser#program.
YalcilListener.prototype.exitProgram = function(ctx) {
};


// Enter a parse tree produced by YalcilParser#expression.
YalcilListener.prototype.enterExpression = function(ctx) {
};

// Exit a parse tree produced by YalcilParser#expression.
YalcilListener.prototype.exitExpression = function(ctx) {
};


// Enter a parse tree produced by YalcilParser#lambdaAbstraction.
YalcilListener.prototype.enterLambdaAbstraction = function(ctx) {
};

// Exit a parse tree produced by YalcilParser#lambdaAbstraction.
YalcilListener.prototype.exitLambdaAbstraction = function(ctx) {
};


// Enter a parse tree produced by YalcilParser#application.
YalcilListener.prototype.enterApplication = function(ctx) {
};

// Exit a parse tree produced by YalcilParser#application.
YalcilListener.prototype.exitApplication = function(ctx) {
};


// Enter a parse tree produced by YalcilParser#literal.
YalcilListener.prototype.enterLiteral = function(ctx) {
};

// Exit a parse tree produced by YalcilParser#literal.
YalcilListener.prototype.exitLiteral = function(ctx) {
};



exports.YalcilListener = YalcilListener;