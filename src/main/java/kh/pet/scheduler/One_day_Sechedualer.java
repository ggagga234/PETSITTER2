package kh.pet.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import kh.pet.service.AdminService;


@Service
public class One_day_Sechedualer {
	
	@Autowired
	private AdminService service;

	@Scheduled(cron = "0 0 0 * * ?")
	public void stop_count(){
		service.petsitter_time();
		service.stop_scaduler();
		service.insert_v();
	}
}
