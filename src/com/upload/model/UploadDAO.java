package com.upload.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;


public class UploadDAO implements UploadDAO_interface{

	private static final String GET_ALL_STMT="From UploadVO";
	
	//spring hibernateTemplate
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public void insert(UploadVO uploadVO) {
		hibernateTemplate.save(uploadVO);
		
	}

	@Override
	public UploadVO findPrimaryKey(Integer file_no) {
		UploadVO uploadVO =(UploadVO) hibernateTemplate.get(UploadVO.class, file_no);
		return uploadVO;
	}

	@Override
	public List<UploadVO> getAll() {
		List<UploadVO> list = null;
		list = (List<UploadVO>) hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}
	
	public static void main(String[] args) {
		
		//EmpHibernateDAO dao = new EmpHibernateDAO();
		//為方便一般應用程式main方的測試,所以底下的model-config1-DriverManagerDataSource.xml內部dataSource設定是採用org.springframework.jdbc.datasource.DriverManagerDataSource
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config-JDBC.xml");
		
        // 建立DAO物件
		UploadDAO_interface dao =(UploadDAO_interface) context.getBean("uploadDAO");
		
		//● 新增
		//
//		UploadVO uploadVO = new UploadVO();
//		uploadVO.setName("薇婷");
//		uploadVO.setAddress("1234");
//		uploadVO.setBirthday(new java.sql.Date(System.currentTimeMillis()));
//		uploadVO.setPhoto("9876");
//		dao.insert(uploadVO);
		
		//● 查詢-findByPrimaryKey (多方reservation.hbm.xml必須設為lazy="false")(優!)
//		UploadVO uploadVO = dao.findPrimaryKey(2);
//		System.out.print(uploadVO.getFile_no() + ",");
//		System.out.print(uploadVO.getName() + ",");
//		System.out.print(uploadVO.getAddress() + ",");
//		System.out.print(uploadVO.getBirthday() + ",");
//		System.out.print(uploadVO.getPhoto() + ",");
		
		//● 查詢-getAll (多方reservation.hbm.xml必須設為lazy="false")(優!)
//		List<UploadVO> list = dao.getAll();
//		for (UploadVO afile : list) {
//			System.out.print(afile.getFile_no() + ",");
//			System.out.print(afile.getName() + ",");
//			System.out.print(afile.getAddress() + ",");
//			System.out.print(afile.getBirthday() + ",");
//			System.out.println(afile.getPhoto() + ",");
//		}
	}

}
