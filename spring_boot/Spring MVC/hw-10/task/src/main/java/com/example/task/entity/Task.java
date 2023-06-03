package com.example.task.entity;

import com.example.task.statics.TaskStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    int id;
    String name;
    LocalDateTime endTime;
    LocalDateTime creatTime;
    TaskStatus taskStatus;
    Boolean isExpired;
}
