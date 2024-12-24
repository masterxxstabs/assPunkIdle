package configs.stages;

import configs.Panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static configs.Panels.lifePanel;

public class mainMenu {
    public static void mainMenu() {
        JFrame frame = new JFrame("Main Manu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //title
        JLabel title = new JLabel("assPunk");
        //begin button
        JButton startGame = new JButton("Begin");

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                  frame,
                  JOptionPane.QUESTION_MESSAGE,
                  "Begin the game?",
                  JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    lifePanel();
                } else if (result == JOptionPane.NO_OPTION) {

                }
            }
        });

        // quit button
        JButton quitGame = new JButton("Quit");

        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        frame,
                        JOptionPane.QUESTION_MESSAGE,
                        "Quit game?",
                        JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose();
                } if (result == JOptionPane.NO_OPTION) {

                }
            }
        });
        //background
    }
}
