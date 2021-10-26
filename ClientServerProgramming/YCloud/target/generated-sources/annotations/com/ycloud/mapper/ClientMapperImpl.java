package com.ycloud.mapper;

import com.ycloud.dto.ClientDto;
import com.ycloud.model.Client;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-28T02:07:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( client.getId() );
        clientDto.setName( client.getName() );
        clientDto.setSurname( client.getSurname() );
        clientDto.setEmail( client.getEmail() );
        clientDto.setPassword( client.getPassword() );

        return clientDto;
    }

    @Override
    public Client toClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDto.getId() );
        client.setName( clientDto.getName() );
        client.setSurname( clientDto.getSurname() );
        client.setPassword( clientDto.getPassword() );
        client.setEmail( clientDto.getEmail() );

        return client;
    }
}
