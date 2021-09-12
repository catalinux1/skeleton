package com.skeleton.service;

import com.skeleton.entity.User;
import com.skeleton.repository.UserRepository;
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
public class UserService {
    @NonNull
    private final UserRepository userRepository;

    public Paged<User> getUserPage(final int pageNumber, final int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.Direction.DESC, "lastUpdateDate");
        Page<User> userPage = userRepository.findAll(request);

        return new Paged<>(userPage, Paging.of(userPage.getTotalPages(), pageNumber, size));
    }
}