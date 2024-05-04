package ru.fullstackguy.hibdemo.api.dto;

import java.util.List;

public record StudentDto(String name, PassportDto passport, List<String> subjects) {
}
