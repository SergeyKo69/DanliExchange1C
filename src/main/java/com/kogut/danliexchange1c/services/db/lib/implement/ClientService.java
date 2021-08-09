package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.client.ClientDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.ClientMapper;
import com.kogut.danliexchange1c.model.lib.client.ClientEntity;
import com.kogut.danliexchange1c.repositories.lib.ClientRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 09.08.2021
 */

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository,
                         ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    @Transactional
    public ClientEntity save(ClientEntity entity) {
        return clientRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveDTO(ClientDTO dto) {
        clientRepository.save(clientMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<ClientEntity> saveAll(List<ClientEntity> entities) {
        return clientRepository.saveAll(entities);
    }

    @Override
    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<ClientEntity> findAllByExternalId(String externalId) {
        return clientRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<ClientEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return clientRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<ClientEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return clientRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        clientRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        clientRepository.deleteAll();
    }

}
