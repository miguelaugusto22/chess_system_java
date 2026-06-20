package chess;

/**
 * Representa as cores possíveis das peças de xadrez.
 */
public enum Color {
    BLACK,
    WHITE;

    /** Retorna a cor oposta. */
    public Color opposite() {
        return this == WHITE ? BLACK : WHITE;
    }

    @Override
    public String toString() {
        return this == WHITE ? "White" : "Black";
    }
}
