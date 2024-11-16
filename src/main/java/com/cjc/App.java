package com.cjc;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.cjc.configue.HibernateUtil;
import com.cjc.model.Student;

/**
 * Hello world!
 *
 */
public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Scanner sc = new Scanner(System.in);

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		// SQL : delete from Student_dtls where Student_address='Pune'

		// HQl : delete from Student where address='Pune'

		System.out.println("Enter City Name");
		String city = sc.next();

		String hql = "delete from Student where address= :adr ";

		Query query = session.createQuery(hql);

		query.setParameter("adr", city);

		Transaction tx = session.beginTransaction();

		query.executeUpdate();

		tx.commit();

		System.out.println("Done..!");

	}

	private static void getDataByNameUsingHQL(Scanner sc, Session session) {

		// SQL : select * from student_dtls where Student_Address ='Mumbai';
		// HQL : from Student where address='Mumbai';

		System.out.println("Enter City Name");
		String city = sc.next();

		String query = "from Student where address=? ";

		Query q = session.createQuery(query);

		q.setParameter(0, city);

		List<Student> list = q.getResultList();

		for (Student st : list) {
			System.out.println("-----------------");
			System.out.println("Stduent Rollno :" + st.getRollno());
			System.out.println("Stduent Name :" + st.getName());
			System.out.println("Stduent Address :" + st.getAddress());
			System.out.println("Stduent Marks :" + st.getMarks());
		}
	}

	private static void getAllDataUsingHQL(Session session) {
		// SQL : select * from table_name;
		// HQL : from ClassName

		String query = "from Student";

		Query q = session.createQuery(query);

		List<Student> list = q.getResultList();

		for (Student st : list) {
			System.out.println("-----------------");
			System.out.println("Stduent Rollno :" + st.getRollno());
			System.out.println("Stduent Name :" + st.getName());
			System.out.println("Stduent Address :" + st.getAddress());
			System.out.println("Stduent Marks :" + st.getMarks());
		}
	}

	private static void getAllDataUsingSQL(Session session) {
		String sql = "select * from student_dtls";

		Query query = session.createSQLQuery(sql).addEntity(Student.class);

		List<Student> list = query.getResultList();

		for (Student st : list) {
			System.out.println("-----------------");
			System.out.println("Stduent Rollno :" + st.getRollno());
			System.out.println("Stduent Name :" + st.getName());
			System.out.println("Stduent Address :" + st.getAddress());
			System.out.println("Stduent Marks :" + st.getMarks());
		}
	}

	private static void insertData(Session session) {
		Student stu1 = new Student(1, "ABC", "Pune", 52.25f);
		Student stu2 = new Student(2, "STU", "Mumbai", 72.25f);
		Student stu3 = new Student(3, "PQR", "Nashik", 95.25f);
		Student stu4 = new Student(4, "ABC", "Pune", 62.25f);
		Student stu5 = new Student(5, "XYZ", "Mumbai", 92.25f);

		session.save(stu1);
		session.save(stu2);
		session.save(stu3);
		session.save(stu4);
		session.save(stu5);

		session.beginTransaction().commit();

		System.out.println("Done....!");
	}
}
