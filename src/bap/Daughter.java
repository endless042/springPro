package bap;


public class Daughter implements Person{
	private String friend;
	
	public void bap() {
		System.out.println("현미밥 싫어 싫어===> 난 쌀밥 좋아 ");
	}
	public void setFriend(String friend) {
		this.friend=friend;
	}
	public void getFriend() {
		System.out.println("딸의 친구"+friend+"입니다");
	}
}
