/**
 * 
 */
package cn.yd.Hangzhou_01.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yd.Hangzhou_01.model.Product;
import cn.yd.Hangzhou_01.util.JdbcUtil;

/**
 * @author xxh
 * @param <T>
 *
 */
public abstract class BaseDao<T> {

	protected void update(String sql,Object[] param){
	
		Connection connection = null;
		PreparedStatement pre =null;
		try {
			 connection=JdbcUtil.getConnection();
			 pre= connection.prepareStatement(sql);
			 System.out.println(pre);
			 for (int i = 0; i < param.length; i++) {
				pre.setObject(i+1, param[i]);
			}
			pre.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(connection, pre);
		}
	}
	
	
	protected abstract T getRow(ResultSet rSet) throws SQLException;
	protected List<T> querySelect(String sql,Object[] param,Class<T> class1) throws Exception{
		List<T> tList = new ArrayList<T>();
//		T t = null;
		Connection connection=null;
		PreparedStatement pre=null;
		ResultSet rSet=null;
		
		//
		try {
			connection=JdbcUtil.getConnection();
			pre=connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pre.setObject(i+1, param[i]);
			}
			rSet = pre.executeQuery();
			ResultSetMetaData metaData=rSet.getMetaData();
			while (rSet.next()) {
				T model = class1.newInstance();
				for (int i = 1; i <=metaData.getColumnCount(); i++) {
					String name =metaData.getColumnName(i);
					Field field = class1.getDeclaredField(name);
					field.setAccessible(true);
					field.set(model, rSet.getObject(name));
				}
				tList.add(model);
			}
			return tList;
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(connection, pre, rSet);
		}		
		
	}
	
}
