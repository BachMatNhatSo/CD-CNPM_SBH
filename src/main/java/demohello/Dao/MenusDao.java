package demohello.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import demohello.Entity.MapperMenus;
import demohello.Entity.Menus;

@Repository
public class MenusDao extends BaseDao {

	public List<Menus> GetDataMenus() {
		List<Menus> menu = new ArrayList<Menus>();
		String sql = "SELECT * FROM menus";
		menu = _jbJdbcTemplate.query(sql, new MapperMenus());
		return menu;
	}
}
