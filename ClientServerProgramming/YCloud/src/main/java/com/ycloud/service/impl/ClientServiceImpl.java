package com.ycloud.service.impl;

import com.ycloud.dto.ClientDto;
import com.ycloud.exception.client.ClientAlreadyExistsException;
import com.ycloud.exception.client.ClientNotFoundException;
import com.ycloud.mapper.ClientMapper;
import com.ycloud.repository.ClientRepository;
import com.ycloud.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {  //приймає запроси зовні(controller) і звертається до repository
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientDto getClient(String email){
        if (!clientRepository.existsByEmail(email)){
            throw new ClientNotFoundException(ClientNotFoundException.DEFAULT_MESSAGE +": Check email");
        }
        return ClientMapper.INSTANCE.toClientDto(clientRepository.getOneByEmail(email));
    }

    @Override
    public ClientDto createClient(ClientDto clientDto){
        if (clientRepository.existsByEmail(clientDto.getEmail())){
            throw new ClientAlreadyExistsException(ClientAlreadyExistsException.DEFAULT_MESSAGE + ": email is already in use");
        }
        clientDto.setPassword(passwordEncoder.encode(clientDto.getPassword()));
        return ClientMapper.INSTANCE.toClientDto(
                clientRepository.save(ClientMapper.INSTANCE.toClient(clientDto)));
    }

    @Override
    @Transactional
    public ClientDto updateClient(String email, ClientDto clientDto){
        if (!clientRepository.existsByEmail(email)){
            throw new ClientNotFoundException(ClientNotFoundException.DEFAULT_MESSAGE +": Check email");
        }
        clientDto.setId(clientRepository.findIdByEmail(email));
        clientRepository.removeByEmail(email);
        return ClientMapper.INSTANCE.toClientDto(
                clientRepository.save(ClientMapper.INSTANCE.toClient(clientDto)));
    }

    @Override
    @Transactional
    public void deleteClient(String email){
        if (!clientRepository.existsByEmail(email)){
            throw new ClientNotFoundException(ClientNotFoundException.DEFAULT_MESSAGE +": Check email");
        }
        clientRepository.removeByEmail(email);
    }

    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAll()
                .stream().map(client -> ClientMapper.INSTANCE.toClientDto(client)).collect(Collectors.toList());
    }


    
}
