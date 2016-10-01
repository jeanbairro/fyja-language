/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;

/**
 *
 * @author jean_
 */
public class Comando {
    public enum Acoes {
        Andar, Pular, Nadar;
    }
    
    public enum Direcoes {
        Norte, Sul, Leste, Oeste;
    }

    public Comando(Acoes acao, Direcoes direcao, int quantidadePassos) {
        
    }
    
    private Acoes acao;
    private Direcoes direcao;
    private int quantidadePassos;

    public Acoes getAcao() {
        return acao;
    }

    public void setAcao(Acoes acao) {
        this.acao = acao;
    }

    public Direcoes getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcoes direcao) {
        this.direcao = direcao;
    }

    public int getQuantidadePassos() {
        return quantidadePassos;
    }

    public void setQuantidadePassos(int quantidadePassos) {
        this.quantidadePassos = quantidadePassos;
    }
}
