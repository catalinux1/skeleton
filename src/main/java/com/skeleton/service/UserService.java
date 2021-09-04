package com.skeleton.service;

import com.skeleton.mapper.UserMapper;
import com.skeleton.model.UserModel;
import com.skeleton.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {
    @NonNull
    private final UserRepository userRepository;

    public List<UserModel> getUserModelList() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::entityToModel)
                .collect(Collectors.toList());
    }
}