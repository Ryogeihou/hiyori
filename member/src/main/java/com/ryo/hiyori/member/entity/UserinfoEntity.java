package com.ryo.hiyori.member.entity;

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
 * @date 2021-11-15 18:29:26
 */
@Data
@TableName("userinfo")
public class UserinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
//	private String _id;
	/**
	 * 
	 */
	private String _openid;
	/**
	 * 
	 */
	private String avatarurl;
	/**
	 * 
	 */
	private String brandcollection;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String collection;
	/**
	 * 
	 */
	private Integer consumption;
	/**
	 * 
	 */
	private String country;
	/**
	 * 
	 */
	private Long createdtime;
	/**
	 * 
	 */
	private Integer gender;
	/**
	 * 
	 */
	private Integer memberlevel;
	/**
	 * 
	 */
	private Long mobile;
	/**
	 * 
	 */
	private String nickname;
	/**
	 * 
	 */
	private Integer point;
	/**
	 * 
	 */
	private String province;
	/**
	 * 
	 */
	private Integer referrer;
	/**
	 * 
	 */
	private Integer userid;
	/**
	 * 
	 */
	@TableId
	private Integer id;

}
