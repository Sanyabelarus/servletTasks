package com.task14;

import com.task14.dao.DAOListExpensesImpl;
import com.task14.dao.ListExpensesException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Task14 extends javax.servlet.http.HttpServlet {

  private static DAOListExpensesImpl dao = DAOListExpensesImpl.getDAOListExpensesImpl();

  @Override
  public void init() {
    try {
      dao.getConnection();
    } catch (ListExpensesException e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    ResultSet result;
    try {
      result =
          dao.executeQueryAtListExpenses(
              "select e.num,paydate,name,value from expenses as e,receivers as r where receiver=r.num;");
      PrintWriter out = response.getWriter();

      out.println("<html><head><title>Task14</title></head>");
      out.println("<body><h1>Table of expenses</h1>");
      out.println("<table style=\"width:100%\"><tr>");
      out.println("<th>Num</th>");
      out.println("<th>Pay Date</th>");
      out.println("<th>Receiver</th>");
      out.println("<th>Value</th></tr>");
      while (result.next()) {
        out.println("<tr><td>" + result.getString(1) + "</td>");
        out.println("<td>" + result.getString(2) + "</td>");
        out.println("<td>" + result.getString(3) + "</td>");
        out.println("<td>" + result.getString(4) + "</td></tr>");
      }
      out.println("</body></html>");
    } catch (ListExpensesException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  public void destroy() {
    try {
      dao.closeConnection();
    } catch (ListExpensesException e) {
      e.printStackTrace();
    }
  }
}
