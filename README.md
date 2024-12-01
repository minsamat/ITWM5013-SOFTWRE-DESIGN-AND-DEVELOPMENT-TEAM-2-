 Company Structure Management System

 Overview

 This Java project provides a flexible and extensible object-oriented model for managing a company's organizational structure. It demonstrates core Object-Oriented Programming (OOP) principles such as inheritance, encapsulation, and polymorphism through a hierarchical employee management system.

Project Structure

The project consists of several interconnected classes that represent different roles within a typical technology company:

- `Employee` (Abstract Base Class)
- `SoftwareEngineer`
- `TechnicalLead`
- `Accountant`
- `BusinessLead`

 Key Features

 Employee Management
- Automatic unique ID generation for employees
- Base salary tracking
- Role-specific status reporting

 Team Composition
- Technical Leads can manage up to 4 Software Engineers
- Business Leads can manage up to 5 Accountants
- Accountants can be assigned to support specific Technical Lead teams

 Class Relationships

```
       Employee (Abstract)
       /     |     \     \
      /      |      \     \
SoftwareEngineer  TechnicalLead  Accountant  BusinessLead
```

 Core Functionality

- Dynamic team creation and management
- Hierarchical reporting structure
- Team status reporting
- Salary and role tracking

 Design Principles

- **Inheritance**: Demonstrates how specialized employee types extend the base `Employee` class
- **Encapsulation**: Uses private fields with public getter/setter methods
- **Polymorphism**: Implements method overriding for specialized status reporting

 Getting Started

 Prerequisites
- Java Development Kit (JDK) 8 or higher
- A Java IDE or text editor

 Running the Project
1. Clone the repository
2. Compile the Java files
3. Run the `CompanyStructure` class

#Example Usage

```java
// Create a Technical Lead
TechnicalLead CTO = new TechnicalLead("Satya Nadella");

// Add Software Engineers to the team
SoftwareEngineer engineer1 = new SoftwareEngineer("John Doe");
CTO.addReport(engineer1);

// Print team status
System.out.println(CTO.getTeamStatus());
```

 Potential Improvements
- Add more robust error handling
- Implement salary calculation methods
- Create interfaces for more flexible role definitions
- Add more advanced team management features

 Contributing
Contributions, issues, and feature requests are welcome. Feel free to check [issues page](your-repo-issues-link).

 License
Free

 Author
Dato Terry (MC240929424) 
Boss Nazir  (MC240930323)
Min (MC240930137)


 Acknowledgments
- Inspired by real-world organizational structures
- Demonstrates key Object-Oriented Programming concepts
