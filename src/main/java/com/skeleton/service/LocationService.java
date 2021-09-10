package com.skeleton.service;

import com.skeleton.entity.Location;
import com.skeleton.mapper.LocationMapper;
import com.skeleton.model.LocationModel;
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


    public Paged<Location> getLocationPage(final int pageNumber, final int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.Direction.DESC, "lastUpdateDate");
        Page<Location> locationPage = locationRepository.findAll(request);

        return new Paged<>(locationPage, Paging.of(locationPage.getTotalPages(), pageNumber, size));
    }

    public LocationModel getLocationModelById(final Long id) {
        LocationModel locationModel = new LocationModel();
        Location location = locationRepository.findById(id).orElse(null);
        if (location != null) {
            locationModel = LocationMapper.entityToModel(location);
        }
        return locationModel;
    }
}