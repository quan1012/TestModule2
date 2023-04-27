package controller;

import scan.Scan;
import sort.increaseScore;
import model.Student;


import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentManager {
    Scanner scanner = new Scanner(System.in);
    static LinkedList<Student> students = new LinkedList<>();

    public static LinkedList<Student> getStudents() {
        return students;
    }

    public static void setStudents(LinkedList<Student> students) {
        StudentManager.students = students;
    }
//Hiển thị danh sách sinh viên
    public void showListStudent() {
        if (students.isEmpty()) {
            System.err.println("Danh sách chưa có sinh viên nào!!!");
            System.out.print("Nhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            int count = 0;
            System.out.println("\n----------------------------Danh sách sinh viên-------------------------");
            System.out.printf("%-10s%-20s%-10s%-15s%-25s%-6s\n", "MSV", "Họ Tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm trung bình");
            for (int i = 0; i < students.size(); i++) {
                if (count % 5 == 0&&count!=0) {
                    System.out.println("\n------------------Nhấn Enter để tiếp tục hiển thị----------------");
                    scanner.nextLine();
                }
                System.out.println(students.get(i).toString());
                count++;
            }
        }
        System.out.println();
    }
//Thêm thông tin sinh viên
    public Student createStudent() {
        String msv = "";
        int index;
        do {
            index = -1;
            msv = Scan.scanMSV();
            for (Student student : students) {
                if (student.getMsv().equals(msv)) {
                    index = 1;
                    break;
                }
            }
            if (index == 1) System.out.println("\nMã sinh viên đã tồn tại mời nhập mã khác.");
        } while (index == 1);
        System.out.println("Nhập họ và tên:");
        String name = scanner.nextLine();
        int age = Scan.scanAge();
        String gender = Scan.scanGender();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        double score = Scan.scanScore();
        Student student = new Student(msv, name, age, gender, address, score);
        return student;
    }

    public int Index() {
        System.out.println("Nhập MSV:");
        String msv = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMsv().equals(msv)) return i;
        }
        return -1;
    }

    public void addStudent() {
        students.add(createStudent());
    }
//Sửa thông tin sinh viên
    public void editStudent() {
        int index;
        System.out.println("Nhập thông tin sinh viên sửa: ");
        index = Index();
        if (index == -1) {
            System.out.println("\nKhông tìm được sinh viên với mã sinh viên ở trên.");
            System.out.print("Nhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            System.out.println("Nhập thông tin sinh viên muốn sửa");
            students.get(index).equals(createStudent());
            System.out.println("\nSửa thành công sinh viên");
            System.out.println("Nhấn ENTER để tiếp tục");
            scanner.nextLine();
        }
    }
//Xóa thông tin sinh viên
    public void deleteStudent() {
        int index;
        System.out.println("Nhập thông tin sinh viên muốn xoá: ");
        index = Index();
        if (index == -1) {
            System.out.println("\nKhông có sinh viên nào có mã sinh viên này.");
            System.out.print("Nhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            System.out.println("Nhấn 'Y' để xác nhận xoá");
            String check= scanner.nextLine();
            if (check.equals("Y")){
                System.out.printf("\nĐã xoá sinh viên có mã sinh viên là %s ",students.get(index).getMsv());
                students.remove(index);
                System.out.println("Nhấn ENTER để tiếp tục");
                scanner.nextLine();
            }
            else {
                System.out.println("\nXoá không thành công.");
                System.out.println("Nhấn ENTER để quay về màn hình chính");
                scanner.nextLine();
            }
        }
    }
//Sắp xếp sinh viên theo điểm
    public void sortStudentScore() {
        while (true) {
            String string = """
                    \n----------Sắp xếp sinh viên theo điểm trung bình----------
                                 Chọn chức năng theo số (để tiếp tục)
                    1. Sắp xếp theo điểm trung bình tăng dần
                    2. Sắp xếp theo điểm trung bình giảm dần
                    3. Quay lại""";
            System.out.println(string);
            int choice;
            do {
                try {
                    System.out.println("Mời nhập lựa chọn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("\nPhải nhập số!");
                    System.out.print("Nhấn ENTER để tiếp tục");
                    scanner.nextLine();
                }
            } while (true);
            switch (choice) {
                case 1:
                    System.out.println("\nSắp xếp theo điểm trung bình tăng dần!");
                    Collections.sort(students, new increaseScore());
                    showListStudent();
                    break;
                case 2:
                    Collections.reverse(students);
                    System.out.println("\nSắp xếp theo điểm trung bình giảm dần!");
                    showListStudent();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}