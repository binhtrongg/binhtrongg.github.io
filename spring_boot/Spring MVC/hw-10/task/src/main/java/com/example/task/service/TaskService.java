package com.example.task.service;
import com.example.task.entity.Task;
import com.example.task.model.request.TaskRequest;
import com.example.task.model.response.StatusReponse;
import com.example.task.model.response.TaskDetailResponse;
import com.example.task.model.response.TaskReponse;
import com.example.task.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.example.task.statics.TaskStatus;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    TaskRepository taskRepository;
    ObjectMapper objectMapper;

    public List<TaskReponse> getTasks() {
        List<Task> tasks = taskRepository.getTasks();
        List<TaskDetailResponse> tempData = tasks.stream().map(t -> objectMapper.convertValue(t, TaskDetailResponse.class)).collect(Collectors.toList());
        List<TaskStatus> taskStatuses = Arrays.asList(TaskStatus.values());
        return taskStatuses.stream().map(status -> {
            List<TaskDetailResponse> taskDetailResponses = tempData.stream().filter(t -> t.getTaskStatus().equals(status)).collect(Collectors.toList());
            return new TaskReponse(status, taskDetailResponses);
        }).collect(Collectors.toList());
    }

    public List<StatusReponse> getStatus() {
        return List.of(
                StatusReponse.builder().code(TaskStatus.TODO.getCode()).name(TaskStatus.TODO.getName()).build(),
                StatusReponse.builder().code(TaskStatus.IN_PROGRESS.getCode()).name(TaskStatus.IN_PROGRESS.getName()).build(),
                StatusReponse.builder().code(TaskStatus.COMPLETED.getCode()).name(TaskStatus.COMPLETED.getName()).build(),
                StatusReponse.builder().code(TaskStatus.REVIEWING.getCode()).name(TaskStatus.REVIEWING.getName()).build()
        );
    }

    public void saveTask(TaskRequest createRequest) {
        Task task = objectMapper.convertValue(createRequest, Task.class);
        LocalDateTime now = LocalDateTime.now();
        task.setCreatTime(now);
        task.setIsExpired(task.getEndTime().isBefore(now));
        taskRepository.save(task);
        System.out.println("thêm mới thành công");
    }
    

    public Object getDetail(Integer id) {
        Task task = taskRepository.findByID(id);
        return objectMapper.convertValue(task, TaskDetailResponse.class);
    }

    public void delete(Integer id) {
        taskRepository.delete(id);
    }

    public void updatetask(TaskRequest updateRequest) {
        Task task=objectMapper.convertValue(updateRequest,Task.class);
        taskRepository.update(task);
    }
}
