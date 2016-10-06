/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyja.game.language;

import interpretador.Comando.Acoes;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jean_
 */
public class Mapa {
    private final int linhas;
    private final int colunas;
    private final int dados[][];

    public Mapa(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.dados = Globals.mapa;
    }

    public void renderiza(Graphics g, Personagem personagem){
        for (int i = Globals.LINHAS_DO_MAPA - 1; i >= 0; i--) {
            for (int j = Globals.COLUNAS_DO_MAPA - 1; j >= 0; j--) {
                int dest_x = j * Globals.TAMANHO_DOS_TILES;
                int dest_y = i * Globals.TAMANHO_DOS_TILES;
                
                switch (this.dados[j][i]) {
                    case 0:
                        g.setColor(Color.RED);
                        break;
                    case 1:
                        g.setColor(Color.GREEN);
                        break;
                    case 2:
                        g.setColor(Color.WHITE);
                        break;
                    case 3:
                        g.setColor(Color.YELLOW);
                        break;
                    case 4:
                        g.setColor(Color.BLUE);
                        break;
                    case 5:
                        g.setColor(Color.GRAY);
                        break;
                }
                
                g.fillRect(dest_x, dest_y, 
                        dest_x + Globals.TAMANHO_DOS_TILES,
                        dest_y + Globals.TAMANHO_DOS_TILES);
                
                //Desenha linha
                g.setColor(Color.GRAY);
                g.drawRect( 
                        dest_x, dest_y, 
                        dest_x + Globals.TAMANHO_DOS_TILES,
                        dest_y + Globals.TAMANHO_DOS_TILES
                        );
            }
        }
    }
    
    public boolean validaPosicao(Personagem personagem) throws Exception {
        if (personagem.getPosicaoX() < 0 || personagem.getPosicaoX() > Globals.COLUNAS_DO_MAPA - 1) {
            return false;
        } else if (personagem.getPosicaoY() < 0 || personagem.getPosicaoY() > Globals.LINHAS_DO_MAPA - 1) {
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
         for (int i = Globals.LINHAS_DO_MAPA - 1; i >= 0; i--) {
            for (int j = Globals.COLUNAS_DO_MAPA - 1; j >= 0; j--) {
               if (this.dados[j][i] == 3) {
                   this.dados[j][i] = 5;
               } 
            }
         }
         
         this.dados[personagem.getPosicaoX()][personagem.getPosicaoY()] = 3;
    }
}
