package demohello.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import demohello.Dto.CartDto;
import demohello.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	
	
	
	@Autowired
	private CartServiceImpl	cartService = new CartServiceImpl();	
	
	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		
		 HashMap<Long, CartDto> cart = ( HashMap<Long, CartDto>)session.getAttribute("Cart");
		 if(cart == null) {
			 cart = new HashMap<Long, CartDto>();
		 }
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		/* return "redirect:/chi-tiet-san-pham/"+id; */
		return "redirect:"+request.getHeader("Referer");
	}
}
