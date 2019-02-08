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

import beans.FavoriteBeans;
import dao.FavoriteDAO;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteServlet() {
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
		String id = request.getParameter("userId");
		int userId =Integer.parseInt(id);
		// 確認用：idをコンソールに出力
		System.out.println(userId);



		// お気に入り一覧を取得
				FavoriteDAO favoriteDao = new FavoriteDAO();
				List<FavoriteBeans> favoriteList = favoriteDao.getAllFavoriteData(userId);
				if(favoriteList == null){
					//インスタンスをリクエストスコープに保存
					request.setAttribute("errorMsg", "お気に入りした商品はありません" );

					// ログインjspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Favorite.jsp");
					dispatcher.forward(request, response);
					return;
				}
				// リクエストスコープにお気に入り商品情報をセット
				request.setAttribute("favoriteList", favoriteList);


				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Favorite.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("itemDetailId");
				int itemDetailId =Integer.parseInt(id);
				// 確認用：idをコンソールに出力
				System.out.println(itemDetailId);
				// URLからGETパラメータとしてIDを受け取る
				String uid = request.getParameter("userId");
				int userId =Integer.parseInt(uid);
				// 確認用：idをコンソールに出力
				System.out.println(userId);

				FavoriteDAO favoriteDao = new FavoriteDAO();
				favoriteDao.findSameFavoriteId(userId,itemDetailId);
				

				if(favoriteDao.findSameFavoriteId(userId,itemDetailId)) {
				favoriteDao.deleteFavorite(userId, itemDetailId);

				}else{
					favoriteDao.insertFavorite(userId,itemDetailId) ;

					// サーブレットにリダイレクト
					response.sendRedirect("ItemServlet");
				}

	}

}
