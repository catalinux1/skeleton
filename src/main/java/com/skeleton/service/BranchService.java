package com.skeleton.service;

import com.skeleton.mapper.BranchMapper;
import com.skeleton.model.BranchModel;
import com.skeleton.repository.BranchRepository;
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
public class BranchService {
    @NonNull
    private final BranchRepository branchRepository;

    public List<BranchModel> getBranchModel() {
        return branchRepository.findAll()
                .stream()
                .map(BranchMapper::entityToModel)
                .collect(Collectors.toList());
    }
}
