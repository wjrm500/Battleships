import java.util.ArrayList;

public class Battleship {
    private int size;
    private ArrayList<Cell> cellsOccupied = new ArrayList();

    public Battleship(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 1) {
            System.out.println("Battleship must have a size of at least one unit");
            System.exit(1);
        }
        this.size = size;
    }

    public ArrayList<Cell> getCellsOccupied() {
        return cellsOccupied;
    }

    public void setCellsOccupied(ArrayList<Cell> cellsOccupied) {
        this.cellsOccupied = cellsOccupied;
    }

    public Cell checkForHit(CellReference cellReference) {
        for (Cell cell : cellsOccupied) {
            boolean hit = cell.checkForHit(cellReference);
            if (hit) {
                return cell;
            }
        }
        return null;
    }

    public boolean checkForSunk() {
        int hitCells = 0;
        for (Cell cell : cellsOccupied) {
            if (cell.getHit()) {
                hitCells++;
            }
        }
        return size == hitCells;
    }
}