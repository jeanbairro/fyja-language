/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyja.game.language;

import interpretador.Interpretador;

/**
 *
 * @author jean_gayzinho
 */
public class FyjaGameLanguage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interpretador interpretador = new Interpretador();
        String fonte = "INICIO " +
                "ANDAR 20 PARA SUL " + 
                "NADAR 10 PARA NORTE " +
                "FIM";
        interpretador.interpretar(fonte);
        
    }
    
}
