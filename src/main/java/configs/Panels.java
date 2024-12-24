package configs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import static configs.commands.Work.workDay;
import static configs.commands.findJob.getRandomJob;
import static configs.commands.findJob.whenJobFound;
import static configs.commands.ShoppingScript.shop;
import static configs.commands.sleep.sleepCycle;

public class Panels extends configs.Data {
    public static void lifePanel() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Life Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 600);

            JTabbedPane tabbedPane = new JTabbedPane();

            //work tab
            JPanel workPanel = new JPanel();
            workPanel.setLayout(new BoxLayout(workPanel, BoxLayout.Y_AXIS));
            workPanel.add(Box.createVerticalStrut(20));

            JLabel jobLabel = new JLabel("Current Job: " + Data.job);
            jobLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            workPanel.add(jobLabel);

            JButton findJob = new JButton("Find Job");
            findJob.setAlignmentX(Component.CENTER_ALIGNMENT);
            workPanel.add(findJob);
            findJob.setVisible(findWorkUpdate);

            JButton work =  new JButton("Work");
            work.setAlignmentX(Component.CENTER_ALIGNMENT);
            workPanel.add(work);
            work.setVisible(workUpdate);

            JButton quitJob = new JButton("Quit Job");
            quitJob.setAlignmentX(Component.CENTER_ALIGNMENT);
            workPanel.add(quitJob);
            quitJob.setVisible(quitJobUpdate);

            workPanel.add(Box.createVerticalStrut(20));

            findJob.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(
                                                frame,
                            JOptionPane.QUESTION_MESSAGE,
                            "Do you want this job?" + Data.foundJob,
                            JOptionPane.YES_NO_OPTION
                                        );

                    if (result == JOptionPane.YES_OPTION) {
                        getRandomJob();
                        whenJobFound();

                        Data.foundJob = getRandomJob();
                        Data.job = Data.foundJob;
                        Data.wage = whenJobFound();
                        Data.findWorkUpdate = false;
                        Data.workUpdate = true;
                        Data.quitJobUpdate = true;

                        workPanel.revalidate();
                        workPanel.repaint();
                        workPanel.updateUI();
                        jobLabel.setText("Current Job: " + Data.job);

                        JOptionPane.showMessageDialog(frame, "You have taken the job of" + Data.job + " Your daily wages are " + Data.wage);

                        frame.dispose();
                        lifePanel();
                    } else if (result == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(frame, "Job Search Cancelled.");
                    }
                }
            });

            work.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Data.energy <= 0.80) {
                        System.out.println("Not enough energy to work!");
                    } else if (Data.energy >= 0.80) {
                        workDay();
                    }
                }
            });

            quitJob.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(
                      frame,
                      JOptionPane.QUESTION_MESSAGE,
                      "Do you want to quit the job?" + Data.job,
                       JOptionPane.YES_NO_OPTION
                    );

                    if (result == JOptionPane.YES_OPTION) {
                        Data.job = "";
                        Data.wage = 0;
                        Data.findWorkUpdate = true;
                        Data.workUpdate = false;
                        Data.quitJobUpdate = false;

                        JOptionPane.showMessageDialog(frame, "You have quit your job.");

                        frame.dispose();
                        lifePanel();
                    } else if (result == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(frame, "You have decided to now quit your job.");
                    }
                }
            });

            //life tab
            JPanel lifePanel = new JPanel();
            lifePanel.setLayout(new BoxLayout(lifePanel, BoxLayout.Y_AXIS));
            lifePanel.add(Box.createVerticalStrut(20));

            JButton sleep = new JButton("Sleep");
            sleep.setAlignmentX(Component.CENTER_ALIGNMENT);
            lifePanel.add(sleep);

            sleep.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sleepCycle();
                }
            });

            //schooling tab
            JPanel schoolPanel = new JPanel();
            schoolPanel.add(new JLabel("Schooling"));

            //map tab
            JPanel mapPanel = new JPanel();

            JLabel mapTitle = new JLabel("Map");

            JButton store = new JButton("Store");
            JButton dealer = new JButton("Dealer");
            JButton Apartments = new JButton("Apartments");
            JButton Schools = new JButton("Schools");

            store.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(
                            frame,
                            "Go to to the store?",
                            "Open shopping window?",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (result == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(frame, "You are now opening a shopping window.");
                        shop();
                    } else if (result == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(frame, "You are not opening a shopping window.");
                    }
                }
            });

            mapPanel.add(mapTitle);
            mapPanel.add(store);
            mapPanel.add(dealer);
            mapPanel.add(Apartments);
            mapPanel.add(Schools);
            mapPanel.add(mapTitle);

            //banking tab
            JPanel bankingPanel = new JPanel();

            JLabel Usd = new JLabel("USD: " + "$ " +  Data.money);
            JLabel creditScore = new JLabel("Credit Score: " + Data.creditScore);

            bankingPanel.add(Usd, Utils.createGridBagConstraints());
            bankingPanel.add(creditScore, Utils.createGridBagConstraints());

            tabbedPane.addTab("Work", workPanel);
            tabbedPane.addTab("Life", lifePanel);
            tabbedPane.addTab("Banking", bankingPanel);
            tabbedPane.addTab("Map", mapPanel);
            tabbedPane.addTab("Schooling", schoolPanel);

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }

    public static void statsPanel() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Stats Panel");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(100, 400);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            //Label Arrays
            String[] statNames = {"Money", "Strength", "Charisma", "Endurance", "Crafting", "Metal Working", "Merchantile"};
            int[] statValues = { (int) money, Strength, Charisma, Endurance, Crafting, Metal_Working, Merchantile };

            //Loop frame
            for (int i = 0; i < statNames.length; i++) {
                JLabel label = new JLabel(statNames[i] + ": " + statValues[i]);
                frame.add(label);
            }

            frame.setVisible(true);
        });
    }

    public static void saveSystem() {
        String name = Data.name;
        String DOB = Data.DOB;
        int age = Data.age;

        String dataToWrite = "Name: " + name + "\nAge: " + age + "\nDOB: " + DOB;

        try (FileWriter writer = new FileWriter("save_data.txt")) {
            writer.write(dataToWrite);
            System.out.println("Data Saved to save_Data.txt successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void loadSaveSystem() {
        String filePath = "save_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key) {
                        case "name":
                            Data.name = value;
                            break;
                        case "DOB":
                            Data.DOB = value;
                            break;
                        case "age":
                            Data.age = Integer.parseInt(value);
                    }
                }
            }
            displayData();
        } catch (IOException e) {
             System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void displayData() {
        System.out.println("Name: " + Data.name);
        System.out.println("DOB: " + Data.DOB);
        System.out.println("Age: " + Data.age);
    }
}