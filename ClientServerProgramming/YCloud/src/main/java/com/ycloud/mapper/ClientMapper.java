package com.ycloud.mapper;


import com.ycloud.dto.ClientDto;
import com.ycloud.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    ClientDto toClientDto(Client client);   //перетворює ClientDto в Client
    Client toClient(ClientDto clientDto);   //перетворює Client в ClientDto


}
