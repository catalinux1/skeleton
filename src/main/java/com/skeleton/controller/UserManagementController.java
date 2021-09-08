package com.skeleton.controller;

import com.skeleton.service.BranchService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/branchPage")
    public String getBranchPage(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                                @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                Model model) {
        model.addAttribute("branchPage", branchService.getBranchPage(pageNumber, size));

        return "userManagement/branchPage";
    }
}