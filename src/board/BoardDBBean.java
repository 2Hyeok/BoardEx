package board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import mybatis.SqlMapClient;

public class BoardDBBean implements BoardDao {
	// 글 전체글갯수
	// 글 갯수 표시 부분
	public int getCount() {
		return SqlMapClient.getSession().selectOne("Board.getCount");
	}
	
	
	
	// 글쓰기
	// sql 을 3번 써줌
	public int insertArticle(BoardDataBean dto) {
		int num=dto.getNum();
		int ref=dto.getRef();
		int re_step=dto.getRe_step();
		int re_level=dto.getRe_level();
         
		//				ref 	re_step 	re_level
		// 10제목글		8     		0       	0
		// 09 ㄴ 답글		8     		2       	1
		// 09   ㄴ 재답글 	8			3       	2
		// 07 ㄴ답글        	8     		1			1
         
		//				ref 	re_step 	re_level
		// 10제목글         	8     		0       	0
		// 09 ㄴ 답글       	8     		1       	1
		// 09   ㄴ 재답글  	8     		2       	1
		// 07 ㄴ답글        	8     		3       	2
         
		String  sql=null;
		if(num==0) {
			//제목글
			int count = getCount();
			if(count != 0) {
				// 글이 있는 경우
				int maxnum = SqlMapClient.getSession().selectOne("Board.maxNum");
				ref = maxnum+1;// 그룹화 아이디 = 글번호 최댓값 + 1, int로 넘김
			}
			re_step=0;
			re_level=0;
		}else {
			//답변글
			// map 으로 넘길 필요없이 넘기는 바구니안에 데이터가 다 들어있어 바구니를 통체로 던지면됨
			SqlMapClient.getSession().update("Board.updateReply", dto);// 바구니에서 꺼내오면 안된다.
			re_step ++;
			re_level ++;
		}
	
		// 반드시 넘기는것
		dto.setRef(ref);
		dto.setRe_step(re_step);
		dto.setRe_level(re_level);
		
		// 글 등록
		return SqlMapClient.getSession().insert("Board.insertArticle", dto);
	}
	
	
	
	
	// list.jsp의 getArticles
	public List<BoardDataBean> getArticles(Map<String, Integer> map){
		return SqlMapClient.getSession().selectList("Board.getArticles", map);
	}
	
	
	// 글 보기
	public BoardDataBean getArticle(int num) {
		return SqlMapClient.getSession().selectOne("Board.getArticle", num);
	}
	
	
	
	// 조회수
	public void addCount(int num) {
		SqlMapClient.getSession().update("Board.addCount", num);
   }
   
	
	// 비밀번호 체크
	public int check(int num, String passwd) {
		BoardDataBean dto = getArticle(num);
		int result = 0;
		
		if(dto.getPasswd().equals(passwd)) {
			result = 1; //비밀번호가 다르면
		}else {
			result = 0; // 비밀번호가 같으면
		}
		
		return result;
   }
   
	// 글 삭제
	public int deleteArticle(int num) {
		//					ref		re_step		re_level
		//제목글				10		0			0
		//ㄴ나중에 쓴 답글		10		1			1
		//ㄴ답글				10		2			1
		// ㄴ재답글			10		3			2
		
		// ref 같다		re_step + 1 같다		re_level 크다.
		
		// 답글이 있는경우	삭제된 글 입니다.
		// 답글이 없는경우	삭제
		
		BoardDataBean dto = getArticle(num); // ref, re_step, re_level 값을 가져오지 못하고 num값을 가져오기 때문에 getArticle을 가져옴
		// 답글 유무 확인
		int count = SqlMapClient.getSession().selectOne("Board.checkReply", dto);
		
		if(count != 0) {
			// 답글이 있는경우
			return SqlMapClient.getSession().update("Board.delArticle", num);
			
		} else {
			// 답글이 없는경우
			SqlMapClient.getSession().update("Board.deleteReply", dto);
			
			// 삭제
			return SqlMapClient.getSession().delete("Board.deleteArticle", dto);
		}
	}
	
	// 글 수정
	public int modifyArticle(BoardDataBean dto) {
		return SqlMapClient.getSession().update("Board.modifyArticle", dto);
   }
	
	
}// class
