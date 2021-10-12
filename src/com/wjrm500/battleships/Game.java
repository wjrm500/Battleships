package com.wjrm500.battleships;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Game {
    private Board board;
    private Battleship battleship;
    private UserClient userClient;
    private boolean isOver;
    private int numGuesses = 1;

    public static void main(String[] args) {
        GameArgs gameArgs = new GameArgs();
        JCommander jc = JCommander.newBuilder()
            .addObject(gameArgs)
            .build();
        jc.parse(args);
        Game game = new Game();
        game.setupGame(gameArgs.numRows, gameArgs.numCols, gameArgs.shipSize);
        game.playGame();
    }

    private void setupGame(int numRows, int numCols, int battleshipSize) {
        board = new Board(numRows, numCols);
        battleship = new Battleship(battleshipSize);
        battleship.randomlyPlace(board);
    }

    private void playGame() {
        while (!isOver) {
            System.out.print(board);
            CellReference cellReference = userClient.getCellReferenceFromUser();
            if (cellReference == null) {
                continue;
            }
            Cell cell = board.getCell(cellReference);
            if (cell == null) {
                continue;
            }
            if (cell.isGuessed()) {
                UserClient.printAlreadyGuessed();
                continue;
            }
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
            numGuesses++;
        }
    }
}