package com.example.Reward.controller;

import com.example.Reward.service.RewardService;
import com.example.Reward.model.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class RewardController {

    private RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService){
        this.rewardService = rewardService;
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Reward> getRewardByCustomerId(@PathVariable("customerId")int customerId) throws ParseException {
        Reward reward = rewardService.getRewardByCustomerId(customerId);
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }

    @GetMapping(value = "/{customerId}/{month}")
    public ResponseEntity<Reward> getRewardByCustomerIdForCertainMonth(@PathVariable("customerId")int customerId, @PathVariable("month")int month) throws ParseException {
        Reward reward = rewardService.getRewardByCustomerIdForCertainMonth(customerId, month);
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }

}
