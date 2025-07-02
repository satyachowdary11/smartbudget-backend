package com.satyasolutions.smartbudget.service;

import com.satyasolutions.smartbudget.entity.Transaction;
import com.satyasolutions.smartbudget.entity.User;
import com.satyasolutions.smartbudget.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    // 🔹 Save transaction for a specific user
    public Transaction addTransaction(Transaction transaction, User user) {
        transaction.setUser(user);
        return repository.save(transaction);
    }

    // 🔹 Get all transactions for a user
    public List<Transaction> getAllUserTransactions(User user) {
        return repository.findByUser(user);
    }

    // 🔹 Delete transaction by ID (optional: add ownership check here)
    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }

    // (Optional) Filter, sort, paginate, etc.
}
