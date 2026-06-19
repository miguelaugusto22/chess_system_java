package boardgame;

/**
 * Exceção personalizada para erros relacionados ao tabuleiro.
 * 
 * Essa classe estende RuntimeException, permitindo lançar erros
 * específicos do domínio "boardgame" sem precisar declarar em throws.
 */
public class BoardException extends RuntimeException {
    
    // Identificador único da versão da classe (boa prática em classes serializáveis)
    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem de erro.
     * Essa mensagem será exibida quando a exceção for lançada.
     *
     * @param msg texto explicando o motivo do erro
     */
    public BoardException(String msg) {
        super(msg); // chama o construtor da superclasse RuntimeException
    }
}
