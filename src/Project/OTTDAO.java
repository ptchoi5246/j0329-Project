package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

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

	
	//메인 - 전체 보기 & 검색 // JTable 메인, 전체보기 버튼 getTotalList()
	public Vector getTotalList() {
		Vector vData = new Vector<>();
		
		try {
			sql = "select * from ott order by idx";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("ott"));
				vo.add(rs.getString("genre"));
				vo.add(rs.getString("open"));
				
				vData.add(vo);
			}
					
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	
	//메인 - 전체 보기 & 검색 :: getConditionSearch(String fieldName, String txtCondi)
	public Vector getConditionSearch(String fieldName, String txtCondi) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from ott where "+fieldName+" like ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%");
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("ott"));
				vo.add(rs.getString("genre"));
				vo.add(rs.getString("open"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	
	//해당OTT - 전체 보기 & 검색 :: 전체 보기 getOTTList(String ottName)
	public Vector getOTTList(String ottName) {
		Vector vData = new Vector<>();
		
		try {
			sql = "select * from ott where ott = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ottName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("ott"));
				vo.add(rs.getString("genre"));
				vo.add(rs.getString("open"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	

	//해당OTT - 전체 보기 & 검색 // getOTTConditionSearch(String fieldName, String txtCondi, String ottName)
	public Vector getOTTConditionSearch(String fieldName, String txtCondi, String ottName) {
		Vector vData = new Vector<>();
		
		try {
			sql = "select * from ott where "+fieldName+" like ? and ott = ? order by name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%");
			pstmt.setString(2, ottName);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("ott"));
				vo.add(rs.getString("genre"));
				vo.add(rs.getString("open"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	// OTT 중복처리(포스터, 작품 등록) getNameSearchOTT(String name)
	public OTTVO getNameSearchOTT(String name) {
		OTTVO vo = new OTTVO();
		try {
			sql = "select * from ott where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setOtt(rs.getString("ott"));
				vo.setGenre(rs.getString("genre"));
				vo.setOpen(rs.getString("open"));
				vo.setImg(rs.getString("img"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	
	//OTT 작품 등록 처리 setOTTInput(OTTVO vo)
	public int setOTTInput(OTTVO vo) {
		int res = 0;
		try {
			sql = "insert into ott values (default, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getOtt());
			pstmt.setString(3, vo.getGenre());
			pstmt.setString(4, vo.getOpen());
			pstmt.setString(5, vo.getImg());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류(등록처리) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
		
	// OTT 삭제 처리 setOTTDelete(String name)
	public int setOTTDelete(String name) {
		int res = 0;
		try {
			sql = "delete from ott where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류(삭제처리) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}


}
