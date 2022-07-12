package com.myprojects.tastyapp;

import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        String customer = request.getParameter("customer");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Hello " + customer + "</h1>");
//        out.println("</body></html>");

        response.setContentType("application/json");

        JSONObject customer = new JSONObject();

        customer.put("email", "emma@gmail.com");
        customer.put("first_name", "Emma");
        customer.put("last_name", "Chen");
        customer.put("age", 18);

        response.getWriter().print(customer);
    }

    public void destroy() {
    }
}