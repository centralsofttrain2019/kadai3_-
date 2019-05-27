package web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginBean;
import service.EmployeeService;

/**
 * Servlet implementation class LoginSrvlet
 */
@WebServlet("/LoginSrvlet")
public class LoginSrvlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSrvlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
            )  throws ServletException, IOException
    {

        System.out.println("StartServletが実行されました。");

        //画面から入力したデータを取得する


        String str =request.getParameter("loginId");
        byte[] bi = str.getBytes("iso-8859-1");
        String loginId = new String( bi, "UTF-8" );

        //String password = request.getParameter("password");

        //bean のインスタンスを生成する
        LoginBean bean = new LoginBean();
        bean.setLoginId( loginId );
        //bean.setPassword( password );
        bean.setLoginDateTime( LocalDateTime.now() );

        //serviceのインスタンスを生成する
        EmployeeService service = new EmployeeService();
        service.findByKey( loginId );

        //セッションの今回の計算結果を保存
        //request.getSession().setAttribute("loginBean", bean);

        HttpSession ss= request.getSession();
        ss.setAttribute("loginBean", bean);


        //beanをリクエストにセット キー名は「bean」とする
        request.setAttribute("bean", bean);

        //JSPに遷移する
        RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
        disp.forward(request, response);

    }
}
