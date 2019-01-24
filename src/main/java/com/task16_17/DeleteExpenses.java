package com.task16_17;

import com.task14.dao.DAOListExpensesImpl;
import com.task14.dao.ListExpensesException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class DeleteExpenses extends javax.servlet.http.HttpServlet {

    private static DAOListExpensesImpl dao =DAOListExpensesImpl.getDAOListExpensesImpl();



    @Override
    public void init() {
        try {
            dao.getConnection();
        } catch (ListExpensesException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("deleteExpense.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException{
        String message="";
        String query = "delete from expenses where expenses.num="+request.getParameter("num")+";";
        try {
            boolean flag=dao.executeUpdateAtListExpenses(query);
            if (flag){
                message="Expense has been deleted";
            }else {
                message="Expense hasn't been deleted";
            }
        } catch (ListExpensesException e) {
            message+=e.toString();
            e.printStackTrace();
        }
        request.setAttribute("message",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request,response);
    }


    @Override
    public void destroy(){
        try {
            dao.closeConnection();
        } catch (ListExpensesException e) {
            e.printStackTrace();
        }
    }
}
