package donation.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dto.DonationListDto;

@MultipartConfig
@WebServlet("/DonationServlet")
public class DonationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int seq = Integer.parseInt(request.getParameter("seq"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DonationListDto donation = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##systemid", "systempwd");
            String sql = "SELECT seq, text FROM donation WHERE seq = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                donation = new DonationListDto();
                donation.setSeq(rs.getInt("seq"));
                donation.setText(rs.getString("text"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("donation", donation);
        request.getRequestDispatcher("/DisplayTextServlet").forward(request, response);
    }

    // doPost 메서드 추가
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

