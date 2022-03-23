grammar CCAL;

prog:   decl_list function_list main;

decl_list:  decl SEMI decl_list 
            | epsilon
            ;

decl:   var_decl
        | const_decl;

var_decl: VAR ID COLON (INTEGER|BOOLEAN); // According to the language definition: "Variables or constants cannot be declared using the void type". Instead of using "type" I used the reserved words INTEGER and BOOLEAN to get around this

const_decl: <assoc=right> CONST ID COLON (INTEGER|BOOLEAN) EQUALS expression;
//Learned about <assoc=right> from https://github.com/antlr/antlr4/blob/master/doc/left-recursion.md
//"If your grammar uses a right-associative ternary operator, you will need to update your grammar to include <assoc=right> on the alternative operator"
//Also described in The Definitive ANTLR4 reference book

function_list:  function function_list 
                | epsilon
                ;

function: type ID LBR parameter_list RBR
          CURLY_LBR
          decl_list
          statement_block
          RETURN LBR (expression | epsilon) RBR SEMI
          CURLY_RBR
          ;

type:   INTEGER 
        | BOOLEAN 
        | VOID
        ;

parameter_list: nemp_parameter_list 
                | epsilon;

nemp_parameter_list:    ID COLON type
                        | ID COLON type COMMA nemp_parameter_list
                        ;

main:   MAIN CURLY_LBR
        decl_list
        statement_block
        CURLY_RBR
        ;

statement_block:    statement statement_block
                    | epsilon
                    ;

statement:  <assoc=right> ID EQUALS expression SEMI
            | ID LBR arg_list RBR SEMI
            | CURLY_LBR statement_block CURLY_RBR
            | IF condition CURLY_LBR statement_block CURLY_RBR
              ELSE CURLY_LBR statement_block CURLY_RBR
            | WHILE condition CURLY_LBR statement_block CURLY_RBR
            | SKIPS SEMI
            ;

expression: frag binary_arith_op frag
            | LBR expression RBR
            | ID LBR arg_list RBR
            | frag
            ;

binary_arith_op:    PLUS 
                    | <assoc=right> MINUS //arithmetic negation is right to left associative according to the langauge definition
                    ;

frag:       ID
             | MINUS ID
             | NUMBER 
             | TRUE 
             | FALSE
             | LBR expression RBR //how to eliminate indirect recursion?
             //ANTLR 4 is able to process only direct left-recursion:
             //right now, we have indirect left recursion
             //placing left bracket before the recursive call and right bracket after it to eliminate the indirect recursion
             ;

condition:  <assoc=right> NEGATION condition
            | LBR condition RBR
            | expression comp_op expression
            | condition (OR | AND) condition
            ;


comp_op:    EQUAL_TO 
            | NOT_EQUAL_TO 
            | LESS_THAN 
            | LESS_THAN_EQUAL_TO 
            | GREATER_THAN 
            | GREATER_THAN_EQUAL_TO;

arg_list:   nemp_arg_list
            | epsilon
            ;
nemp_arg_list:  ID | ID COMMA nemp_arg_list;

epsilon: ; //empty




fragment A:     'a'|'A';
fragment B:	'b'|'B';
fragment C:	'c'|'C';
fragment D:	'd'|'D';
fragment E:	'e'|'E';
fragment F:	'f'|'F';
fragment G:	'g'|'G';
fragment H:	'h'|'H';
fragment I:	'i'|'I';
fragment J:	'j'|'J';
fragment K:	'k'|'K';
fragment L:	'l'|'L';
fragment M:	'm'|'M';
fragment N:	'n'|'N';
fragment O:	'o'|'O';
fragment P:	'p'|'P';
fragment Q:	'q'|'Q';
fragment R:	'r'|'R';
fragment S:	's'|'S';
fragment T:	't'|'T';
fragment U:	'u'|'U';
fragment V:	'v'|'V';
fragment W:	'w'|'W';
fragment X:	'x'|'X';
fragment Y:	'y'|'Y';
fragment Z:	'z'|'Z';


fragment Integer:     '0' | MINUS [1-9] ([0-9])* | [1-9] ([0-9])*; //Can either have a 0 by itself or start with a minus sign followed by 1-9 followed by zero or more 0-9 e.g -234 or 1-9 followed by zero or more 0-9 e.g. 567
fragment Letter:      [a-zA-Z]+;
fragment UnderScore:     '_';

//Reserved words
VAR:    V A R;
CONST:  C O N S T;
RETURN: R E T U R N;
INTEGER:    I N T E G E R;
BOOLEAN:    B O O L E A N;
VOID:   V O I D;
MAIN:   M A I N;
IF:     I F;
ELSE:   E L S E;
TRUE:   T R U E;
FALSE:  F A L S E;
WHILE:  W H I L E;
SKIPS:   S K I P; //Had to change the word to 'SKIPS' because an error occured otherwise e.g. "cannot declare a rule with reserved name SKIP" 

//The Following are tokens in the language
COMMA:  ',';
SEMI:   ';';
COLON:  ':';
EQUALS: '=';
CURLY_LBR:   '{';
CURLY_RBR:   '}';   
LBR:    '(';
RBR:    ')';
PLUS:   '+';
MINUS:   '-';
NEGATION:    '~';
OR:     '||';
AND:    '&&';
EQUAL_TO:    '==';
NOT_EQUAL_TO:   '!=';
LESS_THAN:   '<';
LESS_THAN_EQUAL_TO:    '<=';
GREATER_THAN:    '>';
GREATER_THAN_EQUAL_TO: '>=';

NUMBER:         Integer;


ID:     Letter (Letter | Integer | UnderScore)*;
//Identifiers are represented by a string of letters, digits or underscore character beginning with a letter

WS:     [ \t\r\n]+ -> skip;

COMMENT:    '/*' (COMMENT|.)*? '*/'   ->  skip;
//This allows for comments just with the "/* */" symbols. Also allows for 0 or more tokens between
//the comment symbols. But also allows for 0 or more nested comments by using recursion
//greedy block ()* contains wildcard; the non-greedy syntax ()*? may be preferred
// use recursion in order to cater for nested comments
// can have 0 or more nested comments
LINE_COMMENT:   '//' .*? '\n'   ->  skip;
//"?" in ANTLR4 defines an optional argument
//'.' is a wildcard and can be replaced with anything
// a comment can appear between any two tokens so we use '.' to represent any token the comment can be placed around
//is Channel(HIDDEN) supposed to be used instead of skip?
