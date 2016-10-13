package fyja.game.language;

/**
 *
 * @author jean_
 */
public class Globais {
    /* Dimensões */
    public static final int LINHAS_DO_MAPA = 20;
    public static final int COLUNAS_DO_MAPA = 20;
    public static final int TAMANHO_DOS_TILES = 15;
    public static final int LARGURA_DA_TELA = COLUNAS_DO_MAPA * 30;
    public static final int ALTURA_DA_TELA = LINHAS_DO_MAPA * 30;
    public static final int ALTURA_DO_FOOTER = 100;
    
    /* Objetos da Matriz */
    public static final int BLOCO_BLOQUEIO = 0;
    public static final int BLOCO_TERRA = 1;
    public static final int BLOCO_DESTINO = 2;
    public static final int BLOCO_PERSONAGEM = 3;
    public static final int BLOCO_AGUA = 4;
    public static final int BLOCO_CAMINHO = 5;
    
    
    public static int mapa[][] = {
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
    { 0, 0, 2, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
    { 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
    { 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
    { 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1 },
    { 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0 },
    { 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0 },
    { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
    { 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1 },
    { 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0 },
    { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0 },
    { 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
    { 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
    { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 4, 4, 4, 0, 0, 4, 4, 0, 1 },
    { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 4, 4, 4, 0, 0, 4, 4, 0, 1 },
    { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 4, 4, 4, 1, 1, 4, 4, 1, 1 },
    { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
    { 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 3 },
    };
}
