import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        int counter = 1;
        int row = 0;
        int col = 0;
        int pad = 0;
        boolean vertical = false;
        boolean reverse = false;
        while (counter <= n * n) {
            matrix[row][col] = counter;

            if (!vertical && !reverse) {
                if (col == n - 1 - pad) {
                    vertical = true;
                } else {
                    col++;
                }
            }

            if (vertical && !reverse) {

                if (row == n - 1 - pad) {
                    reverse = true;
                    vertical = false;
                } else {
                    row++;
                }
            }

            if (!vertical && reverse) {

                if (col == 0 + pad) {
                    vertical = true;
                    pad++;
                } else {
                    col--;
                }
            }

            if (vertical && reverse) {

                if (row == 0 + pad) {
                    vertical = false;
                    reverse = false;
                    col++;
                } else {
                    row--;
                }
            }

            counter++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}