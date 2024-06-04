package ra.javacore_abstraction.business;

import java.util.Scanner;

public interface IEmployee {
    Scanner scanner = new Scanner(System.in);
    float BASIC_SALARY = 1300000;
    void inputData(Scanner scanner);
    void displayData();
}
