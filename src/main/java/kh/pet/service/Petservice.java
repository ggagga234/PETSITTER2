package kh.pet.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.pet.staticInfo.Mb_Configuration;
import kh.pet.dao.PetDao;
import kh.pet.dto.MemboardDto;
import kh.pet.dto.Mypet_regDTO;


@Service
public class Petservice {
	@Autowired
	private PetDao dao;
	
	public List<Mypet_regDTO> Petselect(String id) throws Exception {
		return dao.Petselect(id);
	}
	
	public int Memboardinsert(MemboardDto mdto) throws Exception {
		return dao.Memboardinsert(mdto);
	}
	
	public MemboardDto redlist(String mb_seq) throws Exception {
		return dao.redlist(mb_seq);
	}
	
	public String petphoto(Mypet_regDTO pdto) throws Exception {
		return dao.petphoto(pdto);
	}
	
	public String gettime(String time) throws Exception {
		return dao.gettime(time);
	}
	
	public String getpettype(Mypet_regDTO pdto) throws Exception {
		return dao.getpettype(pdto);
	}

	public MemboardDto bopet(String seq) throws Exception {
		return dao.bopet(seq);
	}
	
	public MemboardDto modlist(String mb_seq) throws Exception {
		return dao.modlist(mb_seq);
	}
	
	public int Memboardupdate(MemboardDto mdto) throws Exception {
		return dao.Memboardupdate(mdto);
	}
	
	public int deleteboard(MemboardDto mdto) throws Exception {
		System.out.println("삭제 페이지 번호 : "+mdto.getMb_seq());
		return dao.deleteboard(mdto);
	}
	
	public List<MemboardDto> seqid(String id) throws Exception {
		return dao.seqid(id);
	}
	
	public String addselec(String id) throws Exception {
		return dao.addselec(id);
	}
	
	public int reserv_point(MemboardDto mbdto) throws Exception {
		return dao.reserv_point(mbdto);
	}

	public int reservdel(String seq) throws Exception {
		return dao.reservdel(seq);
	}

	public int mpoint(String id) throws Exception {
		return dao.mpoint(id);
	}

	public int applyup(MemboardDto mbdto) throws Exception {
		return dao.applyup(mbdto);
	}
	
	public int applydown(String seq) throws Exception {
		return dao.applydown(seq);
	}

	public int mpointup(MemboardDto mbdto) throws Exception {
		return dao.mpointup(mbdto);
	}
	
	public int ppointup(MemboardDto mbdto) throws Exception {
		return dao.ppointup(mbdto);
	}

	
	public int petsitter(String id) throws Exception {
		return dao.petsitter(id);
	}

	public List<MemboardDto> petselname(String id) throws Exception {
		return dao.petselname(id);
	}
	
	public List<MemboardDto> mb_boardList(int cpage) throws Exception {
		int start =  cpage*Mb_Configuration.recordCountPerPage-(Mb_Configuration.recordCountPerPage-1);
		int end = start + (Mb_Configuration.recordCountPerPage-1);
		
		Map<String,Integer> con = new HashMap<String,Integer>();
		con.put("start",start);
		con.put("end",end);
		return dao.mb_boardList(con);
	}
	
	public String getPageNavi(int currentPage) throws Exception {
		
		int recordTotalCount = dao.getArticleCount();//총 게시물의 개수
		
		int pageTotalCount = 0; // 전체 페이지 개수
		
		if(recordTotalCount % Mb_Configuration.recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / Mb_Configuration.recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / Mb_Configuration.recordCountPerPage;
		}
		
	
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int startNavi = (currentPage - 1) / Mb_Configuration.naviCountPerPage * Mb_Configuration.naviCountPerPage + 1;
		int endNavi = startNavi + (Mb_Configuration.naviCountPerPage -1);

		if(endNavi>pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
	
		if(startNavi == 1) {needPrev=false;}
		if(endNavi == pageTotalCount) {needNext = false;}
		
		StringBuilder sb = new StringBuilder();
		
		if(needPrev) {sb.append("<a href='/mb/mb_board?cpage="+(startNavi-1)+"'>< </a>");}
		for(int i = startNavi;i<= endNavi;i++) {
			sb.append("<a href='/mb/mb_board?cpage="+i+"'>"+i+"</a>");
		}
		if(needNext) {sb.append("<a href='/mb/mb_board?cpage="+(endNavi+1)+"'> ></a>");}
		
		return sb.toString();
	}
}
