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
 * @date 2021-11-11 20:23:58
 */
@Data
@TableName("brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String bgpic;
	/**
	 * 
	 */
	@TableId
	private Integer brandid;
	/**
	 * 
	 */
	private Integer count;
	/**
	 * 
	 */
	private String homepage;
	/**
	 * 
	 */
	private String intro;
	/**
	 * 
	 */
	private String logo;
	/**
	 * 
	 */
	private String onsale;
	/**
	 * 
	 */
	private String slogan;
	/**
	 * 
	 */
	private String title;

}
