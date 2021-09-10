package com.skeleton.mapper;

import com.skeleton.entity.Branch;
import com.skeleton.entity.Location;
import com.skeleton.model.LocationModel;

public class LocationMapper {
    public static LocationModel entityToModel (final Location location) {
        return LocationModel.builder()
                .id(location.getId())
                .name(location.getName())
                .branchId(location.getBranch() != null ? location.getBranch().getId() : null)
                .branchName(location.getBranch() != null ? location.getBranch().getName() : null)
                .createdBy(location.getCreatedBy())
                .createdDate(location.getCreatedDate())
                .lastUpdateBy(location.getLastUpdateBy())
                .lastUpdateDate(location.getLastUpdateDate())
                .build();
    }

    public static Location modelToEntity (final LocationModel locationModel, final Branch branch) {
        final Location location = Location.builder()
                .id(locationModel.getId())
                .name(locationModel.getName())
                .active(locationModel.getActive())
                .branch(branch)
                .build();

        location.setCreatedBy(locationModel.getCreatedBy());
        location.setCreatedDate(locationModel.getCreatedDate());

        return location;
    }
}
