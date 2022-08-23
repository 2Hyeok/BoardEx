package handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.BoardDBBean;
import board.BoardDao;

@Controller
public class DeleteProHandler implements CommandHandler{
	
	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("/deletePro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");

		int resultCheck = boardDao.check(num, passwd);
		
		request.setAttribute("resultCheck", resultCheck);
		request.setAttribute("pageNum", pageNum);
		
		if(resultCheck != 0) {
			int result = boardDao.deleteArticle(num);
			request.setAttribute("result", result);
		}
		
		return new ModelAndView("deletePro");
	}

}
