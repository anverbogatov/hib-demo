package ru.fullstackguy.hibdemo.infrastructure.integrations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import ru.fullstackguy.hibdemo.infrastructure.integrations.dtos.JsonApiTaskDto;

@FeignClient(name = "jsonApiClient", url = "${integration.json-api-service.host}")
public interface JsonApiFeignClient {

    @GetMapping(path = "/todos/1",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    JsonApiTaskDto getTodos();
}
