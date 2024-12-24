package configs.commands;

import configs.Data;
import configs.JsonGet.Item;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.Map;

public class ShoppingScript {
    public static void shop() {
        JFrame frame = new JFrame("Shop");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Food tab
        List<Item> foodItems = loadItemsByCategory();

        JPanel foodPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("Food", null, foodPanel, "Buy food here");

        JLabel foodLabel = new JLabel("Buy Food Here");
        foodPanel.add(foodLabel, BorderLayout.NORTH);

        // Populate combo box with food items
        final JComboBox<Item> foodComboBox = new JComboBox<>(foodItems.toArray(new Item[0]));
        foodPanel.add(foodComboBox, BorderLayout.CENTER);

        JButton foodBuyButton = new JButton("Buy");
        foodPanel.add(foodBuyButton, BorderLayout.SOUTH);

        foodBuyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item selectedFood = (Item) foodComboBox.getSelectedItem();
                if (selectedFood != null) {
                    if (Data.money >= selectedFood.getPrice()) {
                        Data.money -= selectedFood.getPrice();
                        System.out.println("Bought: " + selectedFood.getName() + " for $" + selectedFood.getPrice());
                        System.out.println("Remaining Money: $" + Data.money);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Not enough money to buy " + selectedFood.getName());
                    }
                }
            }
        });

        // Add the tabbedPane to the frame
        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private static List<Item> loadItemsByCategory() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String category = null;
            return objectMapper.readValue(new File("D:/Games/assPunkIdle/src/main/java/items. json"), new TypeReference<Map<String, List<Item>>>() {}).getOrDefault(category, List.of());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
