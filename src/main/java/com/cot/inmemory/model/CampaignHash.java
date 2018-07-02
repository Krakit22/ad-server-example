package com.cot.inmemory.model;

import com.cot.domain.Campaign;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("CampaignHash")
public class CampaignHash implements Serializable {

    public CampaignHash(Campaign campaign) {
        this.id = campaign.getId();
        this.name = campaign.getName();
        this.weight = campaign.getWeight();
        this.advertisingPhrase = campaign.getAdvertisingPhrase();
        this.placements = campaign.getPlacements().stream().map(PlacementHash::new).collect(Collectors.toSet());
    }

    private Long id;
    private String name;
    private Byte weight;
    private String advertisingPhrase;
    private Set<PlacementHash> placements;
}
