package com.example.reyna.alzreminder;

/**
 * Created by reyna on 3/14/2018.
 */

public class DataListTask {
    public String title;
    public String description;
    public String clock;
    public String date;

    public DataListTask(String title, String description, String clock, String date) {
        this.title = title;
        this.description = description;
        this.clock = clock;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getClock() {
        return clock;
    }

    public String getDate() {
        return date;
    }
}
