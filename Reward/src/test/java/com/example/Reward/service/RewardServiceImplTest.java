package com.example.Reward.service;

import com.example.Reward.constant.Constants;
import com.example.Reward.dao.Impl.RewardDaoImpl;
import com.example.Reward.dao.RewardDaoImplTest;
import com.example.Reward.model.Transaction;
import com.example.Reward.service.Impl.RewardServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RewardServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(RewardServiceImpl.class);

    @Mock
    private RewardDaoImpl rewardDao;

    @InjectMocks
    private RewardServiceImpl rewardService = new RewardServiceImpl(rewardDao);

    List<Transaction> result;

    int customerId;

    int month;

    @Before
    public void setUp(){
        customerId = 2;
        month = 1;
        result = Collections.synchronizedList(new ArrayList<>());
        result.add(new Transaction(4,2,"2023-01-30",100));
    }

    @Test
    public void getRewardByCustomerIdTest() throws ParseException {
        log.info("RewardServiceImplTest - Inside getRewardByCustomerIdTest method");
        when(rewardDao.findByCustomerIdInCertainMonths(customerId, Constants.oneMonth)).thenReturn(result);
        assertEquals(50, rewardService.getRewardByCustomerId(customerId).getRewardPoints());
    }

    @Test
    public void getRewardByCustomerIdForCertainMonthTest() throws ParseException {
        log.info("RewardServiceImplTest - Inside getRewardByCustomerIdForCertainMonthTest method");
        when(rewardDao.findByCustomerIdInCertainMonths(customerId, month)).thenReturn(result);
        assertEquals(50, rewardService.getRewardByCustomerIdForCertainMonth(customerId, month).getRewardPoints());
    }
}
