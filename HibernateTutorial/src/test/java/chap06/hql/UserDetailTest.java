package chap06.hql;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import util.DaoCommon;
import util.HibernateUtil;

public class UserDetailTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		DaoCommon<UserDetail> daoUserDetail = new DaoCommon<UserDetail>(UserDetail.class);
		
		for(int i=0; i<10; i++) {
			daoUserDetail.insert(new UserDetail("User"+i));
		}
		
		SessionFactory factory = HibernateUtil.getSessionFactory(UserDetail.class);
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		/*String minUserId = "5";
		Query query = session.createQuery("from UserDetail where id > ? and userName = ?");
		query.setInteger(0, Integer.parseInt(minUserId));
		query.setString(1, "User9");*/
		
		String userId = "5";
		String userName = "User9";
		Query query = session.createQuery("from UserDetail where id > :userId and userName = :userName");
		query.setInteger("userId", Integer.parseInt(userId));
		query.setString("userName", userName);
		
		List<UserDetail> list = query.list();
		session.getTransaction().commit();
		
		for(UserDetail userDetail:list) {
			System.out.println(userDetail);
		}
	}

}
