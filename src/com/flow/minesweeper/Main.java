package com.flow.minesweeper;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            MinerGUI minerGUI = new MinerGUI();
            minerGUI.setVisible(true);
        });

        Table t1 = new Table(7);
        System.out.println(t1);
    }
}
