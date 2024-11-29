package com.itwill.jhsproject;

import static com.itwill.jhsproject.OracleJdbc.PASSWORD;
import static com.itwill.jhsproject.OracleJdbc.URL;
import static com.itwill.jhsproject.OracleJdbc.USER;
import static com.itwill.jhsproject.ParkingArea.Entity.COL_P_AREA;
import static com.itwill.jhsproject.ParkingArea.Entity.COL_P_CHECK;
import static com.itwill.jhsproject.ParkingArea.Entity.TBL_AREA;
import static com.itwill.jhsproject.ParkingFinishData.Entity.COL_F_NREDU;
import static com.itwill.jhsproject.ParkingFinishData.Entity.COL_F_NUM;
import static com.itwill.jhsproject.ParkingFinishData.Entity.COL_F_PFEE;
import static com.itwill.jhsproject.ParkingFinishData.Entity.COL_F_PTIME;
import static com.itwill.jhsproject.ParkingFinishData.Entity.TBL_FINDATA;
import static com.itwill.jhsproject.ParkingInfo.Entity.COL_C_ENTRA;
import static com.itwill.jhsproject.ParkingInfo.Entity.COL_C_EXIT;
import static com.itwill.jhsproject.ParkingInfo.Entity.COL_C_NREDU;
import static com.itwill.jhsproject.ParkingInfo.Entity.COL_C_NUM;
import static com.itwill.jhsproject.ParkingInfo.Entity.COL_C_PFEE;
import static com.itwill.jhsproject.ParkingInfo.Entity.COL_C_PTIME;
import static com.itwill.jhsproject.ParkingInfo.Entity.COL_R_NAME;
import static com.itwill.jhsproject.ParkingInfo.Entity.COL_R_NREDU;
import static com.itwill.jhsproject.ParkingInfo.Entity.COL_R_RATIO;
import static com.itwill.jhsproject.ParkingInfo.Entity.TBL_INFO;
import static com.itwill.jhsproject.ParkingInfo.Entity.TBL_REDU;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;

public enum ParkingDao {

	INSTANCE;
	
