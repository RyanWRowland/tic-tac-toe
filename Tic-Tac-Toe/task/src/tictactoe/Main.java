package tictactoe;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] field = createField();

        boolean isXTurn = true;
        boolean isGameOver = false;
        while (!isGameOver) {
            printField(field);
            String fieldState = getFieldState(field);

            switch (fieldState) {
                case "Impossible":
                case "X wins":
                case "O wins":
                case "Draw":
                    System.out.println(fieldState);
                    isGameOver = true;
                    break;
                default:
                    move(field, isXTurn ? 'X' : 'O');
                    isXTurn = !isXTurn;
            }
        }

        scanner.close();
    }

    // get field state from user input
    public static char[][] getField() {
        System.out.print("Enter cells: ");
        String input = scanner.nextLine().trim();
        char[][] field = new char[3][3];

        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = input.charAt(counter);
                counter++;
            }
        }

        return field;
    }

    // create empty field, '_' fills empty cells
    public static char[][] createField() {
        char[][] field = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = '_';
            }
        }

        return field;
    }


    // get and place move on field
    public static void move(char[][] field, char player) {
        if (player != 'X' && player != 'O') {
            System.out.println("Invalid player token passed: must be X or O");
            return;
        }

        int[] coordinates;
        // get coordinates from player, if cell is occupied get another set of coordinates
        while (true) {
            coordinates = convertCoordinates(getCoordinates());
            if (field[coordinates[0]][coordinates[1]] == '_') {
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }

        field[coordinates[0]][coordinates[1]] = player;
    }

    // converts user input coordinates into array coordinates
    public static int[] convertCoordinates(int[] coordinates) {
        int[] convertCoordinates = new int[2];
        convertCoordinates[0] = Math.abs(coordinates[1] - 3);
        convertCoordinates[1] = coordinates[0] - 1;

        return convertCoordinates;
    }

    // gets user coordinates, prompts until valid input
    public static int[] getCoordinates() {
        int[] coordinates = new int[2];
        String[] inputs;
        while (true) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine().trim();

            if (!input.matches("\\d \\d")){
                System.out.println("You should enter numbers!");
                continue;
            }

            inputs = input.split(" ");
            coordinates[0] = Integer.parseInt(inputs[0]);
            coordinates[1] = Integer.parseInt(inputs[1]);

            if (coordinates[0] < 1 || coordinates[0] > 3 ||
                    coordinates[1] < 1 || coordinates[1] > 3) {
                System.out.println("Coordinates should be from 1 to 3");
            } else {
                break;
            }
        }

        return coordinates;
    }


    public static String getFieldState(char[][] field) {
        if (isImpossible(field)) {
            return "Impossible";
        } else if (xWin(field)) {
            return "X wins";
        } else if (oWin(field)) {
            return "O wins";
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j] == '_') {
                        return "Game not finished";
                    }
                }
            }

            return "Draw";
        }
    }

    public static boolean xWin(char[][] field) {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == 'X' && field[i][1] == 'X' && field[i][2] == 'X') {
                return true;
            }
            if (field[0][i] == 'X' && field[1][i] == 'X' && field[2][i] == 'X') {
                return true;
            }
        }

        return (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X' ||
                field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] == 'X');
    }

    public static boolean oWin(char[][] field) {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == 'O' && field[i][1] == 'O' && field[i][2] == 'O') {
                return true;
            }
            if (field[0][i] == 'O' && field[1][i] == 'O' && field[2][i] == 'O') {
                return true;
            }
        }

        return (field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O' ||
                field[0][2] == 'O' && field[1][1] == 'O' && field[2][0] == 'O');

    }

    public static boolean isImpossible(char[][] field) {
        if (xWin(field) && oWin(field)) {
            return true;
        }

        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'X') {
                    xCount++;
                }
                if (field[i][j] == 'O') {
                    oCount++;
                }
            }
        }

        return Math.abs(xCount - oCount) >= 2;
    }

    public static void printField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }
}
