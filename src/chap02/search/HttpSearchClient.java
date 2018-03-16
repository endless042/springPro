package chap02.search;

public class HttpSearchClient implements SearchClient{

	@Override
	public void addDocument(SearchDocument searchDocument) {
		// TODO Auto-generated method stub
		System.out.println("문서 추가함");
	}

	@Override
	public void checkLive() {
		// TODO Auto-generated method stub
		System.out.println("상태 확인");
	}
	
}
