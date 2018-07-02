package com.cot.inmemory.model;

import com.cot.domain.Placement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("PlacementHash")
public class PlacementHash implements Serializable {

    public PlacementHash(Placement placement) {
        this.id = placement.getId();
        this.name = placement.getName();
    }

    private Long id;
    private String name;

}
