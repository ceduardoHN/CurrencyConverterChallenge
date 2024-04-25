package com.curso.alura.models;

/**
 * @author Soriano
 */
public record LatestExchangeRateDTO(
        String result, String time_last_update_utc,
        String base_code, Object conversion_rates) {
}
