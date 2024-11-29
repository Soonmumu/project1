package com.itwill.jhsproject;

public class ParkingArea {
	
	public static final class Entity {
		public static final String TBL_AREA = "PARKING_AREA";
		public static final String COL_P_AREA = "P_AREA";
		public static final String COL_P_CHECK = "P_CHECK";
	}
	
	private String pArea;
	private Integer pCheck;
	private String cNum;
	
	public ParkingArea() {};
	public ParkingArea(String pArea, Integer pCheck, String cNum) {
		this.pArea = pArea;
		this.pCheck = pCheck;
		this.cNum = cNum;
	}


	public String getpArea() {
		return pArea;
	}
	public void setpArea(String pArea) {
		this.pArea = pArea;
	}
	public Integer getpCheck() {
		return pCheck;
	}
	public void setpCheck(Integer pCheck) {
		this.pCheck = pCheck;
	}
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	
	@Override
	public String toString() {
		return "ParkingArea [pArea=" + pArea + ", pCheck=" + pCheck + ", cNum=" + cNum + "]";
	}
	
	public static ParkingAreaBuilder builder() {
		return new ParkingAreaBuilder();
	}
	
	public static class ParkingAreaBuilder {
		private String pArea;
		private Integer pCheck;
		private String cNum;
		
		private ParkingAreaBuilder() {}
		
		public ParkingAreaBuilder pArea(String pArea) {
			this.pArea = pArea;
			return this;
		}
		public ParkingAreaBuilder pCheck(Integer pCheck) {
			this.pCheck = pCheck;
			return this;
		}
		public ParkingAreaBuilder cNum(String cNum) {
			this.cNum = cNum;
			return this;
		}
		
		public ParkingArea build() {
			return new ParkingArea(pArea, pCheck, cNum);
		}
	}
}
