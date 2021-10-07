import java.util.Scanner;

public class UserClient {
    public static CellReference getCellReferenceFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a cell reference: ");
        String input = scanner.nextLine();
        String[] splitArr = input.split(",", 0);
        int splitArrLen = splitArr.length;
        if (splitArrLen != 2) {
            System.out.println("Invalid cell reference");
            System.exit(1);
        }
        int row = Integer.parseInt(splitArr[0]); // TODO: Implement checks to see if definitely int
        int column = Integer.parseInt(splitArr[1]);
        CellReference cellReference = new CellReference(row, column);
        return cellReference;
    }

    public static void printHit(Cell cell) {
        System.out.println("You hit!");
    }

    public static void printMissed() {
        System.out.println("You missed!");
    }

    public static void printSunk(int numGuesses) {
        String str = String.format("You sunk the battleship in %d guesses!", numGuesses);
        System.out.println(str);
    }
}