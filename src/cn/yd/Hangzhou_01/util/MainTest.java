/**
 * 
 */
package cn.yd.Hangzhou_01.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import cn.yd.Hangzhou_01.model.Product;

/**
 * @author xxh
 *
 */
public class MainTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	//通过反射获取所有class文件信息
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class classz = Product.class;
		
		
//		Method[] methods = classz.getMethods();
//		for (Method method : methods) {
//			System.out.println(method.getName());
//		}
		
		Class class1 = Class.forName("cn.yd.Hangzhou_01.model.Product");
		Object t = class1.newInstance();
		Method setId = class1.getMethod("setId", Integer.class);
		setId.invoke(t, 12);
		Method getId = class1.getMethod("getId");
		System.out.println(getId.invoke(t));
		
		
		Field name = class1.getDeclaredField("name");
		name.setAccessible(true);
		name.set(t, "笔记本电脑");
		System.out.println(name.get(t));
		
		
	}

}
