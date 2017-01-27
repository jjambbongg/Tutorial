package chap01.crud;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
 
import util.HibernateUtil;

public class MemberTest {
	
	private static final String HELLO_HIBERNATE = "Hello Hibernate";
	private static final String HELLO_WORLD = "Hello World";
	private static final String SOPHIE = "Sophie";
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	
	@Test
	public void CRUDTest() {
		
		//Insert
		Member member = new Member(SOPHIE, HELLO_WORLD);
		Insert(member);
		
		//Select One
		Member selectedMember = selectById(1);
		assertEquals(HELLO_WORLD, selectedMember.getMessage());
		
		//Update
		selectedMember.setMessage(HELLO_HIBERNATE);
		update(selectedMember);
		Member updatedMember = selectById(1);
		assertEquals(HELLO_HIBERNATE, updatedMember.getMessage());
		
		//Delete
		delete(updatedMember);
		Member deletedMember = selectById(1);
		assertNull(deletedMember);
	}

	public void delete(Member updatedMember) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.delete(updatedMember);
		session.getTransaction().commit();
	}

	public void update(Member selectedMember) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(selectedMember);
		session.getTransaction().commit();
	}
	
	private Member selectById(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Member selectedMember = (Member) session.get(Member.class, id);
		session.getTransaction().commit();
		return selectedMember;
	}

	public void Insert(Member member) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(member);
		session.getTransaction().commit();
	}
}

