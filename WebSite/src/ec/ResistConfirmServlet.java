package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * Servlet implementation class ResistConfirmServlet
 */
@WebServlet("/ResistConfirmServlet")
public class ResistConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResistConfirmServlet() {
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
		//resistConfirmjspにforward
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ResistConfirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cancel =request.getParameter("cancel");


				// リクエストパラメータ

				String loginId = request.getParameter("login_id");
				String name=request.getParameter("name");
				String address=request.getParameter("address");
				String password =request.getParameter("password");


		HttpSession session =request.getSession();
		session.getAttribute("resist");


		UserDAO userDao =new UserDAO();

		//cancelだった時＝nullではない
		if(cancel!=null) {


			response.sendRedirect("UserDataServlet");
			return;
		}else {
			// セッションスコープを取得

			userDao.resisterUser(loginId,name, address,password);
			session.removeAttribute("resist");
		}

			// userupdateresultのサーブレットにリダイレクト
			response.sendRedirect("UserUpdateResult");




	}

}
