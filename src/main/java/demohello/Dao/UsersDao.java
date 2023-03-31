package demohello.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import demohello.Entity.Categorys;
import demohello.Entity.MapperUsers;
import demohello.Entity.Users;

@Repository
public class UsersDao extends BaseDao {
	public int AddAccount(Users user) {
		StringBuffer  sql = new StringBuffer();
//		sql.append("INSERT INTO users ");
//		sql.append("( ");
//		sql.append("    user, ");
//		sql.append("    password, ");
//		sql.append("    displayname, ");
//		sql.append("    address, ");
//		sql.append("    vaitro ");
//		sql.append(") ");
//		sql.append("VALUES ");
//		sql.append("( ");
//		sql.append("    '"+user.getUser()+"', ");
//		sql.append("    '"+user.getPassword()+"', ");
//		sql.append("    '"+user.getDisplayname()+"', ");
//		sql.append("    '"+user.getAddress()+"', ");
//		sql.append("    '"+user.getVaitro()+"') ");
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
	public List<Users> GetAllDataUsers(){
		List<Users> list=new ArrayList<Users>();
		String sql = "SELECT * FROM users";
		list = _jbJdbcTemplate.query(sql,new MapperUsers());
		return list;
	}
	public int save(Users users) {
		String sql ="INSERT INTO users (user,password,displayname,address,vaitro) VALUES(?,?,?,?,?)";
		return _jbJdbcTemplate.update(sql,users.getUser(),users.getPassword(),users.getDisplayname(),users.getAddress(),users.getVaitro());		
	}
	public int update(Users users) {
		String sql="UPDATE users SET  user=?,password=?,displayname=?,address=?,vaitro=? WHERE id=?";
		return _jbJdbcTemplate.update(sql,users.getUser(),users.getPassword(),users.getDisplayname(),users.getAddress(),users.getVaitro(),users.getId());
	}
	public Users getid(Integer id) {
		String sql ="SELECT* FROM users WHERE id="+id;
		ResultSetExtractor<Users> extractor=new ResultSetExtractor<Users>() {
			
			@Override
			public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String user=rs.getString("user");
					String password=rs.getString("password");
					String displayname=rs.getString("displayname");
					String address=rs.getString("address");
					String vaitro=rs.getString("vaitro");
					
					return new Users(id, user,password,displayname,address,vaitro);
				}
				return null;
			}
		};
		return _jbJdbcTemplate.query(sql, extractor);
	}
	public int deletebyid(Integer id) {
		String sql= "DELETE FROM users WHERE id="+id;
		return _jbJdbcTemplate.update(sql);
	}
	
}
