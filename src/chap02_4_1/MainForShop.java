package chap02_4_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap02.search.SearchClientFactory;
import chap02.search.SearchServiceHealthChecker;
import chap02.shop.OrderInfo;
import chap02.shop.OrderService;
import chap02.shop.ProductInfo;
import chap02.shop.ProductService;


public class MainForShop {
	public static void main(String[] args) {
		runByUsingXmlConfig();
		System.out.println("====================");
		runByUsingJavaConfig();
	}
	private static void runByUsingXmlConfig() {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext("classpath:chap02_4_1/config-shop.xml");
		useBean(ctx);	
		ctx.close();
	}
	private static void useBean(ApplicationContext ctx) {
		ProductService productService=ctx.getBean(ProductService.class);
		productService.createProduct(new ProductInfo());
		OrderService orderService=ctx.getBean(OrderService.class);
		orderService.order(new OrderInfo());
		SearchClientFactory orderSearchClientFactory = ctx.getBean("orderSearchClientFactory",SearchClientFactory.class);
		System.out.println(orderSearchClientFactory);
		System.out.println("********************");
		SearchServiceHealthChecker healthChecker=ctx.getBean("searchServiceHealthChecker",SearchServiceHealthChecker.class);
		healthChecker.check();
	}
	private static void runByUsingJavaConfig() {
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(ConfigShop.class);
		useBean(ctx);
		ctx.close();
	}
	
}
