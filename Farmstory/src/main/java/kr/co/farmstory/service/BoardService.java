package kr.co.farmstory.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.farmstory.dao.BoardDao;
import kr.co.farmstory.vo.ArticleVo;
import kr.co.farmstory.vo.FileVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	public int insertArticle(ArticleVo vo) {
		dao.insertArticle(vo);
		return vo.getSeq();
	}
	public void insertFile(FileVo vo) {
		dao.insertFile(vo);
	};
	public FileVo selectFile(int fseq) {
		return dao.selectFile(fseq);
	};
	public ArticleVo selectArticle(int seq) {
		return dao.selectArticle(seq);
	}
	public List<ArticleVo> selectArticles(String cate,int start) {
		return dao.selectArticles(cate,start);
	}
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
	}
	
	public void updateArticle(ArticleVo vo) {
		 dao.updateArticle(vo);
	}
	public void updateFileDownload(int fseq) {
		dao.updateFileDownload(fseq);
		
	};
	public void deleteArticle(int seq) {
		dao.deleteArticle(seq);
	}
	
	public void fileDownload(HttpServletResponse resp, FileVo fileVo) {

		File file = new File("src/main/resources/static/file/");
		String path = file.getAbsolutePath()+"/"+fileVo.getNewName();
		
		try {
			byte[] fileByte = FileUtils.readFileToByteArray(new File(path));
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileVo.getOriName(), "utf-8"));
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
			
			
			resp.getOutputStream().write(fileByte);
			resp.getOutputStream().flush();
			resp.getOutputStream().close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Business ?????? ?????? ?????? ?????????
		///?????? ?????????
		public FileVo fileUpload(MultipartFile fname, int seq) {
			//?????? ????????? ??????
			File file = new File("src/main/resources/static/file/");
			String path = file.getAbsolutePath();
			
			String name = fname.getOriginalFilename();
			String ext = name.substring(name.lastIndexOf("."));
			
			String uName = UUID.randomUUID().toString()+ext;
			
			FileVo fvo = null;
			
			try {
				//???????????? ??????
				fname.transferTo(new File(path+"/"+uName));
				
				//???????????? ?????? Insert
				fvo = new FileVo();
				fvo.setParent(seq);
				fvo.setOriName(name);
				fvo.setNewName(uName);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return fvo;
		}
		
		//????????? ????????? ????????????
		public int getPageStartNum(int total, int start) {
			return total - start;
		}
		//????????? ?????? ?????? ??????(??????,??????)
		public int[] getPageGroup(int currentPage, int lastPageNum) {
			int groupCurrent = (int) Math.ceil(currentPage / 10.0);
			int groupStart = (groupCurrent - 1) * 10 +1;
			int groupEnd = groupCurrent * 10;
			
			if(groupEnd > lastPageNum) {
				groupEnd = lastPageNum;
			}
			int[] groups = {groupStart, groupEnd};
			return groups;
		}
		
		public int getCurrentPage(String pg) {
			int currentPage = 1;
			if (pg != null) {
				currentPage = Integer.parseInt(pg);
			}
			return currentPage;
		}
		
		//?????? ????????? SQL start ??????
		public int getLimitStart(int currentPage) {
			return (currentPage -1) * 10;
		}
		
		//????????? ????????? ????????? ??????
		public int getLastPageNum(int total) {
			int lastPageNum = 0;
			
			if(total % 10 == 0) {
				lastPageNum = total / 10;
			}else {
				lastPageNum = total / 10 + 1;
			}
			
			return lastPageNum;
		}

}
