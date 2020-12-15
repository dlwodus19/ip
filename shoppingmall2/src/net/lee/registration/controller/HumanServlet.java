package net.lee.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.lee.registration.dao.HumanDao;
import net.lee.registration.model.Human;

/**
 * Servlet implementation class HumanServlet
 */
@WebServlet("")
public class HumanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private HumanDao humanDao = new HumanDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HumanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/humanregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Human human = new Human();
		human.setFirstName(firstName);
		human.setLastName(lastName);
		human.setUsername(username);
		human.setPassword(password);
		human.setAddress(address);
		human.setContact(contact);
		
		try {
			humanDao.registerHuman(human);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/humandetails.jsp");
		dispatcher.forward(request, response);
	}

}
