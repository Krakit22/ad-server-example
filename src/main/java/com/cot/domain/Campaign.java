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
    private Byte weight;

    @Column(name="advertising_phrase")
    private String advertisingPhrase;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "campaign_id")
    private Set<Placement> placements;
}
