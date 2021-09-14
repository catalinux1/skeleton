package com.skeleton.model;

import com.skeleton.entity.Location;
import com.skeleton.enumerated.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long id;

    @NotBlank(message = "Campul trebuie completat!")
    @Size(min = 2, max = 255, message = "Campul trebuie sa contina intre 2 si 255 caractere!")
    @Email(message = "Adresa de email trebuie sa fie valida!")
    private String email;

    @NotEmpty(message = "Campul trebuie completat!")
    @Size(min = 6, message = "Parola trebuie sa aiba cel putin 6 caractere!")
    @Pattern.List({
            @Pattern(regexp = ".*[A-Z].*", message = "Parola trebuie sa contina cel putin o litera mare!"),
            @Pattern(regexp = ".*[a-z].*", message = "Parola trebuie sa contina cel putin o litera mica!"),
            @Pattern(regexp = ".*[0-9].*", message = "Parola trebuie sa contina cel putin o cifra!")
    })
    private String password;

    @NotBlank(message = "Campul trebuie completat!")
    @Size(min = 2, max = 255, message = "Campul trebuie sa contina intre 2 si 255 caractere!")
    private String firstName;

    @NotBlank(message = "Campul trebuie completat!")
    @Size(min = 2, max = 255, message = "Campul trebuie sa contina intre 2 si 255 caractere!")
    private String lastName;

    @NotEmpty(message = "Campul trebuie completat!")
    private List<Role> roles;

    @Size(max = 255, message = "Campul trebuie sa contina maxim 255 caractere!")
    private String job;

    @Size(max = 255, message = "Campul trebuie sa contina maxim 255 caractere!")
    private String phone;

    private Boolean active;
    private String lastUpdateBy;
    private LocalDateTime lastUpdateDate;
    private String createdBy;
    private LocalDateTime createdDate;
    private List<Location> locations;

    @NotEmpty(message = "Campul trebuie completat!")
    private List<Long> locationIds;
}