package com.skeleton.mapper;

import com.skeleton.entity.Branch;
import com.skeleton.model.BranchModel;

public class BranchMapper {
    public static BranchModel entityToModel(final Branch branch) {
        return BranchModel.builder()
                .id(branch.getId())
                .name(branch.getName())
                .active(branch.getActive())
                .createdBy(branch.getCreatedBy())
                .createdDate(branch.getCreatedDate())
                .lastUpdateBy(branch.getLastUpdateBy())
                .lastUpdateDate(branch.getLastUpdateDate())
                .build();
    }

    public static Branch modelToEntity(final BranchModel branchModel) {
        final Branch branch = Branch.builder()
                .id(branchModel.getId() != null ? branchModel.getId() : null)
                .name(branchModel.getName())
                .active(branchModel.getActive())
                .build();

        branch.setCreatedBy(branchModel.getCreatedBy());
        branch.setCreatedDate(branchModel.getCreatedDate());

        return branch;
    }
}
