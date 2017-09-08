package com.eternal.dao.impl;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.eternal.dao.UserDao;
import com.eternal.domain.User;
import com.eternal.utils.XmlUtils;

public class UserDaoImpl implements UserDao {

	@SuppressWarnings("deprecation")
	public void save(User user) {
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element userElement = root.addElement("user");
			
			userElement.setAttributeValue("id", user.getId());
			userElement.setAttributeValue("username", user.getUsername());
			userElement.setAttributeValue("password", user.getPassword());
			userElement.setAttributeValue("email", user.getEmail());
			
			XmlUtils.write2Xml(document);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User find(String username,String password) {
		User user = null;
		try {
			Document document = XmlUtils.getDocument();
			Element element = (Element)document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(element==null) {
				return null;
			}
			user = new User();
			user.setId(element.attributeValue("id"));
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(element.attributeValue("email"));
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	
	public boolean find(String username) {		
		try {
			Document document = XmlUtils.getDocument();
			Element element = (Element)document.selectSingleNode("//user[@username='"+username+"']");
			if(element==null) {
				return false;
			}
			return true;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
		
	}
}

