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
public class ContentHandler implements CommandHandler{
	
	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("/content")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		int number = Integer.parseInt(request.getParameter("number"));

		BoardDataBean dto = boardDao.getArticle(num); //데이터를 가져다 바로 출력
		if( ! dto.getIp().equals(request.getRemoteAddr()) ){
			boardDao.addCount(num);
		}
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("dto", dto);
		
		return new ModelAndView("content");
	}

}
