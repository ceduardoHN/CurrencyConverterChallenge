package com.curso.alura.models;

/**
 * @author Soriano
 */
public record ConversionPairDTO(
        String result, String time_last_update_utc,
        String base_code, String target_code,
        double conversion_rate) {
}
