package donation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import donation.dto.ImageDto;

public class ImageDao{
	// DB 연결 parameters
	private String jdbcURL = "jdbc:donation_database_url";
	private String jdbcUsername ="donation_db_username";
	private String jdbcPassword ="donation_db_password";
	
	public List<donation.dto.ImageDto> findAll(){
		List<donation.dto.ImageDto> images = new ArrayList<>();
		String sql = "SELECT image_name, image_url FROM images";
		
		try(Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				ImageDto image = new ImageDto();
				image.setImageName(rs.getString("image_name"));
				image.setImageUrl(rs.getString("image_url"));
				images.add(image);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return images;
	}		
}
