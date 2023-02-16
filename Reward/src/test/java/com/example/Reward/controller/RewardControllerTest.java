package com.example.Reward.controller;

import com.example.Reward.dao.RewardDaoImplTest;
import com.example.Reward.model.Reward;
import com.example.Reward.service.Impl.RewardServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RewardControllerTest {

    private static final Logger log = LoggerFactory.getLogger(RewardDaoImplTest.class);

    @Mock
    private RewardServiceImpl rewardService;

    @InjectMocks
    private RewardController rewardController = new RewardController(rewardService);

    private int customerId;

    private int month;

    private ResponseEntity response;

    private Reward reward;

    @Before
    public void setUp(){
        customerId = 1;
        month = 2;
        reward = new Reward();
        reward.setCustomerId(1);
        reward.setRewardPoints(130);
        response = new ResponseEntity(reward, HttpStatus.OK);
    }

    @Test
    public void getRewardByCustomerIdTest() throws ParseException {
        log.info("RewardControllerTest - Inside getRewardByCustomerIdTest method");
        when(rewardService.getRewardByCustomerId(customerId)).thenReturn(reward);
        assertEquals(response, rewardController.getRewardByCustomerId(customerId));
    }

    @Test
    public void getRewardByCustomerIdForCertainMonthTest() throws ParseException {
        log.info("RewardControllerTest - Inside getRewardByCustomerIdForCertainMonthTest method");
        when(rewardService.getRewardByCustomerIdForCertainMonth(customerId, month)).thenReturn(reward);
        assertEquals(response, rewardController.getRewardByCustomerIdForCertainMonth(customerId, month));
    }

}
