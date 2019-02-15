package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDetailBeans;

/**
 * Servlet implementation class ItemDeleteServlet
 */
@WebServlet("/ItemDeleteServlet")
public class ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("itemDetailId");
				int itemDetailId =Integer.parseInt(id);
				// 確認用：idをコンソールに出力
				System.out.println(itemDetailId);



				HttpSession session = request.getSession();
				//カートを取得
				ArrayList<ItemDetailBeans> cart = (ArrayList<ItemDetailBeans>) session.getAttribute("cart");


					for (ItemDetailBeans cartInItem : cart) {
						if (cartInItem.getItemDetailId() == itemDetailId) {
							cart.remove(cartInItem);
							break;

						}
					}
					response.sendRedirect("CartServlet");

	}



}
