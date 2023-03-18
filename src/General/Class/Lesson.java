package General.Class;

public class Lesson {
    private int id;
    private String lessonName;
    private String discription;

    public Lesson() {
    }

    public Lesson(int id, String lessonName, String discription) {
        this.id = id;
        this.lessonName = lessonName;
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return "\nСlass.c.Lesson " +
                "\nid :" + id +
                "\n lessonName='" + lessonName +
                "\n discription='" + discription
                ;
    }
}
