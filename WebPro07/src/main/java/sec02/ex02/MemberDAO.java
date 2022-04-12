package sec02.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
//	private static final String driver = "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String user = "scott";
//	private static final String pwd = "tiger";
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pw);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addMember(MemberVO vo) {
		try {
			con = dataFactory.getConnection();

			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();

			String query = "insert into t_member";
			query += "(id, pwd, name, email)";
			query += "values(?,?,?,?)";
			System.out.println("preparedStatement :" + query);
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();

			String query = "delete from t_member where id =?";
			System.out.println("preparedStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("oracle driver 로딩 성공");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("connection 생성 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
