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
import dao.ItemDetailDAO;

/**
 * Servlet implementation class ItemAdd
 */
@WebServlet("/ItemAdd")
public class ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int itemDetailId = Integer.parseInt(request.getParameter("itemDetailId"));
		int sizeId = Integer.parseInt(request.getParameter("sizeId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		ItemDetailDAO itemDetailDao =new ItemDetailDAO();
		//対象のアイテム情報を取得
		ItemDetailBeans item = itemDetailDao.selectItemDetailIdbyItemDetailIdAndSizeId(itemDetailId,sizeId);

		//追加した商品を表示するためリクエストパラメーターにセット
		request.setAttribute("item", item);
		HttpSession session = request.getSession();
		//カートを取得
		ArrayList<ItemDetailBeans> cart = (ArrayList<ItemDetailBeans>) session.getAttribute("cart");

		//セッションにカートがない場合カートを作成
		if (cart == null) {
			cart = new ArrayList<ItemDetailBeans>();
		}
		//カートに商品を追加。
		cart.add(item);
		//カート情報更新
		session.setAttribute("cart", cart);
		request.setAttribute("cartActionMessage", "商品を追加しました");
		request.getRequestDispatcher(EcHelper.CART_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
