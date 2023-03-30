package demohello.Controller.User;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController extends BaseController {
	@RequestMapping(value = { "/admin/tong-quan" })
	public ModelAndView Index(HttpSession session, ModelMap model) {
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.setViewName("/admin/quan-tri-index");
		return _mvShare;
	}

}
