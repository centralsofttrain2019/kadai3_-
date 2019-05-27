package bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LoginBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	//private String password;
	private String loginId;
	private LocalDateTime loginDateTime;

//	public String toString()
//	{
//		return "user id:" + this.getLoginId()
//				+ " login at:" + this.getLoginDateTime().toString();
//	}

//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public LocalDateTime getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(LocalDateTime loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
}
