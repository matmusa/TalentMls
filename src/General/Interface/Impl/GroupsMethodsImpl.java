package General.Interface.Impl;

import General.Class.Group;
import General.Class.Lesson;
import General.Class.Person;
import General.Enum.Gender;
import General.Exception.MyException;
import General.Interface.GroupsMethods;
import org.w3c.dom.ls.LSOutput;

import java.rmi.StubNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GroupsMethodsImpl implements GroupsMethods {

    List<Group> groups = new ArrayList<>();


    @Override
    public void addNewGroup() {
        try {
            Group group = new Group();

            List<Person> people = new ArrayList<>();
            List<Lesson> lessons = new ArrayList<>();
            System.out.println("WRITE A NAME OF  GROUP  :");
            String name = new Scanner(System.in).nextLine().toUpperCase();
            group.setGroupName(name.toUpperCase());
            for (Group g : groups
            ) {
                if (g.getGroupName().equalsIgnoreCase(name)) {
                    throw new MyException("SAME GROUP NAME!");
                }

            }
            System.out.println("WRITE A DDESCRIPTION GROUP :");
            String description = new Scanner(System.in).nextLine().toUpperCase();
            group.setDescription(description.toUpperCase());
            group.setId(groups.size() + 1);
            group.setPeople(people);
            group.setLessons(lessons);
            groups.add(group);
            System.out.println(group + "\nSUCCESSFULLY ADDED!");

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getGroupByName() {

        ArrayList<Group> groups1 = new ArrayList<>();
        System.out.println("WRITE A NAME OF  GROUP  :");
        String name = new Scanner(System.in).nextLine().toUpperCase();
        try {
            for (Group g : groups) {

                if (g.getGroupName().toUpperCase().equals(name)) {
                    groups1.add(g);
                    break;
                }
            }
            if (!groups1.isEmpty()) {
                for (Group g : groups1) {
                    System.out.println(g);
                }

            } else {
                throw new MyException("NO SUCH GROUP!!!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateGroupName() {
        ArrayList<Group> groups1 = new ArrayList<>();
        System.out.println("WRITE A NAME OF  GROUP  :");
        String name = new Scanner(System.in).nextLine().toUpperCase();
        try {
            for (Group g : groups) {

                if (g.getGroupName().toUpperCase().equals(name)) {
                    groups1.add(g);
                    break;
                }
            }
            if (!groups1.isEmpty()) {
                for (Group g : groups1) {

                    System.out.println("WRITE NEW NAME OF THE  :");
                    String name1 = new Scanner(System.in).nextLine().toUpperCase();
                    g.setGroupName(name1.toUpperCase());
                    System.out.println(g.getGroupName() + " NAME SUCCESSFULLY CHANGED!");
                    System.out.println(g);

                }

            } else {
                throw new MyException("NO SUCH GROUP!!!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());

        }
    }


    @Override
    public void getAllGroups() {
        for (Group g : groups) {
            System.out.println(g.toString().toUpperCase());

        }
    }

    @Override
    public void addNewStudentToGroup() {
        ArrayList<Group> groups1 = new ArrayList<>();

        Person person = new Person();
        System.out.println("WRITE A NAME OF  GROUP  :");
        String name = new Scanner(System.in).nextLine().toUpperCase();
        for (Group g : groups) {

            if (g.getGroupName().toUpperCase().equals(name)) {
                groups1.add(g);
                break;
            }
        }
        try {
            if (!groups1.isEmpty()) {
                for (Group g : groups1) {

                    System.out.println("WRITE A  FIRST NAME OF  STUDENT  :");
                    String nameOFStudent = new Scanner(System.in).nextLine().toUpperCase();
                    person.setFirstName(nameOFStudent.toUpperCase());
                    System.out.println("WRITE A LAST NAME OF STUDENT :");
                    String nameOFStudent1 = new Scanner(System.in).nextLine().toUpperCase();
                    person.setLastName(nameOFStudent1.toUpperCase());
                    System.out.println("WRITE A   GMAILL  :");
                    String nameOFStudent2 = new Scanner(System.in).nextLine().toUpperCase();
                    boolean isTrue = true;
                    for (Group t : groups) {
                        if (t.getPeople().isEmpty()) {
                            for (Person person1 : t.getPeople()) {
                                if (person1.getGmaill().equals(nameOFStudent2)) {
                                    isTrue = true;
                                    throw new MyException("SAME GMAIL");
                                } else {
                                    isTrue = false;

                                    if (nameOFStudent2.contains("@")) {
                                        person.setGmaill(nameOFStudent2.toUpperCase());
                                    } else {
                                        throw new MyException("WRITE WITH  @");
                                    }

                                    person.setId(g.getPeople().size() + 1);
                                    System.out.println("WRITE A GENDER(MALE/FEMALE :");
                                    String gender = new Scanner(System.in).nextLine().toUpperCase();
                                    if (gender.equals(Gender.MALE.name().toUpperCase())) {
                                        person.setGender(Gender.MALE);
                                    } else if (gender.equals(Gender.FEMALE.name().toUpperCase())) {
                                        person.setGender(Gender.FEMALE);

                                    } else {
                                        System.out.println("UNCORRECT GENDER!");
                                        break;
                                    }
                                    System.out.println("WRITE A  PASSWORD  :");
                                    String passsword = new Scanner(System.in).nextLine().toUpperCase();
                                    if (passsword.length() <= 7) {
                                        throw new MyException("LENGTH MUST BE AT LEAST 7 WORDS");
                                    } else {
                                        person.setPassword(passsword);
                                        g.getPeople().add(person);
                                        System.out.println(g);
                                    }

                                }
                            }
                        }

                    }
                    }
                } else{
                throw new MyException("NO SUCH GROUP!");
                }
            } catch(
                MyException e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void updateStudent() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        try {
            System.out.println("WRITE A GMAILL OF STUDENT  :");
            String nameOFStudent = new Scanner(System.in).nextLine().toUpperCase();
            if (!nameOFStudent.contains("@")) {
                throw new MyException("WRITE A WITH @");
            }
            for (Group g : groups
            ) {
                for (Person p : g.getPeople()
                ) {
                    if (p.getGmaill().toUpperCase().equals(nameOFStudent)) {
                        personArrayList.add(p);
                        break;
                    }
                }
            }
            if (!personArrayList.isEmpty()) {
                for (Person p : personArrayList

                ) {
                    System.out.println("WRITE A  PASSWORD OF  STUDENT  :");
                    String nameOFStuden = new Scanner(System.in).nextLine().toUpperCase();
                    if (p.getPassword().toUpperCase().equals(nameOFStuden)) {
                    } else {
                        throw new MyException("UNCORRECT PASSWORD!");
                    }
                    System.out.println("WRITE A NEW FIRST NAME OF STUDENT  :");
                    String nameOFStud = new Scanner(System.in).nextLine().toUpperCase();
                    p.setFirstName(nameOFStud.toUpperCase());
                    System.out.println("WRITE A NEW LAST NAME OF STUDENT  :");
                    String nameOFStud2 = new Scanner(System.in).nextLine().toUpperCase();
                    p.setLastName(nameOFStud2.toUpperCase());
                    System.out.println(p.getFirstName() + " SUCCESSFULLY CHANGED!");
                    break;
                }

            } else {
                throw new MyException("WRITE WITH A @");
            }


        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void findStudentByFirstName() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        System.out.println("WRITE A FIRST NAME OF STUDENT  :");
        String nameOFStudent = new Scanner(System.in).nextLine().toUpperCase();

        for (Group g : groups
        ) {
            for (Person p : g.getPeople()
            ) {
                if (p.getFirstName().toUpperCase().equals(nameOFStudent)) {
                    personArrayList.add(p);
                    break;
                }
            }
            if (!personArrayList.isEmpty()) {
                for (Person p : personArrayList
                ) {
                    System.out.println(p.toString());
                }


            }
        }
    }


    @Override
    public void getAllStudentsByGroupName() {

        ArrayList<Group> groups1 = new ArrayList<>();
        System.out.println("WRITE A NAME OF  GROUP  :");
        String name = new Scanner(System.in).nextLine().toUpperCase();
        try {
            for (Group g : groups
            ) {

                if (g.getGroupName().toUpperCase().equals(name)) {
                    groups1.add(g);
                    break;

                }
            }
            if (!groups1.isEmpty()) {
                for (Group g : groups1
                ) {
                    System.out.println(g.getPeople());
                }

            } else {
                throw new MyException("NO SUCH GROUP!!!");
            }
        } catch (
                MyException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void getAllStudentLesson() {
        ArrayList<Group> personArrayList = new ArrayList<>();
        ArrayList<Lesson> lessons = new ArrayList<>();
        System.out.println("WRITE A GMAILL OF STUDENT  :");
        String nameOFStudent = new Scanner(System.in).nextLine().toUpperCase();
        for (Group g : groups
        ) {
            for (Person p : g.getPeople()
            ) {
                if (p.getGmaill().contains(nameOFStudent.toUpperCase())) {
                    lessons.addAll(g.getLessons());
                    break;
                }
            }
        }
        try {
            if (!lessons.isEmpty()) {
                for (Lesson p : lessons
                ) {
                    System.out.println(p);

                }
            } else {
                throw new MyException("Lesson is empty!");


            }
        } catch (MyException e) {
            System.out.println(e.getMessage());

        }


    }

    @Override
    public void deleteStudent() {
        Person person = null;
        ArrayList<Person> personArrayList = new ArrayList<>();
        System.out.println("WRITE A EMAIL OF STUDENT  :");
        String nameOFStudent = new Scanner(System.in).nextLine().toUpperCase();
        for (Group g : groups) {
            for (Person p : g.getPeople()) {
                if (p.getGmaill().toUpperCase().equals(nameOFStudent)) {
                    person = p;
                    personArrayList.add(p);
                    break;
                }
            }

            try {
                if (!personArrayList.isEmpty()) {
                    for (int i = 0; i < g.getPeople().size(); i++) {
                        g.getPeople().remove(person);
                        System.out.println(nameOFStudent + " SUCCESSFULLY REMOVED!");

                    }

                } else {
                    throw new MyException("UNCORRECT FIRST NAME! ");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    @Override
    public void addNewLessonToGroup() {
        ArrayList<Group> groups1 = new ArrayList<>();
        Lesson lesson = new Lesson();
        System.out.println("WRITE A NAME OF  GROUP  :");
        String name = new Scanner(System.in).nextLine().toUpperCase();
        for (Group g : groups) {

            if (g.getGroupName().toUpperCase().equals(name)) {
                groups1.add(g);
                break;
            }
        }
        try {
            if (!groups1.isEmpty()) {
                for (Group g : groups1) {
                    System.out.println("WRITE A  NAME OF LESSON   :");
                    String nameOFStudent = new Scanner(System.in).nextLine().toUpperCase();
                    lesson.setLessonName(nameOFStudent);
                    System.out.println("WRITE A DESCRIPTON OF  LESSON :");
                    String nameOFStudent1 = new Scanner(System.in).nextLine().toUpperCase();
                    lesson.setDiscription(nameOFStudent1);
                    lesson.setId(g.getLessons().size() + 1);
                    g.getLessons().add(lesson);
                    System.out.println(lesson.getLessonName() + "SUCCESSFULLY ADDED!");
                }

            } else {
                throw new MyException("NO SUCH GROUP!");
            }
        } catch (
                MyException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void getClassLessonByName() {

        ArrayList<Lesson> lessons = new ArrayList<>();
        System.out.println("WRITE A NAME OF  LESSON :");
        String nameOFStudent1 = new Scanner(System.in).nextLine().toUpperCase();

        for (Group g : groups
        ) {
            for (Lesson l : g.getLessons()
            ) {

                if (l.getLessonName().toUpperCase().equals(nameOFStudent1)) {
                    lessons.add(l);
                    break;
                }
            }

        }
        try {
            if (!lessons.isEmpty()) {
                for (Lesson l : lessons
                ) {
                    System.out.println(l.toString());
                }

            } else {
                throw new MyException("UNCORRECT LESSON NAME!");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void getAllLessonByGroupName() {
        ArrayList<Group> groups1 = new ArrayList<>();
        System.out.println("WRITE A NAME OF  GROUP  :");
        String name = new Scanner(System.in).nextLine().toUpperCase();
        try {
            for (Group g : groups
            ) {

                if (g.getGroupName().toUpperCase().equals(name)) {
                    groups1.add(g);
                    break;

                }
            }
            if (!groups1.isEmpty()) {
                for (Group g : groups1
                ) {
                    System.out.println(g.getLessons());
                    break;
                }
            } else {
                throw new MyException("NO SUCH GROUP!!!");
            }
        } catch (
                MyException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteLesson() {
        ArrayList<Lesson> lessons = new ArrayList<>();
        Lesson lesson = null;
        System.out.println("WRITE A NAME OF  LESSON :");
        String nameOFStudent1 = new Scanner(System.in).nextLine().toUpperCase();
        try {
            for (Group g : groups
            ) {
                for (Lesson l : g.getLessons()
                ) {

                    if (l.getLessonName().toUpperCase().equals(nameOFStudent1)) {
                        lesson = l;
                        lessons.add(l);
                        break;

                    }
                }

                if (!lessons.isEmpty()) {
                    for (int i = 0; i < g.getLessons().size(); i++) {
                        g.getLessons().remove(lesson);
                        System.out.println(lesson + " SUCCESSFULLY REMOVED !");

                    }
                } else {
                    throw new MyException("UNCORRECT NAME OF LESSON!");
                }
            }
        } catch (
                MyException e) {
            System.out.println(e.getMessage());

        }

    }


    @Override
    public void deleteGroup() {
        ArrayList<Group> groups1 = new ArrayList<>();
        System.out.println("WRITE A NAME OF  GROUP  :");
        String name = new Scanner(System.in).nextLine().toUpperCase();
        try {
            for (Group g : groups
            ) {

                if (g.getGroupName().toUpperCase().equals(name)) {
                    groups1.add(g);
                    break;

                }
            }
            if (!groups1.isEmpty()) {
                for (Group g : groups1
                ) {
                    groups.remove(g);
                    System.out.println(g.getGroupName() + " SUCCESSFULLY REMOVED!");
                }

            } else {
                throw new MyException("NO SUCH GROUP!!!");
            }
        } catch (
                MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
