package com.kogut.danliexchange1c.schedulers;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.common.AbstractEntity;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBaseDocService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * @author S.Kogut on 23.08.2021
 */
public abstract class AbstractDocScheduler<D extends AbstractDTO, E extends AbstractEntity> {

    private final IExchange<D> exchangeService;
    private final IBaseDocService<E,D> dbService;
    private final AbstractMapper<E, D> mapper;

    @Value("${scheduler.enabled}")
    private Boolean schedulerEnabled;

    public AbstractDocScheduler(IExchange<D> exchangeService,
                                IBaseDocService<E, D> dbService,
                                AbstractMapper<E, D> mapper) {
        this.exchangeService = exchangeService;
        this.dbService = dbService;
        this.mapper = mapper;
    }

    @Scheduled(fixedRateString = "${scheduler.frequency}")
    public void startExchange() {
        if (schedulerEnabled) {
            List<D> entityList = dbService.findAllDTO();
            entityList.forEach(exchangeService::exchange);
        }
    }
}
