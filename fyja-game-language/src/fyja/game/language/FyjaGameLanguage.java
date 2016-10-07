/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyja.game.language;

import interpretador.Comando;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import interpretador.Interpretador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FyjaGameLanguage implements Runnable {
    private Mapa mapa;
    private Component tela;
    private Image buffer;
    private Personagem personagem;

    public FyjaGameLanguage(Component tela) {
        this.tela = tela;
        /* Atribui posição inicial na construção */
        this.personagem = new Personagem(19, 19);
    }
    
    private void desenhaTela() {
        this.mapa.renderiza(buffer.getGraphics(), personagem);
        Graphics g = this.tela.getGraphics();
        g.drawImage(buffer, 0, 0, null);
    }
    
    private void movePersonagem() throws Exception {
        Comando comando = Interpretador.comandos.get(0);
        
        if (comando.getQuantidadePassos() < 0){
            throw new Exception("Você informou uma quantidade de passos negativa.");
        } else if (comando.getQuantidadePassos() == 0) {
            Interpretador.comandos.remove(0);
            return;
        }
        
        switch(comando.getAcao()){
            case Andar:
                personagem.setAcaoNoMomento(Comando.Acoes.Andar);
                personagem.percorrer(comando.getDirecao());
                if (mapa.validaPosicao(personagem)){
                    mapa.trocaPosicaoPersonagem(personagem);
                    comando.setQuantidadePassos(comando.getQuantidadePassos() - 1);
                } else {
                    throw new Exception("Você não programou um caminho válido.");
                }
                break;
            case Nadar:
                personagem.setAcaoNoMomento(Comando.Acoes.Nadar);
                personagem.percorrer(comando.getDirecao());
                if (mapa.validaPosicao(personagem)){
                    mapa.trocaPosicaoPersonagem(personagem);
                    comando.setQuantidadePassos(comando.getQuantidadePassos() - 1);
                } else {
                    throw new Exception("Você não programou um caminho válido.");
                }
                break;
            case Pular:
                personagem.setAcaoNoMomento(Comando.Acoes.Pular);
                personagem.pular(comando.getDirecao(), comando.getQuantidadePassos());
                if (mapa.validaPosicao(personagem)){
                    mapa.trocaPosicaoPersonagem(personagem);
                    comando.setQuantidadePassos(0);
                } else {
                    throw new Exception("Você não programou um caminho válido.");
                }
                break;
        }
    }

    @Override
    public void run() {
        this.mapa = new Mapa(Globais.LINHAS_DO_MAPA, Globais.COLUNAS_DO_MAPA);
        this.buffer = tela.getGraphicsConfiguration().createCompatibleImage(
                Globais.LARGURA_DA_TELA, Globais.ALTURA_DA_TELA);
        Interpretador interpretador = new Interpretador();
        
        try {
            desenhaTela();
            JTextArea textArea = new JTextArea(20, 20);
            switch (JOptionPane.showConfirmDialog(null, new JScrollPane(textArea))) {
                case JOptionPane.OK_OPTION:
                    interpretador.interpretar(textArea.getText().toUpperCase());
            }
            
            while (!Interpretador.comandos.isEmpty()) {
                desenhaTela();
                movePersonagem();
                /* Pra movimentação ficar mais lenta */
                Thread.sleep(125);
            }            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(tela, "Você informou um caminho inválido. Detalhes: "+ex.getMessage());
            tela.setVisible(false);
            System.exit(0);
        }
    }
    
}
