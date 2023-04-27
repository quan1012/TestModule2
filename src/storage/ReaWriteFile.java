package storage;

import controller.StudentManager;
import model.Student;

import java.io.*;
import java.util.LinkedList;

public class ReaWriteFile {
    public static void readFile() {
        try (FileInputStream fis = new FileInputStream("D:\\Module2\\TestModule2\\src\\students.csv");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            StudentManager.setStudents((LinkedList<Student>) ois.readObject());
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc đọc.");
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try (FileOutputStream fos = new FileOutputStream("D:\\Module2\\TestModule2\\src\\students.csv");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(StudentManager.getStudents());
        } catch (Exception e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc ghi.");
            e.printStackTrace();
        }
    }
}