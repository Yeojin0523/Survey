package donation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donation.dto.DonationListDto;
import oracle.db.DBConnect;

public class DonationListDao {

	// 기부 데이터 삽입
	public void insertDonation(DonationListDto dto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO donation (seq, title, categories, text, start_date, last_date, points, target_amount) "
				+ "VALUES (seq_Donation.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 값 바인딩
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getCategories());
			pstmt.setString(3, dto.getText());
			pstmt.setString(4, dto.getStartDate());
			pstmt.setString(5, dto.getLastDate());
			pstmt.setString(6, dto.getPoints());
			pstmt.setString(7, dto.getTargetAmount());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.DBClose(pstmt, conn);
		}
	}

	// 모든 기부 데이터 조회
	public Vector<DonationListDto> getAllDatas() throws Exception {
		Vector<DonationListDto> list = new Vector<DonationListDto>();

		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM donation ORDER BY seq";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DonationListDto dto = new DonationListDto();
				dto.setSeq(rs.getInt("seq"));
				dto.setText(rs.getString("text"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.DBClose(rs, pstmt, conn);
		}
		return list;
	}

	// 기부 데이터 삭제
	public void deleteDonation(Integer seq) throws Exception {
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM donation WHERE seq = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.DBClose(pstmt, conn);
		}
	}

	// 하나의 기부 데이터 조회
	public DonationListDto getData(Integer seq) throws Exception {
		DonationListDto dto = new DonationListDto();
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM donation WHERE seq = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setSeq(rs.getInt("seq"));
				dto.setText(rs.getString("text"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.DBClose(rs, pstmt, conn);
		}
		return dto;
	}

	// 기부 데이터 수정
	public void updateDonation(DonationListDto dto) throws Exception {
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE donation SET text = ? WHERE seq = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getText());
			pstmt.setInt(2, dto.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.DBClose(pstmt, conn);
		}
	}
}
