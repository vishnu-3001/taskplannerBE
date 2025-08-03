package com.taskplanner.taskplanner.model;

public enum Status {
    TODO       (0, "To-do"),
    IN_PROGRESS(1, "In Progress"),
    DONE       (2, "Done");

    private final int code;
    private final String label;

    Status(int code, String label) {
        this.code  = code;
        this.label = label;
    }

    public int getCode()     { return code; }
    public String getLabel() { return label; }

    public static Status fromCode(int code) {
        for (Status s : values()) {
            if (s.code == code) return s;
        }
        throw new IllegalArgumentException("Unknown Status code: " + code);
    }
}
