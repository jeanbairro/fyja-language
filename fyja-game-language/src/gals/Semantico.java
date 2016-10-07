package gals;
import interpretador.Comando;
import interpretador.Interpretador;

public class Semantico implements Constants
{
    /*
        Um comando é composto por três dados: quantidade de passos, direção e ação.
        O executeAction é chamado quando for recebido um desses dados, esses dados são recebidos na ordem citada acima.
        Partindo disso implementamos a lógica para adicionar o dado recebidos em uma fila. 
        E quando nessa fila é adicionada o último dado que compões um comando, ou seja, uma ação (ANDAR ou PULAR ou NADAR), 
        sabemos que ela deve ser esvaziada, instanciando um novo comando.
    */   
    public void executeAction(int action, Token token)	throws SemanticError
    {
        switch(action){
            case 1:
                Interpretador.filaInterpretacao.add(Comando.Acoes.Andar); 
                Interpretador.comandos.add(new Comando(
                        (int)Interpretador.filaInterpretacao.poll(), 
                        (String)Interpretador.filaInterpretacao.poll(), 
                        (Comando.Acoes) Interpretador.filaInterpretacao.poll()
                ));
                break;
            case 2:
                Interpretador.filaInterpretacao.add(Comando.Acoes.Pular); 
                Interpretador.comandos.add(new Comando(
                        (int)Interpretador.filaInterpretacao.poll(), 
                        (String)Interpretador.filaInterpretacao.poll(), 
                        (Comando.Acoes) Interpretador.filaInterpretacao.poll()
                ));
                break;
            case 3:
                Interpretador.filaInterpretacao.add(Comando.Acoes.Nadar); 
                Interpretador.comandos.add(new Comando(
                        (int)Interpretador.filaInterpretacao.poll(), 
                        (String)Interpretador.filaInterpretacao.poll(), 
                        (Comando.Acoes) Interpretador.filaInterpretacao.poll()
                ));
                break;
            case 4:
                /* Quantidade de Passos */
                Interpretador.filaInterpretacao.add(Integer.parseInt(token.getLexeme()));
                break;
            case 5:
                /* Direção */
                Interpretador.filaInterpretacao.add(token.getLexeme());
                break;
        }
    }	
}
