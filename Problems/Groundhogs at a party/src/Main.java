import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int cups = scanner.nextInt();
        boolean weekend = scanner.nextBoolean();

        if (weekend) {
            System.out.println(cups >= 15 && cups <= 25);
        } else {
            System.out.println(cups >= 10 && cups <= 20);
        }
    }
}