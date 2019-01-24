package com.task10;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Exception extends javax.servlet.http.HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>Exception</title></head>");
    out.println("<body><h1>Sorry. You must fill in all fields</h1>");
    out.println("<a href=\"http://localhost:8080/servletTasks/Form\">Back to Form</a>");
    out.println("</body></html>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
