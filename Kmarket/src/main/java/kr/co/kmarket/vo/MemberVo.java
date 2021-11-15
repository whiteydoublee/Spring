package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //table로 사용 가능하게 만들어줌 
@Table(name="km_member")
public class MemberVo {
	@Id //PK 가 JPA Repo의 아이디로 사용되어짐으로 
	private String uid;
	private String pass;
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
	
	//추가필드 (JPA는 VO의 컬럼이 똑같아야함, 따라서 transient라는 annotation 사용하여 table 컬럼에서 제외
	@Transient 
	private int productCode;
	
}
