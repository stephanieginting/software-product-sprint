package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that responds with the current date. */
@WebServlet("/message")
public class MessageServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String json = newJson();
    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

    /**
   * Creates a new Json 
   */
  private String newJson() {
    String json = "{";
    json += "\"message1\": ";
    json += "\"Don't forget to drink water today\"";
    json += ", ";
    json += "\"message2\": ";
    json += "\"Sleep at reasonable hours >:0\"";
    json += ", ";
    json += "\"message3\": ";
    json += "\"Go outside!\"";
    json += "}";
    return json;
  }
}

