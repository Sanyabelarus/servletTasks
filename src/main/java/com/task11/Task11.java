package com.task11;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Task11 extends javax.servlet.http.HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String browser = request.getHeader("User-Agent");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>Task11</title></head>");
    out.println("<body><h1>Hello of the the " + browser + " user</h1>");
    out.println("</body></html>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
