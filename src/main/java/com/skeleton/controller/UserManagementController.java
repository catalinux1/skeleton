package com.skeleton.controller;

import com.skeleton.service.BranchService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/userManagement")
public class UserManagementController {
    @NonNull
    private final BranchService branchService;

    @GetMapping(value = "/dashboard")
    public String getList() {

        return "userManagement/dashboard";
    }

    @GetMapping(value = "/branchPage")
    public String getBranchPage(final Model model,
                                @SortDefault(sort = "name", direction = Sort.Direction.ASC)
                                @PageableDefault(size = 10) final Pageable pageable) {
        model.addAttribute("branchModelPage", branchService.getBranchModelPage(pageable));

        return "userManagement/branchPage";
    }
}