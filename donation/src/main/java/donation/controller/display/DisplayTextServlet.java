package donation.controller.display;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dto.DonationDto;

// 이전에 DonationServlet에서 가져온 데이터를 클라이언트에게 보여주는 역할

@WebServlet("/DisplayTextServlet")
public class DisplayTextServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        DonationDto donation = (DonationDto) request.getAttribute("donation");
        if (donation == null) {
            System.out.println("Donation object is null");
        } else {
            System.out.println("Donation text: " + donation.getText());
        }

        request.setAttribute("donation", donation);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/List/donationList.jsp");
        dispatcher.forward(request, response);
    }

    // doPost 메서드 추가
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
