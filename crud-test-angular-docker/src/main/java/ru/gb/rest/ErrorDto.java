package ru.gb.rest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class ErrorDto {
    LocalDateTime localDateTime;
    String message;

    public ErrorDto(String message) {
        this.localDateTime = LocalDateTime.now();
        this.message = message;
    }
}
