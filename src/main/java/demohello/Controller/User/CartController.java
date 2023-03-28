package demohello.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demohello.Dto.CartDto;
import demohello.Entity.Bill;
import demohello.Entity.Users;
import demohello.Service.User.BillServiceImpl;
import demohello.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private BillServiceImpl billServiceImpl =new BillServiceImpl();
	
	@RequestMapping(value = "gio-hang")

	public ModelAndView Index(HttpSession session, ModelMap model) {
		
		_mvShare.addObject("slides", _homeService.GetDataSlides());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}

	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {

		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		/* return "redirect:/chi-tiet-san-pham/"+id; */
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "gio-hang/EditCart/{id}/{quanty}")

	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable long id, @PathVariable int quanty) {

		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		
		  cart = cartService.EditCart(id, quanty, cart); 
		  session.setAttribute("Cart",cart); 
		  session.setAttribute("TotalQuantyCart",cartService.TotalQuanty(cart)); 
		  session.setAttribute("TotalPriceCart",cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}

	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "checkout",method =RequestMethod.GET)
	public ModelAndView Checkout(HttpServletRequest request, HttpSession session) {		
		_mvShare.setViewName("user/bill/checkout");
		Bill bill=new Bill();
		Users loginInfo=(Users)session.getAttribute("Loginfo");
		if(loginInfo!=null) {
			bill.setAddress(loginInfo.getAddress());
			bill.setDisplayname(loginInfo.getDisplayname());
			bill.setUser(loginInfo.getUser());					
		}
		_mvShare.addObject("bill",bill);
		return _mvShare;
	}
	@RequestMapping(value = "checkout",method =RequestMethod.POST)
	public String CheckoutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill")Bill bill) {
		bill.setTotal(Double.valueOf(session.getAttribute("TotalPriceCart").toString()));
		bill.setTotal(Double.valueOf(session.getAttribute("TotalPriceCart").toString()));
		
		if(billServiceImpl.AddBill(bill)>0) {
			HashMap<Long, CartDto>carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			billServiceImpl.AddBillDetail(carts);
			
		}
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
	}
	
}
