package kr.co.sboard.vo;

import lombok.Data;

@Data
public class FileVo {
	
	private int fseq;
	private int parent;
	private String oriName;
	private String newName;
	private int download;
	private String rdate;

}
