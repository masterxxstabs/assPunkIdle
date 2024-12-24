package configs.commands;
import configs.Data;
import configs.Panels;

import javax.swing.*;
import java.util.Random;

public class findJob {
    public static String getRandomJob() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        int cumulativeProbability = 0;
        for (int i = 0; i < Data.jobs.length; i++) {
            cumulativeProbability += Data.probabilities[i];
            if (randomNumber < cumulativeProbability) {
                return Data.jobs[i];
            }
        }
        return "No job found";
    }

    public static int whenJobFound() {
        switch (Data.job) {
            case " Dishwasher" -> Data.wage = Data.dishWasher;
            case " Fast Food Worker" -> Data.wage = Data.fastFood;
            case " Warehouse Worker" -> Data.wage = Data.wareHouse;
            case " Cook" -> Data.wage = Data.cook;
            case " Mailman" -> Data.wage = Data.mailMan;
            default -> {
                Data.wage = 0;
                System.out.println("Invalid job.");
            }
        }
        return Data.wage;
    }
}
