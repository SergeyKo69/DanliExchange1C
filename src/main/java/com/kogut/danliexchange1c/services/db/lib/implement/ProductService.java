package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.product.ProductDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.ProductMapper;
import com.kogut.danliexchange1c.model.lib.product.ProductEntity;
import com.kogut.danliexchange1c.repositories.lib.ProductRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public ProductEntity save(ProductEntity entity) {
        return productRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveDTO(ProductDTO dto) {
        productRepository.save(productMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<ProductEntity> saveAll(List<ProductEntity> entities) {
        return productRepository.saveAll(entities);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductEntity> findAllByExternalId(String externalId) {
        return productRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<ProductEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return productRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<ProductEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return productRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        productRepository.deleteByExternalId(externalId);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
