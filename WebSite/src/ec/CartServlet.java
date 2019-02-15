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
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session =request.getSession();

		ArrayList<ItemDetailBeans> cart = (ArrayList<ItemDetailBeans>) session.getAttribute("cart");
		//セッションにカートがない場合カートを作成
		if (cart == null) {
			cart = new ArrayList<ItemDetailBeans>();
			session.setAttribute("cart", cart);
		}

		String cartActionMessage = "";
		//カートに商品が入っていないなら
		if(cart.size() == 0) {
			cartActionMessage = "カートに商品がありません";
		}

		//合計金額
		int totalPrice = EcHelper.getTotalItemPrice(cart);

		int quantity= cart.size();

		BuyDetailBeans cartData = new BuyDetailBeans(totalPrice,quantity);





		//購入確定で利用
		session.setAttribute("cartData", cartData);
		request.setAttribute("cartActionMessage", cartActionMessage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Cart.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
