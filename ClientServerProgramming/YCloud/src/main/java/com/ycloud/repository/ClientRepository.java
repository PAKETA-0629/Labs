package com.ycloud.repository;

import com.ycloud.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> { //для роботи з БД
        boolean existsByEmail(String email);
        Client getOneByEmail(String email);
        void removeByEmail(String email);
        long findIdByEmail(String email);
}
