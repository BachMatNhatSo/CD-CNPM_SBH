package demohello.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user=new Users();
		user.setId(rs.getLong("id"));
		user.setUser(rs.getString("user"));
		user.setPassword(rs.getString("password"));
		user.setDisplayname(rs.getString("displayname"));
		user.setAddress(rs.getString("address"));
		user.setVaitro(rs.getString("vaitro"));
		return user;
	}
	

}
