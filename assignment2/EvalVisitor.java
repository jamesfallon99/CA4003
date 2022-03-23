import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
//The code compiles fine but still getting compilation errors in the editor
public class EvalVisitor extends CCALBaseVisitor<String>{
    public SymbolTable symbolTable;

    public EvalVisitor(){
        symbolTable = new SymbolTable();
    }

    String scope = "global"; //this will change between global and local as the tree is parsed

    @Override
    public String visitVar_decl(CCALParser.Var_declContext ctx){
        //String scope = "global";
        //When we visit Var_decl, we need to check has it already been declared
        //in the scope that we are currently in (scope will be handled by other methods that call var_decl)

        String id = ctx.ID().getText(); //we get the id
        String type = ctx.type().getText(); //we get the type
        Symbol symbol = new Symbol(id, type, "var", "null", false);
        symbolTable.insertToSymbolTable(id, symbol, scope);
        //System.out.println(symbolTable.globalScopeTable.get(id).toString());
        return type;
    }
    @Override
    public String visitConst_decl(CCALParser.Const_declContext ctx){
        //String scope = "global"; //this will be set as the tree is parsed
        String id = ctx.ID().getText();
        String type = ctx.type().getText();
        Symbol symbol = new Symbol(id, type, "var", "null", false);
        symbolTable.insertToSymbolTable(id, symbol, scope);
        return type;
    }
    @Override 
    public String visitNonEmptyParameterList(CCALParser.NonEmptyParameterListContext ctx){
        scope = "local"; //parameter list only occur when going in to a new scope (local) and not contained in global
        String id = ctx.ID().getText();
        String type = ctx.type().getText();
        Symbol symbol = new Symbol(id, type, "null", "null", false);
        symbolTable.insertToSymbolTable(id, symbol, scope);
        return type;
    }

    @Override 
    public String visitNestedNonEmptyParameterList(CCALParser.NestedNonEmptyParameterListContext ctx){
        //scope = "local"; //parameter list only occur when going in to a new scope (local) and not contained in global
        String id = ctx.ID().getText();
        String type = ctx.type().getText();
        Symbol symbol = new Symbol(id, type, "null", "null", false);
        symbolTable.insertToSymbolTable(id, symbol, scope);
        visit(ctx.nemp_parameter_list()); //Need to visit NonEmptyParamreterList here also
        return type;
    }

    @Override 
    public String visitFragID(CCALParser.FragIDContext ctx){
        //When an identifier is used, it is looked up in the symbol table
        String id = ctx.ID().getText();
        String idPointer = symbolTable.checkIfPresent(id, scope); //this will either return "global", "local", or "null"
        if(idPointer == "global"){
            String value = symbolTable.getSymbol(id, idPointer).getValue(); //we get the value
            String type = symbolTable.getSymbol(id, idPointer).getType();
            String valueAndType = value + "&" + type;
            return valueAndType; 
        }
        if(idPointer == "local"){
            String value = symbolTable.getSymbol(id, idPointer).getValue(); //get the value associated with the id
            String type = symbolTable.getSymbol(id, idPointer).getType();
            String valueAndType = value + "&" + type;
            return valueAndType;
        }

        if(idPointer == "null"){
            //throw an error as not in the symbol table
            Error("Has not been declared");
        }
        return "";
        
    }


    @Override 
    public String visitFragMinusID(CCALParser.FragMinusIDContext ctx){
        String id = ctx.ID().getText();
        String idPointer = symbolTable.checkIfPresent(id, scope);
        //need to check if it's an INT
        //if so, we can add a minus sign to the INT

        //Need to check if it's a boolean
        //If it is, then we can't attach a minus sign to it
        if(idPointer == "global"){
            Symbol symbol = symbolTable.getSymbol(id, idPointer); //we get the symbol
            if(symbol.type.equalsIgnoreCase("boolean")){
                Error("Can't minus a boolean value");
            }
            if(symbol.type.equalsIgnoreCase("integer")){
                //get the value and attach a minus
                String value = symbolTable.getSymbol(id, idPointer).getValue();
                value = "-" + value;

                String type = symbolTable.getSymbol(id, idPointer).getType();
                String valueAndType = value + "&" + type;
                return valueAndType;
            }
        }   

        if(idPointer == "local"){
            Symbol symbol = symbolTable.getSymbol(id, idPointer); //we get the symbol
            
            if(symbol.type.equalsIgnoreCase("boolean")){
                Error("Can't minus a boolean value");
            }
            if(symbol.type.equalsIgnoreCase("integer")){
                //get the value and attach a minus
                String value = symbolTable.getSymbol(id, idPointer).getValue();
                value = "-" + value;

                String type = symbolTable.getSymbol(id, idPointer).getType();
                String valueAndType = value + "&" + type;
                return valueAndType;
            }  
        }

        if(idPointer == "null"){
            //throw an error as not in the symbol table
            Error("Has not been declared");
            
        }
        return "";
    }

