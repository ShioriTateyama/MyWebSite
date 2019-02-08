package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBeans;
import dao.UserDAO;
/**
 * Servlet implementation class UserDataServlet
 */
@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインセッションがない場合、ログイン画面にリダイレクトさせる
				HttpSession session =request.getSession(false);
				if(session.getAttribute("loginUser")== null ) {
					session =request.getSession(true);
					response.sendRedirect("LoginServlet");
					return;
				}

				// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("userId");
				int userId=Integer.parseInt(id);
				// 確認用：idをコンソールに出力
				System.out.println(userId);

				UserDAO userDao =new UserDAO();
				UserBeans loginUserInfo =userDao.referUser(userId);

				//requestスコープにインスタンスを保存
				request.setAttribute("loginUserInfo", loginUserInfo);

				RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/UserData.jsp");
				dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
