# CA4003
Assignments for CA4003 Compiler Construction

Assignment 1: A Lexical and Syntax Analyser for the CCAL Language
"The aim of this assignment is to implement a lexical and syntax analyser using Antlr4 for a simple language called CCAL. The target language of Antrl4 must be Java.
Your parser must read the source language from a file."

Assignment 2: Semantic Analysis and Intermediate Representation for the CCAL Language
"The aim of this assignment is to add semantic analysis checks and intermediate representation generation to the lexical and syntax analyser you have implement for the CCAL language as Assignment 1. The target language of Antrl4 must be Java. The genetated intermediate code should be a 3-address code and stored in a file with the ".ir" extension.

Your will need to extend your submission for Assignment 1 to:

Add a Symbol Table that can handle scope.
Perform a set of semtantic checks. This following is a list of typical sematic checks:
Is every identifier declared within scope before its is used?
Is no identifier declared more than once in the same scope?
Is the left-hand side of an assignment a variable of the correct type?
Are the arguments of an arithmetic operator the integer variables or integer constants?
Are the arguments of a boolean operator boolean variables or boolean constants?
Is there a function for every invoked identifier?
Does every function call have the correct number of arguments?
Is every variable both written to and read from?
Is every function called?
Generate an Intermediate Representation using 3-address code."
