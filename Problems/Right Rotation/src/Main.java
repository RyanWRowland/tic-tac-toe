import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // get input string and parse into int array
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        // get # of rotations
        int rotations = scanner.nextInt();

        for (int i = 0; i < rotations % array.length; i++) {
            array = rotate(array);
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static int[] rotate(int[] array) {
        int[] rotated = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            rotated[i] = array[(array.length - 1 + i) % array.length];
        }

        return rotated;
    }
}