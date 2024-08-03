package donation.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 역할: 필요에 따라 insertForm.jsp또는 다른 jsp 페이지로 리디렉션한다.
@WebServlet("/DonationServlet")
public class DonationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int seq = Integer.parseInt(request.getParameter("seq"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String text = "";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##systemid", "systempwd");
            String sql = "SELECT text FROM Donation WHERE seq = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                text = rs.getString("text");
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

        request.setAttribute("text", text);
        request.getRequestDispatcher("/DisplayTextServlet").forward(request, response);
    }
}