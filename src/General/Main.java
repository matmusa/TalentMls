package General;

import General.Class.Admin;
import General.Class.Group;
import General.Exception.MyException;
import General.Interface.Impl.GroupsMethodsImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        int a = LocalDateTime.now().getHour();
        int b = LocalDateTime.now().getMinute();
        System.out.println("TIME NOW ->" + a + ":" + b);
        if (a >= 5 && a <= 11) {
            System.out.println("GOOD MORNING!");
        } else if (a >= 11 && a <= 17) {
            System.out.println("GOOD AFTERNOON!");

        } else if (a >= 18 && a <= 22) {
            System.out.println("GOOD EVENING!");

        } else {
            System.out.println("GOOD NIGHT!");
        }


        Admin admin = new Admin();
        admin.setAdminGmail("Matmusa@");
        admin.setPassword("Matmusa2001");
        System.out.println("IF YOU ARE REGISTERED CLICK 1" +
                "\nIF YOU FORGET PASSWORD CLICK 2");
        int c = new Scanner(System.in).nextInt();
        while (true) {
            if (c == 1) {

                try {
                    System.out.println("WRITE A GMAIL :");
                    String gmaill = new Scanner(System.in).nextLine().toUpperCase();
                    if (admin.getAdminGmail().toUpperCase().equals(gmaill)) {
                    } else if (!gmaill.contains("@")) {
                        throw new MyException("WRITE A GMAILL WITH @");
                    } else {
                        throw new MyException("UNCORRECT GMAIL!");
                    }
                    System.out.println("WRITE A PASSWORD :");
                    String password = new Scanner(System.in).nextLine().toUpperCase();
                    if (admin.getPassword().toUpperCase().equals(password)) {


                            myMethids();


                    } else {
                        throw new MyException("UNCORRECT PASSWORD");
                    }
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                    String password = new Scanner(System.in).nextLine();
                }
            } else if (c == 2) {

            }
        }
    }

    public static void myMethids() {

        GroupsMethodsImpl groupsMethods = new GroupsMethodsImpl();
        System.out.println("WELCOME!");
        while (true) {
            System.out.println(
                    "<<<CHOOSE ONE FUNCTION>>>");
            System.out.println("" + "  1-> Add new group\n" +
                    "  2-> Get group by name\n" +
                    "  3-> Update group name\n" +
                    "  4->Get all groups\n" +
                    "  5-> Add new student to group\n" +
                    "  6->Update student\n" +
                    "  7->Find student by first name\n" +
                    "  8-> Get all students by group name\n" +
                    "  9-> Get all student’s lesson\n" +
                    "  10->Delete student\n" +
                    "  11->Add new lesson to group\n" +
                    "  12->Get Lesson by name\n" +
                    "  13->Get all lesson by group name\n" +
                    "  14->Delete lessonp\n" +
                    "  15->Delete group\n");
            int d = new Scanner(System.in).nextInt();
            switch (d) {
                case 1 -> {
                    groupsMethods.addNewGroup();
                }
                case 2 -> {
                    groupsMethods.getGroupByName();
                }

                case 3 -> {
                    groupsMethods.updateGroupName();
                }

                case 4 -> {
                    groupsMethods.getAllGroups();
                }

                case 5 -> {
                    groupsMethods.addNewStudentToGroup();
                }

                case 6 -> {
                    groupsMethods.updateStudent();
                }

                case 7 -> {
                    groupsMethods.findStudentByFirstName();
                }

                case 8 -> {
                    groupsMethods.getAllStudentsByGroupName();
                }

                case 9 -> {
                    groupsMethods.getAllStudentLesson();
                }

                case 10 -> {
                    groupsMethods.deleteStudent();
                }

                case 11 -> {
                    groupsMethods.addNewLessonToGroup();
                }

                case 12 -> {
                    groupsMethods.getClassLessonByName();
                }

                case 13 -> {
                    groupsMethods.getAllLessonByGroupName();
                }

                case 14 -> {
                    groupsMethods.deleteLesson();
                }

                case 15 -> {
                    groupsMethods.deleteGroup();
                }

                default -> {
                    System.out.println("UNCORRECT NUMBER!");

                }
            }

        }
    }
}


