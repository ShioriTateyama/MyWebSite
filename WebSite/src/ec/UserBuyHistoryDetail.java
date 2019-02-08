package ec;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyBeans;
import beans.BuyDetailBeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * Servlet implementation class UserBuyHistoryDetail
 */
@WebServlet("/UserBuyHistoryDetailServlet")
public class UserBuyHistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBuyHistoryDetail() {
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
		String id = request.getParameter("buyId");
		int buyId=Integer.parseInt(id);
		// 確認用：idをコンソールに出力
		System.out.println(buyId);

		BuyDAO buyDao =new BuyDAO();
		BuyBeans selectBuyData=buyDao.selectBuyData(buyId);

		//Requestスコープにインスタンスを保存
		request.setAttribute("selectBuyData", selectBuyData);

		BuyDetailDAO buyDetailDao =new BuyDetailDAO();
		List<BuyDetailBeans> buyDetailData =buyDetailDao.selectBuyDetailData(buyId);

		//Requestスコープにインスタンスを保存
		request.setAttribute("buyDetailData", buyDetailData);

		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/UserBuyHistoryDetail.jsp");
		dispatcher.forward(request, response);
	}



}
