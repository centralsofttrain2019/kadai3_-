package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeListDispBean;
import service.EmployeeService;


	/**
	 * Servlet implementation class IndexStartServlet
	 */
	@WebServlet("/EmployeeDispServlet")
	public class EmployeeListDispServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public EmployeeListDispServlet() {
	        super();
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(
				HttpServletRequest request,
				HttpServletResponse response)
						throws ServletException, IOException
		{

			System.out.println("StartServletが実行されました。");


			//サービスを取得
			EmployeeService service = new EmployeeService();
			EmployeeListDispBean bean = service.findAll();

			//beanをリクエストにセット キー名は「bean」とする
			request.setAttribute("bean", bean);
			//JSPに遷移する
			RequestDispatcher disp = request.getRequestDispatcher("/employeeDisp.jsp");
			disp.forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	}

