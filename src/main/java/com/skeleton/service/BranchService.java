package com.skeleton.service;

import com.skeleton.entity.Branch;
import com.skeleton.mapper.BranchMapper;
import com.skeleton.model.BranchModel;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BranchService {
    @NonNull
    private final BranchRepository branchRepository;

    public Paged<BranchModel> getBranchPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.Direction.DESC, "lastUpdateDate");
        Page<BranchModel> branchModelPage = branchRepository.findAll(request).map(BranchMapper::entityToModel);

        return new Paged<>(branchModelPage, Paging.of(branchModelPage.getTotalPages(), pageNumber, size));
    }

    public BranchModel getBranchModelById(final Long id) {
        BranchModel branchModel = new BranchModel();
        Branch branch = branchRepository.findById(id).orElse(null);
        if(branch != null) {
            branchModel = BranchMapper.entityToModel(branch);
        }

        return branchModel;
    }

    public void saveBranch(final BranchModel branchModel) {
        final Branch savedBranch = branchRepository.findById(branchModel.getId()).orElse(null);
        final Branch branch = BranchMapper.modelToEntity(branchModel, savedBranch);
        branchRepository.save(branch);
    }

    public List<BranchModel> getAllActive() {
        return branchRepository.findByActiveTrue().stream()
                .map(BranchMapper::entityToModel)
                .collect(Collectors.toList());
    }
}
