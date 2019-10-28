package com.internousdev.arizona.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.arizona.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute(){
		String result;
		result = null;

		if(!session.containsKey("tempUserId") && !session.containsKey("userId")) {
			return "sessionTimeout";
		}

		int logined = Integer.parseInt(String.valueOf(session.get("logined")));
		if(logined != 1) {
			return "sessionTimeout";
		}

		try{
			DestinationInfoDAO dao = new DestinationInfoDAO();
		result = ERROR;
		int count = dao.addDestinationData(
				session.get("userId").toString(),
				session.get("familyName").toString(),
				session.get("firstName").toString(),
				String.valueOf(session.get("familyNameFurigana")),
				String.valueOf(session.get("firstNameFurigana")),
				String.valueOf(session.get("email")),
				String.valueOf(session.get("phoneNumber")),
				session.get("address").toString()
				);

		if(count > 0){
			result = SUCCESS;
		}

		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameFurigana");
		session.remove("firstNameFurigana");
		session.remove("email");
		session.remove("phoneNumber");
		session.remove("address");

		}catch(SQLException e){
			e.printStackTrace();

		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
