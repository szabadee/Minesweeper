package com.flow.minesweeper;

public class Table {
    private Cell[][] matrix;
    private final int size;

    public Table (int size) {
        this.size = size;

        matrix = new Cell[size][size];
        generateBombs();
        fillMap();
    }

    private void fillMap () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = new Cell();
                    matrix[i][j].setValue(countBomb(i, j));
                }
            }
        }
    }

    public Cell getCell (int i, int j) {
        return matrix[i][j];
    }

    public void opener (int i, int j) {
        matrix[i][j].open();

        if (!matrix[i][j].isBomb() && matrix[i][j].getValue() == 0) {
            for (int k = i - 1; k <= i + 1; k++) {
                for (int l = j - 1; l <= j + 1; l++) {
                    if (k >= 0 && l >= 0 && k < matrix.length && l < matrix.length) {
                        if ((k != i || l != j) && (!matrix[k][l].isOpened())) {
                            opener(k, l);
                        }
                    }
                }
            }
        }
    }

    private void generateBombs () {
        int x;
        int y;

        for (int i = 0; i < size; ++i) {
            do {
                x = (int) (Math.random() * size);
                y = (int) (Math.random() * size);
            } while (matrix[x][y] != null);

            matrix[x][y] = new Bomb();
        }
    }


    public int countBomb (int i, int j) {
        int count = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && l >= 0 && k < matrix.length && l < matrix.length) {
                    if (matrix[k][l] != null && matrix[k][l].isBomb()) {
                        count++;
                    }
                }
            }

        }

        return count;
    }

    @Override
    public String toString() {
        String table = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                table += ' ' + matrix[i][j].toString();
            }

            table += '\n';
        }

        return table;
    }
}
