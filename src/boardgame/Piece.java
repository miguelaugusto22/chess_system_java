package boardgame;

/**
 * Classe base para todas as peças do tabuleiro.
 * Cada peça conhece o tabuleiro ao qual pertence e sua posição atual.
 * Subclasses devem implementar possibleMoves() retornando uma matriz booleana
 * indicando onde a peça pode se mover.
 */
public abstract class Piece {

    // posição atual da peça no tabuleiro (visibilidade protegida para permitir uso em subclasses)
    protected Position position;

    // referência ao tabuleiro onde a peça está (privado, acessível via getBoard)
    private Board board;

    /**
     * Construtor: associa a peça a um tabuleiro.
     * A posição inicial é null (peça ainda não colocada).
     */
    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    /**
     * Retorna o tabuleiro associado à peça.
     */
    protected Board getBoard() {
        return board;
    }

    /**
     * Subclasses devem implementar este método para indicar
     * todos os movimentos possíveis da peça.
     * A matriz tem o mesmo tamanho do tabuleiro: [rows][columns].
     */
    public abstract boolean[][] possibleMoves();

    /**
     * Verifica se a peça pode se mover para a posição passada.
     * Faz validação de limites antes de acessar a matriz para evitar
     * ArrayIndexOutOfBoundsException.
     *
     * @param position posição a verificar
     * @return true se a peça pode mover para a posição; false caso contrário
     */
    public boolean possibleMove(Position position) {
        // valida se a posição pertence ao tabuleiro
        if (position == null || !getBoard().positionExists(position)) {
            return false;
        }
        boolean[][] mat = possibleMoves(); // calcula uma vez
        return mat[position.getRow()][position.getColumn()];
    }

    /**
     * Retorna true se existir pelo menos um movimento possível.
     * Usa laços corretos (mat[i].length) e evita recalcular possibleMoves
     * dentro do laço.
     *
     * @return true se há ao menos um movimento possível
     */
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) { // corrigido: mat[i].length
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Encapsulamento para alterar a posição da peça.
     * Protegido para que apenas subclasses e classes do mesmo pacote possam usar.
     */
    protected void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Retorna a posição atual da peça.
     * Protegido para uso interno/subclasses; torne público se necessário externamente.
     */
    protected Position getPosition() {
        return position;
    }
}
