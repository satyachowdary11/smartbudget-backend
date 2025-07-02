package com.satyasolutions.smartbudget.repository;

import com.satyasolutions.smartbudget.entity.Transaction;
import com.satyasolutions.smartbudget.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // 🔍 Find all with pagination and sorting
    Page<Transaction> findAll(Pageable pageable);

    // 🔍 Filter by type (INCOME or EXPENSE)
    List<Transaction> findByTypeIgnoreCase(String type);

    // 🔍 Filter by category
    List<Transaction> findByCategoryIgnoreCase(String category);

    // 🔍 Filter by date
    List<Transaction> findByDate(LocalDate date);

    // 🔍 Filter by amount range
    List<Transaction> findByAmountBetween(double min, double max);

    // 🔍 Filter by category + amount range
    List<Transaction> findByCategoryIgnoreCaseAndAmountBetween(String category, double min, double max);

    // 🔍 Filter by date + type
    List<Transaction> findByDateAndTypeIgnoreCase(LocalDate date, String type);
    
    List<Transaction> findByUser(User user);

}
