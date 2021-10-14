package kr.co.ch08.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVo {
	private String uid;
	private String name;
	private String address;
	private String phone;

}