	ParkingDao() {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeResource(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void closeResource(Connection conn, PreparedStatement stmt) {
		closeResource(conn, stmt, null);
	}
	
	public LocalDateTime dateToLocalDateTime(Date date) {
		if(date == null) return null;
		LocalDateTime localDateTime = new Timestamp(date.getTime()).toLocalDateTime();
		return localDateTime;
	}
	
	private ParkingArea getParkingAreafromResultSet(ResultSet rs) throws SQLException {
		String pArea = rs.getString(COL_P_AREA);
		Integer pCheck = rs.getInt(COL_P_CHECK);
		String cNum = rs.getString(COL_C_NUM);
		
		return ParkingArea.builder().pArea(pArea).pCheck(pCheck).cNum(cNum).build();
	}
	
	private ParkingFinishData getParkingFinishDatafromResultSet(ResultSet rs) throws SQLException {
		String fNum = rs.getString(COL_F_NUM);
		Long fPtime = rs.getLong(COL_F_PTIME);
		Double fPfee = rs.getDouble(COL_F_PFEE);
		Integer fNredu = rs.getInt(COL_F_NREDU);
		
		return ParkingFinishData.builder().fNum(fNum).fPTime(fPtime).fPFee(fPfee).fNredu(fNredu).build();
	}
	
	private ParkingInfo getParkingInfofromResultSet(ResultSet rs) throws SQLException {
		String cNum = rs.getString(COL_C_NUM);
		Long cEntra = rs.getLong(COL_C_ENTRA);
		Integer cNredu = rs.getInt(COL_C_NREDU);
		Long cExit = rs.getLong(COL_C_EXIT);
		Long pTime = rs.getLong(COL_C_PTIME);
		Double pFee = rs.getDouble(COL_C_PFEE);
		Integer rNredu = rs.getInt(COL_R_NREDU);
		String rName = rs.getString(COL_R_NAME);
		Double rRatio = rs.getDouble(COL_R_RATIO);
		
		
		return ParkingInfo.builder().cNum(cNum).cEntra(cEntra).cNredu(cNredu).cExit(cExit).pTime(pTime).cPfee(pFee)
				.rNredu(rNredu).rName(rName).rRatio(rRatio).build();
	}
	
	private static final String SQL_CREATE_INFO = String.format(
			"insert into %s (%s, %s, %s) values (?, ?, ?)", 
			TBL_INFO, COL_C_NUM, COL_C_ENTRA, COL_C_NREDU);
	
	public int regiInfo(ParkingInfo pInfo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_CREATE_INFO);
			
			stmt.setString(1, pInfo.getcNum());
			stmt.setLong(2, pInfo.getcEntra());
			stmt.setInt(3, pInfo.getcNredu());
			
			result = stmt.executeUpdate();
			
			
		} catch (SQLIntegrityConstraintViolationException e){
			return result = 2;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt);
		}
		return result;
	}
	
	private static final String SQL_CREATE_AREA = String.format(
			"update %s set %s = ?, %s = ? where %s = ?", 
			TBL_AREA, COL_P_CHECK, COL_C_NUM, COL_P_AREA);
	 // 
	public int updateArea(ParkingArea pArea) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_CREATE_AREA);
			
			stmt.setInt(1, pArea.getpCheck());
			stmt.setString(2, pArea.getcNum());
			stmt.setString(3, pArea.getpArea());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt);
		}
		return result;
	}
	
	private static final String SQL_UPDATE_INFO_EXIT = String.format(
			"update  %s "
			+ "set     %s = ? , %s = ? , %s = ? "
			+ "where   upper(%s) = ?"
			,TBL_INFO, COL_C_EXIT, COL_C_PTIME, COL_C_PFEE, COL_C_NUM);
	
	public int updateInfo(ParkingInfo pInfo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_UPDATE_INFO_EXIT);
			stmt.setLong(1, pInfo.getcExit());
			stmt.setLong(2, pInfo.getpTime());
			stmt.setDouble(3, pInfo.getcPfee());
			stmt.setString(4, pInfo.getcNum().toUpperCase());
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt);
		}
		return result;
	}
	
	private static final String SQL_SELECT_AREA = String.format(
			"select * from %s", TBL_AREA);
	
	public List<ParkingArea> readArea() {
		List<ParkingArea> pAreas = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_AREA);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ParkingArea pArea = getParkingAreafromResultSet(rs);
				pAreas.add(pArea);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt, rs);
		}
		return pAreas;
	}
	
	private static final String SQL_SELECT_AREA_BY_C_NUM = String.format(
			"select * from %s where upper(%s) = ?", TBL_AREA, COL_C_NUM); // -> checking = 1
	
	private static final String SQL_SELECT_AREA_BY_P_AREA = String.format(
			"select * from %s where upper(%s) = ?", TBL_AREA, COL_P_AREA); // -> checking = 2
	
	public ParkingArea readArea(String content, int checking) {
		ParkingArea area = new ParkingArea();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			switch (checking) {
			case 1:
				stmt = conn.prepareStatement(SQL_SELECT_AREA_BY_C_NUM);
				break;
			case 2:
				stmt = conn.prepareStatement(SQL_SELECT_AREA_BY_P_AREA);
				break;
			}
			stmt.setString(1, content.toUpperCase());
			rs = stmt.executeQuery();
			
			if(rs.next()) area = getParkingAreafromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt, rs);
		}
		return area;
	}
	
	private static final String SQL_SELECT_INFO = String.format(
			"select * from %s join %s on %s = %s", 
			TBL_INFO, TBL_REDU, COL_C_NREDU, COL_R_NREDU);
	
	public List<ParkingInfo> readInfo() {
		List<ParkingInfo> pInfos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_INFO);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ParkingInfo pInfo = getParkingInfofromResultSet(rs);
				pInfos.add(pInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt, rs);
		}
		return pInfos;
	}
	
	private static final String SQL_SELECT_INFO_BY_C_NUM = String.format(
			"select * from %s join %s on %s = %s where upper(%s) = ?", 
			TBL_INFO, TBL_REDU, COL_C_NREDU, COL_R_NREDU, COL_C_NUM);
	
	public ParkingInfo readInfo(String cNum) {
		ParkingInfo pInfo = new ParkingInfo();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_INFO_BY_C_NUM);
			
			stmt.setString(1, cNum.toUpperCase());
			rs = stmt.executeQuery();
			if(rs.next()) pInfo = getParkingInfofromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt, rs);
		}
		return pInfo;
	}
	
	public Double calculateFee(Long parkingTime, Double rRatio) {
		double fee = 0;
		int pTimeTrans10M = (int)(parkingTime / 10);
		if(pTimeTrans10M < 1) fee = 0;
		else if (pTimeTrans10M <= 3) fee = 1000;
		else {
			fee = pTimeTrans10M * 300;
			if(fee > 20000) fee = 20000;
		}
		return fee * rRatio;
	}
	
	private static final String SQL_SELECT_FINISH_DATA = String.format(
			"select * from %s", TBL_FINDATA);
	
	public List<ParkingFinishData> readFinishData() {
		List<ParkingFinishData> pFinDatas = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_FINISH_DATA);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ParkingFinishData pFinData = getParkingFinishDatafromResultSet(rs);
				pFinDatas.add(pFinData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt, rs);
		}
		return pFinDatas;
	}
	
	public String SimpleDateFormat(Long time) {
		SimpleDateFormat x = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return x.format(time);
	}
	
	private static final String SQL_INSERT_FININFO = String.format(
			"insert into %s (%s, %s, %s, %s) values (?, ?, ?, ?)",
			TBL_FINDATA, COL_F_NUM, COL_F_PTIME, COL_F_PFEE, COL_F_NREDU);
	public int insertFinInfo(ParkingInfo newInfo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_INSERT_FININFO);
			
			stmt.setString(1, newInfo.getcNum());
			stmt.setLong(2, newInfo.getpTime());
			stmt.setDouble(3, newInfo.getcPfee());
			stmt.setInt(4, newInfo.getcNredu());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String SQL_DELETE_INFO = String.format(
			"delete from %s where upper(%s) = ?", TBL_INFO, COL_C_NUM);
	
	public int deleteInfo(String cNum) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_DELETE_INFO);
			
			stmt.setString(1, cNum.toUpperCase());
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
