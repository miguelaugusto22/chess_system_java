package boardgame;

/**
 * Representa uma posição no tabuleiro, definida por linha e coluna.
 * Essa classe é usada para localizar peças dentro da matriz Board.
 */
public class Position {

    // Linha da posição
    private int row;

    // Coluna da posição
    private int column;
    
    /**
     * Construtor: cria uma posição com linha e coluna específicas.
     *
     * @param row linha da posição
     * @param column coluna da posição
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Retorna a linha
    public int getRow() {
        return row;
    }

    // Define a linha
    public void setRow(int row) {
        this.row = row;
    }

    // Retorna a coluna
    public int getColumn() {
        return column;
    }

    // Define a coluna
    public void setColumn(int column) {
        this.column = column;
    }
    
    /**
     * Atualiza os valores de linha e coluna de uma vez.
     *
     * @param row nova linha
     * @param column nova coluna
     */
    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Retorna a posição em formato legível.
     * Útil para mensagens de erro ou debug.
     */
    @Override
    public String toString() {
        return row + ", " + column;
    }
}
