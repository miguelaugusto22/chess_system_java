package boardgame;

public class Board {

    // Número de linhas e colunas do tabuleiro
    private int rows;
    private int columns;

    // Matriz que guarda as peças do tabuleiro
    private Piece[][] pieces;
    
    // Construtor: cria o tabuleiro com a quantidade de linhas e colunas
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            // Garante que o tabuleiro tenha pelo menos 1 linha e 1 coluna
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns]; // Inicializa a matriz de peças
    }

    // Retorna o número de linhas
    public int getRows() {
        return rows;
    }

    // Retorna o número de colunas
    public int getColumns() {
        return columns;
    }
    
    // Retorna a peça em uma posição específica (linha, coluna)
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }
    
    // Retorna a peça em uma posição representada por um objeto Position
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    
    // Coloca uma peça em uma posição do tabuleiro
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position; // Atualiza a posição da peça
    }
    
    // Remove uma peça de uma posição do tabuleiro
    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null) {
            return null; // Não há peça para remover
        }
        Piece aux = piece(position);
        aux.position = null; // Remove a referência da peça à posição
        pieces[position.getRow()][position.getColumn()] = null; // Remove da matriz
        return aux; // Retorna a peça removida
    }
    
    // Verifica se uma posição (linha, coluna) existe dentro do tabuleiro
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    
    // Verifica se uma posição existe usando o objeto Position
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }
    
    // Verifica se há uma peça em determinada posição
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
s