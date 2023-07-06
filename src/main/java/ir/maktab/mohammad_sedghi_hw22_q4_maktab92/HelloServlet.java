package ir.maktab.mohammad_sedghi_hw22_q4_maktab92;

import java.io.*;
import java.util.Arrays;

import base.repository.util.HibernateUtil;
import entity.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.Impl.PersonRepositoryImpl;
import repository.PersonRepository;
import service.Impl.PersonServiceImpl;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(name = "helloServlet", value = "/greeting")
public class HelloServlet extends HttpServlet {
    private String message;
    PersonRepository personRepository;
    PersonServiceImpl personService;
    private SessionFactory sessionFactory;
public static Person member;
    public void init() {
       sessionFactory = HibernateUtil.getSessionFactory();

        message = "Hello World!hhhh";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String username = request.getParameter("fname");
//        String password = request.getParameter("lname");
//        if (username.equals("a")) response.sendRedirect("electionPage.html");
//
//        String selectedValue = request.getParameter("selectedValue");
//        response.setContentType("text/plain");
//        PrintWriter out = response.getWriter();
//        out.println("Selected value: " + selectedValue);
//        out.println("<html><body>");
//        out.println("<h1>" + selectedValue + "</h1>");
//        out.println("</body></html>");

        Session session = sessionFactory.openSession() ;
            personRepository = new PersonRepositoryImpl(session);
            personService = new PersonServiceImpl(personRepository);

            String username = request.getParameter("fname");
            String password = request.getParameter("lname");
            personService.findByUsernameAndPassword(username, password);
            System.out.println(username);
            System.out.println(password);
            if (member == null) response.sendRedirect("login.html");
            else {
                response.sendRedirect("electionPage.html");
            }
        String selectedValue = request.getParameter("selectedValue");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Selected value: " + selectedValue);
        out.println("<html><body>");
        out.println("<h1>" + selectedValue + "</h1>");
        out.println("</body></html>");




//      try(PrintWriter out=response.getWriter()){
//          out.print(username);
//      }
//        response.setContentType("text/html");

//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + username + "</h1>");
//        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String selectedChoice = request.getParameter("option");
//        System.out.println(selectedChoice);
//        response.setContentType("text/plain");
//        response.getWriter().write("Vote submitted successfully");

//        String[] selectedChoices = request.getParameterValues("choices");
//        Arrays.stream(selectedChoices).forEach(System.out::println);
//
//        response.setContentType("text/plain");
//        response.getWriter().write("Vote submitted successfully");
        Session session = sessionFactory.openSession() ;
        personRepository = new PersonRepositoryImpl(session);
        personService = new PersonServiceImpl(personRepository);
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        Person person=new Person(firstName,lastName,username,password);
        personService.save(person);
        System.out.println("ths person is saved");
        response.sendRedirect("electionPage.html");
    }
    public void destroy() {
    }
}