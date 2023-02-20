# Reward Points Calculator based on transaction
#The SpringBoot application to get customer rewards based on customer Id and specific month

#A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.   A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).   Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total. 

- The package name is structured as com.example.Reward
- This application is the implementation of the reward calculator
- The application provide two API for user: one to search for total reward for three month period, one to search reward for specific one month
- Thread safe list stored mocked data in dao layer
- No need to install additional database for integration test
- Project can be open on IntelliJIdea
- Please check https://github.com/newuser-471/Task/blob/main/Instruction.pdf to install and run the application
- Unit test can be found in https://github.com/newuser-471/Task/tree/main/Reward/src/test/java/com/example/Reward
- The application is integrated with Jacoco, please right click java folded under test folder and click "Run All Tests with Coverage" to see test result and code coverage
- Following are two endpoints to search reward with customerId, Please provide a request parameter as "month" with integer 1-3 for second endpoint to search reward of a specific month 
```
 http://localhost:8080/threeMonth/{customerId}
```
```
 http://localhost:8080/{customerId}
```
- Please perform integration test on postman following the instruciton on https://github.com/newuser-471/Task/blob/main/Instruction.pdf
