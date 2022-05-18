### Clone and Build Application
1. Clone repository from Git, and make sure all the dependencies are up-to-date:
Run `./gradlew clean build` to build the application

### Access Running Test
Running tests are simple you should go the Path 
   1. For controller tests navigate or run from console: ATMControllerTest.java
   2. For services tests navigate or run from console: ATMServicesTest.java
Each test case is list in Numerical Order to make it easier to read.

Tested the controller and service by testing the HTTP status of the API and how data was getting treated by the methods. 

### Accessing API Json
Go to on your browser `https://api.lloydsbank.com/open-banking/v2.2/atms`

### Run The Application 
Running the application is simple you can go to the path or user your IDE to run it
1. Click run in OpenBankApplication.class 
2. Navigate to http://localhost:8080/atms?identification= $User Identification$ e.g., (LFFFAC11) 


### Test Results
Navigate to your browser $USER$/JF-open-banking-app/build/reports/tests/test/index.html
