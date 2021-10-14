package com.techawarelabs.employeemanager.controller;

import com.techawarelabs.employeemanager.model.SupportForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class SupportFormController {

    @GetMapping("/support")
    public String complaintForm(Model model) {
        model.addAttribute("supportDetails", new SupportForm());
        List<String> membershipList = Arrays.asList("Platinum", "Gold", "Silver");
        model.addAttribute("membershipList", membershipList);
        return "support";
    }

    @PostMapping("/support")
    public String submitComplaint(@Valid @ModelAttribute SupportForm supportDetails, BindingResult bindingResult, Model model) {

        model.addAttribute("supportDetails", supportDetails);
        //below is for to populate dropdown after rerendering it,
        List<String> membershipList = Arrays.asList("Platinum", "Gold", "Silver");
        model.addAttribute("membershipList", membershipList);
        if (bindingResult.hasErrors()) {
            System.out.println("Errors found");
            return "support";
        } else {
            System.out.println("No errors found");
            return "submit";
        }
    }
}
