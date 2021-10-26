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
public class ClientDto { //data transfer object - об'єкт передачі даних
    private long id;
    @NotEmpty(message = "Client Name should not be empty")
    private String name;
   @NotEmpty(message = "Client Surname should not be empty")
    private String surname;
    @NotEmpty(message = "Client Email should not be empty")
    @Email(message = "Client Email should be valid")
    private String email;
    @NotEmpty(message = "Client Password should not be empty")
    private String password;
    @NotEmpty(message = "Client Password should not be empty")
    private String repeatPassword;
    private List<OrderDto> orders;
    private List<ReviewDto> reviews;
}
