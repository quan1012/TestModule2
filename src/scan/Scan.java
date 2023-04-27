package scan;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scan {
    static Scanner scanner = new Scanner(System.in);

    public static String scanMSV() {
        String msv = "";
        while (true) {
            String string = """
                    Nhập mã sinh viên:
                    Lưu ý: Bắt đầu bằng 'SV' và có đuôi là 3 kí tự số(0-9)""";
            System.out.println(string);
            msv = scanner.nextLine();
            boolean msv1 = Pattern.matches("[SV0-9]{5}", msv);
            boolean msv2 = Pattern.matches("[SV]+[0-9]*", msv);
            if (msv1 && msv2) break;
            else {
                System.out.println("\nNhập không đúng định dạng!");
                System.out.println("Nhấn ENTER để nhập lại");
                scanner.nextLine();
            }
        }
        return msv;
    }

    public static int scanAge() {
        int age;
        do {
            do {
                try {
                    System.out.println("Nhập tuổi: ");
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số");
                    System.out.println("Nhấn ENTER để nhập lại");
                    scanner.nextLine();
                }
            } while (true);
            if (age < 18 || age > 60) {
                System.out.println("Phải nhập số lớn hơn 18 và nhỏ hơn 60!");
                System.out.println("Nhấn ENTER để nhập lại");
                scanner.nextLine();
            }
        } while (age < 18 || age > 60);
        return age;
    }

    public static String scanGender() {
        String gender;
        int choise;
        String string = """
                Nhập giới tính:
                \t1. Nam.
                \t2. Nữ.""";
        System.out.println(string);
        do {
            try {
                do {

                    System.out.println("Nhập lựa chọn: ");
                    choise = Integer.parseInt(scanner.nextLine());
                    if (choise != 1 && choise != 2) System.out.println("Phải nhập 1 hoặc 2");
                } while (choise != 1 && choise != 2);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Phải nhập số");
                System.out.println("Nhấn ENTER để nhập lại");
                scanner.nextLine();
            }
        } while (true);
        switch (choise) {
            case 1:
                gender = "Nam";
                break;
            case 2:
                gender = "Nữ";
                break;
            default:
                gender = "";
                break;
        }
        return gender;
    }

    public static double scanScore() {
        double score;
        do {
            do {
                try {
                    System.out.println("Nhập điểm trung bình: ");
                    score = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số");
                    System.out.println("Nhấn ENTER để nhập lại");
                    scanner.nextLine();
                }
            } while (true);
            if (score < 0 || score > 10) {
                System.out.println("Phải nhập số trong khoảng 0 đến 10!");
                System.out.println("Nhấn ENTER để nhập lại");
                scanner.nextLine();
            }
        } while (score < 0 || score > 10);
        return score;
    }
}