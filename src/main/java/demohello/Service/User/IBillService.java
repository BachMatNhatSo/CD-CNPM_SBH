package demohello.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import demohello.Dto.CartDto;
import demohello.Entity.Bill;
@Service
public interface IBillService {

	public int AddBill(Bill bill);
	public void AddBillDetail(HashMap<Long, CartDto> carts);
}
