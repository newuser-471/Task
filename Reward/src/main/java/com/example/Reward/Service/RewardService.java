package com.example.Reward.Service;

import com.example.Reward.Constants.Constants;
import com.example.Reward.DAO.RewardDao;
import com.example.Reward.entity.Transaction;
import com.example.Reward.model.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardService {

    @Autowired
    private RewardDao rewardDao;

    public Reward getRewardByCustomerId(int customerId){
        List<Transaction> transactions = rewardDao.findByCustomerIdInCertainMonths(customerId, Constants.threeMonthsPeriod);
        long rewardPoints = getRewardForThreeMonths(transactions);
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
            return 0l;
        }
    }

    private long getRewardForThreeMonths(List<Transaction> transactionList){
        return transactionList.stream().map(t->calculateReward(t)).
                collect(Collectors.summingLong(reward->reward.longValue()));
    }
}
