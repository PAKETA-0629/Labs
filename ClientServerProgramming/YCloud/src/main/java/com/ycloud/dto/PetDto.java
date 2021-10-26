package com.ycloud.dto;

import com.ycloud.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    private long id;
    @NotBlank(message = "Pet date should not be empty")
    private String name;
    @NotNull(message = "Pet should have Client")
    private Client client;
}
