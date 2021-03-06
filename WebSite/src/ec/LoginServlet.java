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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインセッションがある場合、ユーザ一覧画面にリダイレクトさせる

		HttpSession session = request.getSession();
				if(request.getSession().getAttribute("loginUser")!=null) {
					response.sendRedirect("UserDataServlet");
					return;
				}
				session.removeAttribute("resist");
				//ログインjspにforward
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
				request.setCharacterEncoding("UTF-8");

				// リクエストパラメータの入力項目を取得
				String loginId =request.getParameter("loginId");
				String password =request.getParameter("password");


				// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
				UserDAO userDao = new UserDAO();
				UserBeans loginUser = userDao.findByLoginInfo(loginId, password);

				if(loginUser ==null) {
					//インスタンスをリクエストスコープに保存
					request.setAttribute("error", "ログインIDまたはパスワードが異なります" );

					// ログインjspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
					dispatcher.forward(request, response);
					return;
				}

				// セッションスコープを取得
				HttpSession session = request.getSession();
				//セッションスコープにインスタンスを保存
				session.setAttribute("loginUser", loginUser);

				// indexのサーブレットにリダイレクト
				response.sendRedirect("IndexServlet");

			}



}
