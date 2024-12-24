package configs.commands;

import configs.Data;

public class sleep {
    static public void sleepCycle() {
        int sleepHours = 8;
        boolean sleepCompleted = false;

        if (sleepCompleted) {
            sleepCompleted = false;
            return;
        }

        for (int hour = 1; hour <= sleepHours; hour++) {
            Data.energy += 0.1;

            System.out.println("You slept and regained " + 0.1 + " energy");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Sleep Interrupted");
                break;
            }
        }
        sleepCompleted = true;
    }
}
