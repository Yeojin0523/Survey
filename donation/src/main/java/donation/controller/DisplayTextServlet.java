package donation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이전에 DonationServlet에서 가져온 데이터를 클라이언트에게 보여주는 역할

@WebServlet("/main/DisplayTextServlet")
public class DisplayTextServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		
		String text = request.getParameter("text");
		request.setAttribute("text", text);
		// request.getRequestDispatcher("/donation/donationText.jsp").forward(request, response);
	
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/donation/donationText.jsp");
		dispatcher.forward(request, response);
	}
}