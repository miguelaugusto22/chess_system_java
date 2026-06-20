package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * Representa a peça Cavalo no jogo de xadrez.
 * O cavalo se move em formato de "L" (duas casas em uma direção e uma em perpendicular).
 */
public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N"; // símbolo do cavalo
    }

    // Verifica se o cavalo pode se mover para determinada posição
    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
    
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        // Lista de deslocamentos possíveis do cavalo (8 movimentos em "L")
        int[][] moves = {
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, 2}, {2, 1}, {2, -1}, {1, -2}
        };

        // Itera sobre todos os movimentos possíveis
        for (int[] m : moves) {
            p.setValues(position.getRow() + m[0], position.getColumn() + m[1]);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
}
