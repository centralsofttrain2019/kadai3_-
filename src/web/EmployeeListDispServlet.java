package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeListDispBean;
import bean.LoginBean;
import service.EmployeeService;



/**
 * Servlet implementation class IndexStartServlet
 */
@WebServlet("/EmployeeListDispServlet")
public class EmployeeListDispServlet extends HttpServlet
{
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
			HttpServletResponse response
			) 	throws ServletException, IOException
	{

		//サービスを取得
		EmployeeService service = new EmployeeService();
		EmployeeListDispBean bean = service.findAll( );


		//セッションからログイン情報を取得
		LoginBean loginBean = (LoginBean)request.getSession().getAttribute("loginBean");
		bean.setLoginBean(loginBean);


		//beanをリクエストにセット キー名は「bean」とする
		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/employeeListDisp.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
