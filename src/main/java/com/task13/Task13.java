package com.task13;

import com.task12.Task12;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Task13 extends javax.servlet.http.HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    boolean flag = false;
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      if ("wasHere".equals(cookie.getName())) {
        flag = true;
        break;
      }
    }
    if (flag) {
      Task12.drawMessage("You was here today", response);
    } else {
      Cookie c = new Cookie("wasHere", "true");
      c.setMaxAge(60 * 60 * 24);
      response.addCookie(c);

      super.doGet(request, response);
    }
  }

  protected void doPost(
      javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {}
}
