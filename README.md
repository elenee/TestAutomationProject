# FINAL PROJECT: TEST AUTOMATION

---

## KETEVANI SAMUKASHVILI

### API Test Cases
- GetAllProductsListTest  
- POSTToAllProductsListTest  

### UI Test Cases
- LogoutUserTest  
- VerifyProductQuantityTest  

---

## ELENE RAINAULI

### API Test Cases
- GetUserAccountDetailByEmailTest  
- POSTToVerifyLoginWithInvalidDetailsTest  

### UI Test Cases
- RegisterUserTest  
- LoginUserWithCorrectEmailAndPasswordTest  

---

## BARBARE KUKISHVILI

### API Test Cases
- GetAllBrandsListTest  
- PUTToAllBrandsListTest  

### UI Test Cases
- ContactUsFormTest  
- SearchProductTest  

---

## BAKARI AKHVLEDIANI

### API Test Cases
- POSTToSearchProductTest  
- POSTToSearchProductWithoutParameterTest  

### UI Test Cases
- VerifyTestCasesPageTest  
- VerifySubscriptionOnHomePageTest  

---

## NIKA CHKHUTIASHVILI

### API Test Cases
- VerifyLoginWithValidDetailsTest  
- VerifyLoginWithoutEmailTest  

### UI Test Cases
- AddReviewOnProductTest  
- ViewAndCartBrandProductsTest  

---

# HOW TO RUN THE PROJECT

## Prerequisites
- Java JDK 21+
- Maven 3+
- TestNG
- Chrome or Firefox (for UI tests)
- Internet connection (for API execution)
- Allure Commandline installed

---

## Run All Tests

From the project root directory:

```bash
mvn clean test
```

Generate Allure Report

After executing the tests:
```bash
allure serve target/allure-results
```

