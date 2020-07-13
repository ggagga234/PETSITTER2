<<<<<<< HEAD:RETSITTER/src/main/java/kh/pet/aspect/LogAdvisor.java
package kh.pet.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class LogAdvisor {
	
	@Autowired
	private HttpSession session;
	
	public Object logincheck(ProceedingJoinPoint pj) throws Throwable{
		if(session.getAttribute("loginInfo")==null) {
			return "/member/login";
		}
		else {
		}
		Object re = pj.proceed();
		return re;
	}
}
=======
package kh.pet.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class LogAdvisor {
	
	@Autowired
	private HttpSession session;
	
	public Object logincheck(ProceedingJoinPoint pj) throws Throwable{
		if(session.getAttribute("loginInfo")==null) {
			return "redirect:/";
		}
		else {
		}
		Object re = pj.proceed();
		return re;
	}
}
>>>>>>> b2951192f15074ad7e1f045f7cf5b29481d3ebff:src/main/java/kh/pet/aspect/LogAdvisor.java
