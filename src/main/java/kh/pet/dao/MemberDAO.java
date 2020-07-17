package kh.pet.dao;

import java.util.Map;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.pet.dto.MemberDTO;
import kh.pet.service.MemberService;

@Repository
public class MemberDAO {


	@Autowired
	private SqlSessionTemplate mybatis;

	@Autowired
	private MemberService mservice;



	public String isExistId(String ps_id) throws Exception{
		int result = mybatis.selectOne("Member.existId", ps_id);
		if(result==0) {return String.valueOf(true);}
		else {return String.valueOf(false);}
	}

	//id중복체크
	public int idDuplCheck(String id) {
		int result = mybatis.selectOne("Member.dupleCheck", id);
		return result;
	}

	//이메일 중복체크
	public int emailCheck(String email) throws Exception {

		int result = mybatis.selectOne("Member.emailCheck", email);
		return result;
	}

	public void signup(MemberDTO dto) throws Exception {	 //가입

		if(dto.getMem_pw() != null) {
			dto.setMem_pw(mservice.getSHA512(dto.getMem_pw()));
		}

		mybatis.insert("Member.signup", dto);

	}

	//이메일 인증키 확인
	public int authkey(String key) { 

		return mybatis.selectOne("Member.authkey", key);

	}
	//인증여부 n->y로 바꿈.
	public int successAuthkey(String key) {

		return mybatis.update("Member.successAuthkey", key);

	}

	//이메일 인증 마쳤는지 확인.
	public int verify(String id) {  
		return mybatis.selectOne("Member.verify", id);
	}

	//로그인
	public boolean login(Map<String, String> map)throws Exception{

		int result = mybatis.selectOne("Member.login", map);

		if(result>0) return true;
		return false;

	}

	public MemberDTO myInfo(String id) {
	

		return mybatis.selectOne("Member.myinfo", id);
	}

	public String findID(String email) {

		return mybatis.selectOne("Member.findid", email);
	}

	public int findPw(Map<String, String> map) { //아이디, 이메일과 일치하는지 확인. 

		return mybatis.selectOne("Member.findpw", map);
	}
	public int replacepw(Map<String, String> map) { //임시비밀번호로 재설정

		return mybatis.update("Member.replacepw", map);
	}

	public int withdraw(String id) { //탈퇴
		
		System.out.println("dao:" +id);

		return mybatis.delete("Member.withdraw", id);	
	}

	public int myinfo_modify(MemberDTO dto) {
		
		System.out.println("mybatis를 찾아서");
		return mybatis.update("Member.myinfo_modify", dto);

	}
	public int myinfo_email(MemberDTO dto) {

		return mybatis.update("Member.myinfo_email", dto);

	}
	public int myinfo_sns(MemberDTO dto) {
		
		return mybatis.update("Member.myinfo_sns", dto);

	}


}
