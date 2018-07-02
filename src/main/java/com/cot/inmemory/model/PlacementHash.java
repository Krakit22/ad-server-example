package com.cot.inmemory.model;

import com.cot.domain.Campaign;
import com.cot.domain.Placement;
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
@RedisHash("PlacementHash")
public class PlacementHash implements Serializable {

    public PlacementHash(Placement placement, Set<Campaign> campaigns) {
        this.id = placement.getId();
        this.name = placement.getName();
        this.campaigns = campaigns.stream().map(CampaignHash::new).collect(Collectors.toSet());
    }

    private Long id;
    private String name;
    private Set<CampaignHash> campaigns;

}
