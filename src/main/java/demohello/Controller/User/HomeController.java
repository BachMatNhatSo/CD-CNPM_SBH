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
import demohello.Dao.UsersDao;
import demohello.Entity.Categorys;
import demohello.Entity.Users;
import demohello.Service.User.CategoryServiceImpl;

@Controller
public class HomeController extends BaseController{

	@Autowired
	CategorysDao categorysDao =new CategorysDao();
	@Autowired
	CategoryServiceImpl categoryServiceImpl =new CategoryServiceImpl();
	@Autowired
	UsersDao userDao = new UsersDao();
	
	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index(HttpSession session, ModelMap model) {
		
		_mvShare.addObject("slides",_homeService.GetDataSlides());
		_mvShare.addObject("categorys",_homeService.GetDataCategorys());
		_mvShare.addObject("products",_homeService.GetDataProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	//Goto form index admin
	@RequestMapping(value = { "/admin/index" })
	public ModelAndView adminGoToIndex(HttpSession session, ModelMap model) {
		//_mvShare.addObject("categorys",_homeService.GetDataCategorys());		
		_mvShare.setViewName("admin/quan-tri-index");
		return _mvShare;
	}
	@RequestMapping(value = { "/admin/HienThiloaisanpham" })
	public ModelAndView adminGoToDSLSP(HttpSession session, ModelMap model) {
		_mvShare.addObject("categorys",_homeService.GetDataCategorys());		
		_mvShare.setViewName("admin/quantri-HienThiDSLSP");
		return _mvShare;
	}
	//show obj dslsp and goto this
	@RequestMapping(value = { "/admin/ds-loaisanpham" }, method = RequestMethod.GET)
	public ModelAndView adminDSLSP() {
		_mvShare.setViewName("/admin/quantri-fromaddloaisp");
		_mvShare.addObject("categorys", new Categorys());
		return _mvShare;
	
	}
	//add or update lsp and  goto trang index của admin
	@RequestMapping(value = { "/admin/ds-loaisanpham" }, method = RequestMethod.POST)
	public ModelAndView adminAddDSLSP(@ModelAttribute("categorys") Categorys categorys) {		
		if(categorys.getId() == null) {
			categorysDao.save(categorys);
		}else {
			categorysDao.update(categorys);
		}				 
		_mvShare.setViewName("/admin/quan-tri-index");
		return _mvShare;
	}
	//lấy chỉ số  id của obj rồi đi tới forrm add loai sản pham
	@RequestMapping(value = { "/admin/edit" }, method = RequestMethod.GET)
	public ModelAndView adminEditDSLSP(HttpServletRequest request) {		
		 Integer id =Integer.parseInt(request.getParameter("id"));
		 Categorys categorys=categorysDao.getid(id);
		 ModelAndView model =new ModelAndView("/admin/quantri-fromaddloaisp");		 
		 model.addObject("categorys",categorys);		 
		return model;
	}
	//delete obj dựa trên chỉ số vừa lấy
	@RequestMapping(value = { "/admin/delete" }, method = RequestMethod.GET)
	public ModelAndView adminDeleteDSLSP(@RequestParam Integer id) {		
		categorysDao.deletebyid(id);
		
		return new  ModelAndView("redirect:/admin/HienThiloaisanpham");
	}
	//Goto form admin show account
	@RequestMapping(value = { "/admin/hienthitaikhoan" })
	public ModelAndView adminGoToAccountShow(HttpSession session, ModelMap model) {
		_mvShare.addObject("accounts", userDao.GetAllDataUsers());		
		_mvShare.setViewName("admin/quan-tri-HienThiaccount");
		return _mvShare;
	}
	//Goto form Add accounts
	@RequestMapping(value = { "/admin/ds-taikhoan" }, method = RequestMethod.GET)
	public ModelAndView adminDSAccount() {
		_mvShare.setViewName("/admin/quan-tri-formaddaccounts");
		_mvShare.addObject("accounts", new Users());
		return _mvShare;	
	}
	//add or update Account and  goto trang index của admin
		@RequestMapping(value = { "/admin/ds-taikhoan" }, method = RequestMethod.POST)
		public ModelAndView adminSaveOrUpdateAccount(@ModelAttribute("categorys") Users users) {		
			if(users.getId() == null) {
				userDao.save(users);
			}else {
				userDao.update(users);
			}				 
			_mvShare.setViewName("/admin/quan-tri-index");
			return _mvShare;
		}
		//lấy chỉ số  id của obj rồi đi tới forrm add loai sản pham
		@RequestMapping(value = { "/admin/Account-edit" }, method = RequestMethod.GET)
		public ModelAndView adminGotoFormAddAccWithID(HttpServletRequest request) {		
			 Integer id =Integer.parseInt(request.getParameter("id"));
			 Users users=userDao.getid(id);
			 ModelAndView model =new ModelAndView("/admin/quan-tri-formaddaccounts");		 
			 model.addObject("accounts",users);		 
			return model;
		}
		
		//delete obj dựa trên chỉ số vừa lấy
		@RequestMapping(value = { "/admin/Account-delete" }, method = RequestMethod.GET)
		public ModelAndView adminAccountByID(@RequestParam Integer id) {		
			userDao.deletebyid(id);			
			return new  ModelAndView("redirect:/admin/hienthitaikhoan");
		}
	

	
}
