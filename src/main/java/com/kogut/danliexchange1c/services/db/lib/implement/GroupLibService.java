package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.common.GroupLibDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.GroupLibMapper;
import com.kogut.danliexchange1c.model.lib.common.GroupLibEntity;
import com.kogut.danliexchange1c.repositories.lib.GroupLibRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IGroupLibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 09.08.2021
 */

@Service
public class GroupLibService implements IGroupLibService {

    private final GroupLibRepository groupLibRepository;
    private final GroupLibMapper groupLibMapper;

    @Autowired
    public GroupLibService(GroupLibRepository groupLibRepository, GroupLibMapper groupLibMapper) {
        this.groupLibRepository = groupLibRepository;
        this.groupLibMapper = groupLibMapper;
    }

    @Override
    @Transactional
    public GroupLibEntity save(GroupLibEntity entity) {
        return groupLibRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveDTO(GroupLibDTO dto) {
        groupLibRepository.save(groupLibMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<GroupLibEntity> saveAll(List<GroupLibEntity> entities) {
        return groupLibRepository.saveAll(entities);
    }

    @Override
    public List<GroupLibEntity> findAll() {
        return groupLibRepository.findAll();
    }

    @Override
    public List<GroupLibEntity> findAllByExternalId(String externalId) {
        return groupLibRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<GroupLibEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return groupLibRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<GroupLibEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return groupLibRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        groupLibRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        groupLibRepository.deleteAll();
    }
}
