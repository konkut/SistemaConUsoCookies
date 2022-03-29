/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.sistemadetectorvisitas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;
        Cookie[] cokies = request.getCookies();
        if (cokies != null) {
            for (Cookie c : cokies) {
                if (c.getName().equals("visitas")) {
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        contador++;
        Cookie c = new Cookie("visitas", Integer.toString(contador));
        c.setMaxAge(3600);
        response.addCookie(c);
        response.setContentType("text/html");
        response.sendRedirect("index.jsp?contador="+contador);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
