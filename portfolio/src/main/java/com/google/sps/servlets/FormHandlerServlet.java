package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/comment")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // // Get the value entered in the form.
    // String note = request.getParameter("note-input");
    // String email = request.getParameter("email");

    // // Print the value so you can see it in the server logs.
    // System.out.println("Thank you for your note!");

    // // Write the value to the response so the user can see it.
    // response.getWriter().println("User with email address " + email +" sent this note: " + note);

    String note = Jsoup.clean(request.getParameter("note-input"), Whitelist.none());
    String email = Jsoup.clean(request.getParameter("email"), Whitelist.none());

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Comment");
    FullEntity commentEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("email", email)
            .set("note", note)
            .build();
    datastore.put(commentEntity);

    response.sendRedirect("/index.html");
    
  }
}
