package org.riya.ServeletEx;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServer extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("In service");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2><b>HELLO WORLD</h2></b>");
	}
}
