package chess;

import boardgame.BoardException;

/**
 * Exceção personalizada para erros relacionados ao jogo de xadrez.
 * 
 * Estende BoardException para reaproveitar a lógica de exceções
 * do tabuleiro, mas diferencia semanticamente os erros de xadrez
 * (como movimentos inválidos, regras especiais, etc.).
 */
public class ChessException extends BoardException {
    
    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem de erro.
     * Essa mensagem será exibida quando a exceção for lançada.
     *
     * @param msg texto explicando o motivo do erro
     */
    public ChessException(String msg) {
        super(msg);
    }
}
