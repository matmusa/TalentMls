package General.Class;

import java.util.List;

public class Group {

    private int id;
    private String groupName;
    private String description;
    private List<Person>people;
    private List<Lesson> lessons;

    public Group() {
    }

    public Group(int id, String groupName, String description, List<Person> people, List<Lesson> lessons) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.people = people;
        this.lessons = lessons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Group :" +
                "\nid :" + id +
                " \ngroupName :" + groupName +
                "\n description :" + description +
                "\nstudents :" + people +
                "\nlessons :" + lessons
                ;
    }
}
