package com.baizhi.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.FileParm;
import com.baizhi.utils.UploadUtil;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
	
	@RequestMapping("/add")
	@ResponseBody
	public void addChapter(HttpServletRequest request,String id,MultipartFile addFile){
		FileParm uploadFile = UploadUtil.uploadFile(addFile, request, UploadUtil.FILE);	
		System.out.println(uploadFile.getOldName());
		System.out.println(uploadFile.getUrl());
	}
	@RequestMapping("download")
	@ResponseBody
	public void downloadChapter(String url,String oldName,HttpServletRequest request,HttpServletResponse response){
		
		String projectPath=request.getSession().getServletContext().getRealPath("/");
		File file=new File(projectPath);
		String webappPath=file.getParent();
		String filePath=webappPath+url;
		File downFile=new File(filePath);
		String fileName=null;

		try {
			fileName=new String (oldName.getBytes("utf-8"),"iso-8859-1");
			//URLEncoder.encode(url,"utf-8")
			response.setHeader("content-disposition", "attachment;fileName="+fileName);
			response.setContentType("audio/mpeg");
			ServletOutputStream sos=response.getOutputStream();
			sos.write(FileUtils.readFileToByteArray(downFile));
			System.out.println("hll");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
