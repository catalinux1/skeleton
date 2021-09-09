package com.skeleton.controller;

import com.skeleton.service.BranchService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = "/branch/list")
    public String getBranchList(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                                @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                Model model) {
        model.addAttribute("branchModel", branchService.getBranchPage(pageNumber, size));

        return "userManagement/branch/list";
    }

    @GetMapping(value = "/branch/form/{branchId}")
    public String getBranchForm(@PathVariable final Long branchId, final Model model) {
        model.addAttribute("branchModel", branchService.getBranchModelById(branchId));

        return "userManagement/branch/form";
    }
}