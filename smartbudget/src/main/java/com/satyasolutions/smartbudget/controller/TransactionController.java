package com.satyasolutions.smartbudget.controller;

import com.satyasolutions.smartbudget.dto.TransactionDto;
import com.satyasolutions.smartbudget.entity.Transaction;
import com.satyasolutions.smartbudget.entity.User;
import com.satyasolutions.smartbudget.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    // 🔐 GET all transactions for the logged-in user
    @GetMapping
    public List<Transaction> getMyTransactions() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return service.getAllUserTransactions(user);
    }


    // 🔐 POST a transaction for the logged-in user
    @PostMapping
    public Transaction add(@RequestBody @Valid TransactionDto dto) {
        User user = getLoggedInUser();

        Transaction transaction = new Transaction();
        transaction.setTitle(dto.getTitle());
        transaction.setAmount(dto.getAmount());
        transaction.setType(dto.getType());
        transaction.setCategory(dto.getCategory());
        transaction.setDate(LocalDate.parse(dto.getDate()));

        return service.addTransaction(transaction, user);
    }

    // 🔐 DELETE (optional: secure it by ownership)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteTransaction(id);
        return "Deleted transaction with ID: " + id;
    }

    // 🔁 Reusable method to get logged-in user from Spring Security context
    private User getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (User) auth.getPrincipal();  // ✅ because JwtAuthFilter sets the User as principal
    }
}
