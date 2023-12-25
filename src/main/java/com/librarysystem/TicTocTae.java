package com.librarysystem;

import java.util.Random;
import java.util.Scanner;

public class TicTocTae {

    private static char[][] gameBoard = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer = 'X';
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    public static void main(String[] args) {
        System.out.println("Please choose your opponent Friend(true) or Computer(false): ");
        playWith(scanner.nextBoolean());
    }
    private static void playWith(boolean choose){
        printGameBoard();
        while (true) {
            if (!choose){
                if (currentPlayer == 'X') {
                    play(scanner);
                } else {
                    playComputer(random);
                }
            }else {
                play(scanner);
            }
            printGameBoard();

            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isGameBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
        scanner.close();
    }

    private static void printGameBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    private static void playComputer(Random random) {
        int row, column;

        System.out.println("Computer's turn : ");
        do {
            row = random.nextInt(3);
            column = random.nextInt(3);
        } while (!isValidMove(row, column));

        System.out.println("Computer chose: " + (row + 1) + ", " + (column + 1));
        gameBoard[row][column] = currentPlayer;
    }

    private static void play(Scanner scanner) {
        int row, col;

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (first -> row and second -> column): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                gameBoard[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[0][i] == currentPlayer && gameBoard[1][i] == currentPlayer && gameBoard[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (gameBoard[0][0] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][2] == currentPlayer) ||
                (gameBoard[0][2] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][0] == currentPlayer);
    }

    private static boolean isGameBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && gameBoard[row][col] == ' ';
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == currentPlayer && gameBoard[i][1] == currentPlayer && gameBoard[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }


}
