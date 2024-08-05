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

import donation.dto.DonationDto;

@WebServlet("/DonationServlet")
public class DonationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 폼으로부터 전달된 파라미터를 받습니다.
        String seqParam = request.getParameter("seq");
        String text = request.getParameter("text");
        System.out.println("Received seq parameter: " + seqParam);
        System.out.println("Received text parameter: " + text);

        int seq = Integer.parseInt(seqParam);
        DonationDto donation = new DonationDto();
        donation.setSeq(seq);
        donation.setText(text);

        // DonationDto 객체를 request에 설정
        request.setAttribute("donation", donation);
        System.out.println("Donation object set: seq=" + donation.getSeq() + ", text=" + donation.getText());

        // DisplayTextServlet으로 포워딩
        request.getRequestDispatcher("/main/DisplayTextServlet").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
