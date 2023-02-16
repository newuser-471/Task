package com.example.Reward.dao.Impl;

import com.example.Reward.constant.Constants;
import com.example.Reward.dao.RewardDao;
import com.example.Reward.model.Transaction;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RewardDaoImpl implements RewardDao {

    private static List<Transaction> transactionList = Collections.synchronizedList(new ArrayList<>());

    //mock data
    static {
        transactionList.add(new Transaction(1,1,"2023-01-31", 120));
        transactionList.add(new Transaction(2,1,"2022-12-31",90));
        transactionList.add(new Transaction(3,1,"2022-9-30",100));
        transactionList.add(new Transaction(4,2,"2023-01-30",100));
    }

    @Override
    public List<Transaction> findByCustomerIdInCertainMonths(Integer customerId, int mostRecentMonth) throws ParseException {
        LocalDate lb = null;
        LocalDate tmp = null;
        switch (mostRecentMonth){
            case 1:
                lb = LocalDate.now().minusDays(mostRecentMonth* Constants.oneMonth);
                break;
            case 2:
                tmp = LocalDate.now().minusDays(Constants.oneMonth);
                lb = tmp.minusDays(Constants.oneMonth);
                break;
            case 3:
                tmp = LocalDate.now().minusDays((mostRecentMonth-1)* Constants.oneMonth);
                lb = tmp.minusDays(Constants.oneMonth);
                break;
            default:
                lb = LocalDate.now().minusDays(3* Constants.oneMonth);
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date lowerBound = Date.from(lb.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date upperBound = tmp==null?new Date():Date.from(tmp.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<Transaction> result1 = transactionList.stream().filter(t->t.getCustomerId() == customerId).collect(Collectors.toList());
        return result1.stream().filter(t-> {
            try {
                return format.parse(t.getDate()).compareTo(lowerBound)>0 && format.parse(t.getDate()).compareTo(upperBound)<=0;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

}
