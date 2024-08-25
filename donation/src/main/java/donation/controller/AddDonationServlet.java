package donation.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import donation.dao.DonationListDao;
import donation.dto.DonationListDto;

@WebServlet("/AddDonationServlet")
@MultipartConfig
public class AddDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청에서 파라미터 가져오기
		String title = request.getParameter("title");
		String categories = request.getParameter("categories");
		String text = request.getParameter("text");
		String startDate = request.getParameter("startDate");
		String lastDate = request.getParameter("lastDate");
		String points = request.getParameter("points");
		String targetAmount = request.getParameter("targetAmount");

		// 파일 업로드 처리
		Part filePart = request.getPart("file"); // 파일 part 가져오기
		
		if (filePart == null || filePart.getSize() == 0) {
		    // Handle the case where no file was uploaded
		    System.out.println("No file uploaded or file is empty.");
		    response.sendRedirect("error.jsp"); // Redirect to an error page or show an error message
		    return; // 여기서 에러나는 건 확실
		}

		String filePath = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		File file = new File(filePath);
		filePart.write(file.getAbsolutePath());
		
		// DTO 객체 생성 및 데이터 설정
		DonationListDto dto = new DonationListDto();
		dto.setTitle(title);
		dto.setCategories(categories);
		dto.setText(text);
		dto.setStartDate(startDate);
		dto.setLastDate(lastDate);
		dto.setPoints(points);
		dto.setTargetAmount(targetAmount);
		dto.setImagePath(filePath); // 이미지 경로 설정

		// DAO를 통해 데이터베이스에 기부 데이터 삽입
		DonationListDao dao = new DonationListDao();
		try {
            dao.insertDonation(dto);
            response.sendRedirect("main.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Donation could not be added");
        }
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response); // GET 요청도 POST와 동일하게 처리
	}
}
