/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;
import gals.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jean_
 */
public class Interpretador {
    public static List<Comando> comandos = new ArrayList<>();
    
    public void interpretar(String fonte) {        
        fonte = "INICIO " +
                "ANDAR 20 PARA SUL " +
                "NADAR 10 PARA NORTE " +
                "FIM";
        
        Lexico lex = new Lexico();
        Sintatico sin = new Sintatico();
        Semantico sem = new Semantico();
        
        try {
            sin.parse(lex, sem);
        } catch (LexicalError | SyntaticError | SemanticError ex) {
            Logger.getLogger(Interpretador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
