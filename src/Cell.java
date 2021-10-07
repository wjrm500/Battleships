public class Cell {
    private int row;
    private int column;
    private boolean hit; // Defaults to false
    private Battleship battleship;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean getHit() {
        return hit;
    }

    public boolean checkForHit(CellReference cellReference) {
        return cellReference.row == this.row && cellReference.column == this.column && !hit;
    }

    public void markAsHit() {
        this.hit = true;
    }
}