package com.internousdev.arizona.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.arizona.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware {

	private String userId;
	private String familyName;
	private String firstName;
	private String familyNameFurigana;
	private String firstNameFurigana;
	private String address;
	private String email;
	private String phoneNumber;
	private Map<String, Object> session;
	private String errorMessage;

	private List<String> familyNameErrorMessageList;
	private List<String> firstNameErrorMessageList;
	private List<String> familyNameFuriganaErrorMessageList;
	private List<String> firstNameFuriganaErrorMessageList;
	private List<String> emailErrorMessageList;
	private List<String> phoneNumberErrorMessageList;
	private List<String> addressErrorMessageList;

	public String execute() {

		if (!session.containsKey("tempUserId") && !session.containsKey("userId")) {
			return "sessionTimeout";
		}

		int logined = Integer.parseInt(String.valueOf(session.get("logined")));
		if (logined != 1) {
			return "sessionTimeout";
		}

		String result = ERROR;

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameFurigana", familyNameFurigana);
		session.put("firstNameFurigana", firstNameFurigana);
		session.put("address", address);
		session.put("email", email);
		session.put("phoneNumber", phoneNumber);

		InputChecker ic = new InputChecker();
		// 入力ミスがあったらエラーメッセージのリストを作りたいため、InputCheckerを利用する
		emailErrorMessageList = ic.doCheckForEmail("メールアドレス", email, 10, 32);
		familyNameErrorMessageList = ic.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false);
		firstNameErrorMessageList = ic.doCheck("名", firstName, 1, 16, true, true, true, false, false, false);
		familyNameFuriganaErrorMessageList = ic.doCheck("姓ふりがな", familyNameFurigana, 1, 16, false, false, true, false,
				false, false);
		firstNameFuriganaErrorMessageList = ic.doCheck("名ふりがな", firstNameFurigana, 1, 16, false, false, true, false,
				false, false);
		addressErrorMessageList = ic.doCheck("住所", address, 10, 50, true, true, true, true, true, false);
		phoneNumberErrorMessageList = ic.doCheck("電話番号", phoneNumber, 10, 13, false, false, false, true, false, false);

		if (familyNameErrorMessageList.size() > 0 || firstNameErrorMessageList.size() > 0
				|| familyNameFuriganaErrorMessageList.size() > 0 || firstNameFuriganaErrorMessageList.size() > 0
				|| emailErrorMessageList.size() > 0 || phoneNumberErrorMessageList.size() > 0
				|| addressErrorMessageList.size() > 0) {
			result = ERROR;
		} else {
			result = SUCCESS;
		}
		return result;
	}

	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}

	public void setFamilyNameErrorMessageList(List<String> familyNameErrorMessageList) {
		this.familyNameErrorMessageList = familyNameErrorMessageList;
	}

	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}

	public void setFirstNameErrorMessageList(List<String> firstNameErrorMessageList) {
		this.firstNameErrorMessageList = firstNameErrorMessageList;
	}

	public List<String> getFamilyNameFuriganaErrorMessageList() {
		return familyNameFuriganaErrorMessageList;
	}

	public void setFamilyNameFuriganaErrorMessageList(List<String> familyNameFuriganaErrorMessageList) {
		this.familyNameFuriganaErrorMessageList = familyNameFuriganaErrorMessageList;
	}

	public List<String> getFirstNameFuriganaErrorMessageList() {
		return firstNameFuriganaErrorMessageList;
	}

	public void setFirstNameFuriganaErrorMessageList(List<String> firstNameFuriganaErrorMessageList) {
		this.firstNameFuriganaErrorMessageList = firstNameFuriganaErrorMessageList;
	}

	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}

	public void setEmailErrorMessageList(List<String> emailErrorMessageList) {
		this.emailErrorMessageList = emailErrorMessageList;
	}

	public List<String> getPhoneNumberErrorMessageList() {
		return phoneNumberErrorMessageList;
	}

	public void setPhoneNumberErrorMessageList(List<String> phoneNumberErrorMessageList) {
		this.phoneNumberErrorMessageList = phoneNumberErrorMessageList;
	}

	public List<String> getAddressErrorMessageList() {
		return addressErrorMessageList;
	}

	public void setAddressErrorMessageList(List<String> addressErrorMessageList) {
		this.addressErrorMessageList = addressErrorMessageList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameFurigana() {
		return familyNameFurigana;
	}

	public void setFamilyNameFurigana(String familyNameFurigana) {
		this.familyNameFurigana = familyNameFurigana;
	}

	public String getFirstNameFurigana() {
		return firstNameFurigana;
	}

	public void setFirstNameFurigana(String firstNameFurigana) {
		this.firstNameFurigana = firstNameFurigana;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
