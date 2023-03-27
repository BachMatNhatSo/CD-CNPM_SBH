package demohello.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import demohello.Dto.ProductsDto;

@Service
public interface IProductService {
	public ProductsDto GetProductsByID(long id);
	public List<ProductsDto> GetProductsByIDCategory(int id);
}
