package edu.elon.events;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chayes10
 */
@WebServlet(name = "HalloweenServlet", urlPatterns = {"/goelon"})
public class HalloweenServlet extends HttpServlet {


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    String url = "/index.html";
    String action = request.getParameter("action");
    
    if (action == null) {
      action = "return";  // default action
    }

    // perform action and set URL to appropriate page
    if (action.equals("return")) {
      url = "/index.html";
    } else if (action.equals("add")) {
      url = "/subscribe.html";
      System.out.println("First Name: " + request.getParameter("firstName"));
      System.out.println("Last Name: " + request.getParameter("lastName"));
      System.out.println("Email: " + request.getParameter("email"));
      System.out.println("Zip: " + request.getParameter("zip"));
    }

    getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
  }
  
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doPost(request, response);
  }
}
