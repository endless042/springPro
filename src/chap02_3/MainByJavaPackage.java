package chap02_3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import chap02.AuthenticationService;
import chap02.PasswordChangeService;

public class MainByJavaPackage {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext("classpath:chap02_4/config-aaa-*.xml");
		
		
	
		AuthenticationService authSvc=ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi","1234");
		PasswordChangeService pwChgSvc=ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		authSvc.authenticate("bkchoi","5678");
		ctx.close();
	}
}
