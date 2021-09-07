package com.skeleton.service;

import com.skeleton.entity.Branch;
import com.skeleton.mapper.BranchMapper;
import com.skeleton.model.BranchModel;
import com.skeleton.repository.BranchRepository;
import com.skeleton.util.PageWrapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BranchService {
    @NonNull
    private final BranchRepository branchRepository;

    public PageWrapper<BranchModel> getBranchModelPage(final Pageable pageable) {
        final List<BranchModel> branchModelList = new ArrayList<>();
        final Page<Branch> branchPage= branchRepository.findAll(pageable);
        for (final Branch branch : branchPage.getContent()) {
            final BranchModel branchModel = BranchMapper.entityToModel(branch);
            branchModelList.add(branchModel);
        }

        return new PageWrapper<>(new PageImpl<>(branchModelList, pageable, branchPage.getTotalElements()), "/userManagement/branchPage");
    }
}
