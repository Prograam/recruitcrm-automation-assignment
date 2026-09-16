# Recruit CRM Automation Assignment

This repository contains the UI automation framework that I built as part of the Recruit CRM Automation Assignment using **Java, Selenium WebDriver, TestNG, and Maven**. I followed the **Page Object Model (POM)** approach to keep the framework clean, reusable, and easy to maintain.

## Tech Stack

* Java 21
* Selenium WebDriver
* TestNG
* Maven
* Extent Reports
* Apache Commons IO

## What I Automated

I automated the following modules from the DemoQA application.

### Elements

* Text Box
* Check Box
* Radio Button
* Web Tables
* Buttons
* Dropdown

### Alerts, Frames & Windows

* Browser Windows
* JavaScript Alerts

### Interactions

* Drag & Drop
* Resizable
* Selectable
* Sortable

## Framework Features

* Page Object Model (POM)
* Reusable `BaseTest`
* Explicit Waits
* TestNG Suite execution
* Extent HTML Report generation
* Automatic screenshot capture on failed tests

## Reporting Validation

I created **11 automated test cases** for this assignment.

To verify that my reporting implementation was working correctly, I intentionally kept **1 test case failing**.

I did this to demonstrate that the framework correctly:

* Captures a screenshot automatically whenever a test fails.
* Saves the screenshot inside `test-output/screenshots/`.
* Attaches the screenshot to the Extent HTML Report.
* Logs the failure details and stack trace in the report.

This helped me verify that both the screenshot mechanism and the reporting functionality are working as expected.

## How to Run

Clone the repository.

```bash
git clone https://github.com/Prograam/recruitcrm-automation-assignment.git
```

Install dependencies.

```bash
mvn clean install
```

Run the complete TestNG suite.

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Reports

After execution, the Extent Report is generated here.

```text
test-output/ExtentReport.html
```

Failure screenshots are stored here.

```text
test-output/screenshots/
```

## Project Structure

```text
src
├── main
│   └── java
│       └── com.recruitcrm
│           ├── pages
│           └── utils
└── test
    └── java
        └── com.recruitcrm
            ├── base
            ├── reports
            └── tests
```

## GitHub Repository

Repository: `https://github.com/Prograam/recruitcrm-automation-assignment`

## Author

**Rohan Sahu**
