package demohello.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBills implements RowMapper<Bill>{

	@Override
	public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bill bill= new Bill();
		bill.setId(rs.getInt("id"));
		bill.setUser(rs.getString("user"));
		bill.setPhone(rs.getString("phone"));
		bill.setDisplayname(rs.getString("displayname"));
		bill.setAddress(rs.getString("address"));
		bill.setTotal(rs.getDouble("total"));
		bill.setQuanty(rs.getInt("quanty"));
		bill.setNote(rs.getString("note"));
		return bill;	
	}

}
