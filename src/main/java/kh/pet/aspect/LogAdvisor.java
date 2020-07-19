package kh.pet.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import kh.pet.dto.MemberDTO;

public class LogAdvisor {
	
	@Autowired
	private HttpSession session;
	
	public Object logincheck(ProceedingJoinPoint pj) throws Throwable{
		String stop = ((MemberDTO)session.getAttribute("loginInfo")).getMem_status();
		if(session.getAttribute("loginInfo")==null) {
			return "redirect:/";
		}
		else if(!stop.contentEquals("YES")) {
			return "redirect:/member/logout";
		}
		else {
		}
		Object re = pj.proceed();
		return re;
	}
}
