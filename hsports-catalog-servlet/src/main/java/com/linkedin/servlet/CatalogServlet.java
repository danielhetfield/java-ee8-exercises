package com.linkedin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet("/CatalogServlet")
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("/" + request.getParameter("name"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	  */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Getting data from the form
		String name = request.getParameter("name");
		String manufacturer = request.getParameter("manufacturer");
		String sku = request.getParameter("sku");
		//Setting a sample header and cookie
		response.setHeader("someHeader", "someHeaderValue");
		response.addCookie(new Cookie("someCookie","someCookieValue"));
		//Adding this data to the Catalog
		Catalog.addItem(new CatalogItem(name,manufacturer,sku));
		//Adding products as request attribute
		request.setAttribute("products", Catalog.getItems());
		//Sending control to JSP page for rendering.
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);		
	}
}
