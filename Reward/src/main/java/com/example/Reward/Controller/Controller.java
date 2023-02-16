package com.example.Reward.Controller;

import com.example.Reward.Service.RewardService;
import com.example.Reward.model.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RewardService rewardService;

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Reward> getRewardByCustomerId(@PathVariable("customerId")int customerId){
        Reward reward = rewardService.getRewardByCustomerId(customerId);
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }
}
