package com.upload.model;

import java.util.List;

public interface UploadDAO_interface {

	public void insert(UploadVO uploadVO);
	public UploadVO findPrimaryKey(Integer file_no);
	public List<UploadVO> getAll();
}
