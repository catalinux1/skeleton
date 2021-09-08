package com.skeleton.service;

import com.skeleton.entity.Branch;
import com.skeleton.repository.BranchRepository;
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
public class BranchService {
    @NonNull
    private final BranchRepository branchRepository;

//    public PageWrapper<BranchModel> getBranchModelPage(final Pageable pageable) {
//        final List<BranchModel> branchModelList = new ArrayList<>();
//        final Page<Branch> branchPage= branchRepository.findAll(pageable);
//        for (final Branch branch : branchPage.getContent()) {
//            final BranchModel branchModel = BranchMapper.entityToModel(branch);
//            branchModelList.add(branchModel);
//        }
//
//        return new PageWrapper<>(new PageImpl<>(branchModelList, pageable, branchPage.getTotalElements()), "/userManagement/branchPage");
//    }

    public Paged<Branch> getBranchPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.Direction.ASC, "id");

        Page<Branch> branchPage = branchRepository.findAll(request);

        return new Paged<>(branchPage, Paging.of(branchPage.getTotalPages(), pageNumber, size));
    }
}
