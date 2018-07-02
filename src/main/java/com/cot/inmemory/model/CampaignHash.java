package com.cot.inmemory.model;

import com.cot.domain.Campaign;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("CampaignHash")
public class CampaignHash implements Serializable {

    public CampaignHash(Campaign campaign) {
        this.id = campaign.getId();
        this.name = campaign.getName();
        this.weight = campaign.getWeight();
        this.advertisingPhrase = campaign.getAdvertisingPhrase();
    }

    private Long id;
    private String name;
    private Integer weight;
    private String advertisingPhrase;
}
