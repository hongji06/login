package junit.test;

import org.junit.Test;

import com.eternal.dao.UserDao;
import com.eternal.dao.impl.UserDaoImpl;
import com.eternal.domain.User;

public class UserDaoTest {

	@Test
	public void testSave() {
		User user = new User("61234123","xu","111","11@163.com");
		UserDao userDaoImpl = new UserDaoImpl();
		userDaoImpl.save(user);
	}
	
	@Test
	public void testFindByUsername() {
		UserDao userDaoImpl = new UserDaoImpl();
		boolean flag = userDaoImpl.find("xu");
		System.out.println("find by username :"+flag);
	}
	
	@Test
	public void testFindByUser() {
		UserDao userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.find("xu", "111");
		System.out.println(user);
	}
}
