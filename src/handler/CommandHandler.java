package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface CommandHandler {
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response)
	throws Throwable;
}
