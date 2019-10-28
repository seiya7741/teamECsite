package com.internousdev.arizona.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.arizona.dao.UserInfoDAO;
import com.internousdev.arizona.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private UserInfoDAO dao = new UserInfoDAO();
	private UserInfoDTO userInfoDTO;

	public String execute() {

		if (!session.containsKey("tempUserId") && !session.containsKey("userId")) {
			return "sessionTimeout";

		}

		int logined = Integer.parseInt(String.valueOf(session.get("logined")));
		if (logined != 1) {
			return "sessionTimeout";
		}
		try {
			userInfoDTO = dao.getUserInfo(String.valueOf(session.get("userId")));
		} catch (SQLException e)  {
			e.printStackTrace();
			return ERROR;
		}

		if (userInfoDTO.getUserId() == null) {
			userInfoDTO = null;
		}

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}

	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}
}
