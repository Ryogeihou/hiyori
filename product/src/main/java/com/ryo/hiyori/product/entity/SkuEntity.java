package com.ryo.hiyori.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-09 14:46:27
 */
@Data
@TableName("sku")
public class SkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String catsecondid;
	/**
	 * 
	 */
	private Integer costprice;
	/**
	 * 
	 */
	private Integer count;
	/**
	 * 
	 */
	private Integer isdelete;
	/**
	 * 
	 */
	private Integer marketvalue;
	/**
	 * 
	 */
	private String onoffer;
	/**
	 * 
	 */
	private String point;
	/**
	 * 
	 */
	private Integer price;
	/**
	 * 
	 */
	private String selling;
	/**
	 * 
	 */
	private String suhead;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private Integer vipprice;
	/**
	 * 
	 */
	private String subhead;
	/**
	 * 
	 */
	private Integer rhid;

}
