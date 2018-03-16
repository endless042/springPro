package chap02_4_1;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap02.erp.ErpClient;
import chap02.erp.ErpClientFactory;

public class MainForErp {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext("classpath:chap02_4_1/config-erp.xml");
		ErpClientFactory factory = ctx.getBean("factory", ErpClientFactory.class);
		ErpClient client=factory.create();
		System.out.println("===============");
		client.connect();
		client.close();
		System.out.println("===============");
		ctx.close();
	}
}
