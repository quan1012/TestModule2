package views;

import controller.StudentManager;
import storage.ReaWriteFile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String string = """
                    -----------  CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN  ----------
                            Chọn chức năng theo số (để tiếp tục)
                    1. Xem danh sách sinh viên
                    2. Thêm mới
                    3. Cập nhật
                    4. Xóa
                    5. Sắp xếp
                    6. Đọc từ file
                    7. Ghi vào file
                    8. Thoát
                    Chọn chức năng:
                    """;
            System.out.println(string);
            int choice;
            do {
                try {
                    System.out.println("Mời bạn nhập lựa chọn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("\nPhải nhập số!!!!!!");
                    System.out.println("Nhấp Enter để tiếp tục");
                    scanner.nextLine();
                }
            }while (true);
            switch (choice){
                case 1:
                    studentManager.showListStudent();
                    break;
                case 2:
                    System.out.println("Nhập thông tin sinh viên muốn thêm");
                    studentManager.addStudent();
                    break;
                case 3:
                    studentManager.editStudent();
                    break;
                case 4:
                    studentManager.deleteStudent();
                    break;
                case 5:
                    studentManager.sortStudentScore();
                    break;
                case 6:
                    System.out.println("Bạn có muốn cập nhật bộ nhớ không? Nhấn 'Y' để đồng ý!");
                    String update=scanner.nextLine();
                    if (update.equals("Y")){
                        ReaWriteFile.readFile();
                        System.out.println("\nĐã cập nhật lại bộ nhớ");
                        System.out.print("Nhấn ENTER để tiếp tục");
                        scanner.nextLine();
                    }else {
                        System.out.println("\nChưa nhật lại bộ nhớ");
                        System.out.print("Nhấn ENTER để tiếp tục");
                        scanner.nextLine();
                    }
                    break;
                case 7:
                    ReaWriteFile.writeFile();
                    System.out.println("Đã ghi dữ liệu vào file!");
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
