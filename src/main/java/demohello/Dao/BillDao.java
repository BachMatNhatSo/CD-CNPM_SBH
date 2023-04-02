package demohello.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import demohello.Entity.Bill;
import demohello.Entity.BillDetail;
import demohello.Entity.MapperBills;
import demohello.Entity.Users;

@Repository
public class BillDao extends BaseDao {
	public int AddBill(Bill bill) {

		StringBuilder varname1 = new StringBuilder();
		varname1.append("INSERT INTO bill ");
		varname1.append("( ");
		varname1.append("	`user`,`phone`,`displayname`,`address`,`total`,`quanty`,`note`");
		varname1.append(") ");
		varname1.append("VALUES ");
		varname1.append("( ");
		varname1.append("    '" + bill.getUser() + "', ");
		varname1.append("    '" + bill.getPhone() + "', ");
		varname1.append("    '" + bill.getDisplayname() + "', ");
		varname1.append("    '" + bill.getAddress() + "', ");
		varname1.append("    '" + bill.getTotal() + "', ");
		varname1.append("    '" + bill.getQuanty() + "', ");
		varname1.append("    '" + bill.getNote() + "' ");
		varname1.append(");");
		int insert = _jbJdbcTemplate.update(varname1.toString());
		return insert;
	};
	public long GetIDLastBill() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT MAX(id) FROM bill;");
		long id =_jbJdbcTemplate.queryForObject(sql.toString(),new Object[] {},Long.class);
		return id;
	};
	public int AddBillDetail(BillDetail billDetail) {
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("INSERT INTO billdetail ");
		varname1.append("( ");
		varname1.append("	`id_product`, ");
		varname1.append("    `id_bill`, ");
		varname1.append("    `quanty`, ");
		varname1.append("    `total` ");
		varname1.append(") ");
		varname1.append("VALUES ");
		varname1.append("( ");
		varname1.append("    '"+billDetail.getId_product()+"', ");
		varname1.append("   '"+billDetail.getId_bill()+"', ");
		varname1.append("    '"+billDetail.getQuanty()+"', ");
		varname1.append("    '"+billDetail.getTotal()+"' ");
		varname1.append(");");
		int insert=_jbJdbcTemplate.update(varname1.toString());
		return insert;
	};
	public List<Bill> GetAllDataBill(){
		List<Bill> list =new ArrayList<Bill>();
		String sql = "SELECT * FROM bill";
		list= _jbJdbcTemplate.query(sql, new MapperBills());
		return list;
	}
	public Bill getid(Integer id) {
		String sql ="SELECT* FROM users WHERE id="+id;
		ResultSetExtractor<Bill> extractor=new ResultSetExtractor<Bill>() {
			
			@Override
			public Bill extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String user=rs.getString("user");
					String phone=rs.getString("phone");
					String displayname=rs.getString("displayname");
					String address=rs.getString("address");
					double total=rs.getDouble("total");
					int quantry=rs.getInt("quanty");
					String note=rs.getString("note");
					
					return new Bill(id, user,phone,displayname,address,total,quantry,note);
				}
				return null;
			}
		};
		return _jbJdbcTemplate.query(sql, extractor);
	}
	public int deletebyid(Integer id) {
		String sql= "DELETE FROM bill WHERE id="+id;
		return _jbJdbcTemplate.update(sql);
	}

}
