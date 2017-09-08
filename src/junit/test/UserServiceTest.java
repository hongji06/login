package junit.test;

import org.junit.Test;

import com.eternal.domain.User;
import com.eternal.exception.UserExistException;
import com.eternal.exception.UserNotFoundException;
import com.eternal.service.impl.UserServiceImpl;

public class UserServiceTest {

	@Test
	public void testRegister() {
		User user = new User("61234123","xu","111","11@163.com");
		UserServiceImpl service = new UserServiceImpl();
		try {
			service.register(user);
			System.out.println("regist success.");
		} catch (UserExistException e) {
			System.out.println("user had exist.");
		}
	}
	
	@Test
	public void testLogin() {
		String username = "xu";
		String password = "111";
		UserServiceImpl service = new UserServiceImpl();
		try {
			User user = service.login(username, password);
			System.out.println(user);
		} catch (UserNotFoundException e) {
			System.out.println("username or password error.");
		}
		
	}

}
