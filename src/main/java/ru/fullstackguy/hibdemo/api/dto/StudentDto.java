package ru.fullstackguy.hibdemo.api.dto;

public record StudentDto(long id,
                         String name,
                         long groupId,
                         String groupName) {
}
