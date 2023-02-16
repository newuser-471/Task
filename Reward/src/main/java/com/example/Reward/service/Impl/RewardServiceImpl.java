package com.example.Reward.service.Impl;

import com.example.Reward.constant.Constants;
import com.example.Reward.dao.Impl.RewardDaoImpl;
import com.example.Reward.model.Transaction;
import com.example.Reward.model.Reward;
import com.example.Reward.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {

    private RewardDaoImpl rewardDao;

    @Autowired
    public RewardServiceImpl(RewardDaoImpl rewardDao){
        this.rewardDao = rewardDao;
    }

    @Override
    public Reward getRewardByCustomerId(int customerId) throws ParseException {
        List<Transaction> transactions = rewardDao.findByCustomerIdInCertainMonths(customerId, Constants.oneMonth);
        long rewardPoints = getRewardForMonth(transactions);
        Reward reward = new Reward();
        reward.setCustomerId(customerId);
        reward.setRewardPoints(rewardPoints);
        return reward;
    }

    @Override
    public Reward getRewardByCustomerIdForCertainMonth(int customerId, int month) throws ParseException {
        List<Transaction> transactions = rewardDao.findByCustomerIdInCertainMonths(customerId, month);
        long rewardPoints = getRewardForMonth(transactions);
        Reward reward = new Reward();
        reward.setCustomerId(customerId);
        reward.setRewardPoints(rewardPoints);
        return reward;
    }

    private long calculateReward(Transaction t){
        if(t.getAmount()> Constants.rewardUnder100 && t.getAmount()<Constants.rewardAbove100){
            return Math.round(t.getAmount()-Constants.rewardUnder100);
        }else if(t.getAmount()>=Constants.rewardAbove100){
            return (Constants.rewardAbove100-Constants.rewardUnder100)+Math.round(t.getAmount()-Constants.rewardAbove100)*2;
        }else{
            return 0;
        }
    }

    private long getRewardForMonth(List<Transaction> transactionList){
        return transactionList.stream().map(t->calculateReward(t)).
                collect(Collectors.summingLong(reward->reward.longValue()));
    }
}
