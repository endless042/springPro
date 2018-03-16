package chap02_2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXmlWithoutId {
 public static void main(String[] args) {
	GenericXmlApplicationContext ctx=new GenericXmlApplicationContext("classpath:chap02_2/config-without-id.xml");
	String[] beanNames=ctx.getBeanDefinitionNames();
	for(String bn:beanNames)
		System.out.println(bn);
	ctx.close();
}
}
