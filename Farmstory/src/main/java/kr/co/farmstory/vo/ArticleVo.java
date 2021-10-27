package kr.co.farmstory.vo;

import org.springframework.web.multipart.MultipartFile;

import kr.co.farmstory.vo.FileVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleVo {
	private int seq;
	private int parent;
	private String comment;
	private String title;
	private String content;
	private int file;
	private int hit;
	private String uid;
	private String regip;
	private String rdate;
	
	//추가필드
	private MultipartFile fname;
	private String nick;
	private FileVo fileVo;
}
