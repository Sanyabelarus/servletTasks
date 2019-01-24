package com.task9;

import java.io.*;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Count extends javax.servlet.http.HttpServlet {

  private static long countOfUsers;

  private static final String PATH =
      "E:\\java\\tutorials\\homework\\servletTasks\\src\\main\\resources\\count.dat";

  public void init() {
    DataInputStream stream = null;
    try {
      stream = new DataInputStream(new BufferedInputStream(new FileInputStream(PATH)));
      countOfUsers = stream.readLong();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (stream != null) {
        try {
          stream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  protected void doGet(
      javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {
    countOfUsers++;
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>Counter</title></head>");
    out.println("<h1>You are " + countOfUsers + "th on this site</h1>");
  }

  protected void doPost(
      javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {}

  public void destroy() {
    DataOutputStream stream = null;
    try {
      stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(PATH)));
      stream.writeLong(countOfUsers);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (stream != null) {
        try {
          stream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
