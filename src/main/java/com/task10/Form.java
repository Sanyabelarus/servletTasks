package com.task10;

import javax.servlet.RequestDispatcher;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Form extends javax.servlet.http.HttpServlet {
  public void init() {}

  protected void doGet(
      javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>Form</title></head>");
    out.println("<body><h1>Please enter the data</h1>");
    out.println("<form action=\"/servletTasks/Myserv\" method=\"GET\">");
    out.println("Name<br><input type=\"text\" name=\"Name\"><br>");
    out.println("E-mail<br><input type=\"text\" name=\"E-mail\"><br>");
    out.println("Phone<br><input type=\"text\" name=\"Phone\"><br>");
    out.println("<input type=\"submit\" value=\"Submit\">");
    out.println("</body></html>");
  }

  protected void doPost(
      javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {
    doGet(request, response);
  }
}
