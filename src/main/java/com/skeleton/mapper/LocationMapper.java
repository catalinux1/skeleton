package com.skeleton.mapper;

import com.skeleton.entity.Branch;
import com.skeleton.entity.Location;
import com.skeleton.model.LocationModel;

public class LocationMapper {
    public static LocationModel entityToModel(final Location location) {
        return LocationModel.builder()
                .id(location.getId())
                .name(location.getName())
                .branchId(location.getBranch() != null ? location.getBranch().getId() : null)
                .branchName(location.getBranch() != null ? location.getBranch().getName() : null)
                .active(location.getActive())
                .createdBy(location.getCreatedBy())
                .createdDate(location.getCreatedDate())
                .lastUpdateBy(location.getLastUpdateBy())
                .lastUpdateDate(location.getLastUpdateDate())
                .build();
    }

    public static Location modelToEntity(final LocationModel locationModel, final Branch branch, final Location savedLocation) {
        final Location location = Location.builder()
                .id(locationModel.getId() != 0 ? locationModel.getId() : null)
                .name(locationModel.getName())
                .active(locationModel.getActive())
                .branch(branch)
                .build();

        if (savedLocation != null) {
            location.setCreatedBy(savedLocation.getCreatedBy());
            location.setCreatedDate(savedLocation.getCreatedDate());
        }

        return location;
    }
}
