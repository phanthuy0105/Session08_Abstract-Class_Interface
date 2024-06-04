package ra.javacore_abstraction.businessImp;

import ra.javacore_abstraction.business.IEmployee;
import ra.practice03_session06.entity.Product;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee implements IEmployee {
    private String employeeId;
    private String employeeName;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean employeeStatus;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, int year, float rate, float commission, float salary, boolean employeeStatus) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.salary = salary;
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public void inputData(Scanner scanner) {
        this.employeeId = inputEmployeeId(scanner);
        this.employeeName = inputEmployeeName(scanner);
        this.year = inputYear(scanner);
        this.rate = inputRate(scanner);
        this.commission = inputCommission(scanner);
        this.employeeStatus = inputEmployeeStatus(scanner);
    }

    public String inputEmployeeId(Scanner scanner) {
        System.out.println("Nhập vào mã nhân viên: ");
        return scanner.nextLine();
    }

    public String inputEmployeeName(Scanner scanner) {
        System.out.println("Nhập vào tên nhân viên: ");
        return scanner.nextLine();
    }

    public int inputYear(Scanner scanner) {
        System.out.println("Nhập vào năm sinh nhân viên: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public float inputRate(Scanner scanner) {
        System.out.println("Nhập vào hệ số lương nhân viên: ");
        return Float.parseFloat(scanner.nextLine());
    }

    public float inputCommission(Scanner scanner) {
        System.out.println("Nhập vào hoa hồng của nhân viên hàng tháng: ");
        return Float.parseFloat(scanner.nextLine());
    }

    public boolean inputEmployeeStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái nhân viên: ");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    public void calSalary() {
        this.salary = this.rate * BASIC_SALARY + this.commission;
    }
    public void displayData() {
        System.out.printf("Employee ID: %s - Employee Name: %s - Year: %d - Rate: %.2f \n", this.employeeId, this.employeeName, this.year, this.rate);
        System.out.printf("Commission: %.2f - Salary: %.2f - Employee Status: %s\n", this.commission, this.salary, this.employeeStatus ? "Đang làm việc" : "Nghỉ việc");
    }
}
