/**
 * 
 */
package com.yuepeng.platform.common.controller;

import com.yuepeng.platform.common.bean.entity.TSysCity;
import com.yuepeng.platform.common.bean.entity.TSysProvince;
import com.yuepeng.platform.common.service.ICommonService;
import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.platform.pm.bean.entity.TSysDepart;
import com.yuepeng.platform.pm.bean.entity.TSysPmUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:共用方法控制类
 * @author:     shenchu
 * @date:        2017年3月1日 下午9:39:51
 * Copyright (c) 2017, Samton. All rights reserved
 */
@Controller
@RequestMapping("/platform/common")
public class CommonController extends BaseController {
	
	@Resource
	public ICommonService commonService;

	/**
	 * 
	 * @Title:        personnelSelectorData 
	 * @Description:  人员选择器数据
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       String    
	 * @author        shenchu
	 * @Date          2017年3月2日 下午4:48:29
	 */
	@RequestMapping("/personnelSelectorData")
	@ResponseBody
	public Map<String, Object> personnelSelectorData() throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		Integer sysType = CurrentUtil.getCurrentUser().getSystemId();
		Integer proxyId = CurrentUtil.getCurrentUser().getProxyId();
		Integer custId = CurrentUtil.getCurrentUser().getEnterpriseId();
		List<TSysPmUser> users = commonService.getUsersForSelect(sysType, proxyId, custId);
		List<TSysDepart> depart = commonService.getDepartForSelect(sysType, proxyId, custId);
		data.put("users", users);
		data.put("depart", depart);
		return data;
	}
	
	/**
	 * 
	 * @Title:        queryUserName 
	 * @Description:  查询用户信息集合，数量不超过10个
	 * @param:        @param name
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       List<Map<String,Object>>    
	 * @author        shenchu
	 * @Date          2017年3月4日 下午5:04:19
	 */
	@RequestMapping("/queryUserName")
	@ResponseBody
	public List<Map<String,Object>>  queryUserName(String name)throws Exception{
		Integer sysType = CurrentUtil.getCurrentUser().getSystemId();
		Integer proxyId = CurrentUtil.getCurrentUser().getProxyId();
		Integer custId = CurrentUtil.getCurrentUser().getEnterpriseId();
		List<Map<String,Object>> userList = commonService.queryUserName(name, sysType, proxyId, custId);
		return userList;
	}
	
	/**
	 * 
	 * @Title:        getProvince 
	 * @Description:  获取省信息
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       List<TSysProvince>    
	 * @author        shenchu
	 * @Date          2017年3月2日 下午1:23:04
	 */
	@RequestMapping("/getProvince" + WebConstant.NO_AUTH_SUFFIX)
	@ResponseBody
	public List<TSysProvince> getProvince() throws Exception {
		return commonService.getProvince();
	}

	@RequestMapping("/getProvinceSelect" + WebConstant.NO_AUTH_SUFFIX)
	@ResponseBody
	public List<Map<String, Object>> getProvinceSelect() throws Exception{
		return commonService.getProvinceSelect();
	}
	
	/**
	 * 
	 * @Title:        getCityByProvinceId 
	 * @Description:  通过省ID获取市信息
	 * @param:        @param provinceId
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       List<TSysCity>    
	 * @author        shenchu
	 * @Date          2017年3月2日 下午1:25:30
	 */
	@RequestMapping("/getCityByProvinceId" + WebConstant.NO_AUTH_SUFFIX)
	@ResponseBody
	public List<TSysCity> getCityByProvinceId(Long provinceId) throws Exception {
		return commonService.getCityByProvinceId(provinceId);
	}
	
	/**
	 * 
	 * @Title:        fileUpload 
	 * @Description:  单文件上传
	 * @param:        @param file
	 * @param:        @param request
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Map<String,Object>    
	 * @author        shenchu
	 * @Date          2017年3月6日 上午11:43:26
	 */
	@RequestMapping(value = "/fileUpload")
	@ResponseBody
	public Map<String, Object> fileUpload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws Exception{
		Map<String,Object> result = commonService.uploadFileSingle(file);
		return this.getResultMap(result.isEmpty()?false:true,result);
	}

	@RequestMapping(value = "/ueditor/{type}/fileUpload")
	@ResponseBody
	public Map<String,Object> uEditorFileUpload(@RequestParam("upfile") CommonsMultipartFile file,HttpServletRequest request, @PathVariable("type") Integer type) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		String path = "";
		if(type == 1){
			path = "ueditor" + File.separator + "image";
		}
		if(type == 2){
			path = "ueditor" + File.separator + "video";
		}
		Map<String, Object> data = commonService.uploadFileSingle(file, path);
		map.put("state", "SUCCESS");
		map.put("url",data.get("attachmentPath"));
		map.put("title","");
		map.put("original","realName" );
		return map;
	}


	@RequestMapping(value = "/download")
	public String download(String url, HttpServletRequest request, HttpServletResponse response) {
		url = url.substring(1);
		
		String fileName = url.substring(url.lastIndexOf('/') + 1);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		try {
			String path = request.getSession().getServletContext().getRealPath("/")  + url;
			InputStream inputStream = new FileInputStream(new File(path));

			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}

			 // 这里主要关闭。
			os.close();

			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
            //  返回值要注意，要不然就出现下面这句错误！
            //java+getOutputStream() has already been called for this response
		return null;
	}
	
	/**
	 * 
	 * @Title:        openAudioView 
	 * @Description:  跳转音频播放界面
	 * @param:        @param url			音频文件地址
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       String    
	 * @author        Alex
	 * @Date          2017年4月11日 下午2:57:29
	 */
	@RequestMapping("/openAudioView")
	public String openAudioView(String url) throws Exception{
		this.request.setAttribute("audioUrl", url);
		return "common/audio";
	}

}
