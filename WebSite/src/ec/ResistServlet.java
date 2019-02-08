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
 * Servlet implementation class ResistServlet
 */
@WebServlet("/ResistServlet")
public class ResistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ログインセッションがあればユーザー情報へ飛ぶ
		HttpSession session =request.getSession(false);
		if(session.getAttribute("loginUser")!= null ) {
			session =request.getSession(true);
			response.sendRedirect("UserDataServlet");
			return;
		}
		//新規登録jspにforward
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Resist.jsp");
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
				String password2 =request.getParameter("password2");
				String name =request.getParameter("name");
				String address=request.getParameter("address");

				// リクエストパラメータの入力項目を引数に渡して、resisterUserのメソッドを実行
				UserDAO userDao = new UserDAO();
				userDao.findSameloginId(loginId);



				if(!(password.equals(password2))){

					request.setAttribute("error", "パスワードに誤りがあります。");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Resist.jsp");
					dispatcher.forward(request, response);
					return;

				}if(loginId.isEmpty()||password.isEmpty()||password2.isEmpty()||name.isEmpty()||address.isEmpty()) {

					request.setAttribute("error", "未入力の項目があります。");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Resist.jsp");
					dispatcher.forward(request, response);
					return;
				}if(userDao.findSameloginId(loginId)) {

					request.setAttribute("error", "そのログインIDはすでに使われています。");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Resist.jsp");
					dispatcher.forward(request, response);
					return;
				}

				UserBeans resist =new UserBeans(loginId,name,address, password);
				// セッションスコープを取得
				HttpSession session = request.getSession();
				//セッションスコープにインスタンスを保存
				session.setAttribute("resist", resist);

				//userDao.resisterUser(loginId,name,address, password);
				// サーブレットにリダイレクト
				response.sendRedirect("UserUpdateConfirmServlet");
	}

}
