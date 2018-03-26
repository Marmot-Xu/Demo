/**
 * 
 */
package cn.yd.Hangzhou_01.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.yd.Hangzhou_01.model.Product;

/**
 * @author xxh
 *
 */
public class ProductDaoImplTest {
	

	private static ProductDaoImpl daoimpl;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass   //說明作用 
	public static void setUpBeforeClass() throws Exception {
		System.out.println("------测试方法执行前------");
		daoimpl=new ProductDaoImpl();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("--------方法测试完毕--------");
	}

	/**
	 * Test method for {@link cn.yd.Hangzhou_01.dao.ProductDaoImpl#save(cn.yd.Hangzhou_01.model.Product)}.
	 */
	@Test
	public void testSave() {
		Product product=new Product();
		product.setName("小红");
		product.setPrice(1900.00);
		product.setRemark("小红真红红的");
		daoimpl.save(product);
	}

	/**
	 * Test method for {@link cn.yd.Hangzhou_01.dao.ProductDaoImpl#update(cn.yd.Hangzhou_01.model.Product)}.
	 */
	@Test
	public void testUpdateProduct() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.yd.Hangzhou_01.dao.ProductDaoImpl#delete(int)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.yd.Hangzhou_01.dao.ProductDaoImpl#select(int)}.
	 */
	@Test
	public void testSelect() {
//		Product product=new Product();
//				product=daoimpl.select(10);
//				System.out.println(product);
	}
	@Test
	public void testqueryselect() {
		List<Product> list = daoimpl.queryselect("小红");
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
