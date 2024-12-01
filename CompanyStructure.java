import java.util.ArrayList; // Import ArrayList class for team lists

/**
 * Abstract base class representing a generic Employee in the company.
 * Provides common attributes and methods for all employee types.
 */
abstract class Employee {
    // Private attributes to encapsulate employee details
    private String name;           // Employee's name
    private double baseSalary;     // Base salary of the employee
    private int employeeID;        // Unique identifier for each employee
    
    // Static counter to generate unique employee IDs
    private static int idCounter = 1;

    /**
     * Constructor to create a new Employee
     * @param name Employee's name
     * @param baseSalary Employee's base salary
     */
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.employeeID = idCounter++; // Automatically increment ID for each new employee
    }

    // Getter methods to access private attributes
    public double getBaseSalary() {
        return baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Provides a detailed status of the employee
     * @return String representation of employee status
     */
    public String employeeStatus() {
        return this.toString() + " with a salary of " + this.baseSalary;
    }

    /**
     * Overrides toString() to provide a simple string representation
     * @return String with employee ID and name
     */
    @Override
    public String toString() {
        return employeeID + " " + name;
    }
}

/**
 * Represents a Software Engineer in the company.
 * Extends the base Employee class with additional attributes specific to software engineers.
 */
class SoftwareEngineer extends Employee {
    // Boolean to track code access permission
    private boolean codeAccess;

    /**
     * Constructor for Software Engineer with a predefined base salary
     * @param name Software Engineer's name
     */
    public SoftwareEngineer(String name) {
        super(name, 70000); // Default base salary for software engineers
        this.codeAccess = false; // Initially, no code access
    }

    // Getter and setter for code access
    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    /**
     * Checks if the software engineer can check in code
     * @return boolean indicating code check-in status
     */
    public boolean checkInCode() {
        return this.codeAccess; // Simplified code check-in status
    }

    /**
     * Overrides employeeStatus to provide role-specific status
     * @return Detailed status including role
     */
    @Override
    public String employeeStatus() {
        return super.employeeStatus() + " as a Software Engineer.";
    }
}

/**
 * Represents a Technical Lead who manages a team of Software Engineers.
 * Extends the base Employee class with team management capabilities.
 */
class TechnicalLead extends Employee {
    // Maximum number of engineers the technical lead can manage
    private int headCount;
    // List to store the team of software engineers
    private ArrayList<SoftwareEngineer> team;

    /**
     * Constructor for Technical Lead with predefined base salary and team capacity
     * @param name Technical Lead's name
     */
    public TechnicalLead(String name) {
        super(name, 100000); // Default base salary for technical leads
        this.headCount = 4;  // Maximum team size
        this.team = new ArrayList<>();
    }

    /**
     * Checks if the technical lead can add more team members
     * @return boolean indicating if there's available headcount
     */
    public boolean hasHeadCount() {
        return team.size() < headCount;
    }

    /**
     * Adds a software engineer to the team
     * @param e Software Engineer to be added
     * @return boolean indicating successful addition
     */
    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            team.add(e);
            return true;
        }
        return false;
    }

    /**
     * Generates a status report of the team
     * @return String detailing the technical lead and their team
     */
    public String getTeamStatus() {
        StringBuilder status = new StringBuilder(employeeStatus() + " managing the following engineers:\n");
        for (SoftwareEngineer e : team) {
            status.append(" - ").append(e.employeeStatus()).append("\n");
        }
        return status.toString();
    }

    /**
     * Overrides employeeStatus to provide role-specific status
     * @return Detailed status including role
     */
    @Override
    public String employeeStatus() {
        return super.employeeStatus() + " as a Technical Lead.";
    }
}

/**
 * Represents an Accountant who supports a Technical Lead's team.
 * Extends the base Employee class with team support capabilities.
 */
class Accountant extends Employee {
    // The Technical Lead whose team this Accountant supports
    private TechnicalLead teamSupported;

