package HibernetOnlyWithXML;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    public Course() {
        super();
    }

    @Id
    @Column(name="course_id")
    int course_id;

    @Column(name="course_name")
    String course_name;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="course_student",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="student_id"))
    List<Student> students;

    public void addStudents(Student s) {
        if(students==null) {
            students= new ArrayList<Student>();
        }
        students.add(s);
    }



    public Course(int course_id, String course_name) {
        super();
        this.course_id = course_id;
        this.course_name = course_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
