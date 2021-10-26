package com.ycloud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private long id;
    @NotNull(message = "Review date should not be null")
    private LocalDateTime dateTime;
    @NotEmpty(message = "Review content should not be empty")
    private String content;
    @NotNull(message = "Review should contain Client")
    private ClientDto client;
}
