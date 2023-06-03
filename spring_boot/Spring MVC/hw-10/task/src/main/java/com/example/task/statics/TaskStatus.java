package com.example.task.statics;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskStatus {
    TODO("TODO", "To Do"),
    IN_PROGRESS("IN_PROGRESS","In progress"),
    REVIEWING("REVIEWING","Reviewing"),
    COMPLETED("COMPLETED","Completed");

    public String code;
    public String name;
}
