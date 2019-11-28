package DB;
/*
	이 클래스는 커넥션 풀에 있는 커넥션을 이용해서
	데이터베이스 작업을 할 유틸리티 클래스이다.
	
	커넥션 풀에 있는 커넥션을 관리할 용도의 클래스이다.
*/

import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCP {
	// 1. 커넥션 풀을 관리할 변수 준비
	public DataSource ds;
	/* 
		이 클래스를 누군가 new 시키면
		META_INF/context.xml 파일에 등록된 자원을 가지고 오도록 한다.
		이처럼 context.xml 파일에 등록된 자원을 가지고 오는 기법을
		JNDI(Java Naming and Directory Interface) 기법이라고 한다.
	*/
	public DBCP() {
		try {
			// 2. context.xml 파일에 등록된 자원을 알아낸다.
			InitialContext context = new InitialContext();
			
			// 3. 그 중 필요한 자원을 얻으면 된다.
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/TestDB");
			/*
				찾을 이름을 정하는 규칙
					java:/comp/env/찾을이름
				
				우리의 경우
					java:/comp/env/jdbc/TestsDB
				
				이 작업이 성공을 하면 커넥션 풀을 얻은 것이 된다.
			*/
		}catch (NamingException e) {
			e.printStackTrace();
		} 
	}
	/*
		필요한 순간에 접속을 해야 한다.
		접속은 직접하는 것이 아니고
		커넥션 풀에 있는 커넥션을 얻어와서 사용하면 된다.
	*/
	// 커넥션 풀의 커넥션을 얻어오는 함수
	public Connection getCon() {
		Connection con = null;
		try {
			// 커넥션 풀을 관리하는 DataSource에서 빌려온다.
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// Statement 를 만드는 함수
	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	// PreparedStatement 를 만드는 함수
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	// 더 이상 사용하지 않는 자원을 반환해주는 함수
	public void close(Object o) {
		// 닫아야 할 객체의 종류가 많으므로
		// 모든 것을 다 받을 수 있는 Object 타입으로 매개변수를 정한다.
		// 이후 Object 로 넘어온 객체를 자신의 형태에 맞는 타입으로 강제 형변환해서 닫아주면 된다.
		try {
			if(o instanceof Connection) {
				((Connection) o).close();
			} else if(o instanceof Statement) {
				((Statement) o).close();
			} else if(o instanceof PreparedStatement) {
				((PreparedStatement) o).close();
			} else if(o instanceof ResultSet) {
				((ResultSet) o).close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}





