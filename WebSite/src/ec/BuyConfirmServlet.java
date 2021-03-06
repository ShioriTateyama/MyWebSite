package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDetailBeans;
import beans.ItemDetailBeans;

/**
 * Servlet implementation class BuyConfirmServlet
 */
@WebServlet("/BuyConfirmServlet")
public class BuyConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		for(ItemDetailBeans item:cart) {
			int itemDetailId=item.getItemDetailId();
			int quantity = Integer.parseInt(request.getParameter("quantity-"+itemDetailId));

			item.setQuantity(quantity);




//			ItemDetailDAO itemDetailDao =new ItemDetailDAO();
//			ItemDetailBeans cartItem= itemDetailDao.selectItemDetailDatabyItemDetailId(itemDetailId,quantity);
//			cart.add(cartItem);

		}

		//カート情報更新
		session.setAttribute("cart", cart);


		//合計金額
		int totalPrice = EcHelper.getTotalItemPrice(cart);
		int totalItemQuantity=EcHelper.getTotalItemQuantity(cart);
		int itemQuantity=cart.size();



		if(totalPrice<10000) {
			totalPrice+=500;
		}


		BuyDetailBeans buyConfirm = new BuyDetailBeans(totalPrice,itemQuantity,totalItemQuantity);

		//購入確定で利用
		session.setAttribute("buyConfirm", buyConfirm);

		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/BuyConfirm.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
