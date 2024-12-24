import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import configs.Panels;
import javax.swing.*;

public class Main extends Panels {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(800, 600);
        frame.add(Box.createVerticalStrut(20));

        //title
        JLabel title = new JLabel("assPunk");
        frame.add(title);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(Component.CENTER_ALIGNMENT);

        //begin button
        JButton startGame = new JButton("Begin");
        frame.add(startGame);
        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGame.setAlignmentY(Component.CENTER_ALIGNMENT);

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
                    frame.dispose();
                    lifePanel();
                } else if (result == JOptionPane.NO_OPTION) {

                }
            }
        });

        // quit button
        JButton quitGame = new JButton("Quit");
        frame.add(quitGame);
        quitGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitGame.setAlignmentY(Component.CENTER_ALIGNMENT);

        frame.add(Box.createVerticalStrut(20));

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
                }
                if (result == JOptionPane.NO_OPTION) {

                }
            }
        });
        //background

        frame.setVisible(true);
    }
}