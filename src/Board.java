import java.util.ArrayList;

public class Board {
    private int numRows;
    private int numCols;
    private Cell[][] cells;

    public Board(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        cells = new Cell[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void randomlyPlace(Battleship battleship) {
        // TODO: Currently just placing Battleship on topmost row
        int battleshipSize = battleship.getSize();
        if (battleshipSize > numCols) {
            System.out.println("Battleship too large to be placed");
            System.exit(1);
        }
        ArrayList<Cell> cellsOccupied = new ArrayList();
        for (int i = 0; i < battleshipSize; i++) {
            cellsOccupied.add(cells[0][i]);
        }
        battleship.setCellsOccupied(cellsOccupied);
    }
}