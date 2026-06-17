Cyber Security Awareness Training Platform

Overview

The Cyber Security Awareness Training Platform is a Java-based desktop application developed using Java Swing and MySQL. The platform is designed to educate users about cybersecurity threats and best practices through interactive training modules, quizzes, and certification.

Users can register, log in, complete cybersecurity training modules, take quizzes, view their results, and generate certificates upon successful completion.


Features

User Features

- User Registration
- User Login Authentication
- Interactive Cybersecurity Training Modules
- Quiz Assessment System
- Automatic Score Calculation
- Result Tracking
- Certificate Generation
- User-Friendly Dashboard

Admin Features

- Add Training Modules
- Manage Quiz Questions
- View User Results
- Monitor Platform Activities



Training Modules

1. Password Security
2. Phishing Awareness
3. Malware Awareness
4. Social Engineering
5. Safe Browsing Practices


Technologies Used

Frontend

- Java Swing
- AWT

Backend

- Java

Database

- MySQL

Connectivity

- JDBC (MySQL Connector)

Development Environment

- Apache NetBeans IDE
- JDK 17 or Higher



Project Structure

CyberSecurityAwarenessPlatform

├── DBConnection.java
├── Main.java
├── Session.java

├── LoginPage.java
├── RegisterPage.java
├── Dashboard.java

├── ModuleViewer.java
├── QuizPage.java
├── ResultPage.java

├── AdminDashboard.java
├── ModuleManager.java
├── QuestionManager.java
├── ResultsViewer.java

├── CertificateGenerator.java

├── Theme.java
├── ImagePanel.java
├── StyledButton.java

└── images/



Database Tables

users

- id
- fullname
- email
- password

modules

- id
- title
- content

questions

- id
- module_id
- question
- option1
- option2
- option3
- option4
- correct_answer

results

- id
- user_id
- module_id
- score
- total_questions

---

Installation and Setup

Step 1: Clone Repository

git clone https://github.com/yourusername/CyberSecurityAwarenessPlatform.git

Step 2: Open Project

Open the project in Apache NetBeans IDE.

Step 3: Configure MySQL

Create a database named:

CREATE DATABASE cyberdb;

Import the SQL schema and sample data.

Step 4: Add MySQL JDBC Driver

Add:

mysql-connector-j-8.x.x.jar

to the project's Libraries section.

Step 5: Update Database Credentials

In DBConnection.java:

String url = "jdbc:mysql://localhost:3306/cyberdb";
String username = "root";
String password = "your_password";

Step 6: Run Project

Run:

Main.java





Future Enhancements

- Web-based version using Spring Boot
- AI-powered learning recommendations
- Real-time phishing simulations
- PDF certificate generation
- Cloud database integration
- Mobile application support
- Progress analytics dashboard
- Gamification and leaderboards



Advantages

- Easy-to-use interface
- Interactive learning experience
- Automated assessments
- Certificate generation
- Secure data storage using MySQL
- Expandable architecture


Author

Keerthana K G

Bachelor of Engineering (Information Science & Engineering)

Cyber Security Awareness Training Platform – Major Project
