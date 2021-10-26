package com.ycloud.service;



import com.ycloud.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto getClient(String email);

    ClientDto createClient(ClientDto clientDto);

    ClientDto updateClient(String email, ClientDto clientDto);

    void deleteClient(String email);

    List<ClientDto> getAll();

}
