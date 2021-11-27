package HibernetOnlyWithXML;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


    public class Client {

        public static void main(String[] args) {

            SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.getCurrentSession();
            try {
			Student s1 = new Student(1,"sakariya");
			session.beginTransaction();
			session.save(s1);
			session.flush();
			session.getTransaction().commit();


                session = sf.getCurrentSession();
			     session.beginTransaction();
                System.out.println("here");
                List<Student> students=session.createQuery("from Student").list();
                System.out.println(students.size()+"<-size");
                students.stream().forEach(student-> System.out.println(student.student_id+":"+student.student_name));
                session.getTransaction().commit();
                session.close();
                sf.close();

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
            finally {

            }
        }


}
