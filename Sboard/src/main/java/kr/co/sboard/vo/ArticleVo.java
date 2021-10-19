package kr.co.sboard.vo;

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
}
