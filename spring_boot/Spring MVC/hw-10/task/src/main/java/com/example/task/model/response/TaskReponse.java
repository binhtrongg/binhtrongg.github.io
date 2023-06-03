package com.example.task.model.response;
import com.example.task.statics.TaskStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskReponse {
    TaskStatus taskStatus;
    List<TaskDetailResponse> taskDetailResponses;
}
