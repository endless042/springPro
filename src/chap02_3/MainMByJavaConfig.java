package chap02_3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap02.AuthenticationService;
import chap02.PasswordChangeService;

public class MainMByJavaConfig {
	public static void main(String[] args) {
		useSingleClass();
		useMultipleClass();
	}
	private static void useMultipleClass() {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(config1.class,config2.class);
		useBean(ctx);
		ctx.close();
	}
	private static void useSingleClass() {
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(config.class);
		useBean(ctx);
		ctx.close();
	}
	
	private static void useBean(AnnotationConfigApplicationContext ctx) {
		AuthenticationService authSvc=ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi","1234");
		PasswordChangeService pwChgSvc=ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	}
}
