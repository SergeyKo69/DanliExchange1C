package com.kogut.danliexchange1c.senders.interfaces;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import org.springframework.http.HttpStatus;

/**
 * @author S.Kogut on 24.07.2021
 */
public interface ISender<T extends AbstractDTO> {

    HttpStatus send(T t);

}
