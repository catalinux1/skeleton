package com.skeleton.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchModel {
    private Long id;
    @NotBlank()
    @Size(min = 2, max = 255)
    private String name;
    private Boolean active;
    private String lastUpdateBy;
    private LocalDateTime lastUpdateDate;
    private String createdBy;
    private LocalDateTime createdDate;
}
