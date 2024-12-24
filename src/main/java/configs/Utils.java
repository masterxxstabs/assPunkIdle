package configs;

import java.awt.*;

public class Utils {
    public static void print(String message) {
        System.out.println(message);
    }

    //grid layout gbc
    public static GridBagConstraints createGridBagConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(2, 1, 2, 1);
        return gbc;
    }
}
