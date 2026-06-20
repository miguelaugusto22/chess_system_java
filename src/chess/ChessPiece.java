package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 * Classe base para todas as peças de xadrez.
 * Cada peça conhece sua cor, número de movimentos
 * e pode verificar se há peça adversária em determinada posição.
 */
public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public int getMoveCount() {
        return moveCount;
    }
    
    protected void increaseMoveCount() {
        moveCount++;
    }

    protected void decreaseMoveCount() {
        if (moveCount > 0) {
            moveCount--;
        }
    }

    public boolean hasMoved() {
        return moveCount > 0;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }
    
    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    @Override
    public String toString() {
        return color + " " + this.getClass().getSimpleName();
    }
}
