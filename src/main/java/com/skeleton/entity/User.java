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
@Table(name = "backend_user")
public class User extends AbstractAuditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_gen")
    @SequenceGenerator(name = "seq_user_gen", sequenceName = "seq_user", allocationSize = 1)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean active;
}
