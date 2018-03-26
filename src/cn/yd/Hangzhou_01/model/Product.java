/**
 * 
 */
package cn.yd.Hangzhou_01.model;

import java.math.BigDecimal;
import java.util.Date; //ctrl+t 查看父子类关系，一般首选父类或接口

/**
 * @author xxh
 *
 */
public class Product {

	/**
	 *   id                  int not null auto_increment,
   name                varchar(20),
   price               decimal(8,2),
   pic                 varchar(100),
   remark              longtext,
   date                timestamp default CURRENT_TIMESTAMP,
   primary key (id)
	 */
	//在model中采用引用类型，所以此处用Interger，不用 int
	private Integer id;
	private  String name;
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	private BigDecimal price;

	private String pic;
	private  String remark;
	private Date date;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", pic=" + pic + ", remark=" + remark
				+ ", date=" + date + "]";
	}

	
}
