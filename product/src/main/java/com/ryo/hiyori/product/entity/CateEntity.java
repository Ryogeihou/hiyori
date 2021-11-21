package com.ryo.hiyori.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * 
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-11 20:23:58
 */
@Data
@TableName("cate")
public class CateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String catIcon;
	/**
	 * 
	 */
	private Long catId;
	/**
	 * 
	 */
	private Integer catLevel;
	/**
	 * 
	 */
	private Integer parentid;
	/**
	 * 
	 */
	private String catName;

	@TableField(exist = false)
	private List<CateEntity> children;

	private Integer sort;

	@TableLogic(value = "1",delval = "0")
	private Integer showStatus;
}
