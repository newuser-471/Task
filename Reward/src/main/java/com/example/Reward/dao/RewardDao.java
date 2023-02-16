package com.example.Reward.dao;

import com.example.Reward.model.Transaction;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

@Repository
public interface RewardDao {

    public List<Transaction> findByCustomerIdInCertainMonths(Integer customerId, int monthOffSet) throws ParseException;
}
