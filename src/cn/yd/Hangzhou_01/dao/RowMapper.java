/**
 * 
 */
package cn.yd.Hangzhou_01.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xxh
 * @param <T>
 *
 */
public interface RowMapper<T> {

	abstract T getRow(ResultSet rSet) throws SQLException;
}
