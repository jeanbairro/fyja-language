package gals;
import interpretador.Comando;
import interpretador.Interpretador;

public class Semantico implements Constants
{
    public void executeAction(int action, Token token)	throws SemanticError
    {
        switch(action){
            case 1:
                Interpretador.fila.add(Comando.Acoes.Andar); 
                Interpretador.comandos.add(new Comando((int)Interpretador.fila.poll(), 
                                                        (String)Interpretador.fila.poll(), 
                                                        (Comando.Acoes) Interpretador.fila.poll()
                                                        ));
                break;
            case 2:
                Interpretador.fila.add(Comando.Acoes.Pular); 
                Interpretador.comandos.add(new Comando((int)Interpretador.fila.poll(), 
                                                        (String)Interpretador.fila.poll(), 
                                                        (Comando.Acoes) Interpretador.fila.poll()
                                                        ));
                break;
            case 3:
                Interpretador.fila.add(Comando.Acoes.Nadar); 
                Interpretador.comandos.add(new Comando((int)Interpretador.fila.poll(), 
                                                        (String)Interpretador.fila.poll(), 
                                                        (Comando.Acoes) Interpretador.fila.poll()
                                                        ));
                break;
            case 4:
                Interpretador.fila.add(Integer.parseInt(token.getLexeme()));
                break;
            case 5:
                Interpretador.fila.add(token.getLexeme());
                break;
        }
    }	
}
