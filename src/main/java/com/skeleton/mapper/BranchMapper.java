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

    public static Branch modelToEntity(final BranchModel branchModel, final Branch savedBranch) {
        final Branch branch = Branch.builder()
                .id(branchModel.getId() != 0 ? branchModel.getId() : null)
                .name(branchModel.getName())
                .active(branchModel.getActive())
                .build();

        if (savedBranch != null) {
            branch.setCreatedBy(savedBranch.getCreatedBy());
            branch.setCreatedDate(savedBranch.getCreatedDate());
        }

        return branch;
    }
}
