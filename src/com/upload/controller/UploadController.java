package com.upload.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.upload.model.UploadService;
import com.upload.model.UploadVO;

@Controller
@MultipartConfig
@RequestMapping("/upload")
public class UploadController extends MultiActionController{
	
	@RequestMapping(method = RequestMethod.GET, value = "setUpload")
	public String setUser(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		System.out.println("setUpload");
		UploadVO uploadVO = new UploadVO();
		model.addAttribute("uploadVO", uploadVO);
		return "upload";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "insert")
	public String addUpload(ModelMap model,
			@Valid UploadVO uploadVO, BindingResult result,
			@RequestParam("picture") MultipartFile inputfile,
			HttpServletResponse response,HttpServletRequest request) throws IOException {
		System.out.println("5678");
		if(result.hasErrors()){
			return "upload";
		}
		UploadFile uploadFile = new UploadFile();
		String url = uploadFile.upLoadPhoto(inputfile,response,request);
		UploadService uploadSvc = new UploadService();
		uploadVO.setPhoto(url);
		uploadSvc.addUpload(uploadVO);
		model.addAttribute("uploadVO", uploadVO);
		return "showPhoto";
	}
	
	

}
