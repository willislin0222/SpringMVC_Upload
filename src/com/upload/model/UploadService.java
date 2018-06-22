package com.upload.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UploadService {
	
	private UploadDAO_interface dao;
	public UploadService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config-JNDI.xml");
		dao =(UploadDAO_interface) context.getBean("uploadDAO");
	}
	
	public void addUpload(UploadVO uploadVO){
		dao.insert(uploadVO);
	}
	
	public UploadVO findPrimaryKey(Integer file_no){
		return dao.findPrimaryKey(file_no);
	}
	
	public List<UploadVO> getAll(){
		return dao.getAll();
	}

}
