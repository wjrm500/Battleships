package com.wjrm500.battleships;

import com.beust.jcommander.Parameter;

public class GameArgs {
    @Parameter(names = {"--rows", "-r"})
    public int numRows = 5;

    @Parameter(names = {"--columns", "-c"})
    public int numCols = 5;

    @Parameter(names = {"--shipsize", "-s"})
    public int shipSize = 2;
}
