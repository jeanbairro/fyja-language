/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;

public class Comando {
    public enum Acoes {
        Andar, Pular, Nadar;
    }
    
    public enum Direcoes {
        Norte, Sul, Leste, Oeste;
    }
    
    private Acoes acao;
    private String direcao;
    private int quantidadePassos;

    public Comando( int quantidadePassos, String direcao, Acoes acao) {
        this.acao = acao;
        this.direcao = direcao;
        this.quantidadePassos = quantidadePassos;   
    }

    public Acoes getAcao() {
        return acao;
    }

    public void setAcao(Acoes acao) {
        this.acao = acao;
    }

    public String getDirecao() {
        return this.direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public int getQuantidadePassos() {
        return quantidadePassos;
    }

    public void setQuantidadePassos(int quantidadePassos) {
        this.quantidadePassos = quantidadePassos;
    }
    
    public void printComando(){
        System.out.println(this.acao+ " " + this.quantidadePassos + " para " + this.direcao);
    }
}
