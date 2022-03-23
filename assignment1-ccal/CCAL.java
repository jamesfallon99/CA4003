import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.FileInputStream;
import java.io.InputStream;
//imported ANTLR runtime libraries
//imported necessary java libraries to take input
public class CCAL{
    public static void main(String[] args) throws Exception{
        String languageFile = null; //set the languageFile initially to null
        if(args.length > 0){//check if the command line arguments are greater than zero
            languageFile = args[0]; //if there's arguments, let languageFile equal the argument
            //our languageFile will be a program written in the CCAL language

        }
        InputStream inputStream = System.in; //Create a stream that reads from standard input.
        if(languageFile != null){ //if there's a program written in the languageFile
            inputStream = new FileInputStream(languageFile); //our input stream will use this program
        }

        CCALLexer lexer = new CCALLexer(CharStreams.fromStream(inputStream)); //Create a lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);//Using the lexer, create tokens
        CCALParser parser = new CCALParser(tokens);//create a parser that takes in the tokens
        ParseTree tree = parser.prog(); //Start parsing at the "prog" rule
        //System.out.println(tree.toStringTree(parser));//print out the tree (This line of code was shown in the definitive ANTLR 4 Reference book on page 26)
    }
}