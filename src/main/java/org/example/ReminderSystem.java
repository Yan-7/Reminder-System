package org.example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReminderSystem {

    private Set<Reminder> reminders = new HashSet<>();
    private ScheduledExecutorService executorService;
    private ReminderTask reminderTask;

    public ReminderSystem() {
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        ReminderTask reminderTask = new ReminderTask(reminders);
        executorService.scheduleAtFixedRate(reminderTask, 0, 11, TimeUnit.MINUTES);
    }

    public boolean addReminder(String message, LocalDate expiration, boolean important) {
        Reminder reminder = new Reminder(message, expiration, important);
        reminders.add(reminder);
        return true;
    }

    public Set<Reminder> getReminders() {
        for (Reminder r : reminders) {
            System.out.println(r);
        }
        return new HashSet<>(reminders);
    }

    public Set<Reminder> getImportantReminders() {
        Set<Reminder> importantReminders = new HashSet<>();
        for (Reminder r: reminders) {
            if (r.isImportant()) {
                System.out.println(r);
                importantReminders.add(r);
            }
        }
        return importantReminders;
    }

    public void reminderMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = 1;
            while (x != 0) {
                System.out.println("0 - exit");
                System.out.println("1 - add reminder");
                System.out.println("2 - get reminders");
                System.out.println("3 - get important reminders");

                int answer = scanner.nextInt();
                scanner.nextLine(); // consume newline left-over

                switch (answer) {
                    case 0:
                        System.out.println("goodbye");
                        x = 0;
                        break;
                    case 1:
                        System.out.println("Enter reminder message:");
                        String reminderMessage = scanner.nextLine();

                        System.out.println("Enter date (yyyy-mm-dd):");
                        LocalDate expiration = LocalDate.parse(scanner.nextLine());

                        System.out.println("Important? (true/false)");
                        boolean important = Boolean.parseBoolean(scanner.nextLine());

                        addReminder(reminderMessage, expiration, important);
                        break;
                    case 2:
                        getReminders();
                        break;
                    case 3:
                        getImportantReminders();
                        break;
                }
            }
        }
    }
}
