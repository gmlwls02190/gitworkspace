package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.DeleteBoardAction;
import controller.action.DeleteUserAction;
import controller.action.EditBoardAction;
import controller.action.InsertBoardAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.PostAction;
import controller.action.RegAction;
import controller.action.UpdateBoardAction;
import controller.action.UpdateUserAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());

		ActionForward forward = null;

		System.out.println("action: " + action);
		if (action.equals("/main.do")) {
			forward = new MainAction().execute(request, response);
		}
		else if(action.equals("/login.do")) {
			forward = new LoginAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) {
			forward = new LogoutAction().execute(request, response);
		}
		else if(action.equals("/reg.do")) {
			forward = new RegAction().execute(request, response);
		}
		else if(action.equals("/updateUser.do")) {
			forward = new UpdateUserAction().execute(request, response);
		}
		else if(action.equals("/deleteUser.do")) {
			forward = new DeleteUserAction().execute(request, response);
		}
		else if(action.equals("/post.do")) {
			forward = new PostAction().execute(request, response);
		}
		else if(action.equals("/insertBoard.do")) {
			forward = new InsertBoardAction().execute(request, response);
		}
		else if(action.equals("/editBoard.do")) {
			forward = new EditBoardAction().execute(request, response);
		}
		else if(action.equals("/updateBoard.do")) {
			forward = new UpdateBoardAction().execute(request, response);
		}
		else if(action.equals("/deleteBoard.do")) {
			forward = new DeleteBoardAction().execute(request, response);
		}
		else {
			// 1- 무조건 index.jsp으로 이동
			// 2- 에러페이지
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}