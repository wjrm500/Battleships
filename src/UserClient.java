import java.util.Scanner;

public class UserClient {
    public static CellReference getCellReferenceFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a cell reference (format: \"ROW,COL\" e.g. \"1,a\"): ");
        String input = scanner.nextLine();
        // Validate general format
        if (!input.matches("[1-9],[a-z]")) {
            printInvalid();
            return null;
        }
        String[] splitArr = input.split(",", 2);
        String rowStr = splitArr[0];
        String colStr = splitArr[1];
        int rowNum = Integer.parseInt(rowStr);
        rowNum -= 1; // To account for zero-indexing
        char col = colStr.charAt(0);
        int colNum = (int) col - 97;
        CellReference cellReference = new CellReference(rowNum, colNum);
        return cellReference;
    }

    public static void printHit() {
        System.out.println("You hit!\n");
    }

    public static void printMissed() {
        System.out.println("You missed!\n");
    }

    public static void printSunk(int numGuesses) {
        String str = String.format("You sunk the battleship in %d guesses!\n", numGuesses);
        System.out.println(str);
    }

    public static void printInvalid() {
        System.out.println("Invalid cell reference\n");
    }

    public static void printAlreadyGuessed() {
        System.out.println("You've already guessed this cell!\n");
    }
}