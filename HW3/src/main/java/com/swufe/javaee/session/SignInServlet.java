package com.swufe.javaee.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String password = req.getParameter("inputPassword");

        String f = "C:\\password\\pswd.txt";

        List<String> lines = Files.readAllLines(Paths.get(f));



        Map<String, String> m = new HashMap<>();

        for (String line : lines) {
            String[] name_pwd = line.split(" ");
            m.put(name_pwd[0], name_pwd[1]);
        }

         if (m.containsKey(name)) {
             if (m.get(name).equals(password)) {
                 req.getSession().setAttribute("user", name);
                 req.getSession().setAttribute("key", password);
                 resp.sendRedirect("index");
             } else {
                 req.getRequestDispatcher("error.html").forward(req, resp);
             }
         } else {
             req.getRequestDispatcher("error.html").forward(req, resp);

         }




    }
}