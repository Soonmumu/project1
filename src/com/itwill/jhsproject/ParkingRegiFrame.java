package com.itwill.jhsproject;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ParkingRegiFrame extends JFrame {
	
	public interface RegiNotify {
		void notifyRegiSuccess();
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField parkingAreaField;
	private JTextField carNumField;
	private JComboBox<String> reductionCombo;
	private JButton btnCancel;
	private JButton btnRegister;
	private JLabel lblReduction;
	private JLabel lblCarNum;
	private JLabel lblParkingArea;

	private ParkingDao dao;
	private Component parentComponent;
	private String parkingArea;
	private RegiNotify appMain;
	private String[] reduName = {"해당없음", "경차 - 50%", "다자녀 2인 - 30%", "다자녀 3인 - 50%", 
			"저공해 1,2종 - 50% ", "저공해 3종 - 30%", "긴급/군 차량 - 면제"};
	
	public static void showParkingRegiFrame(Component parentComponent, String parkingArea, RegiNotify appMain) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingRegiFrame frame = new ParkingRegiFrame(parentComponent, parkingArea, appMain);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private ParkingRegiFrame(Component parentComponent, String parkingArea, 
			RegiNotify appMain) {
		setTitle("차량등록");
		dao = ParkingDao.INSTANCE;
		this.parentComponent = parentComponent;
		this.parkingArea = parkingArea;
		this.appMain = appMain;
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 279);
		setLocationRelativeTo(parentComponent);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblParkingArea = new JLabel("주 차 구 역");
		lblParkingArea.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblParkingArea.setBounds(23, 21, 139, 30);
		contentPane.add(lblParkingArea);
		
		lblCarNum = new JLabel("차 량 번 호");
		lblCarNum.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblCarNum.setBounds(23, 73, 139, 30);
		contentPane.add(lblCarNum);
		
		lblReduction = new JLabel("감 면 종 류");
		lblReduction.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblReduction.setBounds(23, 125, 139, 30);
		contentPane.add(lblReduction);
		
		parkingAreaField = new JTextField(parkingArea);
		parkingAreaField.setEditable(false);
		parkingAreaField.setFont(new Font("D2Coding", Font.PLAIN, 20));
		parkingAreaField.setBounds(174, 19, 248, 41);
		contentPane.add(parkingAreaField);
		parkingAreaField.setColumns(10);
		
		carNumField = new JTextField();
		carNumField.setFont(new Font("D2Coding", Font.PLAIN, 20));
		carNumField.setColumns(10);
		carNumField.setBounds(174, 73, 248, 41);
		contentPane.add(carNumField);
		
		btnRegister = new JButton("확 인");
		btnRegister.addActionListener(e -> registerCar());
		btnRegister.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnRegister.setBounds(89, 192, 115, 41);
		contentPane.add(btnRegister);
		
		btnCancel = new JButton("취 소");
		btnCancel.addActionListener(e -> dispose());
		btnCancel.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnCancel.setBounds(227, 192, 115, 41);
		contentPane.add(btnCancel);
		
		reductionCombo = new JComboBox<>();
		reductionCombo.setModel(new DefaultComboBoxModel<>(reduName));
		reductionCombo.setFont(new Font("D2Coding", Font.PLAIN, 20));
		reductionCombo.setBounds(174, 125, 248, 41);
		contentPane.add(reductionCombo);
	}
	
	private void registerCar() {
		String carNumber = carNumField.getText();
		Long carEntrance = System.currentTimeMillis();
		Integer numberReduction = reductionCombo.getSelectedIndex() + 1;
		
		if(carNumber.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "차량번호를 입력해주세요.", 
					"경고", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ParkingInfo pInfo = ParkingInfo.builder().cNum(carNumber).cEntra(carEntrance).cNredu(numberReduction).
				cExit(null).pTime(null).cPfee(null).build();
		ParkingArea pArea = ParkingArea.builder().pCheck(1).cNum(carNumber).pArea(parkingArea).build();
		
		int resultInfo = dao.regiInfo(pInfo);
		
		if(resultInfo == 2 ) {
			JOptionPane.showMessageDialog(contentPane, 
					"이미 등록된 차량입니다.", "실패", JOptionPane.ERROR_MESSAGE);
		} else if(resultInfo == 1) {
			dao.updateArea(pArea);
			
			JOptionPane.showMessageDialog(contentPane, 
					"입차 등록 완료!\n입차시간 : " + dao.SimpleDateFormat(carEntrance), "완료", JOptionPane.INFORMATION_MESSAGE);
			appMain.notifyRegiSuccess();
			dispose();
		} else {
			JOptionPane.showMessageDialog(contentPane, 
					"입차 등록 실패!", "실패", JOptionPane.ERROR_MESSAGE);
		}
	}
}
