/**
 * 
 */
package cn.yd.Hangzhou_01.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.yd.Hangzhou_01.model.Product;
import cn.yd.Hangzhou_01.util.JdbcUtil;

/**
 * @author xxh
 *
 */
//增删改查CRUD
public class ProductDaoImpl extends BaseDao<Product>{
	
	
	public static void main(String[] args) {
		ProductDaoImpl daoimpl=new ProductDaoImpl();
//		Product product =new Product();
		Product product2=null; 
//		product.setName("小明");
//		product.setPrice(90.9);
//		product.setRemark("胖子真是胖的过分");
//		product.setId(5);
//		productDaoImpl.save(product);
//		productDaoImpl.update(product);
//		productDaoImpl.delete(4);
//		product=productDaoImpl.select(5);
//		System.out.println(product.toString());
		List<Product> list = daoimpl.queryselect("");
		for (Product product : list) {
			System.out.println(product);
		}
	}

	
	
	public void save(Product product){
		String sql ="insert into product (name,price,remark) values(?,?,?)";
		   super.update(sql, new Object[]{product.getName(),product.getPrice(),product.getRemark()});
	}
	
	public void update(Product product){
		String sql ="update  product set name=?,price=?,remark=? where id=?";
		super.update(sql, new Object[]{product.getName(),product.getPrice(),product.getRemark(),product.getId()});
		
	}
	
	public void delete(int id){
		String sql ="delete from product where id=?";
		super.update(sql, new Object[]{id});
	}
	
	public Product select(int id){
		Product product = null;
		Connection connection=null;
		PreparedStatement pre=null;
		ResultSet rSet=null;
		String  sql="select * from product where id=?";	
		try {
			connection=JdbcUtil.getConnection();
			pre=connection.prepareStatement(sql);
			pre.setInt(1, id);
			rSet = pre.executeQuery();	
			System.out.println(rSet);
			if (rSet.next()) {
				product = new Product();
				System.out.println(rSet.getString("name"));
				product.setId(rSet.getInt("id"));
				product.setName(rSet.getString("name"));
				product.setPrice(rSet.getDouble("price"));
				product.setRemark(rSet.getString("remark"));
			}			
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(connection, pre, rSet);
		}		
		return product;
	}
	

	public List<Product> queryselect(String name){		
		
		String sql="select * from product where name like ?";
		List<Product> list = super.querySelect(sql, new Object[]{"%"+name+"%"});
		return list;	
	}



	@Override
	protected Product getRow(ResultSet rSet) throws SQLException {
		Product product=new Product();
		product.setId(rSet.getInt("id"));
		product.setName(rSet.getString("name"));
		product.setRemark(rSet.getString("remark"));
		return product;
	}




}
