package kr.co.kmarket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVo {
	private String uid;
	private String pass1;
	private String pass2;
	private String name;
	private int gender;
	private String hp;
	private String email;
	private int type;
	private int point;
	private int grade;
	private String zip;
	private String addr1;
	private String addr2;
	private String company;
	private String ceo;
	private String bizRegNum;
	private String commRepNum;
	private String tel;
	private String manager;
	private String managerHp;
	private String fax;
	private String ip;
	private String leaveDate;
	private String rdate;
	private String etc1;
	private String etc2;
	private String etc3;
	private String etc4;
	private String etc5;
	
	//추가필드
	private int productCode;
	
}
