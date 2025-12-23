package chess.adaptator;

import chess.businessLayer.board.Board;
import chess.useCases.BotStrategy;
import chess.useCases.IBotStrategy;
import chess.useCases.RandomStrategy; // pour le mode aléatoire
import java.util.Scanner;

public class UCIEngine {

    // Change "RandomStrategy()" ou "BotStrategy()"
    private IBotStrategy bot = new RandomStrategy();

    private Board board;

    public static void main(String[] args) {
        new UCIEngine().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        board = new Board();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            handleCommand(input);
        }
    }

    private void handleCommand(String input) {
        String[] tokens = input.split(" ");
        String command = tokens[0];

        switch (command) {
            case "uci":
                System.out.println("id name MonSuperBot");
                System.out.println("id author LeGroupe");
                System.out.println("uciok");
                break;

            case "isready":
                System.out.println("readyok");
                break;

            case "position":
                if (input.contains("startpos")) {
                    board = new Board();
                } else if (input.contains("fen")) {
                    String fen = input.substring(input.indexOf("fen") + 4);
                    board.loadFen(fen);
                }
                break;

            case "go":
                String bestMove = bot.findBestMove(board);
                if (bestMove != null) {
                    System.out.println("bestmove " + bestMove);
                }
                break;

            case "quit":
                System.exit(0);
                break;

            default:
                break;
        }
    }
}