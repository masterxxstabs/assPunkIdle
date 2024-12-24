package configs.commands;

import configs.Data;

public class Work {
    static public void workDay() {
        int workhours = 8;
        boolean workCompleted = false;

        if (workCompleted) {
            workCompleted = false;
            return;
        } try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Nope");
        }

        for (int hour = 1; hour <= workhours; hour++) {
            Data.money += Data.wage;
            Data.energy -= 0.1;

            System.out.println("You worked " + hour + " hours." + "\nAnd earned: $" + Data.wage + "\nAnd lost " + 0.1 + " energy.");
            System.out.println("Total Cash: $" + Data.money);

            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println("Workday Interrupted");
                break;
            }
        }
        workCompleted = true;
        System.out.println("Workday completed! Total earnings: $" + (Data.wage * workhours) + "\nRemaining energy: " + Data.energy);
    }
}