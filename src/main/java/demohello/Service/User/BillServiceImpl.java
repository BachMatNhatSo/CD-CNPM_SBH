package demohello.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demohello.Dao.BillDao;
import demohello.Dto.CartDto;
import demohello.Entity.Bill;
import demohello.Entity.BillDetail;
@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	private BillDao billDao;
	
	public int AddBill(Bill bill) {
		
		return billDao.AddBill(bill);
	}
	
	public void AddBillDetail(HashMap<Long, CartDto> carts) {
		
		long idbill= billDao.GetIDLastBill();
		for(Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail =new BillDetail();
			billDetail.setId_bill(idbill);
			billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billDao.AddBillDetail(billDetail);
			
		}
		
	}

}
