package com.wjrm500.battleships;

import java.util.ArrayList;

public class Battleship {
    private int size;
    private ArrayList<Cell> cellsOccupied = new ArrayList();
    private static final String VERTICAL = "vertical";
    private static final String HORIZONTAL = "horizontal";

    public Battleship(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 1) {
            System.out.println("com.wjrm500.battleships.Battleship must have a size of at least one unit");
            System.exit(1);
        }
        this.size = size;
    }

    public ArrayList<Cell> getCellsOccupied() {
        return cellsOccupied;
    }

    public void setCellsOccupied(ArrayList<Cell> cellsOccupied) {
        this.cellsOccupied = cellsOccupied;
        for (Cell cellOccupied : cellsOccupied) {
            cellOccupied.setBattleship(this);
        }
    }

    public boolean checkForSunk() {
        int guessedCells = 0;
        for (Cell cell : cellsOccupied) {
            if (cell.isGuessed()) {
                guessedCells++;
            }
        }
        return size == guessedCells;
    }

    public void randomlyPlace(Board board) {
        int numRows = board.getNumRows();
        int numCols = board.getNumCols();
        if (size > Math.min(numRows, numCols)) {
            System.out.println("com.wjrm500.battleships.Battleship too large to be placed");
            System.exit(1);
        }
        String dir = Math.random() >= 0.5 ? VERTICAL : HORIZONTAL;
        int startPointRowNum = -1, startPointColNum = -1;
        switch (dir) {
            case VERTICAL:
                startPointRowNum = (int) (Math.random() * (numRows - (size - 1)));
                startPointColNum = (int) (Math.random() * (numCols - 1));
                break;
            case HORIZONTAL:
                startPointRowNum = (int) (Math.random() * (numRows - 1));
                startPointColNum = (int) (Math.random() * (numCols - (size - 1)));
                break;
        }
        ArrayList<Cell> cellsOccupied = new ArrayList();
        int v = 0, h = 0;
        for (int i = 0; i < size; i++) {
            Cell cell = board.getCell(startPointRowNum + v, startPointColNum + h);
            cellsOccupied.add(cell);
            if (dir == VERTICAL) {
                v++;
            } else if (dir == HORIZONTAL) {
                h++;
            }
        }
        setCellsOccupied(cellsOccupied);
    }
}