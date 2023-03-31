package demohello.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import demohello.Entity.Categorys;
import demohello.Entity.MapperCategorys;

@Repository
public class CategorysDao extends BaseDao {

	public List<Categorys> GetDataCategorys() {
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "SELECT * FROM categorys";
		list = _jbJdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}
	public int save(Categorys categorys) {
		String sql ="INSERT INTO categorys (name,description) VALUES(?,?)";
		return _jbJdbcTemplate.update(sql,categorys.getName(),categorys.getDescription());
		
	}
	public int update(Categorys categorys) {
		String sql="UPDATE categorys SET  name=?,description=? WHERE id=?";
		return _jbJdbcTemplate.update(sql,categorys.getName(),categorys.getDescription(),categorys.getId());
	}
	public Categorys getid(Integer id) {
		String sql ="SELECT* FROM categorys WHERE id="+id;
		ResultSetExtractor<Categorys> extractor=new ResultSetExtractor<Categorys>() {
			
			@Override
			public Categorys extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name=rs.getString("name");
					String description=rs.getString("description");
					
					return new Categorys(id, name,description);
				}
				return null;
			}
		};
		return _jbJdbcTemplate.query(sql, extractor);
	}
	public int deletebyid(Integer id) {
		String sql= "DELETE FROM categorys WHERE id="+id;
		return _jbJdbcTemplate.update(sql);
	}
}
