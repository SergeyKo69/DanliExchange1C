package com.kogut.danliexchange1c.schedulers;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.common.AbstractEntity;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author S.Kogut on 23.08.2021
 */

public abstract class AbstractLibScheduler<D extends AbstractDTO, E extends AbstractEntity> {

    private IExchange<D> exchangeService;
    private IBaseLibService<E, D> dbService;
    private AbstractMapper<E, D> mapper;

    @Value("${scheduler.enabled}")
    private Boolean schedulerEnabled;

    public AbstractLibScheduler(IExchange<D> exchangeService,
                                IBaseLibService<E, D> dbService,
                                AbstractMapper<E, D> mapper) {
        this.exchangeService = exchangeService;
        this.dbService = dbService;
        this.mapper = mapper;
    }

    @Scheduled(fixedRateString = "${scheduler.frequency}")
    public void startExchange() {
        if (schedulerEnabled) {
            List<E> entityList = dbService.findAll();
            entityList.forEach(row -> {
                exchangeService.exchange(mapper.toDto(row));
            });
            System.out.println("exchange service: " + exchangeService);
        }
    }
}
