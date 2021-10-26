package com.ycloud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MasterDto {
    private long id;
    @NotEmpty(message = "Master Name should not be empty")
    private String name;
    @NotEmpty(message = "Master Surname should not be empty")
    private String surname;
    @NotEmpty(message = "Master Email should not be empty")
    @Email(message = "Master Email should be valid")
    private String email;
    @NotEmpty(message = "Master Password should not be empty")
    private String password;
    @NotEmpty(message = "Master Password should not be empty")
    private String repeatPassword;
    private Double rating;
    private List<OrderDto> orders;
    private List<TreatmentDto> listOfTreatments;
}
