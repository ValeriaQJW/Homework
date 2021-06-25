package com.swufe.javaee.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbiesServlet extends HttpServlet {
    private Map<String,List<String>> hobbies;

    @Override
    public void init() {

        hobbies = new HashMap<>();
        hobbies.put("Bob", Arrays.asList("knitting","scuba","skiing"));
        hobbies.put("Jim", Arrays.asList("singing","scuba","reading"));
        hobbies.put("James",Arrays.asList("knitting","dating","skiing"));
        hobbies.put("Tom",Arrays.asList("singing","dating","reading"));
        hobbies.put("Fei",Arrays.asList("knitting","scuba","skiing"));
        hobbies.put("Jone",Arrays.asList("singing","scuba","reading"));
        hobbies.put("Fred",Arrays.asList("knitting","dating","skiing"));
        hobbies.put("Pradeep", Arrays.asList("singing","dating","reading"));
        hobbies.put("Philippe", Arrays.asList("knitting","scuba","skiing"));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hobby = request.getParameter("hobby");
        List<String> names = new ArrayList<>();
        hobbies.forEach((k, v) -> {
            if (v.contains(hobby)) {
                names.add(k);
            }
        });
        request.setAttribute("names", names);
        request.setAttribute("hobby", hobby);
        // Two JSPs have different UI styles..。
        //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
        request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}

