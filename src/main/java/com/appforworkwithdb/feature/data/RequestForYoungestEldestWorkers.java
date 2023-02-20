package com.appforworkwithdb.feature.data;

import java.time.LocalDate;

public class RequestForYoungestEldestWorkers {
    private String type;
    private String name;
    private LocalDate localDate;

    public RequestForYoungestEldestWorkers(String type, String name, LocalDate localDate) {
        this.type = type;
        this.name = name;
        this.localDate = localDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
