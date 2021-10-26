package com.ycloud.dto;


import com.ycloud.util.enums.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private long id;
    @NotNull(message = "Order date should not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate treatmentExecutionDate;
    @NotNull(message = "Order time should not be null")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime treatmentExecutionTime;
    @NotNull(message = "Order status should not be null")
    private OrderStatus status;
    @NotNull(message = "Order should contain Client")
    private ClientDto client;
    @NotNull(message = "Order should contain Master")
    private MasterDto master;
    @NotNull(message = "Order should contain Treatment")
    private TreatmentDto treatment;
}
