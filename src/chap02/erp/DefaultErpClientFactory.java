package chap02.erp;

import java.util.Properties;

public class DefaultErpClientFactory extends ErpClientFactory{
	private String server;
	
	public DefaultErpClientFactory(Properties props) {
		// TODO Auto-generated constructor stub
		this.server=props.getProperty("server");
		System.out.println(server);
	}

	@Override
	public ErpClient create() {
		// TODO Auto-generated method stub
		
		
		return new ErpClient() {
			public void connect() {
				System.out.println("연결함:"+server);
			}
			public void close() {
				System.out.println("연결 끊음:"+server);
			}
			public void sendPurchaseInfo(ErpOrderData oi) {
				System.out.println("주문 정보 전송:"+server);
			}
		};		//익명클래스
	}

}
