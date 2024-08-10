package donation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dao.DonationDao;
import donation.dto.DonationDto;

@WebServlet("/addDonationPage/addDonation")
public class addDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String categories = request.getParameter("categories");
		String text = request.getParameter("content");
		String startDate = request.getParameter("startDate");
		String lastDate = request.getParameter("lastDate");
		String points = request.getParameter("points");
		String targetAmount = request.getParameter("targetAmount");

		// dto 객체 생성 및 데이터 설정
		DonationDto dto = new DonationDto();
		dto.setTitle(title);
		dto.setCategories(categories);
		dto.setText(text);
		dto.setStartDate(startDate);
		dto.setLastDate(lastDate);
		dto.setPoints(points);
		dto.setTargetAmount(targetAmount);
		
		DonationDao dao = new DonationDao();
		try {
			dao.insertDonation(dto);
			response.sendRedirect("/donation/main/main.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}