package handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.BoardDBBean;
import board.BoardDao;
import board.BoardDataBean;

@Controller
public class ModifyProHandler implements CommandHandler{
	
	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("/modifyPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		BoardDataBean dto = new BoardDataBean();
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		
		String pageNum = request.getParameter("pageNum");

		int result = boardDao.modifyArticle(dto);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		
		return new ModelAndView("modifyPro");
	}

}
