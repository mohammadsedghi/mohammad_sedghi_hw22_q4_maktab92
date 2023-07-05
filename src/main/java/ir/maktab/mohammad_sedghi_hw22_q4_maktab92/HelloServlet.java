package ir.maktab.mohammad_sedghi_hw22_q4_maktab92;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(name = "helloServlet", value = "/greeting")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      String username=request.getParameter("fname");
      String password=request.getParameter("lname");
      if (username.equals("aaa"))response.sendRedirect("electionPage.html");
      try(PrintWriter out=response.getWriter()){
          out.print(username);
      }

        response.setContentType("text/html");


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + username + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}