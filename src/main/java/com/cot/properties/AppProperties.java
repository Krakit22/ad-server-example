package com.cot.properties;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "adserver")
@Getter
@Setter
public class AppProperties {

    @NonNull
    private Long synchronizeDelay;
}
