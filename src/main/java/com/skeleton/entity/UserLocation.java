package com.skeleton.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_location_gen")
    @SequenceGenerator(name = "seq_user_location_gen", sequenceName = "seq_user_location", allocationSize = 1)
    private Long id;
    @ManyToOne
    private Location location;
    @ManyToOne
    private User user;
}
