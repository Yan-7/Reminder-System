package org.example;

import java.time.LocalDate;

public class Reminder {

    public Reminder(int id) {
        this.id = id;
    }

    public Reminder(int id, String message, LocalDate expiration, boolean important) {

        this.message = message;
        this.expiration = expiration;
        this.important = important;
    }

    public Reminder(String message) {
        this.message = message;
    }

    public Reminder(String message, LocalDate expiration, boolean important) {
        this.message = message;
        this.expiration = expiration;
        this.important = important;
    }

    public boolean isImportant() {
        return important;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    private int id;

    private String message;

    private LocalDate expiration;

    private boolean important;


    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", expiration=" + expiration +
                ", important=" + important +
                '}';
    }
}