    @Override 
    public String visitFragNumber(CCALParser.FragNumberContext ctx){
        String value = ctx.NUMBER().getText();
        String type = "INTEGER"; //a NUMBER will always be an integer so hardcoding it
        String valueAndType = value + "&" + type;
        //we need to return the value and type so in order to do this
        //initially was going to return both in an array but the CCALBaseVisitor has a generic type of string
        //so going to return a concatenated string in which i will use string.subString() to access both
        return valueAndType;
    }

    @Override 
    public String visitFragTrue(CCALParser.FragTrueContext ctx){
        String value = ctx.TRUE().getText();
        String type = "BOOLEAN";
        String valueAndType = value + "&" + type;
        return valueAndType;
    }

    @Override 
    public String visitFragFalse(CCALParser.FragFalseContext ctx){
        String value = ctx.FALSE().getText();
        String type = "BOOLEAN";
        String valueAndType = value + "&" + type;
        return valueAndType;
    }

    @Override 
    public String visitFragLBRExprRBR(CCALParser.FragLBRExprRBRContext ctx){
        visit(ctx.expression());
        return "";
    }

    @Override 
    public String visitFragExpr(CCALParser.FragExprContext ctx){
        visit(ctx.frag());
        return "";
    }

    private void Error(String error) {
        System.out.println(error);
        System.exit(1);
    }

    @Override 
    public String visitFunction(CCALParser.FunctionContext ctx){
        String id = ctx.ID().getText();
        String type = ctx.type().getText();
        scope = "global"; //function id will be defined in the global scope. We will have to check the globalScopeTable to see if it is contained there. If it is, then this is an error as two functions with the same id can't be defined (an error will occur)
        //otherwise if it is not in the symbol table, we can add it to the symbol table.
        String IDPointer = symbolTable.checkIfPresent(id, scope); //returns either global, local or null
        
        if(IDPointer == "global"){
            Error("Function has already been defined.");
        }

        Symbol symbol = new Symbol(id, type, "null", "null", true); //otherwise create a symbol
        symbolTable.insertToSymbolTable(id, symbol, scope); //add it to the symbolTable

        visit(ctx.parameter_list()); //The visitParameterList method will handle this
        symbolTable.undoStack.push("specialCharacter"); //this tells us it is the start of a scope. Not sure if needed as symbol table has a method destroyScope that works well.
        symbolTable.undoStack.push(id);
        scope = "local"; //change to local scope as we are now in a function's scope
        visit(ctx.decl_list()); //our visitDeclr_list will handle this
        visit(ctx.statement_block());//our visitStatement_block will handle this
        String expressionResult = visit(ctx.children.get(10));
        symbolTable.destroyScope(); //exiting the scope so we destroy the scope by removing everything in the localScopeTable 
        symbolTable.clearUndoStack("specialCharacter"); //and popping everything from the undo stack until we reach the specialCharacter
        scope = "global";
        return type;
    }

    @Override 
    public String visitParameterList(CCALParser.ParameterListContext ctx){
        visit(ctx.nemp_parameter_list());
        return "";
    }


