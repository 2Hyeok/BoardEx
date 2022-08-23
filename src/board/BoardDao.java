package board;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	// 메소드 공간
	public int getCount(); // 글갯수 표시
	public List<BoardDataBean> getArticles(Map<String, Integer> map); // 시작과 끝
	
	public int insertArticle(BoardDataBean dto); // 글쓰기
	
	public BoardDataBean getArticle(int num); // 글 읽기
	public void addCount(int num); // 답글
	
	public int check(int num, String passwd); // 비밀번호 확인
	public int modifyArticle(BoardDataBean dto); // 글 수정
	
	public int deleteArticle(int num); // 글 삭제
}
