package gals;
import interpretador.Comando;
import interpretador.Interpretador;

public class Semantico implements Constants
{
    public void executeAction(int action, Token token)	throws SemanticError
    {
        //Interpretador.comandos.add(new Comando(Comando.Acoes.Andar, Comando.Direcoes.Norte, 10));
        
        switch(action){
            case 1:
                System.out.println("1: " + token.getLexeme());
                break;
            case 2:
                System.out.println("2: " + token.getLexeme());
                break;
            case 3:
                System.out.println("3: " + token.getLexeme());
                break;
        }
    }	
}
