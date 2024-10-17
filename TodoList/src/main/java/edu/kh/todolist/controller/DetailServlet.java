package edu.kh.todolist.controller;
// Controller(요청을 받아 알맞은 서비스 호출, 응답을 어떻게 처리할지 결정 -> View)

import java.io.IOException;
import java.util.List;

import edu.kh.todolist.model.dto.Todo;
import edu.kh.todolist.model.service.TodoListService;
import edu.kh.todolist.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/detail")
public class DetailServlet extends HttpServlet{
	
	@Override		// a 태그 요청은 GET 방식
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int index = Integer.parseInt( req.getParameter("index") );
			
			TodoListService service = new TodoListServiceImpl();
			
			// 내 풀이 시작
//			List<Todo> todoList = service.todoListFullView();
//			Todo todo = todoList.get(index);	
//			req.setAttribute("todo", todo);
//			String path = "/WEB-INF/views/detail.jsp";
//			req.getRequestDispatcher(path).forward(req, resp);
			// 내 풀이 여기까지
			
			
			// 강사님 풀이 시작 -> TodoListService 클래스로 이동
			// index 번째 todo 가 없으면 null, 있으면 Todo 객체가 넘어옴!
			Todo todo = service.todoDetailview(index);
			
			// index 번째 todo가 존재하지 않을 경우,
			// 메인페이지(/)로 redirect 후 "해당 index에 todo가 존재하지 않습니다"
			if(todo == null) {
				// message 를 session에 세팅
				HttpSession session = req.getSession();
				session.setAttribute("message", "해당 index에 todo가 존재하지 않습니다");
				resp.sendRedirect("/");		// sendRedirect 안에 작성되는 내용은 요청주소임!!
				return;						// 코드는 일단 끝까지 실행되므로 return 써주기!
			}
			
			// index 번째 todo가 존재하는 경우, detail.jsp로 forward 해서 응답
			// 요청 위임한 페이지에서 서비스로부터 얻어온 todo 를 사용하기 위해 request scope 세팅
			req.setAttribute("todo", todo);
			
			// JSP 파일 경로(webapp 폴더 기준으로 작성)
			String path = "/WEB-INF/views/detail.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			// 강사님 풀이 여기까지

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
