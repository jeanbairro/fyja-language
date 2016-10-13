package interpretador;
import gals.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Interpretador {
    public static Queue<Object> filaInterpretacao = new LinkedList<>();
    public static List<Comando> comandos = new ArrayList<>();
    
    public void interpretar(String fonte) throws LexicalError, SyntaticError, SemanticError {        
        Lexico lex = new Lexico(fonte);
        Sintatico sin = new Sintatico();
        Semantico sem = new Semantico();
        
        try {
            sin.parse(lex, sem);
        } catch (LexicalError | SyntaticError | SemanticError ex) {
            throw ex;
        }
        
        for(int i = 0; i < comandos.size(); i++){
            comandos.get(i).printComando();
        }
    }
}
