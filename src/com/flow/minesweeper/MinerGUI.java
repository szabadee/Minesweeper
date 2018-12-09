package com.flow.minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinerGUI extends JFrame {
    private Table table;
    private JButton[][] btns;

    public MinerGUI() {
        setTitle("Miner");
        setSize(500, 520);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setLayout(null);
        add(root);

        final int size = 10;
        table = new Table(size);

        btns = new JButton[size][size];

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                JButton btn = new JButton();

                btn.setBounds(
                        25 + j * 45,
                        25 + i * 45,
                        40,
                        40);

                root.add(btn);

                btn.setFont(new Font("Arial", Font.PLAIN, 10));
                btn.getInsets(new Insets(0, 0, 0, 0));

                btns[i][j] = btn;

                btn.setActionCommand(i + " " + j);

                btn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String event = e.getActionCommand();
                        String[] array = event.split(" ");
                        int a = Integer.parseInt(array[0]);
                        int b = Integer.parseInt(array[1]);
                        table.opener(a, b);
                        drawTable();
                    }
                });
            }
        }

        drawTable();
    }

    public void drawTable() {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns.length; j++) {
                btns[i][j].setText(table.getCell(i, j).toString());
            }
        }
    }
}
