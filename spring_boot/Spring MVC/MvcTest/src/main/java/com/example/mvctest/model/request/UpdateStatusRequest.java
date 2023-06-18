package com.example.mvctest.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateStatusRequest {
    private Integer id;

    @Size(max = 255, message = "Trạng thái không được vượt quá 255 ký tự")
    private String status;

    @NotNull
    private LocalDateTime updateTime;
}
