//Creating a symbol object so the symbol table will map the scope and the symbol contained in that scope.
//When looking up the hashmap (symbol table) for the symbol, we can check what scope it's contained in.
//A symbol will be made up of an id and type, delcaration, value and if it's a function

public class Symbol {
    String id;
    String type;
    String declaration;
    String value;
    boolean function;

    public Symbol(String id, String type, String declr, String value, boolean function){
        this.id = id;
        this.type = type;
        this.declaration = declr;
        this.value = value;
        this.function = function; //is the symbol a function or not
    }

    public String getID(){
        return this.id;
    }
    public String getType(){
        return this.type;
    }
    public String getDeclaration(){
        return this.declaration;
    }

    public String getValue(){
        return this.value;
    }
    public void setValue(String value){
        this.value = value;
    }

    public void setId(String id){
        this.id = id;
    }

    public String toString(){
        return "id: " + this.getID() + ", " + "type: " + this.getType() + ", " + "value: " + this.getValue() + ", " + "declaration: " + this.getDeclaration();
    }

    public boolean isFunction(){
        return this.function;
    }
    public void setFunction(boolean bool){
        this.function = bool;
    }

    // public static void main(String[] args) {
    //     Symbol symbol = new Symbol("num1", "INT", "VAR", "NULL", false);
    //     System.out.println(symbol.toString());
    // }
}
