background: this is a SpringBoot application which is the answer to the assessment;
install: 
1, please open this project in IntelliJIdea or any Java IDE, IntelliJIdea will automatically load  all necessary dependency;
2, set run/debug configuration as application, and select RewardApplication.java as the main class, then you can run this project;
How to test:
It has mock data in dao layer, you can perform integration test on postman by entering https://localhost:port/endpoint + parameter
there are two API : get reward for a customer for certain month: "/" (path variable is customerId, and a request param is the number of month before now)and 
get reward for all passed three months: "/threeMonth/" (path variable is customerId).
Related Effort: MRAP proejct from FINRA
Maintainer: newuser-471
