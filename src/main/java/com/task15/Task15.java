package com.task15;

import com.task14.dao.DAOListExpensesImpl;
import com.task14.dao.ListExpensesException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Task15 extends javax.servlet.http.HttpServlet {

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
      throws IOException, ServletException {
    ResultSet result;
    try {
      result =
          dao.executeQueryAtListExpenses(
              "select e.num,paydate,name,value from expenses as e,receivers as r where receiver=r.num;");
      ArrayList<ArrayList<String>> listOfResult = new ArrayList<>();
      while (result.next()) {
        ArrayList<String> line = new ArrayList<>();
        line.add(result.getString(1));
        line.add(result.getString(2));
        line.add(result.getString(3));
        line.add(result.getString(4));
        listOfResult.add(line);
      }

      request.setAttribute("result", listOfResult);

      RequestDispatcher dispatcher = request.getRequestDispatcher("task15.jsp");
      dispatcher.forward(request, response);

    } catch (ListExpensesException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
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
