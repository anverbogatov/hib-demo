package ru.fullstackguy.hibdemo.infrastructure.integrations.dtos;

import lombok.Data;

@Data
public class JsonApiTaskDto {
//    https://jsonplaceholder.typicode.com/
    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
}
