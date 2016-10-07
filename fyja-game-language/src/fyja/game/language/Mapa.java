/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyja.game.language;

import interpretador.Comando.Acoes;
import java.awt.Color;
import java.awt.Graphics;

public class Mapa {
    private final int dados[][];

    public Mapa(int linhas, int colunas) {
        this.dados = Globais.mapa;
    }

    public void renderiza(Graphics g, Personagem personagem){
        for (int i = Globais.LINHAS_DO_MAPA - 1; i >= 0; i--) {
            for (int j = Globais.COLUNAS_DO_MAPA - 1; j >= 0; j--) {
                int dest_x = j * Globais.TAMANHO_DOS_TILES;
                int dest_y = i * Globais.TAMANHO_DOS_TILES;
                
                switch (this.dados[j][i]) {
                    case Globais.BLOCO_BLOQUEIO:
                        g.setColor(Color.RED);
                        break;
                    case Globais.BLOCO_TERRA:
                        g.setColor(Color.GREEN);
                        break;
                    case Globais.BLOCO_DESTINO:
                        g.setColor(Color.WHITE);
                        break;
                    case Globais.BLOCO_PERSONAGEM:
                        g.setColor(Color.YELLOW);
                        break;
                    case Globais.BLOCO_AGUA:
                        g.setColor(Color.BLUE);
                        break;
                    case Globais.BLOCO_CAMINHO:
                        g.setColor(Color.GRAY);
                        break;
                }
                
                //Pinta os blocos
                g.fillRect(dest_x, dest_y, 
                        dest_x + Globais.TAMANHO_DOS_TILES,
                        dest_y + Globais.TAMANHO_DOS_TILES);
                
                //Desenha linha entre os blocos
                g.setColor(Color.GRAY);
                g.drawRect( 
                        dest_x, dest_y, 
                        dest_x + Globais.TAMANHO_DOS_TILES,
                        dest_y + Globais.TAMANHO_DOS_TILES
                        );
            }
        }
    }
    
    public boolean validaPosicao(Personagem personagem) throws Exception {
        if (personagem.getPosicaoX() < 0 || personagem.getPosicaoX() > Globais.COLUNAS_DO_MAPA - 1) {
            return false;
        } else if (personagem.getPosicaoY() < 0 || personagem.getPosicaoY() > Globais.LINHAS_DO_MAPA - 1) {
            return false;
        } else if (dados[personagem.getPosicaoX()][personagem.getPosicaoY()] == 0){
            return false;
        } else if (personagem.getAcaoNoMomento() == Acoes.Andar && dados[personagem.getPosicaoX()][personagem.getPosicaoY()] == 4){
            return false;
        } else if (personagem.getAcaoNoMomento() == Acoes.Nadar && dados[personagem.getPosicaoX()][personagem.getPosicaoY()] == 1){
            return false;
        }
        
        return true;
    }
    
    public void trocaPosicaoPersonagem(Personagem personagem) {
         for (int i = Globais.LINHAS_DO_MAPA - 1; i >= 0; i--) {
            for (int j = Globais.COLUNAS_DO_MAPA - 1; j >= 0; j--) {
               if (this.dados[j][i] == Globais.BLOCO_PERSONAGEM) {
                   this.dados[j][i] = Globais.BLOCO_CAMINHO;
               } 
            }
         }
         
         this.dados[personagem.getPosicaoX()][personagem.getPosicaoY()] = Globais.BLOCO_PERSONAGEM;
    }
}