    @Override 
    public String visitStatementStm(CCALParser.StatementStmContext ctx){
        //<assoc=right> ID EQUALS expression SEMI (this part of the grammar)
        //statement is only used in a function or main therefore it is going to be in a local scope
        scope = "local";
        //Is the left-hand side of an assignment a variable of the correct type?
        //we need to cater for this sematic check here as an id will have been declared with a type
        //so we check if that id is present in the symbol table and check the type if it is
        // we the check the type of the expression and if they are the same then all good
        //otherwise error occurs as not the same type.
        String id = ctx.ID().getText();
        //first thing we do is check has the id been declared?
        String IDPointer = symbolTable.checkIfPresent(id, scope);
        if(IDPointer == "null"){ //we know that if this returns null, the id has never been declared and so we give an error
            Error("This has not been declared");
        }
        if(IDPointer == "local"){
            //we know it's contained in the scope so we can proceed
            //next we do our type checking
            Symbol symbol = symbolTable.getSymbol(id, scope);
            String idType = symbol.getType();
            String exprType = visit(ctx.expression()); //the return value of expression should be the type
            //System.out.println(exprType);
            //now we need to perform our semantic check
            //need to see if both types are the same
            //check if the expression has a "+" sign in the returned value
            //if it does, we want to split on this plus sign to get the type and the value
            String[] valueAndType = exprType.split("&"); //all of the fragment alternatives will need to return a type and value, therefore can split on "&" symbol for all
            String type = valueAndType[0];
            String value = valueAndType[1];
            if(idType.equalsIgnoreCase(type)){
                //we know that if the types match, then we can assign the expression value to the id's value
                //symbol.setValue() //need to get the value of the expression
                //got the split, now need to add to symbol if same type and also handle if not same type
                symbol.setValue(value); //set the value of the expression to the symbol 
                return idType;
            }
            if(idType != type){
                Error("Type mismatch");
            }
        }
        return "";

   
    }

    @Override 
    public String visitArgListExpr(CCALParser.ArgListExprContext ctx){
        visit(ctx.arg_list());
        return "";
        //we need to get the value of the arglist and the type
        //in order to perform semantic checking in the expression
        //this method that we are in here is in the expression block in the grammar
        //ID LBR arg_list RBR  #argListExpr
        //Need to check if the id is in the symbol table
        //need to get the value of the arg list
    }

    @Override 
    public String visitOneID(CCALParser.OneIDContext ctx) {
        String id = ctx.ID().getText();
        String IDPointer = symbolTable.checkIfPresent(id, scope);
        if(IDPointer == "local"){
            return id;
        }
        if(IDPointer == "global"){
            return id;
        }
        if(IDPointer == "null"){
            Error(id + " Has not been declared");
        }
        return "";
    }

    //nemp_arg_list
    @Override 
    public String visitMultipleID(CCALParser.MultipleIDContext ctx){
        String id = ctx.ID().getText();
        String IDPointer = symbolTable.checkIfPresent(id, scope);
        if(IDPointer == "local"){
            return id;
        }
        if(IDPointer == "global"){
            return id;
        }
        if(IDPointer == "null"){
            Error(id + " Has not been declared");
        }
        String comma = visit(ctx.COMMA());
        if(comma == null){
            Error("Missing COMMA between args");
        }
        visit(ctx.nemp_arg_list());
        return "";

        //this method would also need to check the order of the args
        //and the types of the args to ensure thet match the order and
        //types of the parameters defined in the function definiton
    }

    @Override 
    public String visitMain(CCALParser.MainContext ctx){
        scope = "local";
        symbolTable.undoStack.push("specialCharacter");
        visit(ctx.decl_list());
        visit(ctx.statement_block());
        symbolTable.destroyScope();
        symbolTable.clearUndoStack("specialCharacter");
        scope = "global";
        return "";
    }

    @Override //This method is for function calls. The id would therefore have to have their function field set to true, or an error occurs
    //only occurs in the local scope
    public String visitArgListStatement(CCALParser.ArgListStatementContext ctx){
        String id = ctx.ID().getText();
        String IDPointer = symbolTable.checkIfPresent(id, scope);
        if(IDPointer == "local"){
            if(symbolTable.getSymbol(id, scope).function == true){
                return "";
            }
            else{
                Error("Not a function");
            }
        }
        if(IDPointer == "null"){
            Error(id + " Has not been declared");
        }
        return "";
    }

    public static void main(String[] args) {
    }
}
