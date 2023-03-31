	package demohello.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import demohello.Dao.CategorysDao;
import demohello.Entity.Categorys;
import demohello.Service.User.CategoryServiceImpl;

@Controller
public class HomeController extends BaseController{

	@Autowired
	CategorysDao categorysDao =new CategorysDao();
	@Autowired
	CategoryServiceImpl categoryServiceImpl =new CategoryServiceImpl();
	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index(HttpSession session, ModelMap model) {
		
		_mvShare.addObject("slides",_homeService.GetDataSlides());
		_mvShare.addObject("categorys",_homeService.GetDataCategorys());
		_mvShare.addObject("products",_homeService.GetDataProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	@RequestMapping(value = { "/admin/index" })
	public ModelAndView admin(HttpSession session, ModelMap model) {
		_mvShare.addObject("categorys",_homeService.GetDataCategorys());		
		_mvShare.setViewName("admin/quan-tri-index");
		return _mvShare;
	}
	@RequestMapping(value = { "/admin/HienThiloaisanpham" })
	public ModelAndView admingotoDSLSP(HttpSession session, ModelMap model) {
		_mvShare.addObject("categorys",_homeService.GetDataCategorys());		
		_mvShare.setViewName("admin/quantri-HienThiDSLSP");
		return _mvShare;
	}
	@RequestMapping(value = { "/admin/ds-loaisanpham" }, method = RequestMethod.GET)
	public ModelAndView adminDSLSP() {
		_mvShare.setViewName("/admin/quantri-dsloaisp");
		_mvShare.addObject("categorys", new Categorys());
		return _mvShare;
	
	}
	@RequestMapping(value = { "/admin/ds-loaisanpham" }, method = RequestMethod.POST)
	public ModelAndView adminAddDSLSP(@ModelAttribute("categorys") Categorys categorys) {		
		if(categorys.getId() == null) {
			categorysDao.save(categorys);
		}else {
			categorysDao.update(categorys);
		}				 
		_mvShare.setViewName("/admin/quantri-HienThiDSLSP");
		return _mvShare;
	}
	@RequestMapping(value = { "/admin/edit" }, method = RequestMethod.GET)
	public ModelAndView adminEditDSLSP(HttpServletRequest request) {		
		 Integer id =Integer.parseInt(request.getParameter("id"));
		 Categorys categorys=categorysDao.getid(id);
		 ModelAndView model =new ModelAndView("/admin/quantri-dsloaisp");		 
		 model.addObject("categorys",categorys);		 
		return model;
	}
	@RequestMapping(value = { "/admin/delete" }, method = RequestMethod.GET)
	public ModelAndView adminDeleteDSLSP(@RequestParam Integer id) {		
		categorysDao.deletebyid(id);
		
		return new  ModelAndView("redirect:/admin/HienThiloaisanpham");
	}
	

	
}
