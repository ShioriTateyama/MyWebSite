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
 * Servlet implementation class UserUpdateConfirmServlet
 */
@WebServlet("/UserUpdateConfirmServlet")
public class UserUpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateConfirmServlet() {
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
		UserBeans updateUser=(UserBeans)request.getAttribute("updateUser");
		UserBeans withoutPassword=(UserBeans)request.getAttribute("withoutPassword");

		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/UserUpdateConfirm.jsp");
		dispatcher.forward(request, response);

		if(updateUser!=null) {
			// セッションスコープを取得

			session.removeAttribute("updateUser");

		}if(withoutPassword!=null) {

			session.removeAttribute("withoutPassword");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cancel =request.getParameter("cancel");



				// リクエストパラメータの入力項目を取得
				String id = request.getParameter("userId");
				int userId=Integer.parseInt(id);
				String loginId = request.getParameter("loginId");
				String name=request.getParameter("name");
				String address=request.getParameter("address");
				String password =request.getParameter("password");


		HttpSession session =request.getSession();
		UserBeans updateUser=(UserBeans)session.getAttribute("updateUser");
		UserBeans withoutPassword=(UserBeans)session.getAttribute("withoutPassword");

		UserDAO userDao =new UserDAO();

		//cancelだった時＝nullではない
		if(cancel!=null) {


			response.sendRedirect("UserDataServlet?userId="+userId);
			return;
		}if(updateUser!=null) {
			// セッションスコープを取得

			userDao.updateUser(userId,loginId,name, address,password);
			session.removeAttribute("updateUser");


		}if(withoutPassword!=null) {

			userDao.updateUserWithoutPassword(userId,loginId,name, address);

			session.removeAttribute("withoutPassword");
		}
			// userupdateresultのサーブレットにリダイレクト
			response.sendRedirect("UserUpdateResultServlet?userId="+userId);




		}





}
