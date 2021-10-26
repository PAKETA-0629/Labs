package com.ycloud.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "y_service")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "price")
    private int price;

    public void setName(String serviceName) {
        this.serviceName = serviceName;
    }


}
