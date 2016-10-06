/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyja.game.language;
import interpretador.Comando.Acoes;
import java.awt.Color;

/**
 *
 * @author jean_
 */
public class Personagem {

    public Personagem(int posicaoX, int posicaoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.cor = Color.YELLOW;
    }
    
    private int posicaoX;
    private int posicaoY;
    private Color cor;
    private Acoes acaoNoMomento;

    public Acoes getAcaoNoMomento() {
        return acaoNoMomento;
    }

    public void setAcaoNoMomento(Acoes acaoNoMomento) {
        this.acaoNoMomento = acaoNoMomento;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
    
    public void percorrer(String direcao) {
        switch(direcao){
            case "NORTE":
                this.posicaoY -= 1;
                break;
            case "SUL":
                this.posicaoY += 1;
                break;
            case "LESTE":
                this.posicaoX += 1;
                break;
            case "OESTE":
                this.posicaoX -= 1;
                break;
        }
    }
    
    public void pular(String direcao, int quantidade) {        
        switch(direcao){
            case "NORTE":
                this.posicaoY -= quantidade;
                break;
            case "SUL":
                this.posicaoY += quantidade;
                break;
            case "LESTE":
                this.posicaoX += quantidade;
                break;
            case "OESTE":
                this.posicaoX -= quantidade;
                break;
        }
    }
}
