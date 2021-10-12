import java.util.Objects;

public class Game {
    private Board board;
    private Battleship battleship;
    private UserClient userClient;
    private boolean isOver;
    private int numGuesses;

    public static void main(String[] args) {
        int numRows = 5;
        int numCols = 5;
        int battleshipSize = 2;
        Game game = new Game();
        game.setupGame(numRows, numCols, battleshipSize);
        game.playGame();
    }

    private void setupGame(int numRows, int numCols, int battleshipSize) {
        board = new Board(numRows, numCols);
        battleship = new Battleship(battleshipSize);
        board.randomlyPlace(battleship);
    }

    private void playGame() {
        while (!isOver) {
            System.out.print(board);
            numGuesses++;
            CellReference cellReference = userClient.getCellReferenceFromUser();
            Cell cell = board.getCell(cellReference);
            cell.markAsGuessed();
            if (cell.hasBattleship()) {
                userClient.printHit();
            } else {
                userClient.printMissed();
            }
            boolean sunk = battleship.checkForSunk();
            if (sunk) {
                userClient.printSunk(numGuesses);
                isOver = true;
            }
        }
    }
}