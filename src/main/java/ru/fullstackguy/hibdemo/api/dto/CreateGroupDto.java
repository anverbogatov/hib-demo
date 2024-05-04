package ru.fullstackguy.hibdemo.api.dto;

import org.springframework.lang.NonNull;

import java.util.List;

public record CreateGroupDto(
        String groupNumber,

        @NonNull
        GroupDetailsDto groupDetails,

        List<StudentDto> students
) {
}
