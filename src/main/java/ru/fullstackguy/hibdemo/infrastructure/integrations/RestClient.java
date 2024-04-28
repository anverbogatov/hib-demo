package ru.fullstackguy.hibdemo.infrastructure.integrations;

import org.springframework.stereotype.Component;

@Component
public class RestClient {

    public void post(long id) {
        if (id == 1) {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
