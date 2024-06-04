package ra.javacore_abstraction.presentation;

import ra.javacore_abstraction.businessImp.Employee;
import ra.practice03_session06.entity.Product;

import java.util.Collection;
import java.util.Scanner;

public class EmployeeManagement {
    //Khởi tạo mảng gồm 100 nhân viên để lưu trữ thông tin các nhân viên quản lý
    Employee[] arrEmployee = new Employee[1000];
    //Biến lưu trữ chỉ số nhân viên nhỏ nhất chưa chứa dữ liệu
    int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagement employeeManagement = new EmployeeManagement();
        //In menu và thực hiện các chức năng theo menu
        do {
            System.out.println("**************MENU****************");
            System.out.println("1. Nhập thông tin cho n nhân viên");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Tính lương cho các nhân viên");
            System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Xóa nhân viên theo mã nhân viên");
            System.out.println("7. Sắp xếp nhân viên theo lương tăng dần");
            System.out.println("8. Sắp xếp nhân viên theo tên nhân viên giảm dần");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeManagement.inputListEmployee(scanner);
                    break;
                case 2:
                    employeeManagement.displayListEmployee();
                    break;
                case 3:
                    employeeManagement.displaySalary();
                    employeeManagement.displayListEmployee();
                    break;
                case 4:
                    employeeManagement.searchEmployeeByName(scanner);
                    break;
                case 5:
                    employeeManagement.updateEmployee(scanner);
                    employeeManagement.displayListEmployee();
                    break;
                case 6:
                    employeeManagement.deleteEmployee(scanner);
                    employeeManagement.displayListEmployee();
                    break;
                case 7:
                    employeeManagement.sortSalary();
                    employeeManagement.displayListEmployee();
                    break;
                case 8:
                    employeeManagement.sortName();
                    employeeManagement.displayListEmployee();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-9");
            }
        } while (true);
    }

    // 1. Nhập thông tin n nhân viên (n nhập từ bàn phím)
    public void inputListEmployee(Scanner scanner) {
        System.out.println("Nhập số nhân viên cần nhập thông tin: ");
        int numberOfEmployee = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfEmployee; i++) {
            //1. Khởi tạo phần tử currentIndex là 1 đối tượng nhân viên
            arrEmployee[currentIndex] = new Employee();
            //2. Gọi inputData() để nhập liệu
            arrEmployee[currentIndex].inputData(scanner);
            //3. tăng currentIndex
            currentIndex++;
        }
        System.out.println("\n");
    }

    // 2. Hiển thị thông tin nhân viên
    public void displayListEmployee() {
        System.out.println("Thông tin nhân viên");
        for (int i = 0; i < currentIndex; i++) {
            arrEmployee[i].displayData();
        }
        System.out.println("\n");
    }

    // 3. Tính lương cho các nhân viên
    public void displaySalary() {
        System.out.println("Lương cho các nhân viên");
        for (int i = 0; i < currentIndex; i++) {
            arrEmployee[i].calSalary();
        }
    }

    // 4. Tìm kiếm nhân viên theo tên nhân viên
    public void searchEmployeeByName(Scanner scanner) {
        System.out.println("Nhập vào tên nhân viên cần tìm:");
        String productNameSearch = scanner.nextLine();
        //Tìm gần đúng
        System.out.println("KẾT QUẢ TÌM KIẾM:");
        for (int i = 0; i < currentIndex; i++) {
            if (arrEmployee[i].getEmployeeName().toLowerCase().contains(productNameSearch.toLowerCase())) {
                arrEmployee[i].displayData();
            }
        }
    }

    public int getIndexByIdEmployee(String employeeId) {
        for (int i = 0; i < currentIndex; i++) {
            if (arrEmployee[i].getEmployeeId().equals(employeeId)) {
                return i;
            }
        }
        return -1;
    }

    public void updateEmployee(Scanner scanner) {
        System.out.println("Nhập vào mã nhân viên cần cập nhật thông tin:");
        String employeeIdUpdate = scanner.nextLine();
        //1. Tìm phần tử cần cập nhât trong mảng (chỉ số phần tử cần cập nhật)
        int indexEmployeeUpdate = getIndexByIdEmployee(employeeIdUpdate);
        //2. Nếu tồn tại thực hiện cập nhật danh mục (trừ mã danh mục)
        if (indexEmployeeUpdate >= 0) {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên của nhân viên");
                System.out.println("2. Cập nhật năm sinh của nhân viên");
                System.out.println("3. Cập nhật hệ số lương của nhân viên");
                System.out.println("4. Cập nhật hoa hồng của nhân viên theo tháng");
                System.out.println("5. Cập nhật trạng thái của nhân viên");
                System.out.println("6. Thoát");
                System.out.print("Lưa chọn của bạn: ");
                int choiceUpdate = Integer.parseInt(scanner.nextLine());
                switch (choiceUpdate) {
                    case 1:
                        System.out.println("Nhập vào tên nhân viên cần cập nhập:");
                        arrEmployee[indexEmployeeUpdate].setEmployeeName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào năm sinh nhân viên cần cập nhật:");
                        arrEmployee[indexEmployeeUpdate].setYear(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập vào hệ số lương nhân viên cần cập nhật:");
                        arrEmployee[indexEmployeeUpdate].setRate(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.println("Nhập vào hoa hồng của nhân viên theo tháng cần cập nhật:");
                        arrEmployee[indexEmployeeUpdate].setCommission(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Nhập vào trạng thái nhân viên cần cập nhật:");
                        arrEmployee[indexEmployeeUpdate].setEmployeeStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 6:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-6");
                }
            } while (isExit);
        } else {
            System.err.println("Mã nhân viên không tồn tại");
        }
    }

    public void deleteEmployee(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần xóa:");
        String employeeIdDelete = scanner.nextLine();
        int indexEmployeeDelete = getIndexByIdEmployee(employeeIdDelete);
        if (indexEmployeeDelete >= 0) {
            for (int i = indexEmployeeDelete; i < currentIndex - 1; i++) {
                arrEmployee[i] = arrEmployee[i + 1];
            }
            arrEmployee[currentIndex - 1] = null;
            currentIndex--;
        } else {
            System.err.println("Mã nhân viên không tồn tại");
        }
    }

    public void sortSalary() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrEmployee[i].getSalary() > arrEmployee[j].getSalary()) {
                    Employee temp = arrEmployee[i];
                    arrEmployee[i] = arrEmployee[j];
                    arrEmployee[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp các nhân viên theo lương tăng dần");
    }

    public void sortName() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrEmployee[i].getEmployeeName().compareTo(arrEmployee[j].getEmployeeName())>0) {
                    Employee temp = arrEmployee[i];
                    arrEmployee[i] = arrEmployee[j];
                    arrEmployee[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp các nhân viên theo tên");
    }
}
