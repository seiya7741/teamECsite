package com.internousdev.arizona.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware{

	private String backFlag;
	private Map<String, Object> session;
	public String execute(){
		if(!session.containsKey("tempUserId") && !session.containsKey("userId")){
			return "sessionTimeout";
		}
		int logined = Integer.parseInt(String.valueOf(session.get("logined")));
		if(logined != 1){
			return "sessionTimeout";
		}
		//ブラウザの戻るボタンなど、ページ内からの画面遷移ではない場合removeする
		if(backFlag == null){
			session.remove("familyName");
			session.remove("firstName");
			session.remove("familyNameFurigana");
			session.remove("firstNameFurigana");
			session.remove("email");
			session.remove("phoneNumber");
			session.remove("address");
		}
			return SUCCESS;
	}
	public String getBackFlag() {
		return backFlag;
	}
	public void setBackFlag(String backFlag) {
		this.backFlag = backFlag;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}