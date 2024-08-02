package org.Sem5HM.Task2;


import java.util.Scanner;

// пришлось попросить нейронку помочь
public class TicTacToe {
    private int[] board;
    private int currentPlayer;

    public TicTacToe() {
        board = new int[9];
        currentPlayer = 1;
    }

    public boolean setMove(int position) {
        if (position < 0 || position > 9) {
            System.err.println("Invalid position");
            return false;
        }
        if (board[position] != 0) {
            System.out.println("This position is already taken.");
            return false;
        }

        board[position] = currentPlayer;
        return true;
    }

    public int getMove(int position) {
        if (position < 0 || position >= 9) {
            System.err.println("Invalid position");
        }
        return board[position];
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    public boolean checkWinner() {
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == currentPlayer && board[i + 1] == currentPlayer && board[i + 2] == currentPlayer) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i] == currentPlayer && board[i + 3] == currentPlayer && board[i + 6] == currentPlayer) {
                return true;
            }
        }
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }
        return board[2] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer;
    }


    public void displayBoard() {
        for (int i = 0; i < 9; i++) {
            char symbol = (board[i] == 0) ? '-' : (board[i] == 1) ? 'X' : 'O';
            System.out.print(symbol);
            if (i % 3 != 2) {
                System.out.print(" | ");
            }
            if (i % 3 == 2 && i < 8) {
                System.out.println("\n---------");
            }
        }
        System.out.println();
    }

    public static void startGame() {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            game.displayBoard();
            System.out.print("Player " + game.currentPlayer + "'s turn. Enter position (0-8): ");
            int position = scanner.nextInt();

            if (game.setMove(position)) {
                if (game.checkWinner()) {
                    game.displayBoard();
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    break;
                }
                game.switchPlayer();
            }
        }
        scanner.close();

    }

}
