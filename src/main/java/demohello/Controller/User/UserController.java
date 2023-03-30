package demohello.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demohello.Entity.Users;
import demohello.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView Create(@ModelAttribute("user") Users user) {
		int count = accountService.AddAccount(user);
		if (count > 0) {
			_mvShare.addObject("status", "Dang ky thanh cong");
		} else {
			_mvShare.addObject("status", "Dang ky that bai");

		}
		// _mvShare.addObject("status",true);
		_mvShare.setViewName("/register");
		return _mvShare;

	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("user") Users user) {
		 user = accountService.CheckAccount(user);
		 String vaitro = user.getVaitro().toString();
		if (user != null) {
			if(vaitro.equals("ADMIN")){
				_mvShare.setViewName("redirect:/admin/index");
				session.setAttribute("Loginfo", user);
			}else if (vaitro!=("ADMIN")){
				_mvShare.setViewName("redirect:trang-chu");
				session.setAttribute("Loginfo", user);
			}else {
				_mvShare.addObject("statusLogin", "Dang Nhap that bai");
			}			
		}
		return _mvShare;
	}
	@RequestMapping(value = { "/admin/index" })
	public ModelAndView Indexadmin(HttpSession session, ModelMap model) {			
		_mvShare.setViewName("admin/quan-tri-index");
		return _mvShare;
	}
	
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String login(HttpSession session,HttpServletRequest request) {
		session.removeAttribute("Loginfo");
		return "redirect:"+request.getHeader("referer");
	}
	@RequestMapping(value = "/dang-xuat-admin", method = RequestMethod.GET)
	public String logout(HttpSession session,HttpServletRequest request) {
		session.removeAttribute("Loginfo");
		return "redirect:trang-chu";
	}

}
