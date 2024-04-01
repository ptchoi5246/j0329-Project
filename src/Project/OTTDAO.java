package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OTTDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	OTTVO vo = null;
	
	public OTTDAO() {

		String url = "jdbc:mysql://localhost:3306/javaclass16";
		String user = "root";
		String pwd = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연결 실패 : " + e.getMessage());
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			pstmtClose();
		} catch (SQLException e) {}
	}

	
	//메인 - 쿠팡 - 전체보기
	public Vector getCoupangList(String str, String order) {
		Vector vData = new Vector<>();
		
			try {
				if(str.equals("name") && order.equals("a")) {
					sql = "select idx, name, genre, open from coupang order by name";
				}
				else if(str.equals("name") && order.equals("d")) {
					sql = "select idx, name, genre, open from coupang order by name desc";
				}
				else {
					sql = "select idx, name, genre, open from coupang order by idx";
				}
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Vector vo = new Vector<>();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getString("genre"));
					vo.add(rs.getInt("open"));
					
					vData.add(vo);
				}
			} catch (SQLException e) {
				System.out.println("SQL 오류 : " + e.getMessage());
			} finally {
				rsClose();
			}
		return vData;
	}
	
	//메인 - 디즈니 - 전체보기
	public Vector getDisneyList(String str, String order) {
		Vector vData = new Vector<>();
		
			try {
				if(str.equals("name") && order.equals("a")) {
					sql = "select idx, name, genre, open from disney order by name";
				}
				else if(str.equals("name") && order.equals("d")) {
					sql = "select idx, name, genre, open from disney order by name desc";
				}
				else {
					sql = "select idx, name, genre, open from disney order by idx";
				}
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Vector vo = new Vector<>();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getString("genre"));
					vo.add(rs.getInt("open"));
					
					vData.add(vo);
				}
			} catch (SQLException e) {
				System.out.println("SQL 오류 : " + e.getMessage());
			} finally {
				rsClose();
			}
		return vData;
	}
	
	//메인 - 넷플릭스 - 전체보기
	public Vector getNetflixList(String str, String order) {
		Vector vData = new Vector<>();
		
			try {
				if(str.equals("name") && order.equals("a")) {
					sql = "select idx, name, genre, open from netflix order by name";
				}
				else if(str.equals("name") && order.equals("d")) {
					sql = "select idx, name, genre, open from netflix order by name desc";
				}
				else {
					sql = "select idx, name, genre, open from netflix order by idx";
				}
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Vector vo = new Vector<>();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getString("genre"));
					vo.add(rs.getInt("open"));
					
					vData.add(vo);
				}
			} catch (SQLException e) {
				System.out.println("SQL 오류 : " + e.getMessage());
			} finally {
				rsClose();
			}
		return vData;
	}
	
	//메인 - 티빙 - 전체보기
	public Vector getTvingList(String str, String order) {
		Vector vData = new Vector<>();
		
			try {
				if(str.equals("name") && order.equals("a")) {
					sql = "select idx, name, genre, open from tving order by name";
				}
				else if(str.equals("name") && order.equals("d")) {
					sql = "select idx, name, genre, open from tving order by name desc";
				}
				else {
					sql = "select idx, name, genre, open from tving order by idx";
				}
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Vector vo = new Vector<>();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getString("genre"));
					vo.add(rs.getInt("open"));
					
					vData.add(vo);
				}
			} catch (SQLException e) {
				System.out.println("SQL 오류 : " + e.getMessage());
			} finally {
				rsClose();
			}
		return vData;
	}
	
	//OTT List and Search - 검색
	public Vector getConditionSearch(String fieldName, String txtCondi) {
		Vector vData = new Vector<>();
		
		System.out.println("fieldNa: " + fieldName + " , txtC: " + txtCondi);
		try {
			sql = "select * from otttotal where "+fieldName+" like ? order by name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%");
			rs = pstmt.executeQuery();
		
		
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("ott"));
				vo.add(rs.getString("genre"));
				vo.add(rs.getInt("open"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	
	
	//OTT List and Search - 전체보기
	public Vector getOTTList(String str, String order) {
		Vector vData = new Vector<>();
		
		try {
			if(str.equals("name") && order.equals("a")) {
				sql = "select * from otttotal order by name"; 
			}
			else if (str.equals("name") && order.equals("d")) {
				sql = "select * from otttotal order by name desc";
			}
			else {
				sql = "select * from otttotal order by name";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("ott"));
				vo.add(rs.getString("genre"));
				vo.add(rs.getInt("open"));
				
				vData.add(vo);
			}
					
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	// 작품명으로 검색하여 개별작품에 대한 정보 1건 가져오기
	public OTTVO getNameSearch(String name) {
		OTTVO vo = new OTTVO();
		try {
			sql = "select * from coupang where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setOtt(rs.getString("ott"));
				vo.setGenre(rs.getString("genre"));
				vo.setOpen(rs.getInt("open"));
				vo.setImg(rs.getString("img"));
				
				
				
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
