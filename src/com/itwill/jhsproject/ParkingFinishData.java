package com.itwill.jhsproject;

public class ParkingFinishData {

	public static final class Entity {
		public static final String TBL_FINDATA = "PARKING_FINISH_DATA";
		public static final String COL_F_NUM = "F_NUM";
		public static final String COL_F_PTIME = "F_PTIME";
		public static final String COL_F_PFEE = "F_PFEE";
		public static final String COL_F_NREDU = "F_NREDU";
	}
	
	private String fNum;
	private Long fPTime;
	private Double fPFee;
	private Integer fNredu;
	
	public ParkingFinishData() {}

	public ParkingFinishData(String fNum, Long fPTime, Double fPFee, Integer fNredu) {
		this.fNum = fNum;
		this.fPTime = fPTime;
		this.fPFee = fPFee;
		this.fNredu = fNredu;
	}

	public String getfNum() {
		return fNum;
	}

	public void setfNum(String fNum) {
		this.fNum = fNum;
	}

	public Long getfPTime() {
		return fPTime;
	}

	public void setfPTime(Long fPTime) {
		this.fPTime = fPTime;
	}

	public Double getfPFee() {
		return fPFee;
	}

	public void setfPFee(Double fPFee) {
		this.fPFee = fPFee;
	}

	public Integer getfNredu() {
		return fNredu;
	}

	public void setfNredu(Integer fNredu) {
		this.fNredu = fNredu;
	}

	@Override
	public String toString() {
		return "ParkingFinishData [fNum=" + fNum + ", fPTime=" + fPTime + ", fPFee=" + fPFee + ", fNredu=" + fNredu
				+ "]";
	}
	
	public static ParkingFinishDataBuilder builder() {
		return new ParkingFinishDataBuilder();
	}
	
	public static class ParkingFinishDataBuilder {
		private String fNum;
		private Long fPTime;
		private Double fPFee;
		private Integer fNredu;
		
		private ParkingFinishDataBuilder() {}
		
		public ParkingFinishDataBuilder fNum(String fNum) {
			this.fNum = fNum;
			return this;
		}
		public ParkingFinishDataBuilder fPTime(Long fPTime) {
			this.fPTime = fPTime;
			return this;
		}
		public ParkingFinishDataBuilder fPFee(Double fPFee) {
			this.fPFee = fPFee;
			return this;
		}
		public ParkingFinishDataBuilder fNredu(Integer fNredu) {
			this.fNredu = fNredu;
			return this;
		}
		public ParkingFinishData build() {
			return new ParkingFinishData(fNum, fPTime, fPFee, fNredu);
		}
	}
	
}
