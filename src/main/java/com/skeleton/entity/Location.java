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
@Table(name = "location")
public class Location extends AbstractAuditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_branch_gen")
    @SequenceGenerator(name = "seq_branch_gen", sequenceName = "seq_branch", allocationSize = 1)
    private Long id;

    private String name;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_branch")
    private Branch branch;
}
