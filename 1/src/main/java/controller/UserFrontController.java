package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;
import vo.ActionForward;

@WebServlet("*.us")
public class UserFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserFrontController123");
		
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		System.out.println("command : " + command);

		Action action = null;
		ActionForward forward = null;	
		
		if(command.equals("/UserJoinForm.us")) {
			forward = new ActionForward();
			forward.setPath("user/user_join.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/UserJoinPro.us")) {
			action = new UserJoinProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/UserLoginPro.us")) {
			action = new UserLoginProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/UserLogoutPro.us")) {
			action = new UserLogoutProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CheckDuplicateId.us")) {
			action = new UserCheckDuplicateIdAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/UserCheckIdForm.us")) {
			forward = new ActionForward();
			forward.setPath("user/user_check_id.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/UserLogin.us")) {
			forward = new ActionForward();
			forward.setPath("user/user_login.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/UserList.us")) {
			forward = new ActionForward();
			forward.setPath("user/user_list.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MyPage.us")) {
			forward = new ActionForward();
			forward.setPath("board/my_page.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/UserProductList.us")){
			try {
				action = new UserProductListProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/UserProductDetail.us")) {
			action = new userProductDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Popup.us")) {
			//????????? ????????? popup.jsp
			forward = new ActionForward();
			forward.setPath("/main/popup.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MakeCookie.us")) {
			//????????? ????????? ????????? makeCookie.jsp
			forward = new ActionForward();
			forward.setPath("/main/makeCookie.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/Cat.us")) {
			//????????? ????????????
			forward = new ActionForward();
			forward.setPath("/main/cat.jpg");
			forward.setRedirect(false);
		} else if(command.equals("/Search.us")) {
			action = new UserSearchProductAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		// --------------------------------------------------------------------------------------
		// ActionForward ????????? ????????? ????????? ????????? ?????? ????????? ?????? ???????????? ?????? ???????????? ??????
		if(forward != null) { // ActionForward ????????? null ??? ?????? ???????????? ????????? ?????? ??????
			// Redirect ?????? vs Dispatcher ?????? ???????????? ??? ????????? ?????? ????????? ?????? ??????
			if(forward.isRedirect()) { // Redirect ??????
				response.sendRedirect(forward.getPath());
			} else { // Dispatcher ??????
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}







