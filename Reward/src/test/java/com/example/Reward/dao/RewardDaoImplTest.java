package com.example.Reward.dao;

import com.example.Reward.dao.Impl.RewardDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RewardDaoImplTest {

    private static final Logger log = LoggerFactory.getLogger(RewardDaoImplTest.class);

    private RewardDaoImpl rewardDao;

    @Before
    public void setUp(){
        rewardDao = new RewardDaoImpl();
    }

    @Test
    public void findByCustomerIdInCertainMonthsTest() throws ParseException {
        log.info("RewardDaoImplTest - Inside findByCustomerIdInCertainMonthsTest method");
        int customerId = 1;
        int month = 1;
        assertEquals(1, rewardDao.findByCustomerIdInCertainMonths(customerId, month).size());
    }
}
