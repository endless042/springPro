package chap02_3;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap02.AuthFailLogger;
import chap02.AuthenticationService;
import chap02.PasswordChangeService;
import chap02.User;
import chap02.UserRepository;

@Configuration
public class config1 {
	
	@Autowired	//애너테이션 추가
	public UserRepository userRepository;		//변수처럼 추가
	
	@Bean
	public PasswordChangeService pwChangeSvc() {
		return new PasswordChangeService(userRepository);	//변수처럼 변경
	}
	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger=new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}
	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc=new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository);
		return authSvc;
	}
}
