package com.kogut.danliexchange1c.services.exchange.interfaces;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;

/**
 * @author S.Kogut on 24.07.2021
 */
public interface IExchange<T extends AbstractDTO> {

    void exchange(T t);

}
