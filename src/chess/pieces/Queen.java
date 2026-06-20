package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * Representa a peça Rainha no jogo de xadrez.
 * A rainha combina os movimentos da torre e do bispo:
 * pode se mover em linhas, colunas e diagonais até encontrar
 * uma peça ou o limite do tabuleiro.
 */
public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q"; // símbolo da rainha
    }
    
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        // Lista de direções possíveis da rainha (8 direções)
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},   // cima, baixo, esquerda, direita
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // diagonais
        };

        // Itera sobre todas as direções
        for (int[] d : directions) {
            p.setValues(position.getRow() + d[0], position.getColumn() + d[1]);
            // Continua andando na direção até encontrar peça ou limite
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setValues(p.getRow() + d[0], p.getColumn() + d[1]);
            }
            // Se encontrar peça adversária, pode capturar
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
}
