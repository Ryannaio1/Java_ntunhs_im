package terst1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class hw6 {
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;
    private Scanner scanner;
    private boolean playWithComputer;

    public hw6(boolean playWithComputer) {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        currentPlayer = 'X';
        gameEnded = false;
        scanner = new Scanner(System.in);
        this.playWithComputer = playWithComputer;
    }

    public void playGame() {
        while (!gameEnded) {
            drawBoard();
            if (playWithComputer && currentPlayer == 'O') {
                computerMove();
            } else {
                playerMove();
            }
            gameEnded = checkWinner();
            if (!gameEnded) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        drawBoard();
        if (checkWinner()) {
            System.out.println("Player " + currentPlayer + " wins!");
        }
    }

    private void playerMove() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                scanner.nextLine();
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    validInput = true;
                } else {
                    System.out.println("This move at (" + row + "," + col + ") is not valid. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only. Try again.");
                scanner.nextLine();
            }
        }
    }

    private void computerMove() {
        Random rand = new Random();
        boolean validMove = false;
        while (!validMove) {
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            if (board[row][col] == ' ') {
                board[row][col] = 'O';
                System.out.println("Computer placed 'O' at (" + row + "," + col + ")");
                validMove = true;
            }
        }
    }

    private boolean checkWinner() {
    	if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
                return true;
            }
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                    return true;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }
            System.out.println("It's a tie!");
            gameEnded = true;
            return false;
    }

    private void drawBoard() {
    	 System.out.println("Board:");
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 System.out.print(board[i][j]);
                 if (j < 2) System.out.print("|");
             }
             System.out.println();
             if (i < 2) System.out.println("-+-+-");
         }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play against the computer? (yes/no)");
        String response = scanner.nextLine();
        boolean playWithComputer = response.equalsIgnoreCase("yes");
        
        hw6 game = new hw6(playWithComputer);
        game.playGame();
    }
}

