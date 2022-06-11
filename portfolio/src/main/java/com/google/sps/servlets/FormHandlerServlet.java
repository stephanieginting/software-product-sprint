package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/comment")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String note = request.getParameter("note-input");
    String email = request.getParameter("email");

    // Print the value so you can see it in the server logs.
    System.out.println("Thank you for your note!");

    // Write the value to the response so the user can see it.
    response.getWriter().println("User with email address " + email +" sent this note: " + note);
  }
}
