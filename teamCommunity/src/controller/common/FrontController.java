package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.AddFavAction;
import controller.action.CDeleteAction;
import controller.action.CInsertAction;
import controller.action.EditUserAction;
import controller.action.JoinAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.MyFavAction;
import controller.action.MyPageAction;
import controller.action.PContentAction;
import controller.action.PDeleteAction;
import controller.action.PInsertAction;
import controller.action.PListsAction;
import controller.action.PUpdateAction;
import controller.action.QuitUserAction;
import controller.action.SearchAction;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String action=uri.substring(cp.length());
		
		ActionForward forward=null;
		
		System.out.println("action: "+action);
		if(action.equals("/main.do")) {
			forward=new MainAction().execute(request, response);
		}
		else if(action.equals("/login.do")) {
			forward=new LoginAction().execute(request, response);
		}
		else if(action.equals("/join.do")) {
			forward=new JoinAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) {
			forward=new LogoutAction().execute(request, response);
		}
		else if(action.equals("/pLists.do")) {
			forward=new PListsAction().execute(request, response);
		}
		else if(action.equals("/pContent.do")) {
			forward=new PContentAction().execute(request, response);
		}
		else if(action.equals("/search.do")) {
			forward=new SearchAction().execute(request, response);
		}
		else if(action.equals("/pInsert.do")) {
			forward=new PInsertAction().execute(request, response);
		}
		else if(action.equals("/pDelete.do")) {
			forward=new PDeleteAction().execute(request, response);
		}
		else if(action.equals("/pUpdate.do")) {
			forward=new PUpdateAction().execute(request, response);
		}
		else if(action.equals("/myPage.do")) {
			forward=new MyPageAction().execute(request, response);
		}
		else if(action.equals("/editUser.do")) {
			forward=new EditUserAction().execute(request, response);
		}
		else if(action.equals("/cInsert.do")) {
			forward=new CInsertAction().execute(request, response);
		}
		else if(action.equals("/cDelete.do")) {
			forward=new CDeleteAction().execute(request, response);
		}
		else if(action.equals("/quitUser.do")) {
			forward=new QuitUserAction().execute(request, response);
		}
		else if(action.equals("/myFav.do")) {
			forward=new MyFavAction().execute(request, response);
		}
		else if(action.equals("/addFav.do")) {
			forward=new AddFavAction().execute(request, response);
		}
		else {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else{
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
