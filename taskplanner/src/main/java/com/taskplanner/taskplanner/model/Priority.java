package com.taskplanner.taskplanner.model;

public enum Priority {
    LOW   (1, "Low"),
    MEDIUM(2, "Medium"),
    HIGH  (3, "High");

    private final int code;
    private final String label;

    Priority(int code, String label) {
        this.code  = code;
        this.label = label;
    }

    public int getCode()   { return code; }
    public String getLabel() { return label; }

    public static Priority fromCode(int code) {
        for (Priority p : values()) {
            if (p.code == code) return p;
        }
        throw new IllegalArgumentException("Unknown Priority code: " + code);
    }
}
