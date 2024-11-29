package com.itwill.jhsproject;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.jhsproject.ParkingAdminRegiFrame.AdminRegiNotify;

public class ParkingAdminFrame extends JFrame implements AdminRegiNotify {
	
	public interface AdminNotify {
		void notifyAdminSuccess();
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Component parentComponent;
	private JLabel lblTitle;
	private JTable nowParkingTable;
	private JTable finishPakingTable;
	private ParkingDao dao;
	private DefaultTableModel modelNowParking;
	private DefaultTableModel modelFinParking;
	
	private static final String[] COLUMN_NAME_NOW_PARKING = {"주차구역", "차량번호", "입차시간", "감면번호"};
	private static final String[] COLUMN_NAME_FIN_PARKING = {"차량번호", "주차시간", "주차요금", "감면번호"};
	private JButton btnAdminRegiCar;
	private JLabel lblFinParking;
	private JLabel lblnowparking;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JPanel panel;
	
	private AdminNotify appMain;
	private JLabel lblPfeeAvgTitle;
	private JLabel lblPfeeAvg;
	private JButton btnRefresh;
	private JLabel lblPTimeAvgTitle;
	private JLabel lblPTimeAvg;
	private JLabel lblParkingCheckTitle;
	private JLabel lblParkingCheck;
	private JButton btnExit;

	public static void showParkingAdminFrame(Component parentComponent, AdminNotify appMain) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingAdminFrame frame = new ParkingAdminFrame(parentComponent, appMain);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private ParkingAdminFrame(Component parentComponent, AdminNotify appMain) {
		setTitle("관리자 메뉴");
		dao = ParkingDao.INSTANCE;
		this.parentComponent = parentComponent;
		this.appMain = appMain;
		initialize();
		initializeAdmin();
	}

