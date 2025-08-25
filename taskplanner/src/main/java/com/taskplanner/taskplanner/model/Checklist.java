package com.taskplanner.taskplanner.model;

public class Checklist {
    private String text;
    private boolean checked;
    private long id;

    public Checklist(){}
    public Checklist(String text,boolean checked,long id){
        this.text=text;
        this.checked=checked;
        this.id=id;
    }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public boolean isStatus() { return checked; }
    public void setStatus(boolean checked) { this.checked = checked; }
}
