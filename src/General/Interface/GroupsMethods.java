package General.Interface;

import General.Exception.MyException;

public interface GroupsMethods {

    void addNewGroup();

    void getGroupByName() throws MyException;

    void updateGroupName();

    void getAllGroups();

    void addNewStudentToGroup();

    void updateStudent();

    void findStudentByFirstName();

    void getAllStudentsByGroupName();

    void getAllStudentLesson();

    void deleteStudent();

    void addNewLessonToGroup();

    void getClassLessonByName();

    void getAllLessonByGroupName();

    void deleteLesson();

    void deleteGroup();

}