	private void initialize() {
		int x = parentComponent.getX() + parentComponent.getWidth();
		int y = parentComponent.getY();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 702, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTitle = new JLabel("< 관리자 메뉴 >");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 25));
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblnowparking = new JLabel("현재 주차 목록");
		lblnowparking.setFont(new Font("굴림", Font.BOLD, 20));
		lblnowparking.setBounds(12, 10, 138, 24);
		panel.add(lblnowparking);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("D2Coding", Font.PLAIN, 15));
		scrollPane.setBounds(12, 44, 466, 260);
		panel.add(scrollPane);
		
		nowParkingTable = new JTable();
		nowParkingTable.setRowHeight(25);
		nowParkingTable.setFont(new Font("D2Coding", Font.PLAIN, 17));
		scrollPane.setViewportView(nowParkingTable);
		
		lblFinParking = new JLabel("주차 정산 목록");
		lblFinParking.setFont(new Font("굴림", Font.BOLD, 20));
		lblFinParking.setBounds(12, 330, 138, 24);
		panel.add(lblFinParking);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 364, 466, 260);
		panel.add(scrollPane_1);
		
		finishPakingTable = new JTable();
		finishPakingTable.setRowHeight(25);
		finishPakingTable.setFont(new Font("D2Coding", Font.PLAIN, 17));
		scrollPane_1.setViewportView(finishPakingTable);
		
		btnAdminRegiCar = new JButton("임의차량등록");
		btnAdminRegiCar.addActionListener(e -> adminRegiCar());
		btnAdminRegiCar.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnAdminRegiCar.setBounds(491, 39, 173, 37);
		panel.add(btnAdminRegiCar);
		
		btnRefresh = new JButton("새로고침");
		btnRefresh.addActionListener(e -> initializeAdmin());
		btnRefresh.setFont(new Font("D2Coding", Font.BOLD, 15));
		btnRefresh.setBounds(381, 13, 97, 23);
		panel.add(btnRefresh);
		
		lblPfeeAvgTitle = new JLabel("[ 평균 주차요금 ]");
		lblPfeeAvgTitle.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblPfeeAvgTitle.setBounds(517, 203, 130, 18);
		panel.add(lblPfeeAvgTitle);
		
		lblPfeeAvg = new JLabel("");
		lblPfeeAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lblPfeeAvg.setFont(new Font("D2Coding", Font.PLAIN, 25));
		lblPfeeAvg.setBounds(490, 243, 174, 37);
		panel.add(lblPfeeAvg);
		
		lblPTimeAvgTitle = new JLabel("[ 평균 주차시간 ]");
		lblPTimeAvgTitle.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblPTimeAvgTitle.setBounds(517, 310, 130, 18);
		panel.add(lblPTimeAvgTitle);
		
		lblPTimeAvg = new JLabel("");
		lblPTimeAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lblPTimeAvg.setFont(new Font("D2Coding", Font.PLAIN, 25));
		lblPTimeAvg.setBounds(502, 350, 174, 37);
		panel.add(lblPTimeAvg);
		
		lblParkingCheckTitle = new JLabel("[ 현 주차대수 ]");
		lblParkingCheckTitle.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblParkingCheckTitle.setBounds(520, 96, 115, 18);
		panel.add(lblParkingCheckTitle);
		
		lblParkingCheck = new JLabel("");
		lblParkingCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblParkingCheck.setFont(new Font("D2Coding", Font.PLAIN, 25));
		lblParkingCheck.setBounds(490, 136, 174, 37);
		panel.add(lblParkingCheck);
		
		btnExit = new JButton("나가기");
		btnExit.addActionListener(e -> dispose());
		btnExit.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnExit.setBounds(520, 587, 114, 37);
		panel.add(btnExit);
	}
	
	private void adminRegiCar() {
		ParkingAdminRegiFrame.showParkingAdminRegiCar(contentPane, ParkingAdminFrame.this);
	}
	
	public void initializeAdmin() {
		List<ParkingInfo> listInfo = dao.readInfo();
		List<ParkingArea> listArea = dao.readArea();
		List<ParkingFinishData> listFinData = dao.readFinishData();
		resetTableModel(listInfo, listArea, listFinData);
		resetInfo(listFinData, listArea);
	}
	
	private void resetInfo(List<ParkingFinishData> listFinData, List<ParkingArea> listArea) {
		double avgPFee = 0;
		long avgPTime = 0;
		int cntParking = 0;
		for(ParkingFinishData Findata : listFinData) {
			avgPFee += Findata.getfPFee() / listFinData.size();
			avgPTime += Findata.getfPTime() / listFinData.size();
		}
		lblPfeeAvg.setText(String.format("%.0f 원", avgPFee));
		lblPTimeAvg.setText(String.format("%d시간 %d분 ", avgPTime/60, avgPTime%60));
		
		for(ParkingArea area : listArea) {
			cntParking += area.getpCheck();
		}
		lblParkingCheck.setText(String.format("%d / %d", cntParking, listArea.size()));
	}
	
	private void resetTableModel(List<ParkingInfo> listInfo, List<ParkingArea> listArea
			, List<ParkingFinishData> listFinData) {
		modelNowParking = new DefaultTableModel(null, COLUMN_NAME_NOW_PARKING);
		modelFinParking = new DefaultTableModel(null, COLUMN_NAME_FIN_PARKING);
		
		for(ParkingInfo info : listInfo) {
			for(int i=0; i<listArea.size(); i++) {
				ParkingArea area = listArea.get(i);
				if(info.getcNum().equals(area.getcNum())) {
					Object[] ndata = {area.getpArea(), info.getcNum(), 
							dao.SimpleDateFormat(info.getcEntra()), info.getcNredu()};
					modelNowParking.addRow(ndata);
					break;
				}
			}
		}
		for(ParkingFinishData FinData : listFinData) {
			Object[] fdata = {FinData.getfNum(), FinData.getfPTime(), FinData.getfPFee(), FinData.getfNredu()};
			modelFinParking.addRow(fdata);
		}
		nowParkingTable.setModel(modelNowParking);
		finishPakingTable.setModel(modelFinParking);
	}
	
	public void notifyAdminRegiSuccess() {
		appMain.notifyAdminSuccess();
		initializeAdmin();
	}
}
