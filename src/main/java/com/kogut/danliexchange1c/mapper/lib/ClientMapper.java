package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.client.ClientContactsDTO;
import com.kogut.danliexchange1c.dto.lib.client.ClientDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.client.ClientContactsEntity;
import com.kogut.danliexchange1c.model.lib.client.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 09.08.2021
 */

@Component
public class ClientMapper extends AbstractMapper<ClientEntity, ClientDTO> {

    private final ModelMapper mapper;

    @Autowired
    public ClientMapper(ModelMapper mapper) {
        super(ClientEntity.class, ClientDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(ClientDTO.class, ClientEntity.class)
                .addMappings(m -> m.skip(ClientEntity:: setId))
                .addMappings(m -> m.skip(ClientEntity::setClientDB))
                .setPostConverter(toEntityConverter());
        mapper.createTypeMap(ClientEntity.class, ClientDTO.class)
                .setPostConverter(toDtoConverter());
    }

    @Override
    public void mapSpecificFields(ClientEntity source, ClientDTO destination) {
        super.mapSpecificFields(source, destination);
        destination.setContacts(
                source
                        .getContacts()
                        .stream()
                        .map(c -> mapper.map(c, ClientContactsDTO.class)).collect(Collectors.toList()));
    }

    @Override
    public void mapSpecificFields(ClientDTO source, ClientEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
        destination.setContacts(
                source
                        .getContacts()
                        .stream()
                        .map(c -> mapper.map(c, ClientContactsEntity.class)).collect(Collectors.toList()));
    }

}
