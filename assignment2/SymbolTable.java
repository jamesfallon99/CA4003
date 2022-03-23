import java.util.HashMap;
import java.util.Map;
//import java.util.HashMap; //used for the symbol table
import java.util.Stack; //used for the undo stack

//This could have been done directly in the visitor class but it would look messy so broke it up into two classes
public class SymbolTable{
    //a symbol table will always have a hashmap and an undo stack
    //therefore we can create fields of these

     
    public Stack<String> undoStack; //an undo stack will keep track of symbols when in scope and determine what elements we need to pop off when we exit a scope
    public Map<String, Symbol> globalScopeTable; //This will contain the elements in the global scope. The scopes will either be global or local
    //When looking up a symbol in the hashmap, we can determine if the symbol is in the local scope or the global scope
    public Map<String, Symbol> localScopeTable;
    public Map<String, Map<String, Symbol>> symbolTable; //a symbol table will map a scope to a symbol.

    public SymbolTable(){
        globalScopeTable = new HashMap<String, Symbol>();
        localScopeTable = new HashMap<String, Symbol>();
        symbolTable = new HashMap<String, Map<String, Symbol>>();
        symbolTable.put("global", globalScopeTable);
        symbolTable.put("local", localScopeTable);
        undoStack = new Stack<String>();

    }

    //in evalVisitor, we pass through the scope (either global or local as a string)
    //this way we can check where the id is in the symbol table having already known what scope it is in.
    //1. we need to check if the id is in the passed scope parameter
    //if it is we get the id

    //The job of symbol table isn't to check the sementic checks so we don't need to check the type
    //That is the visitors job

    public void insertToSymbolTable(String identifier, Symbol symbol, String scope){ //scope can be defined in the method in evalVisitor as we enter a scope we can set scope to "local" or "global"
        //Symbol symbol = new Symbol(identifier, type);
        if(scope == "local"){
            if(localScopeTable.containsKey(identifier)){ //if it is already contained in the map
                //Symbol symbol = localScopeTable.get(identifier);
                if(symbol.getDeclaration().equalsIgnoreCase("VAR")){
                    localScopeTable.replace(identifier, symbol);
                }
                else{
                    System.out.println("Can't update a Const");
                }
            }
        }
        if(scope == "global"){
            if(globalScopeTable.containsKey(identifier)){ //if it is already contained in the map
                //Symbol symbol = localScopeTable.get(identifier);
                if(symbol.getDeclaration().equalsIgnoreCase("VAR")){
                    globalScopeTable.replace(identifier, symbol);
                }
                else{
                    System.out.println("Can't update a Const");
                }
            }
        }
        if(scope == "global" && !globalScopeTable.containsKey(identifier)){
            globalScopeTable.put(identifier, symbol);
        }
        else{
            localScopeTable.put(identifier, symbol);
        }
    }
    public void destroyScope(){
        localScopeTable.clear(); //Removes all of the mappings from the localScopeTable map
        
    }
    public void clearUndoStack(String specialCharacter){
        while(undoStack.pop() != specialCharacter){
            undoStack.pop();
        }
    }

    public Symbol getSymbol(String id, String scope){
        if(scope == "global"){
            return globalScopeTable.get(id);
        }
        else{
            return localScopeTable.get(id);
        }
    }

    public String getScope(String id){
        if(globalScopeTable.containsKey(id)){
            return "global";
        }
        else if(localScopeTable.containsKey(id)){
            return "local";
        }
        return "id not defined";
    }

    public String checkIfPresent(String id, String scope){
        //This method checks what scope the symbol is in and gives us a pointer to that scope
        if(scope == "local" && localScopeTable.containsKey(id)){
            return "local";
        }
        if(scope == "global" && globalScopeTable.containsKey(id)){
            return "global";
        }
        else{
            return "null";
        }
    }


    public static void main(String[] args) {
    }

}

