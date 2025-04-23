package com.krath.CaterFlowBackEnd.kitchen.cookbook.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration, Long> {

    @Override
    public Long convertToDatabaseColumn(Duration duration) {
        return (duration == null) ? null : duration.toSeconds();
    }

    @Override
    public Duration convertToEntityAttribute(Long seconds) {
        return (seconds == null) ? null : Duration.ofSeconds(seconds);
    }
}
