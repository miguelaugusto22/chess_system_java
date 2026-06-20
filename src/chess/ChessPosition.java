package chess;

import boardgame.Position;

/**
 * Representa uma posição no tabuleiro de xadrez usando notação tradicional (a1–h8).
 * Fornece métodos para converter entre ChessPosition e Position (matriz).
 */
public class ChessPosition {
    
    private char column;
    private int row;
    
    public ChessPosition(char column, int row) {
        if (!isValid(column, row)) {
            throw new ChessException("Invalid position: " + column + row + ". Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    /** Converte ChessPosition (ex: e4) para Position (matriz). */
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }
    
    /** Converte Position (matriz) para ChessPosition (ex: e4). */
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    /** Verifica se a posição é válida no tabuleiro de xadrez. */
    public static boolean isValid(char column, int row) {
        return column >= 'a' && column <= 'h' && row >= 1 && row <= 8;
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
