import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] largest = {Integer.MIN_VALUE, 0, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int element = scanner.nextInt();
                if (element > largest[0]) {
                    largest[0] = element;
                    largest[1] = i;
                    largest[2] = j;
                } else if (element == largest[0]) {
                    if (i < largest[1]) {
                        largest[1] = i;
                        largest[2] = j;
                    } else if (i == largest[1]) {
                        if (j < largest[2]) {
                            largest[2] = j;
                        }
                    }
                }
            }
        }

        System.out.println(largest[1] + " " + largest[2]);
    }
}