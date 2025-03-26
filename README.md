# 🚀 Project Name

## 📌 Table of Contents
- [Introduction](#introduction)
- [Demo](#demo)
- [Inspiration](#inspiration)
- [What It Does](#what-it-does)
- [How We Built It](#how-we-built-it)
- [Challenges We Faced](#challenges-we-faced)
- [How to Run](#how-to-run)
- [Tech Stack](#tech-stack)
- [Team](#team)

---

## 🎯 Introduction
Regulatory reporting in the banking sector involves compiling vast amounts of data to meet
compliance requirements.
Data profiling is a critical part of this process, ensuring that reported data aligns with regulatory
requirements.
Traditionally, this process is manual and time-consuming. This solution automates data profiling
using Generative AI (LLMs) and unsupervised machine learning

## 🎥 Demo
🔗 [Live Demo](#) (if applicable)  
📹 [Video Demo](#) (if applicable)  
🖼️ Screenshots:

![Screenshot 1](link-to-image)

## 💡 Inspiration
Manual data profiling is labor-intensive and prone to human error. Automating this process using AI
reduces errors, increases efficiency, and ensures compliance with complex regulatory requirements.

## ⚙️ What It Does
- Generates profiling rules based on transaction data and banking regulations.
- Calculates adaptive risk scores using unsupervised machine learning techniques.
- Detects potential violations and suggests remediation actions using a chatbot.

## 🛠️ How We Built It
- Backend: Java Spring Boot (Gradle) with RESTful APIs.
- Frontend: React.js with state management.
- Profiling Engine: LLM-based rule generation and risk scoring.
- Chatbot: Suggests remediation actions based on profiling results

## 🚧 Challenges We Faced
- Handling large transaction data efficiently.
- Defining accurate profiling rules.
- Generating meaningful remediation suggestions using LLMs.

## 🏃 Project
📂 genai-data-profiling
├── 📂 backend
│   ├── 📂 src
│   │   ├── 📂 main
│   │   │   ├── 📂 java
│   │   │   │   ├── 📂 com.example.profiling
│   │   │   │       ├── DataProfilingApplication.java
│   │   │   │       ├── controller
│   │   │   │       │   ├── ProfilingController.java
│   │   │   │       ├── model
│   │   │   │       │   ├── Transaction.java
│   │   │   │       ├── service
│   │   │   │       │   ├── ProfilingService.java
│   │   │   │       ├── util
│   │   │   │       │   ├── RuleGenerator.java
│   │   │   │       │   ├── RiskScorer.java
├── 📂 frontend
│   ├── 📂 src
│   │   ├── 📂 components
│   │   │   ├── DataDisplay.js
│   │   │   ├── Chatbot.js
│   │   ├── 📂 services
│   │   │   ├── api.js
│   │   ├── App.js
├── build.gradle
├── settings.gradle
├── README.md
```
## Testing:
Test Endpoints Using Postman
Test data:
Transaction ID	Amount	Currency	Country	Status	Account Type	Transaction Type	Date	Customer Age
T001	15000	USD	US	Completed	Savings	Transfer	2025-03-10	70
T002	-500	EUR	DE	Failed	Checking	Withdrawal	2025-03-12	35
T003	3000	GBP	UK	Pending	Savings	Deposit	2025-03-14	40
T004	12000	USD	US	Completed	Checking	Transfer	2025-03-16	65
T005	-100	EUR	FR	Failed	Savings	Withdrawal	2025-03-18	28

GET Request – Fetch Profiling Results
Example Response:
[
  {
    "transactionId": "T001",
    "amount": 15000,
    "currency": "USD",
    "country": "US",
    "riskScore": 1.0,
    "violation": "Large transaction"
  },
  {
    "transactionId": "T002",
    "amount": -500,
    "currency": "EUR",
    "country": "DE",
    "riskScore": 1.0,
    "violation": "Negative amount"
  },
  {
    "transactionId": "T003",
    "amount": 3000,
    "currency": "GBP",
    "country": "UK",
    "riskScore": 0.1,
    "violation": "None"
  },
  {
    "transactionId": "T004",
    "amount": 12000,
    "currency": "USD",
    "country": "US",
    "riskScore": 1.0,
    "violation": "Large transaction"
  },
  {
    "transactionId": "T005",
    "amount": -100,
    "currency": "EUR",
    "country": "FR",
    "riskScore": 1.0,
    "violation": "Negative amount"
  }
]



GET http://localhost:8080/api/profiling/results
[
  {
    "transactionId": "T001",
    "riskScore": 1.0,
    "violation": "Large transaction",
    "suggestedRemediation": "Review the transaction details and verify with the customer."
  },
  {
    "transactionId": "T002",
    "riskScore": 1.0,
    "violation": "Negative amount",
    "suggestedRemediation": "Check for input errors or potential fraud."
  },
  {
    "transactionId": "T003",
    "riskScore": 0.1,
    "violation": "None",
    "suggestedRemediation": "No action needed."
  }
]
Sample Remediation Suggestions (Chatbot)
POST http://localhost:8080/api/profiling/remediation
Request:
{
  "transactionId": "T001",
  "violation": "Large transaction"
}

Response:
{
  "transactionId": "T001",
  "violation": "Large transaction"
}


## 🏗️ Tech Stack
Component	Technology Used
Backend:	Java 17, Spring Boot, Gradle
Frontend:	React.js, JavaScript, Tailwind CSS
AI/ML:	Generative AI (LLMs), Unsupervised Machine Learning
Data Handling:	CSV file input and processing
API Testing	Postman
Version Control	Git

## 👥 Team
- **Your Name** - [GitHub](#) | [LinkedIn](#)
- **Teammate 2** - [GitHub](#) | [LinkedIn](#)