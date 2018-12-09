package com.flow.minesweeper;

public class Cell {
    public int value;
    private boolean opened;

    public void open() {
        opened = true;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isOpened() {
        return opened;
    }

    public boolean isBomb () {
        return false;
    }

    public int getValue () {
        return value;
    }

    @Override
    public String toString() {
        if (opened) {
            if (isBomb()) {
                return "B";
            } else {
                return String.valueOf(value);
            }
        } else {
            return " ";
        }
    }
}
