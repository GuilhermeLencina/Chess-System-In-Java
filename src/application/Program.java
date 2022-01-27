package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while(true) {
            try {
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces());
                    System.out.println();
                    System.out.println("Source: ");
                    ChessPosition source = UI.readChessPosition(scanner);

                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);
                    System.out.println();
                    System.out.println("Target: ");
                    ChessPosition target = UI.readChessPosition(scanner);

                    ChessPiece capturePiece = chessMatch.performChessMove(source, target);
            }catch(ChessException error) {
                System.out.println(error.getMessage());
                scanner.nextLine();
            }catch(InputMismatchException error) {
                System.out.println(error.getMessage());
                scanner.nextLine();
            }
        }
    }
}
