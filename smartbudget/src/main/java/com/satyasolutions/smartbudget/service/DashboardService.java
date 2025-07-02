package com.satyasolutions.smartbudget.service;

import com.satyasolutions.smartbudget.dto.DashboardDto;
import com.satyasolutions.smartbudget.entity.Transaction;
import com.satyasolutions.smartbudget.entity.User;
import com.satyasolutions.smartbudget.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private TransactionRepository transactionRepository;

    public DashboardDto getMonthlySummary(User user) {
        LocalDate now = LocalDate.now();
        LocalDate firstOfMonth = now.withDayOfMonth(1);

        List<Transaction> transactions = transactionRepository.findByUser(user).stream()
                .filter(t -> !t.getDate().isBefore(firstOfMonth))
                .collect(Collectors.toList());

        double income = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("INCOME"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double expense = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("EXPENSE"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        Map<String, Double> categoryBreakdown = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("EXPENSE"))
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)
                ));

        DashboardDto summary = new DashboardDto();
        summary.setTotalIncome(income);
        summary.setTotalExpense(expense);
        summary.setNetBalance(income - expense);
        summary.setCategoryExpenseBreakdown(categoryBreakdown);

        return summary;
    }
}
