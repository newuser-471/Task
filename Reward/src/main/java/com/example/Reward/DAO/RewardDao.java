package com.example.Reward.DAO;

import com.example.Reward.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RewardDao {

    private static List<Transaction> transactionList = new ArrayList<>();

    //mock data
    static {
        transactionList.add(new Transaction(1,1,new Date(2023,1,31), 120));
        transactionList.add(new Transaction(2,1,new Date(2022,12,31),90));
        transactionList.add(new Transaction(3,1,new Date(2022,9,30),100));
        transactionList.add(new Transaction(4,2,new Date(2022,12,30),100));
    }

    public List<Transaction> findByCustomerIdInCertainMonths(Integer customerId, int daysSetOff){
        LocalDate thresh = LocalDate.now().minusDays(daysSetOff);
        Date threshold = Date.from(thresh.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<Transaction> result1 = transactionList.stream().filter(t->t.getCustomerId() == customerId).collect(Collectors.toList());
        return result1.stream().filter(t->t.getDate().compareTo(threshold)>0).collect(Collectors.toList());
    }

}
