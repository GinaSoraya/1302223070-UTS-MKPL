package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private Gender gender;
	private Period period;
    private Salary salary;
    private Spouse spouse;
    private List<Child> child = new ArrayList<>();
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, Gender gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.gender = gender;
	}
	
    public void addChild(String childName, String childIdNumber) {
        child.add(new Child(childName, childIdNumber));
    }

    public Period getPeriod() {
        return period;
    }

    public Salary getSalary() {
        return salary;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public int getTotalChild() {
        return child.size();
    }
	
	public int getAnnualIncomeTax() {
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
