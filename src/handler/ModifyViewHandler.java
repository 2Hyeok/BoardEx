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
public class ModifyViewHandler implements CommandHandler{
	
	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("/modifyView")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");

		int result = boardDao.check(num, passwd);
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		
		if(result != 0) {
			BoardDataBean dto = boardDao.getArticle(num);
			request.setAttribute("dto", dto);
		}
		
		return new ModelAndView("modifyView");
	}

}
