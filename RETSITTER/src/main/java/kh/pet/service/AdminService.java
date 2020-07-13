<<<<<<< HEAD:RETSITTER/src/main/java/kh/pet/service/AdminService.java
package kh.pet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.pet.dao.AdminDAO;
import kh.pet.dao.MessageDAO;
import kh.pet.dto.MemberDTO;
import kh.pet.dto.MemboardDto;
import kh.pet.dto.MessageDTO;
import kh.pet.dto.PetsitterDTO;
import kh.pet.dto.Stop_memberDTO;
import kh.pet.dto.WaitlistDTO;
import kh.pet.staticInfo.Admin_Configuration;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	@Autowired
	private MessageDAO mdao;
	
	//게시판 관리
	
	public int board_stop(String seq, String boardType,String state) {
		Map<String, Object> edit_date = new HashMap<String, Object>();
		edit_date.put("seq", seq);
		edit_date.put("boardType", boardType);
		edit_date.put("state", state);
		return dao.board_state(edit_date);
	}
	
	public List<PetsitterDTO> petsitter(){
		return dao.petsitter();
	}
	
	//펫 시터 신청서 관리
	
	@Transactional("txManager")
	public int petaccept(String id) {
		MessageDTO dto = new MessageDTO();
		dto.setMsg_reciever(id);
		dto.setMsg_title("펫 시터 관련 글입니다.");
		dto.setMsg_contents("승인되었습니다. 지금부터는 펫 시터로 활동이 가능합니다.");
		dto.setMsg_sender("관리자");
		mdao.sendMessage(dto);
		System.out.println(id);
		return dao.petaccept(id);
	}
	
	@Transactional("txManager")
	public int petcencel(String id) {
		MessageDTO dto = new MessageDTO();
		dto.setMsg_reciever(id);
		dto.setMsg_title("펫 시터 관련 글입니다.");
		dto.setMsg_contents("신청이 거절되었습니다. 규약을 잘 읽어보고 다시 신청해주시길 바랍니다.");
		dto.setMsg_sender("관리자");
		mdao.sendMessage(dto);
		System.out.println(id);
		return dao.petcencel(id);
	}
	
	//회원 관리
	
	public int stop_mem(Stop_memberDTO dto){
		String tmp = dto.getS_stop_day();
		if(tmp.contentEquals("3_stop")) {
			dto.setStop_day(3);
		}else if(tmp.contentEquals("7_stop")){
			dto.setStop_day(7);
		}else if(tmp.contentEquals("f_stop")) {
			dto.setStop_day(10000000);
		}else if(tmp.contentEquals("no")) {
			dto.setStop_day(0);
		}
		if(dao.mem_stop_search(dto.getStop_id())==0) {
			return dao.mem_stop(dto);
		}
		else {
			return dao.mem_stop_update(dto);
		}
		
	}
	
	public List<MemberDTO> member(int cpage){
		int start = cpage*Admin_Configuration.member_RECORD_COUNT_PER_PAGE - (Admin_Configuration.member_RECORD_COUNT_PER_PAGE-1);
		int end = start + (Admin_Configuration.member_RECORD_COUNT_PER_PAGE-1);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start",start);
		map.put("end", end);
		return dao.memberlist(map);
	}
	
	public String memberPagNavi(int currentPage){
		int recordTotalCount = this.dao.membercount(); //총 게시물의 갯수.
		int pageTotalCount = 0; //전체 페이지의 갯수

		if(recordTotalCount%Admin_Configuration.member_RECORD_COUNT_PER_PAGE == 0) {
			pageTotalCount = recordTotalCount / Admin_Configuration.member_RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount / Admin_Configuration.member_RECORD_COUNT_PER_PAGE +1;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}
		else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = (currentPage -1) / Admin_Configuration.member_NAVI_COUNT_PAGE *Admin_Configuration.member_NAVI_COUNT_PAGE + 1;
		int endNavi = startNavi +Admin_Configuration.member_NAVI_COUNT_PAGE - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;

		StringBuilder sb = new StringBuilder();

		if(startNavi ==1) {
			needPrev =false;
		}
		if(endNavi==pageTotalCount) {
			needNext = false;
		}

		if(needPrev) {
			sb.append("<a href=\"/admin/member?cpage="+(startNavi-1)+"\"class=\"badge badge-pill badge-info\"><</a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href=\"/admin/member?cpage="+i+"\"class=\"badge badge-pill badge-info\">"+i+"</a>");	
		}
		if(needNext) {
			sb.append("<a href=\"/admin/member?cpage="+(endNavi+1)+"\"class=\"badge badge-pill badge-info\">></a>");
		}
		return sb.toString();
	}
	
	//예약 관리 페이지
	public List<MemboardDto> re_memboard(){
		return dao.re_memboard();
	}
	
	public List<WaitlistDTO> re_psboard(){
		return dao.re_psboard();
	}
	
}
=======
package kh.pet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.pet.dao.AdminDAO;
import kh.pet.dao.MessageDAO;
import kh.pet.dto.MemberDTO;
import kh.pet.dto.MemboardDto;
import kh.pet.dto.MessageDTO;
import kh.pet.dto.PetsitterDTO;
import kh.pet.dto.ReportDTO;
import kh.pet.dto.ReserveDto;
import kh.pet.dto.Stop_memberDTO;
import kh.pet.dto.WaitlistDTO;
import kh.pet.staticInfo.Admin_Configuration;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	@Autowired
	private MessageDAO mdao;
	
	//게시판 관리
	
	public int board_stop(String seq, String boardType,String state) {
		Map<String, Object> edit_date = new HashMap<String, Object>();
		edit_date.put("seq", seq);
		edit_date.put("boardType", boardType);
		edit_date.put("state", state);
		return dao.board_state(edit_date);
	}
	
	public List<PetsitterDTO> petsitter(){
		return dao.petsitter();
	}
	
	//펫 시터 신청서 관리
	
	@Transactional("txManager")
	public int petaccept(String id) {
		MessageDTO dto = new MessageDTO();
		dto.setMsg_reciever(id);
		dto.setMsg_title("펫 시터 관련 글입니다.");
		dto.setMsg_contents("승인되었습니다. 지금부터는 펫 시터로 활동이 가능합니다.");
		dto.setMsg_sender("관리자");
		mdao.sendMessage(dto);
		return dao.petaccept(id);
	}
	
	@Transactional("txManager")
	public int petcencel(String id) {
		MessageDTO dto = new MessageDTO();
		dto.setMsg_reciever(id);
		dto.setMsg_title("펫 시터 관련 글입니다.");
		dto.setMsg_contents("신청이 거절되었습니다. 규약을 잘 읽어보고 다시 신청해주시길 바랍니다.");
		dto.setMsg_sender("관리자");
		mdao.sendMessage(dto);
		System.out.println(id);
		return dao.petcencel(id);
	}
	
	//회원 관리
	
	public int stop_mem(Stop_memberDTO dto){
		String tmp = dto.getS_stop_day();
		if(tmp.contentEquals("3_stop")) {
			dto.setStop_day(3);
		}else if(tmp.contentEquals("7_stop")){
			dto.setStop_day(7);
		}else if(tmp.contentEquals("f_stop")) {
			dto.setStop_day(10000000);
		}
		if(dao.mem_stop_search(dto.getStop_id())==0) {
			return dao.mem_stop(dto);
		}
		else {
			return dao.mem_stop_update(dto);
		}
		
	}
	
	public void stop_scaduler() {
		dao.mem_stop_count();
		List<Stop_memberDTO> list = dao.mem_stop_solve_search();
		dao.mem_stop_solve(list);
	}
	
	public List<MemberDTO> member(int cpage){
		int start = cpage*Admin_Configuration.member_RECORD_COUNT_PER_PAGE - (Admin_Configuration.member_RECORD_COUNT_PER_PAGE-1);
		int end = start + (Admin_Configuration.member_RECORD_COUNT_PER_PAGE-1);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start",start);
		map.put("end", end);
		return dao.memberlist(map);
	}
	
	public String memberPagNavi(int currentPage){
		int recordTotalCount = this.dao.membercount(); //총 게시물의 갯수.
		int pageTotalCount = 0; //전체 페이지의 갯수

		if(recordTotalCount%Admin_Configuration.member_RECORD_COUNT_PER_PAGE == 0) {
			pageTotalCount = recordTotalCount / Admin_Configuration.member_RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount / Admin_Configuration.member_RECORD_COUNT_PER_PAGE +1;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}
		else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = (currentPage -1) / Admin_Configuration.member_NAVI_COUNT_PAGE *Admin_Configuration.member_NAVI_COUNT_PAGE + 1;
		int endNavi = startNavi +Admin_Configuration.member_NAVI_COUNT_PAGE - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;

		StringBuilder sb = new StringBuilder();

		if(startNavi ==1) {
			needPrev =false;
		}
		if(endNavi==pageTotalCount) {
			needNext = false;
		}

		if(needPrev) {
			sb.append("<a href=\"/admin/member?cpage="+(startNavi-1)+"\"class=\"badge badge-pill badge-info\"><</a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href=\"/admin/member?cpage="+i+"\"class=\"badge badge-pill badge-info\">"+i+"</a>");	
		}
		if(needNext) {
			sb.append("<a href=\"/admin/member?cpage="+(endNavi+1)+"\"class=\"badge badge-pill badge-info\">></a>");
		}
		return sb.toString();
	}
	
	//예약 관리 페이지
	//mem_board 관련 
	public List<MemboardDto> re_memboard(){
		return dao.re_memboard();
	}
	
	@Transactional("txManager")
	public int accept_memboard(MemboardDto bdto) {
		Map<String , String> seq_set = new HashMap<String, String>();
		UUID uuid = UUID.randomUUID();
		seq_set.put("p_seq", bdto.getMb_seq());
		seq_set.put("seq",uuid.toString());
		
		MessageDTO b_dto = new MessageDTO();
		b_dto.setMsg_reciever(bdto.getMb_booker());
		b_dto.setMsg_title("예약 관련 글입니다.");
		b_dto.setMsg_contents("예약이 완료되었습니다. 예약 번호는 " +uuid.toString() +"이며,\n자세한 사항 예약 확인 란에서 확인을 하실 수 있습니다.");
		b_dto.setMsg_sender("관리자");
		mdao.sendMessage(b_dto);
		
		MessageDTO w_dto = new MessageDTO();
		w_dto.setMsg_reciever(bdto.getMb_writer());
		w_dto.setMsg_title("돌봄 서비스 관련 글입니다.");
		w_dto.setMsg_contents("돌봄 서비스가 예약이 되었습니다. 예약 번호는 " +uuid.toString() +"이며,\n자세한 사항 예약 확인 란에서 확인을 하실 수 있습니다.");
		w_dto.setMsg_sender("관리자");
		mdao.sendMessage(w_dto);
		
		return dao.accept_memboard(seq_set);
	}
	
	@Transactional("txManager")
	public int cancel_memboard(MemboardDto bdto) {
		
		MessageDTO b_dto = new MessageDTO();
		b_dto.setMsg_reciever(bdto.getMb_booker());
		b_dto.setMsg_title("예약 관련 글입니다.");
		b_dto.setMsg_contents("문의하신 예약이 거절 되었습니다. 자세한 사항은 개별 문의를 부탁드립니다.");
		b_dto.setMsg_sender("관리자");
		mdao.sendMessage(b_dto);
		
		return dao.cancel_memboard(bdto.getMb_seq());
		
	}
	
	
	//petsitter_board 관련
	public List<WaitlistDTO> re_psboard(){
		return dao.re_psboard();
	}
	
	@Transactional("txManager")
	public int accept_petsitter(int wait_seq) {
		
		WaitlistDTO w_dto = dao.accept_pet_info(wait_seq);
		UUID uuid = UUID.randomUUID();
		ReserveDto dto = new ReserveDto(uuid.toString(),w_dto.getBoard_seq(),w_dto.getPetsitter_id(),w_dto.getMem_id(),w_dto.getRsv_pet_name(),w_dto.getRsv_point(),w_dto.getRsv_start_day(),w_dto.getRsv_end_day(),w_dto.getRsv_time());
		
		MessageDTO b_dto = new MessageDTO();
		b_dto.setMsg_reciever(w_dto.getMem_id());
		b_dto.setMsg_title("펫 시터 예약 관련 글입니다.");
		b_dto.setMsg_contents("예약이 완료되었습니다. 예약 번호는 " +uuid.toString() +"이며,\n자세한 사항 예약 확인 란에서 확인을 하실 수 있습니다.");
		b_dto.setMsg_sender("관리자");
		mdao.sendMessage(b_dto);
		
		MessageDTO p_dto = new MessageDTO();
		p_dto.setMsg_reciever(w_dto.getPetsitter_id());
		p_dto.setMsg_title("펫시터 서비스 관련 글입니다.");
		p_dto.setMsg_contents("펫시터 서비스가 예약이 되었습니다. 예약 번호는 " +uuid.toString() +"이며,\n자세한 사항 예약 확인 란에서 확인을 하실 수 있습니다.");
		p_dto.setMsg_sender("관리자");
		mdao.sendMessage(p_dto);

		dao.accept_del_rsv(w_dto.getWait_seq());
		return dao.accept_pet_rsv(dto);
	}
	
	@Transactional("txManager")
	public int cancel_petsitter (int wait_seq) {
		WaitlistDTO w_dto = dao.accept_pet_info(wait_seq);
		
		MessageDTO b_dto = new MessageDTO();
		
		b_dto.setMsg_reciever(w_dto.getMem_id());
		b_dto.setMsg_title("예약 관련 글입니다.");
		b_dto.setMsg_contents("문의하신 예약이 거절 되었습니다. 자세한 사항은 개별 문의를 부탁드립니다.");
		b_dto.setMsg_sender("관리자");
		mdao.sendMessage(b_dto);
		
		return dao.cancel_pettsiter(w_dto.getWait_seq());
		
	}
	
	//게시글 신고 관리
	public List<ReportDTO> reportlist(){
		return dao.reportlist();
	}
	
}
>>>>>>> b2951192f15074ad7e1f045f7cf5b29481d3ebff:src/main/java/kh/pet/service/AdminService.java
