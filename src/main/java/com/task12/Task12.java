package com.task12;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Task12 extends javax.servlet.http.HttpServlet {
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

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    countOfUsers++;

    drawMessage("You are " + countOfUsers + "th visitor", response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

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

  public static void drawMessage(String message, HttpServletResponse response) throws IOException {
    response.setContentType("image/jpeg");
    BufferedImage image = new BufferedImage(1080, 300, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = image.createGraphics();
    graphics.setFont(new Font("Monospaced", Font.ROMAN_BASELINE, 60));
    graphics.setColor(Color.RED);
    graphics.drawString(message, 100, 100);
    ImageIO.write(image, "jpeg", response.getOutputStream());
  }
}
