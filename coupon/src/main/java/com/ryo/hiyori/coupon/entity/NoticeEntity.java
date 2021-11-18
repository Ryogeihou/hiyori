package com.ryo.hiyori.coupon.entity;

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
 * @date 2021-11-15 18:09:18
 */
@Data
@TableName("notice")
public class NoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
//	private String _id;
	/**
	 * 
	 */
	private Long createdtime;
	/**
	 * 
	 */
	private String downloadpath;
	/**
	 * 
	 */
	private String path;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 
	 */
	private String src;
	/**
	 * 
	 */
	private String status;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private Integer nid;
	/**
	 * 
	 */
	private String context;
	/**
	 * 
	 */
	private String title;

}
