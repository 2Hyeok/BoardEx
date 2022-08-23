package handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ListHandler implements CommandHandler{
	
	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("/list")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int pageSize = 10; // 한페이지의 출력할 갯수
		int pageBlock = 3;
		
		int count = 0;
		String pageNum = null;
		int currentPage = 0;
		int start = 0;
		int end = 0;
		int number = 0;
		
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;

		pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			// 페이지가 안넘어올 시
			pageNum = "1";
		}
		currentPage = Integer.parseInt(pageNum);
		start = (currentPage -1 ) * pageSize + 1;		//(5-1) * 10 + 1 			41
		end = start + pageSize - 1;						//41 + 10 - 1				50
		
		count = boardDao.getCount();
		
		if(end > count)end = count;
		
		number = count - (currentPage - 1) * pageSize;			//50 - (5 - 1) * 10			10
		
		pageCount = (count / pageSize) + (count % pageSize > 0 ? 1 : 0);
		startPage = (currentPage/pageBlock) * pageBlock + 1;	//		(5/10) * 10 + 1
		if(currentPage % pageBlock == 0)startPage -= pageBlock; 
		endPage = startPage + pageBlock - 1;
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("count", count);
		request.setAttribute("number", number);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		
		if(count != 0) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("start", start);
			map.put("end", end);
			
			List<BoardDataBean> dtos = boardDao.getArticles(map);
			request.setAttribute("dtos", dtos);
		}

		return new ModelAndView("list");
	}

}
