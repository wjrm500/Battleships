package com.wjrm500.battleships;

public class Cell {
    private int row;
    private int column;
    private boolean guessed; // Defaults to false
    private Battleship battleship = null;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void markAsGuessed() {
        guessed = true;
    }

    public boolean hasBattleship() {
        return battleship != null;
    }

    public void setBattleship(Battleship battleship) {
        this.battleship = battleship;
    }
}