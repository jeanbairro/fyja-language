/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;
import gals.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jean_viadinho
 */
public class Interpretador {
    public static Queue<Object> fila = new LinkedList<>();;
    public static List<Comando> comandos = new ArrayList<>();
    
    public void interpretar(String fonte) {        
        Lexico lex = new Lexico(fonte);
        Sintatico sin = new Sintatico();
        Semantico sem = new Semantico();
        
        try {
            sin.parse(lex, sem);
        } catch (LexicalError | SyntaticError | SemanticError ex) {
            Logger.getLogger(Interpretador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < comandos.size(); i++){
            comandos.get(i).printComando();
        }
    }
}
