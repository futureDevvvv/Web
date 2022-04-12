package sec02.ex01;

import java.util.Date;

public class MemberVO {
	{
		System.out.println("MemberVO 생성자 호출. 값을 전달해주는 Value Object 객체. 테이블에서 조회한 컬럼 값을 속성에 저장함.");
	}
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
}
