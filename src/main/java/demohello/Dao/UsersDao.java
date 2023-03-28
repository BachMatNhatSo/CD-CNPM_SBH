package demohello.Dao;

import org.springframework.stereotype.Repository;

import demohello.Dto.ProductsDto;
import demohello.Entity.MapperUsers;
import demohello.Entity.Users;

@Repository
public class UsersDao extends BaseDao {
	public int AddAccount(Users user) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO users ");
		sql.append("( ");
		sql.append("    user, ");
		sql.append("    password, ");
		sql.append("    displayname, ");
		sql.append("    address ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '"+user.getUser()+"', ");
		sql.append("    '"+user.getPassword()+"', ");
		sql.append("    '"+user.getDisplayname()+"', ");
		sql.append("    '"+user.getAddress()+"') ");
		
		int insert = _jbJdbcTemplate.update(sql.toString());
		return insert;
	}
	public Users GetUserByAccount(Users user) {
		String sql ="SELECT * FROM users WHERE user = '"+user.getUser()+"' ";
		
		Users result=_jbJdbcTemplate.queryForObject(sql, new MapperUsers());		
						
		return result;
	}

}
