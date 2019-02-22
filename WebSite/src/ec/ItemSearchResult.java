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

import beans.ItemDetailBeans;
import dao.ItemDetailDAO;

/**
 * Servlet implementation class ItemSearchResult
 */
@WebServlet("/ItemSearchResultServlet")
public class ItemSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemSearchResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String word =request.getParameter("word");

		request.setAttribute("word",word);
		ItemDetailDAO itemDetailDao =new ItemDetailDAO();

		List<ItemDetailBeans> searchResultList =itemDetailDao.getItemBySearch(word);

		HttpSession session =request.getSession();
		//スコープにインスタンスを保存
		session.setAttribute("searchResultList", searchResultList);

		if(searchResultList.isEmpty()) {

			request.setAttribute("error", "検索結果は０件でした" );
		}






		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemSearchResult.jsp");
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
