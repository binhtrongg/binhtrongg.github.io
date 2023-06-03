package com.example.task.schedule;
import com.example.task.entity.Task;
import com.example.task.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskOverdueMarker {

    TaskRepository taskRepository;

    @Scheduled(fixedRate = 180000)
    public void taskOverdueMarker() {
        List<Task> tasks = taskRepository.getTasks();
        if (!CollectionUtils.isEmpty(tasks)) {
            return;
        }

        val now = LocalDateTime.now();
        tasks.forEach(t -> t.setIsExpired(t.getEndTime().isBefore(now)));
    }

}
