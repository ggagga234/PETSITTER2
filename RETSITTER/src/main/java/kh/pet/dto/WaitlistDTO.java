<<<<<<< HEAD:RETSITTER/src/main/java/kh/pet/dto/WaitlistDTO.java
package kh.pet.dto;

public class WaitlistDTO {
	private int seq;
	private String board_seq;
	private String petsitter_id;
	private String mem_id;
	private String pet_name;
	private String rsv_point;
	private String rsv_start_day;
	private String rsv_end_day;
	private String psb_time;
	
	public WaitlistDTO() {}

	public WaitlistDTO(int seq, String board_seq, String petsitter_id, String mem_id, String pet_name, String rsv_point,
			String rsv_start_day, String rsv_end_day, String psb_time) {
		super();
		this.seq = seq;
		this.board_seq = board_seq;
		this.petsitter_id = petsitter_id;
		this.mem_id = mem_id;
		this.pet_name = pet_name;
		this.rsv_point = rsv_point;
		this.rsv_start_day = rsv_start_day;
		this.rsv_end_day = rsv_end_day;
		this.psb_time = psb_time;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}

	public String getPetsitter_id() {
		return petsitter_id;
	}

	public void setPetsitter_id(String petsitter_id) {
		this.petsitter_id = petsitter_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getPet_name() {
		return pet_name;
	}

	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}

	public String getRsv_point() {
		return rsv_point;
	}

	public void setRsv_point(String rsv_point) {
		this.rsv_point = rsv_point;
	}

	public String getRsv_start_day() {
		return rsv_start_day;
	}

	public void setRsv_start_day(String rsv_start_day) {
		this.rsv_start_day = rsv_start_day;
	}

	public String getRsv_end_day() {
		return rsv_end_day;
	}

	public void setRsv_end_day(String rsv_end_day) {
		this.rsv_end_day = rsv_end_day;
	}

	public String getPsb_time() {
		return psb_time;
	}

	public void setPsb_time(String psb_time) {
		this.psb_time = psb_time;
	}
	
	
	
}	
=======
package kh.pet.dto;

import java.sql.Date;

public class WaitlistDTO {
	private int wait_seq;
	private String board_seq;
	private String petsitter_id;
	private String mem_id;
	private String rsv_pet_name;
	private int rsv_point;
	private Date rsv_start_day;
	private Date rsv_end_day;
	private String rsv_time;
	
	public WaitlistDTO() {}

	public WaitlistDTO(int wait_seq, String board_seq, String petsitter_id, String mem_id, String rsv_pet_name,
			int rsv_point, Date rsv_start_day, Date rsv_end_day, String rsv_time) {
		super();
		this.wait_seq = wait_seq;
		this.board_seq = board_seq;
		this.petsitter_id = petsitter_id;
		this.mem_id = mem_id;
		this.rsv_pet_name = rsv_pet_name;
		this.rsv_point = rsv_point;
		this.rsv_start_day = rsv_start_day;
		this.rsv_end_day = rsv_end_day;
		this.rsv_time = rsv_time;
	}

	public int getWait_seq() {
		return wait_seq;
	}

	public void setWait_seq(int wait_seq) {
		this.wait_seq = wait_seq;
	}

	public String getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}

	public String getPetsitter_id() {
		return petsitter_id;
	}

	public void setPetsitter_id(String petsitter_id) {
		this.petsitter_id = petsitter_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getRsv_pet_name() {
		return rsv_pet_name;
	}

	public void setRsv_pet_name(String rsv_pet_name) {
		this.rsv_pet_name = rsv_pet_name;
	}

	public int getRsv_point() {
		return rsv_point;
	}

	public void setRsv_point(int rsv_point) {
		this.rsv_point = rsv_point;
	}

	public Date getRsv_start_day() {
		return rsv_start_day;
	}

	public void setRsv_start_day(Date rsv_start_day) {
		this.rsv_start_day = rsv_start_day;
	}

	public Date getRsv_end_day() {
		return rsv_end_day;
	}

	public void setRsv_end_day(Date rsv_end_day) {
		this.rsv_end_day = rsv_end_day;
	}

	public String getRsv_time() {
		return rsv_time;
	}

	public void setRsv_time(String rsv_time) {
		this.rsv_time = rsv_time;
	}

	
}	
>>>>>>> b2951192f15074ad7e1f045f7cf5b29481d3ebff:src/main/java/kh/pet/dto/WaitlistDTO.java
