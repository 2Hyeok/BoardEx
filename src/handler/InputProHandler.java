package handler;

import java.sql.Timestamp;

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
public class InputProHandler implements CommandHandler{
	
	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("/inputPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		request.setCharacterEncoding("utf-8");
		
		BoardDataBean dto = new BoardDataBean();
		
		dto.setWriter(request.getParameter("writer"));
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setRef(Integer.parseInt(request.getParameter("ref")));
		dto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		dto.setIp(request.getRemoteAddr());
	
		int result = boardDao.insertArticle(dto);
		
		request.setAttribute("result", result);
		
		return new ModelAndView("inputPro");
	}

}
