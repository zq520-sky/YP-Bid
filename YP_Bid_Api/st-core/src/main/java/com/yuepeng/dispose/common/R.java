package com.yuepeng.dispose.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回数据
 *
 * @author
 */
@Data
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
     * 状态码：
	 * 	0： 成功
	 *  other： 失败
	 */
	private Integer code = 0;
	/**
     * 描述
	 */
	private String msg = "success";
	/**
     * 成功数据
	 */
	private T data;

}
