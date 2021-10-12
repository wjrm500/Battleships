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

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("The Board:\n  ");
        // Print alphabetic column names
        for (int i = 97; i < 97 + numCols; i++) {
            char c = (char) i;
            str.append(String.format(" %c ", c));
        }
        str.append('\n');
        // Print rest of board
        for (int i = 0; i < numRows; i++) {
            str.append(String.format("%d ", i + 1));
            for (int j = 0; j < numCols; j++) {
                Cell cell = cells[i][j];
                char c;
                if (cell.isGuessed()) {
                    c = cell.hasBattleship() ? 'H' : 'M';
                } else {
                    c = '*';
                }
                str.append(String.format(" %c ", c));
            }
            str.append('\n');
        }
        str.append('\n');
        return str.toString();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public Cell getCell(int row, int column) {
        return cells[row][column];
    }

    public Cell getCell(CellReference cellReference) {
        if (cellReference.row > numRows - 1 || cellReference.column > numCols - 1) {
            UserClient.printInvalid();
            return null;
        }
        return cells[cellReference.row][cellReference.column];
    }
}