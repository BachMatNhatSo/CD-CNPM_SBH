package demohello.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demohello.Dao.CategorysDao;
import demohello.Dao.MenusDao;
import demohello.Dao.ProductsDao;
import demohello.Dao.SlidesDao;
import demohello.Dto.ProductsDto;
import demohello.Entity.Categorys;
import demohello.Entity.Menus;
import demohello.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategorysDao categorysDao;
	@Autowired
	private MenusDao menusDao;
	@Autowired
	private ProductsDao productsDao;
	
	public List<Slides> GetDataSlides() {
		return slidesDao.GetDataSlides();
	}
	
	public List<Categorys> GetDataCategorys() {
		return categorysDao.GetDataCategorys();
	}
	public List<Menus> GetDataMenus() {
		return menusDao.GetDataMenus();
	}
	public List<ProductsDto> GetDataProducts() {
		List<ProductsDto> listProducts=productsDao.GetDataProducts();
		return listProducts;
	}	

}
