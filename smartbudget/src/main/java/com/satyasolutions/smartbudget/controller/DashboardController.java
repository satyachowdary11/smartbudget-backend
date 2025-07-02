package com.satyasolutions.smartbudget.controller;

import com.satyasolutions.smartbudget.dto.DashboardDto;
import com.satyasolutions.smartbudget.entity.User;
import com.satyasolutions.smartbudget.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/monthly-summary")
    public DashboardDto getMonthlySummary() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return dashboardService.getMonthlySummary(user);
    }
}
