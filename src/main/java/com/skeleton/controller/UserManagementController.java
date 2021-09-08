package com.skeleton.controller;

import com.skeleton.model.BranchModel;
import com.skeleton.service.BranchService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping(value = "/addBranch")
    public String addBranch(@Valid @ModelAttribute("branchModel") final BranchModel branchModel,
                            final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userManagement/branchPage";
        }

        branchService.saveBranchModel(branchModel);

        return "redirect:/userManagement/branchPage";
    }
}