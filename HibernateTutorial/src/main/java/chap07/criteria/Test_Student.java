package chap07.criteria;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import util.DaoCommon;
import util.HibernateUtil;

public class Test_Student {
	
	SessionFactory factory = HibernateUtil.getSessionFactory(Student.class);
	DaoCommon<Student> daoStudent = new DaoCommon<Student>(Student.class);
	
	@Before
	public void setUp() {
		daoStudent.deleteAllSetTable();
		daoStudent.insert(new Student("Sophie", 100, 100, 100, 100));
		daoStudent.insert(new Student("Tom", 25, 90, 90, 90));
		daoStudent.insert(new Student("Obama", 24, 80, 80, 80));
		daoStudent.insert(new Student("Trump", 23, 70, 70, 70));
		daoStudent.insert(new Student("Hillary", 22, 60, 60, 60));
		daoStudent.insert(new Student("Bush", 21, 50, 50, 50));
		daoStudent.insert(new Student("Mary", 20, 40, 40, 40));
	}
	
	public void test() {
		assertEquals(7, daoStudent.count());
		Session session = factory.getCurrentSession();
		session.beginTransaction();	
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.gt("age", 22));
		criteria.add(Restrictions.le("math", 90));
		criteria.addOrder(Order.desc("id"));
//		criteria.setFirstResult(0);
//		criteria.setMaxResults(2);
		List<Student> list = criteria.list();
		session.getTransaction().commit();
//		for(Student student:list) {
//			System.out.println(student);
//		}
		list.forEach(n -> System.out.println(n)); 
	}
	
	//Restriction
	@Test
	public void rerstriction() throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();	
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.or(Restrictions.between("age", 21, 25), Restrictions.between("kor", 0, 90)));
		List<Student> list = criteria.list();
		System.out.println("Age between 21 and 25 or Kor between 0 and 90");
		list.forEach(n -> System.out.println(n));
		session.getTransaction().commit();	
	}
	
	//Projection
	@Test
	public void projection() throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();	
		Criteria criteria = session.createCriteria(Student.class);
		double avg = (double)criteria.setProjection(Projections.avg("kor")).uniqueResult(); 
		System.out.println("Average of Kor:"+avg);
		session.getTransaction().commit();			
	}
	
	//NamedQuery
	@Test
	public void namedQuery() throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();	
		Query query = session.getNamedQuery("FindByAge");
		query.setInteger(0, 25);
		List<Student> list = query.list();
		System.out.println("Student who is more than 25 yo");
		list.forEach(n-> System.out.println(n));
		session.getTransaction().commit();	
	}
	
	//Native Query
	@Test
	public void nativeQuery() throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();	
		Query query = session.createSQLQuery("Select * from Student").addEntity(Student.class);
		List<Student> list = query.list();
		session.getTransaction().commit();	
		System.out.println("Extract with querey");
		list.forEach(n-> System.out.println(n));		
	}
	
	//Example Query
	@Test
	public void exampleQuery() throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();	
		Student student = new Student();
		student.setKor(90);
		Example example = Example.create(student);
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(example);
		session.getTransaction().commit();
		List<Student> list = criteria.list();
		System.out.println("Extract using Example");
		list.forEach(n-> System.out.println(n));	
	}
}
