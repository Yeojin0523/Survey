package Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import oracle.db.DBConnect;

public class BlogDao{
	public void insertBlog(BlogDto dto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into Blog (seq, text) "
				+ "values (seq_blog.NEXTVAL, ?)";
		
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 값 담아주고 바인딩. ?? 에 값 담아주기
			pstmt.setString(1, dto.getText());
			pstmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			DBConnect.DBClose(pstmt, conn);
		}
	}

	public Vector<BlogDto> getAllDatas() throws Exception{
		Vector<BlogDto> list = new Vector<BlogDto>();
	
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String sql = "SELECT * FROM blog" +
					"ORDER BY seq";
	
		try {
			// PrepareStatement와 ResultSet객체를 이용해 sql 명령문을 전달 후 실행 및 데이터 가져옴
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				// dto 선언
				// set( 값을 넣거나 수정하고, list에 추가해줘야 한다.)
				BlogDto dto = new BlogDto();
				dto.setSeq(rs.getInt("seq"));
				dto.setText(rs.getString("text"));
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.DBClose(rs, pstmt, conn);
		}
		return list;
	}
	
	public void deleteBlog(Integer seq) throws Exception {
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(0, seq);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.DBClose(pstmt, conn);
		}
	}
	
	// update 
	// 하나의 데이터 조회
	public BlogDto getData(Integer seq) throws Exception{
		BlogDto dto = new BlogDto();
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setSeq(rs.getInt(0));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBConnect.DBClose(rs, pstmt, conn);
		}
		return dto;
	}
	// update
	// 수정하기
	public void updateBlog(BlogDto dto) throws Exception {
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt= null;
		String sql = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(0, dto.getSeq());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.DBClose(pstmt, conn);
		}
	}
}
