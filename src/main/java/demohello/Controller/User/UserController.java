package demohello.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demohello.Entity.Users;
import demohello.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {
	@Autowired
	AccountServiceImpl accountService =new AccountServiceImpl();
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView Create(@ModelAttribute("user") Users user) {
		int count =accountService.AddAccount(user);
		if(count>0) {
			_mvShare.addObject("status","Dang ky thanh cong");
		}else
		{
			_mvShare.addObject("status","Dang ky that bai");

		}
		//_mvShare.addObject("status",true);
		_mvShare.setViewName("user/account/register");

		return _mvShare;
		
	}
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") Users user) {
		boolean check =accountService.CheckAccount(user);
		if(check) {
			_mvShare.addObject("statusLogin","Dang Nhap thanh cong");
		}else
		{
			_mvShare.addObject("statusLogin","Dang Nhap that bai");

		}
		_mvShare.setViewName("user/account/register");

		return _mvShare;
		
	}

}
