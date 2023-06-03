package com.example.task.repository;

import com.example.task.entity.Task;
import com.example.task.statics.TaskStatus;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Repository
public class TaskRepository {

    static final List<Task> tasks = new ArrayList<>();
    static int autoId = 1;

    public List<Task> getTasks(){
        return tasks;}

    public void save(Task task){
        task.setId(autoId);
        autoId++;
        tasks.add(task);
    }

    public Task findByID(int id){
        return tasks.stream().filter(task -> task.getId()==id).findFirst().orElse(null);
    }

    public void update(Task task){
        tasks.forEach(t -> {
            if (t.getId() != task.getId()) {
                return;
            }
            t.setName(task.getName());
            t.setCreatTime(task.getCreatTime());
            t.setEndTime(task.getEndTime());
            t.setTaskStatus(task.getTaskStatus());
            t.setIsExpired(task.getIsExpired());
        });
    }

    public void delete(int id){
        tasks.removeIf(task -> task.getId()==id);
    }
}
