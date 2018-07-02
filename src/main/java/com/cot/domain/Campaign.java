package com.cot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer weight;

    @Column(name="advertising_phrase")
    private String advertisingPhrase;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "campaign_to_placement",
            joinColumns = {@JoinColumn(name = "campaign_id")},
            inverseJoinColumns = {@JoinColumn(name = "placement_id")})
    private Set<Placement> placements;
}
