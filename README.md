# 4357_SDET
📌 Project Overview

This project automates the testing of an e-commerce website (Tutorials Ninja) using Selenium WebDriver with Java and TestNG. The automation covers critical functionalities like user authentication, product search, adding to cart, checkout process, and order validation. The Page Object Model (POM) design pattern is used to enhance maintainability and modularity.

📂 Project Structure

E-Commerce-Automation/
│-- src/main/java/PageObjectModel/
│   │-- Login.java
│   │-- RegisterPage.java
│   │-- ProductPage.java
│   │-- CartPage.java
│   │-- Checkout.java
│-- src/test/java/Test/
│   │-- LoginTest.java
│   │-- RegisterTest.java
│   │-- CheckoutTest.java
│-- testng.xml
│-- pom.xml
│-- README.md

🔧 Technologies Used

Java (Programming Language)

Selenium WebDriver (UI Automation)

TestNG (Test Execution Framework)

Maven (Dependency Management)

Page Object Model (POM) (For Better Maintainability)

🚀 Features Automated

🔹 User Authentication

Valid and invalid login test cases

New user registration with form validation

🔹 Product Search & Selection

Searching for a product and verifying results

Sorting products based on different criteria

Selecting a product from the homepage

🔹 Cart & Checkout Process

Adding products to the cart and verifying them

Applying promo codes and validating discounts

Handling out-of-stock scenarios

Completing the checkout process

⚙️ Setup & Installation

Prerequisites:

Install Java JDK (17 or above)

Install Eclipse/IntelliJ (IDE)

Install Maven

Download ChromeDriver (Ensure compatibility with Chrome version)

Clone the Repository:

git clone https://github.com/yourusername/e-commerce-automation.git
cd e-commerce-automation

Install Dependencies:

mvn clean install

Run Tests using TestNG:

mvn test

Or execute tests using TestNG XML:

Right-click on testng.xml -> Run As -> TestNG Suite

📝 Test Execution

Run Specific Tests

Run Login Test: mvn test -Dtest=LoginTest

Run Checkout Test: mvn test -Dtest=CheckoutTest

Test Reports

Test reports are generated in target/surefire-reports/. Use Extent Reports or Allure for better visualization.

🐞 Test Summary & Bugs

Module

Total Test Cases

Passed

Failed

Major Bugs

Minor Bugs

Environment

Registration and Login

28

20

8

8

0

Browser: Chrome

Search

10

6

4

2

2

Browser: Chrome

Order History

10

7

3

1

2

Browser: Chrome

Checkout

7

4

3

2

1

Browser: Chrome

Cart Management

8

6

2

1

1

Browser: Chrome

Account Management

10

7

3

3

0

Browser: Chrome

Promo-Codes and Discounts

10

8

2

0

2

Browser: Chrome

Mobile and Cross-browser Compatibility

8

6

2

0

2

Mobile

Security Features

5

4

1

1

0

Browser: Chrome

Multi-Currency Support

5

4

1

1

0

Browser: Chrome


🔹 Happy Testing! 🚀
