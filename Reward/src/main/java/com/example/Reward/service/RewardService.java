package com.example.Reward.service;

import com.example.Reward.model.Reward;
import org.springframework.stereotype.Repository;

import java.text.ParseException;

@Repository
public interface RewardService {
    public Reward getRewardByCustomerId(int customerId) throws ParseException;

    public Reward getRewardByCustomerIdForCertainMonth(int customerId, int month) throws ParseException;

}
