package org.rai5569;

import java.util.Map;

public record ExchangeRate(
        String time_last_update_utc,
        String base_code,
        Map<String, Double> conversion_rates
)
{

}
