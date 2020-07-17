package kh.pet.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.pet.dao.MypageUseDAO;
import kh.pet.dto.Mypage_UseTableDTO;

@Service
public class UseService {
	@Autowired
	private MypageUseDAO udao;

	// �꽕鍮� 諛�
	public List<Mypage_UseTableDTO> selectByPageNo(int cpage, String id, String name)
			throws Exception {
		List<Mypage_UseTableDTO> dto = udao.selectByPageNo(cpage, id, name);
		return dto;
	}

	// �꽕鍮� 諛�
	public String getPageNavi(int cpage, String name) throws Exception {
		String navi = udao.getPageNavi(cpage, name);
		return navi;
	}

	public void usestate(String id , List<Mypage_UseTableDTO> lists) throws ParseException {

		List<Mypage_UseTableDTO> day = udao.statueday(id);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String nowday = format.format(System.currentTimeMillis());
		java.util.Date date1 = format.parse(nowday);
		
		
		for (int i = 0; i < day.size(); i++) {
			Date start = day.get(i).getStart_day();
			Date end = day.get(i).getEnd_day();
			if (start.after(date1)) {
				lists.get(i).setStatus("예약대기");
			} else if (start.before(date1) && end.after(date1)) {
				lists.get(i).setStatus("서비스중");
			}
		}

	}
}
