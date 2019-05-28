package web;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeDispBean;
import bean.LoginBean;
import service.EmployeeService;

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

		EmployeeService service = new EmployeeService();
		EmployeeDispBean bean = new EmployeeDispBean();
        bean = service.findByKey( request.getParameter("id") );

		//セッションからログイン情報を取得
		LoginBean loginBean = (LoginBean)request.getSession().getAttribute("loginBean");
		bean.setLoginBean(loginBean);

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
