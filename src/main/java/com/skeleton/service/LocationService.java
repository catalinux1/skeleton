package com.skeleton.service;

import com.skeleton.entity.Branch;
import com.skeleton.entity.Location;
import com.skeleton.mapper.LocationMapper;
import com.skeleton.model.LocationModel;
import com.skeleton.repository.BranchRepository;
import com.skeleton.repository.LocationRepository;
import com.skeleton.util.Paged;
import com.skeleton.util.Paging;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LocationService {
    @NonNull
    private final LocationRepository locationRepository;
    @NonNull
    private final BranchRepository branchRepository;

    public Paged<LocationModel> getLocationPage(final int pageNumber, final int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.Direction.DESC, "lastUpdateDate");
        Page<LocationModel> locationModelPage = locationRepository.findAll(request).map(LocationMapper::entityToModel);

        return new Paged<>(locationModelPage, Paging.of(locationModelPage.getTotalPages(), pageNumber, size));
    }

    public LocationModel getLocationModelById(final Long id) {
        LocationModel locationModel = new LocationModel();
        Location location = locationRepository.findById(id).orElse(null);
        if (location != null) {
            locationModel = LocationMapper.entityToModel(location);
        }
        return locationModel;
    }

    public void save(final LocationModel locationModel) {
        final Branch branch = branchRepository.findById(locationModel.getBranchId()).orElse(null);
        Location lastLocationSaved = locationRepository.findById(locationModel.getId()).orElse(null);
        Location location = LocationMapper.modelToEntity(locationModel, branch, lastLocationSaved);
        Location savedLocation = locationRepository.save(location);
        // todo: de sters din userLocation sau adaugat pe superadministrator
    }
}