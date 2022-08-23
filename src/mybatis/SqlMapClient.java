package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClient {
	// 로그인 시 세션이 생김
	private static SqlSession session; // ibatis 로 임포트 , 하나만 만들어서 뿌림, 싱들톤 패턴으로 구현
	static { // 이 안에 있는것들은 다 static으로 설정함
		String resource = "mybatis/sqlMapConfig.xml"; // 이 파일을 읽어드려라
		
		try {
			Reader reader = Resources.getResourceAsReader(resource); // 입출력, 예외처리 필요
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			session = factory.openSession( true ); // 트렌젝션 처리를 해주기위해 일일이 커밋을 직접 해주어야함 그러는게 좋음, true라고 줄시 오토커밋
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	// 리턴 시킬것
	public static SqlSession getSession() {
		return session;
	}
}
