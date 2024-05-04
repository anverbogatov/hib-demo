package ru.fullstackguy.hibdemo.api.dto;

import org.springframework.lang.NonNull;

public record CreateGroupDto(
        String groupNumber,

        @NonNull
        GroupDetailsDto groupDetails
) {
}
