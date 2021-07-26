package com.kogut.danliexchange1c.dto.services;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 11/10/2019
 */

@Component
public class HealthCheck implements HealthIndicator{

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down()
                    .withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    public int check() {
        // Возможно потом будет что - то полезное.
        return 0;
    }

}
