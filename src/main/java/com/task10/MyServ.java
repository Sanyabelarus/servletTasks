package com.task10;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class MyServ extends javax.servlet.http.HttpServlet {
  protected void doGet(
      javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {
    String name = request.getParameter("Name");
    String eMail = request.getParameter("E-mail");
    String phone = request.getParameter("Phone");
    boolean flag =
        (((name == null) || ("".equals(name)))
            || (((eMail == null) || ("".equals(eMail)))
                && ((phone == null) || (("".equals(phone))))));
    if (flag) {
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Exception");
      dispatcher.forward(request, response);
    } else {
      PrintWriter out = response.getWriter();

      out.println("<html><head><title>MyServ</title></head>");
      out.println("<body><h1>Hello " + name + "</h1>");
      if (eMail != null) {
        out.println("<h1>E-mail " + eMail + "</h1>");
      }
      if (phone != null) {
        out.println("<h1>Phone " + phone + "</h1>");
      }
      out.println("</body></html>");
    }
  }

  protected void doPost(
      javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {
    doGet(request, response);
  }

}