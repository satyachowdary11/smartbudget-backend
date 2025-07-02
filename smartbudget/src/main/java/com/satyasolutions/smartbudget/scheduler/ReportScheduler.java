package com.satyasolutions.smartbudget.scheduler;

import com.satyasolutions.smartbudget.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportScheduler {

    @Autowired
    private EmailService emailService;

    // Runs every day at 8 AM (adjust for testing)
    @Scheduled(cron = "0 0 8 * * ?")
    public void sendDailySummary() {
        String subject = "Your Daily Expense Report";
        String text = "Hey Satya,\n\nHere's your daily expense summary from SmartBudget.\n(TODO: Add real report data.)";

        emailService.sendReportEmail("your_email@gmail.com", subject, text);
        System.out.println("✅ Daily summary email sent.");
    }
}
