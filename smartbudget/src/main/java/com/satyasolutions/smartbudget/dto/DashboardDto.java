package com.satyasolutions.smartbudget.dto;

import java.util.Map;

public class DashboardDto {
    private double totalIncome;
    private double totalExpense;
    private double netBalance;
    private Map<String, Double> categoryExpenseBreakdown;

    // Getters & Setters
    public double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(double totalIncome) { this.totalIncome = totalIncome; }

    public double getTotalExpense() { return totalExpense; }
    public void setTotalExpense(double totalExpense) { this.totalExpense = totalExpense; }

    public double getNetBalance() { return netBalance; }
    public void setNetBalance(double netBalance) { this.netBalance = netBalance; }

    public Map<String, Double> getCategoryExpenseBreakdown() { return categoryExpenseBreakdown; }
    public void setCategoryExpenseBreakdown(Map<String, Double> categoryExpenseBreakdown) {
        this.categoryExpenseBreakdown = categoryExpenseBreakdown;
    }
}
