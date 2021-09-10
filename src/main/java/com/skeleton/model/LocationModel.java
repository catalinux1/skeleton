package com.skeleton.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationModel {
    private Long id;

    @NotBlank(message = "Campul trebuie completat!")
    @Size(min = 2, max = 255, message = "Campul trebuie sa contina intre 2 si 255 caractere!")
    private String name;

    @NotNull(message = "Campul trebuie completat!")
    private Long branchId;
    private String branchName;
    private Boolean active;
    private String lastUpdateBy;
    private LocalDateTime lastUpdateDate;
    private String createdBy;
    private LocalDateTime createdDate;
}
