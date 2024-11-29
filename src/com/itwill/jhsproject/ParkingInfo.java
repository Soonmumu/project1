package com.itwill.jhsproject;

public class ParkingInfo {

	public static final class Entity {
		public static final String TBL_INFO = "PARKING_INFO";
		public static final String COL_C_NUM = "C_NUM";
		public static final String COL_C_ENTRA = "C_ENTRA";
		public static final String COL_C_NREDU = "C_NREDU";
		public static final String COL_C_EXIT = "C_EXIT";
		public static final String COL_C_PTIME = "C_PTIME";
		public static final String COL_C_PFEE = "C_PFEE";
		
		public static final String TBL_REDU = "PARKING_REDUCTION";
		public static final String COL_R_NREDU= "R_NREDU";
		public static final String COL_R_NAME= "R_NAME";
		public static final String COL_R_RATIO = "R_RATIO";
	}
	

	private String cNum;
	private Long cEntra;
	private Integer cNredu;
	private Long cExit;
	private Long pTime;
	private Double cPfee;
	
	private Integer rNredu;
	private String rName;
	private Double rRatio;
	
	public ParkingInfo() {}

	public ParkingInfo(String cNum, Long cEntra, Integer cNredu,
			Long cExit, Long pTime, Double cPfee, Integer rNredu, String rName, Double rRatio) {
		this.cNum = cNum;
		this.cEntra = cEntra;
		this.cNredu = cNredu;
		this.cExit = cExit;
		this.pTime = pTime;
		this.cPfee = cPfee;
		this.rNredu = rNredu;
		this.rName = rName;
		this.rRatio = rRatio;
	}

	public String getcNum() {
		return cNum;
	}

	public void setcNum(String cNum) {
		this.cNum = cNum;
	}

	public Long getcEntra() {
		return cEntra;
	}

	public void setcEntra(Long cEntra) {
		this.cEntra = cEntra;
	}

	public Integer getcNredu() {
		return cNredu;
	}

	public void setcNredu(Integer cNredu) {
		this.cNredu = cNredu;
	}

	public Long getcExit() {
		return cExit;
	}

	public void setcExit(Long cExit) {
		this.cExit = cExit;
	}

	public Long getpTime() {
		return pTime;
	}

	public void setpTime(Long pTime) {
		this.pTime = pTime;
	}

	public Double getcPfee() {
		return cPfee;
	}

	public void setcPfee(Double cPfee) {
		this.cPfee = cPfee;
	}
	
	public Integer getrNredu() {
		return rNredu;
	}

	public void setrNredu(Integer rNredu) {
		this.rNredu = rNredu;
	}
	
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public Double getrRatio() {
		return rRatio;
	}
	public void setrRatio(Double rRatio) {
		this.rRatio = rRatio;
	}
	
	@Override
	public String toString() {
		return "ParkingInfo [cNum=" + cNum + ", cEntra=" + cEntra + ", cNredu=" + cNredu + ", cExit=" + cExit
				+ ", pTime=" + pTime + ", cPfee=" + cPfee + ", rNredu=" + rNredu + ", rName=" + rName + ", rRatio=" + rRatio + "]";
	}

	public static ParkingInfoBuilder builder() {
		return new ParkingInfoBuilder();
	}
	
	public static class ParkingInfoBuilder {
		private String cNum;
		private Long cEntra;
		private Integer cNredu;
		private Long cExit;
		private Long pTime;
		private Double cPfee;
		private Integer rNredu;
		private String rName;
		private Double rRatio;
		
		private ParkingInfoBuilder() {}
		
		public ParkingInfoBuilder cNum(String cNum) {
			this.cNum = cNum;
			return this;
		}
		public ParkingInfoBuilder cEntra(Long cEntra) {
			this.cEntra = cEntra;
			return this;
		}
		public ParkingInfoBuilder cNredu(Integer cNredu) {
			this.cNredu = cNredu;
			return this;
		}
		public ParkingInfoBuilder cExit(Long cExit) {
			this.cExit = cExit;
			return this;
		}
		public ParkingInfoBuilder pTime(Long pTime) {
			this.pTime = pTime;
			return this;
		}
		public ParkingInfoBuilder cPfee(Double cPfee) {
			this.cPfee = cPfee;
			return this;
		}
		public ParkingInfoBuilder rNredu(Integer rNredu) {
			this.rNredu = rNredu;
			return this;
		}
		public ParkingInfoBuilder rName(String rName) {
			this.rName = rName;
			return this;
		}
		public ParkingInfoBuilder rRatio(Double rRatio) {
			this.rRatio = rRatio;
			return this;
		}
		
		public ParkingInfo build() {
			return new ParkingInfo(cNum, cEntra, cNredu, cExit, pTime, cPfee, rNredu, rName, rRatio);
		}
	}
}

