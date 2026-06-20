package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch(); // cria uma nova partida
        List<ChessPiece> captured = new ArrayList<>(); // lista de peças capturadas
        
        // Loop principal: continua até ocorrer o checkmate
        while (!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen(); // limpa a tela
                UI.printMatch(chessMatch, captured); // imprime o estado atual da partida
                System.out.println();
                
                // Lê a posição de origem da peça
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                
                // Mostra os movimentos possíveis da peça escolhida
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                
                // Lê a posição de destino
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                
                // Executa o movimento e captura a peça, se houver
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
                
                // Caso haja promoção de peão
                if (chessMatch.getPromoted() != null) {
                    System.out.print("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    
                    // Valida entrada até ser uma opção correta
                    while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
                        System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            }
            // Tratamento de exceções específicas do jogo
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            // Tratamento de entradas inválidas do usuário
            catch (InputMismatchException e) {
                System.out.println("Invalid input! Please use the correct format.");
                sc.nextLine();
            }
        }
        
        // Final da partida: imprime resultado
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}