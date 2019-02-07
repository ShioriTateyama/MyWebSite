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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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



		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String id = request.getParameter("user_id");
		int userId=Integer.parseInt(id);
		String loginId = request.getParameter("login_id");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String password =request.getParameter("password");
		String password2 =request.getParameter("password2");



		//リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		UserDAO userDao = new UserDAO();
		UserBeans user = userDao.referUser(userId);


		//失敗の時
		if(!(password.equals(password2))) {
			// idを引数にして、idに紐づくユーザ情報を出力する


			request.setAttribute("user", user);

			//インスタンスをリクエストスコープに保存
			request.setAttribute("errorMsg", "入力された内容は正しくありません。" );

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);

			return ;


		}if(name.isEmpty()||address.isEmpty()||loginId.isEmpty()) {

			// idを引数にして、idに紐づくユーザ情報を出力する


			request.setAttribute("user", user);


			//インスタンスをリクエストスコープに保存
			request.setAttribute("errorMsg", "入力された内容は正しくありません。" );
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return ;

		}if(password.isEmpty()&&password2.isEmpty()) {
			UserBeans withoutPassword=new UserBeans(userId,loginId, name, address);
			// セッションスコープを取得
			HttpSession session = request.getSession();
			//セッションスコープにインスタンスを保存
			session.setAttribute("withoutPassword", withoutPassword);



		}else {
			UserBeans updateUser=new UserBeans(userId,loginId,name,address,password);
			// セッションスコープを取得
			HttpSession session = request.getSession();
			//セッションスコープにインスタンスを保存
			session.setAttribute("updateUser", updateUser);

		}

		// サーブレットにリダイレクト
		response.sendRedirect("UserUpdateConfirmServlet");

	}

}
