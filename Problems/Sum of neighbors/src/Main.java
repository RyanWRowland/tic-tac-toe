import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            inputs.add(input);
        }
        int rows = inputs.size();
        int cols = inputs.get(0).split(" ").length;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] rowOfInputs = inputs.get(i).split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(rowOfInputs[j]);
            }
        }


        printMatrix(sumNeighbors(matrix));
    }

    public static int[][] sumNeighbors (int[][] matrix) {
        int[][] summedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int sum = 0;
                sum += matrix[i - 1 < 0 ? matrix.length - 1 : i - 1][j];
                sum += matrix[(i + 1) % matrix.length][j];
                sum += matrix[i][j - 1 < 0 ? matrix.length - 1 : j - 1];
                sum += matrix[i][(j + 1) % matrix.length];
                summedMatrix[i][j] = sum;
            }
        }

        return summedMatrix;
    }

    public static void printMatrix (int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}