package ec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDetailBeans;
import beans.ItemDetailBeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * Servlet implementation class BuyResultServlet
 */
@WebServlet("/BuyResultServlet")
public class BuyResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyResultServlet() {
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



				ArrayList<ItemDetailBeans> cart = (ArrayList<ItemDetailBeans>) session.getAttribute("cart");
				if(cart.size() == 0) {
					response.sendRedirect("UserDataServlet");
					return;
				}
				BuyDetailBeans buyData=(BuyDetailBeans) session.getAttribute("buyConfirm");
				int totalPrice=buyData.getTotalPrice();

				// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("userId");
				int userId=Integer.parseInt(id);

				BuyDAO buyDao=new BuyDAO();
				int buyId=buyDao.insertBuyData(userId,totalPrice);

				BuyDetailDAO buyDetailDao=new BuyDetailDAO();

					for(ItemDetailBeans item:cart) {
						int itemDetailId=item.getItemDetailId();
						int purchaseQuantity=item.getQuantity();

						buyDetailDao.insertBuyDetailData(buyId,itemDetailId,purchaseQuantity);
					}
					session.removeAttribute("cart");
					session.removeAttribute("buyConfirm");



					List<BuyDetailBeans> buyDataList=buyDetailDao.selectBuyDetailData(buyId) ;
					request.setAttribute("buyDataList", buyDataList);


			RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/BuyResult.jsp");
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
