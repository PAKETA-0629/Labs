package com.ycloud.service.impl;


import com.ycloud.repository.ServiceRepository;
import com.ycloud.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    public static final String SELECT_ALL = "SELECT * FROM y_services";
    private final DataSource dataSource;
    private final ServiceRepository serviceRepository;

    public List<com.ycloud.model.Service> selectAll() {
        List<com.ycloud.model.Service> services = new ArrayList<>();
        try(Connection conn = dataSource.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                com.ycloud.model.Service service = new com.ycloud.model.Service();
                int id = rs.getInt("id");
                String serviceName = rs.getString("service_name");
                int price = rs.getInt("price");
                service.setId(id);
                service.setName(serviceName);
                service.setPrice(price);
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;

    }


}
