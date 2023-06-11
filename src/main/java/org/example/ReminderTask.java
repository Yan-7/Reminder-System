package org.example;

import java.time.LocalDate;
import java.util.Set;

public class ReminderTask implements Runnable {

    private Set<Reminder> reminders;

    public ReminderTask(Set<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public void run() {
        System.out.println("reminder task running");
        if (reminders != null && !reminders.isEmpty()) {
            for (Reminder r : reminders) {
                if (r.getExpiration().isBefore(LocalDate.now())) {
                    System.out.println(r);
                }
            }
        } else {
            System.out.println("empty list");
        }
    }
}
