package donation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dao.DonationDao;
import donation.dto.DonationDto;

@WebServlet("/AddDonationSevlet")
public class AddDonationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 요청에서 파라미터 가져오기
        String title = request.getParameter("title");
        String categories = request.getParameter("categories");
        String text = request.getParameter("content");
        String startDate = request.getParameter("startDate");
        String lastDate = request.getParameter("lastDate");
        String points = request.getParameter("points");
        String targetAmount = request.getParameter("targetAmount");

        // DTO 객체 생성 및 데이터 설정
        DonationDto dto = new DonationDto();
        dto.setTitle(title);
        dto.setCategories(categories);
        dto.setText(text);
        dto.setStartDate(startDate);
        dto.setLastDate(lastDate);
        dto.setPoints(points);
        dto.setTargetAmount(targetAmount);

        // DAO를 통해 데이터베이스에 기부 데이터 삽입
        DonationDao dao = new DonationDao();
        try {
            dao.insertDonation(dto);
            // 삽입 후 메인 페이지로 리다이렉트
            response.sendRedirect("/donation/main/main.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Donation could not be added.");
        }
        
        request.setAttribute("donation", dto);
        request.getRequestDispatcher("/DisplayAddDonationServlet").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  // GET 요청도 POST와 동일하게 처리
    }
}