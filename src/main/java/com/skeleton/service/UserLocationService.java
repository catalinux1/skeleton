package com.skeleton.service;

import com.skeleton.repository.UserLocationRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserLocationService {
    private static final Long SUPERADMIN_ID = -1L;

    @NonNull
    private final UserLocationRepository userLocationRepository;
}
