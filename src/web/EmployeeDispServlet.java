package web;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeDispBean;
import dao.Dao;
import dao.EmployeesDao;

/**
 * Servlet implementation class IndexStartServlet
 */
@WebServlet("/EmployeeDispServlet")
public class EmployeeDispServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDispServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDispBean bean = null;//Employee bean = new Employee;

		try (Connection con = Dao.getConnection();) {

			EmployeesDao dao = new EmployeesDao(con);

			int id = Integer.parseInt(request.getParameter("id"));
			bean = dao.findByKey(id);//dao.findByKey(bean,id);beanが生き残る

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}

		request.setAttribute("bean", bean);

		RequestDispatcher disp = request.getRequestDispatcher("/employee_disp.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
