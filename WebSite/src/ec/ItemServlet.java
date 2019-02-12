package ec;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDetailBeans;
import dao.ItemDetailDAO;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("categoryId");
				int categoryId=Integer.parseInt(id);
				// 確認用：idをコンソールに出力
				System.out.println(categoryId);

				ItemDetailDAO itemDetailDao =new ItemDetailDAO();

				List<ItemDetailBeans> itemDataList =itemDetailDao.getItemByCategory(categoryId) ;

				//Requestスコープにインスタンスを保存
				request.setAttribute("itemDataList", itemDataList);

				RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/Item.jsp");
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
