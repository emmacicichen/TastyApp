package com.myprojects.tastyapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myprojects.tastyapp.entity.Customer;
import org.apache.commons.io.IOUtils;
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

//        JSONObject customer = new JSONObject();
//
//        customer.put("email", "emma@gmail.com");
//        customer.put("first_name", "Emma");
//        customer.put("last_name", "Chen");
//        customer.put("age", 18);
        ObjectMapper mapper = new ObjectMapper();

        Customer customer = new Customer();
        customer.setEmail("emma@gmail.com");
        customer.setPassword("123456");
        customer.setFirstName("emma");
        customer.setLastName("chen");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));
    }

    public void destroy() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //read customer info from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("firstName");
        String lastName = jsonRequest.getString("lastName");
        int age = jsonRequest.getInt("age");
        //print customer's info
        System.out.println("Email is:" + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        System.out.println("Age is: " + age);

        //return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }
}