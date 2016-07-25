grammar Yalcil;

program: expression EOF;
expression: abstraction | application| literal;

abstraction: LP WS? LAMBDA name=IDENTIFIER? (WS IDENTIFIER)* WS expression WS? RP;
application: LP WS? expression (WS expression)* WS? RP;
literal: FLOAT_LITERAL | INTEGER_LITERAL | IDENTIFIER | STRING_LITERAL;

STRING_LITERAL: '"' ~["]* '"' | '\'' ~[']* '\'' ;
FLOAT_LITERAL: '-'? [0-9]+ '.' [0-9]+;
INTEGER_LITERAL: '-'? [0-9]+;
IDENTIFIER: [a-zA-Z+/*-=?@<>^%_!]+;
LAMBDA: '\\';
LP: '(';
RP: ')';
WS: [ \n\r\t]+;