    /**
     * Constructor for Accountant with predefined base salary
     * @param name Accountant's name
     */
    public Accountant(String name) {
        super(name, 85000); // Default base salary for accountants
    }

    /**
     * Gets the Technical Lead team currently supported
     * @return TechnicalLead currently supported
     */
    public TechnicalLead getTeamSupported() {
        return teamSupported;
    }

    /**
     * Assigns the Accountant to support a specific Technical Lead's team
     * @param lead TechnicalLead to support
     */
    public void supportTeam(TechnicalLead lead) {
        this.teamSupported = lead;
    }

    /**
     * Overrides employeeStatus to provide role-specific status
     * @return Detailed status including supported team
     */
    @Override
    public String employeeStatus() {
        return super.employeeStatus() + " supporting " + (teamSupported != null ? teamSupported.getName() : "no team");
    }
}

/**
 * Represents a Business Lead who manages a team of Accountants.
 * Extends the base Employee class with team management capabilities.
 */
class BusinessLead extends Employee {
    // Maximum number of accountants the business lead can manage
    private int headCount;
    // List to store the team of accountants
    private ArrayList<Accountant> team;

    /**
     * Constructor for Business Lead with predefined base salary and team capacity
     * @param name Business Lead's name
     */
    public BusinessLead(String name) {
        super(name, 120000); // Default base salary for business leads
        this.headCount = 5;  // Maximum team size
        this.team = new ArrayList<>();
    }

    /**
     * Checks if the business lead can add more team members
     * @return boolean indicating if there's available headcount
     */
    public boolean hasHeadCount() {
        return team.size() < headCount;
    }

    /**
     * Adds an accountant to the team and assigns them to support a technical lead
     * @param e Accountant to be added
     * @param supportTeam TechnicalLead to be supported
     * @return boolean indicating successful addition
     */
    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (hasHeadCount()) {
            team.add(e);
            e.supportTeam(supportTeam);
            return true;
        }
        return false;
    }

    /**
     * Generates a status report of the team
     * @return String detailing the business lead and their team
     */
    public String getTeamStatus() {
        StringBuilder status = new StringBuilder(employeeStatus() + " managing the following accountants:\n");
        for (Accountant a : team) {
            status.append(" - ").append(a.employeeStatus()).append("\n");
        }
        return status.toString();
    }

    /**
     * Overrides employeeStatus to provide role-specific status
     * @return Detailed status including role
     */
    @Override
    public String employeeStatus() {
        return super.employeeStatus() + " as a Business Lead.";
    }
}

/**
 * Main class to demonstrate the company structure and relationships
 * between different employee types.
 */
public class CompanyStructure {
    public static void main(String[] args) {
        // Create Technical Leads and their teams
        TechnicalLead CTO = new TechnicalLead("Satya Nadella");
        SoftwareEngineer seA = new SoftwareEngineer("Kasey");
        SoftwareEngineer seB = new SoftwareEngineer("Breana");
        SoftwareEngineer seC = new SoftwareEngineer("Eric");

        // Add software engineers to CTO's team
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);

        // Print CTO's team status
        System.out.println(CTO.getTeamStatus());

        // Create another Technical Lead and team
        TechnicalLead VPofENG = new TechnicalLead("Bill Gates");
        SoftwareEngineer seD = new SoftwareEngineer("Winter");
        SoftwareEngineer seE = new SoftwareEngineer("Libby");
        SoftwareEngineer seF = new SoftwareEngineer("Gizan");
        SoftwareEngineer seG = new SoftwareEngineer("Zaynah");

        // Add software engineers to VP of Engineering's team
        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);

        // Print VP of Engineering's team status
        System.out.println(VPofENG.getTeamStatus());

        // Create Business Lead and Accountants
        BusinessLead CFO = new BusinessLead("Amy Hood");
        Accountant actA = new Accountant("Niky");
        Accountant actB = new Accountant("Andrew");

        // Assign accountants to support different technical leads
        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);

        // Print Business Lead's team status
        System.out.println(CFO.getTeamStatus());
    }
}