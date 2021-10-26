package com.ycloud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDto {

    @Positive(message = "Treatment Id should be positive")
    @NotNull(message = "Treatment should contain id")
    private long id;
    @Positive(message = "Treatment price should be positive")
    @NotNull(message = "Treatment price should not be empty")
    private int price;
    @NotEmpty(message = "Treatment name should not be empty")
    private String name;
    private List<MasterDto> masters;
}
