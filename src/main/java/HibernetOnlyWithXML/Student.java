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
@Table(name="students")
public class Student {

    @Id
    @Column(name="student_id")
    int student_id;

    @Column(name="student_name")
    String student_name;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="course_student",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="course_id"))
    List<Course> cources;

    public void addCourse(Course c) {
        if(cources==null) {
            cources= new ArrayList<Course>();
        }
        cources.add(c);
    }
    public Student() {
        super();
    }
    public Student(int student_id, String student_name) {
        super();
        this.student_id = student_id;
        this.student_name = student_name;
    }




    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    public String getStudent_name() {
        return student_name;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }



}
