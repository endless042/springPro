package chap02_3;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap02.AuthFailLogger;
import chap02.AuthenticationService;
import chap02.PasswordChangeService;
import chap02.User;
import chap02.UserRepository;

@Configuration
public class config2 {
	@Bean
	public User user1() {
		return new User("bkchoi","1234");
	}
	@Bean
	public User user() {
		return new User("madvirus","qwer");
	}
	@Bean
	public UserRepository userRepository() {
		UserRepository userRepo=new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(),user()));
		return userRepo;
		}
	
}
