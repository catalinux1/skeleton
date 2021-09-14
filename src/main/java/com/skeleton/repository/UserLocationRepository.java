package com.skeleton.repository;

import com.skeleton.entity.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
}
