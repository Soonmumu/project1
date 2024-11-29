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
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ParkingAdminRegiFrame extends JFrame {
	
	public interface AdminRegiNotify {
		void notifyAdminRegiSuccess();
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField carNumField;
	private JComboBox<String> reductionCombo;
	private JButton btnCancel;
	private JButton btnRegister;
	private JLabel lblReduction;
	private JLabel lblCarNum;
	private JLabel lblParkingArea;

	private ParkingDao dao;
	private Component parentComponent;
	private String[] pAreas = {"1f01", "1f02", "1f03", "1f04", "1f05", "1f06", "1f07", "1f08", "1f09", "1f10", "1f11", "1f12",
			"2f01", "2f02", "2f03", "2f04", "2f05", "2f06", "2f07", "2f08", "2f09", "2f10", "2f11", "2f12",
			"3f01", "3f02", "3f03", "3f04", "3f05", "3f06", "3f07", "3f08", "3f09", "3f10", "3f11", "3f12"};
	private String[] reduName = {"해당없음", "경차 - 50%", "다자녀 2인 - 30%", "다자녀 3인 - 50%", 
			"저공해 1,2종 - 50% ", "저공해 3종 - 30%", "긴급/군 차량 - 면제"};
	private JTextField timeField;
	private JSlider timslider;
	private JComboBox<String> parkingAreaCombo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblSelectHour;

	private AdminRegiNotify appAdmin;

	public static void showParkingAdminRegiCar(Component parentComponent, AdminRegiNotify appAdmin) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingAdminRegiFrame frame = new ParkingAdminRegiFrame(parentComponent, appAdmin);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ParkingAdminRegiFrame(Component parentComponent, AdminRegiNotify appAdmin) {
		setTitle("차량임의등록");
		dao = ParkingDao.INSTANCE;
		this.appAdmin = appAdmin;
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 462, 374);
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
		lblReduction.setBounds(23, 128, 139, 30);
		contentPane.add(lblReduction);
		
		carNumField = new JTextField();
		carNumField.setFont(new Font("D2Coding", Font.PLAIN, 20));
		carNumField.setColumns(10);
		carNumField.setBounds(174, 73, 248, 41);
		contentPane.add(carNumField);
		
		btnRegister = new JButton("확 인");
		btnRegister.addActionListener(e -> adminRegiCar());
		btnRegister.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnRegister.setBounds(90, 283, 115, 41);
		contentPane.add(btnRegister);
		
		btnCancel = new JButton("취 소");
		btnCancel.addActionListener(e -> dispose());
		btnCancel.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnCancel.setBounds(228, 283, 115, 41);
		contentPane.add(btnCancel);
		
		reductionCombo = new JComboBox<>();
		reductionCombo.setModel(new DefaultComboBoxModel<>(reduName));
		reductionCombo.setFont(new Font("D2Coding", Font.PLAIN, 20));
		reductionCombo.setBounds(174, 125, 248, 41);
		contentPane.add(reductionCombo);
		
		lblSelectHour = new JLabel("임의입차시간");
		lblSelectHour.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblSelectHour.setBounds(13, 187, 149, 30);
		contentPane.add(lblSelectHour);
		
		timeField = new JTextField();
		timeField.setEditable(false);
		timeField.setFont(new Font("D2Coding", Font.PLAIN, 20));
		timeField.setColumns(10);
		timeField.setBounds(174, 176, 248, 41);
		contentPane.add(timeField);
		
		timslider = new JSlider();
		timslider.addChangeListener(e -> settimefield());
		timslider.setPaintTicks(true);
		timslider.setMajorTickSpacing(6);
		timslider.setMinimum(1);
		timslider.setMaximum(72);
		timslider.setBounds(174, 227, 248, 41);
		contentPane.add(timslider);
		
		parkingAreaCombo = new JComboBox<>();
		parkingAreaCombo.setModel(new DefaultComboBoxModel<>(pAreas));
		parkingAreaCombo.setFont(new Font("D2Coding", Font.PLAIN, 20));
		parkingAreaCombo.setBounds(174, 21, 248, 41);
		contentPane.add(parkingAreaCombo);
		
		lblNewLabel = new JLabel("(10분 단위 최대 12시간");
		lblNewLabel.setBounds(13, 216, 131, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("이전으로 입차등록)");
		lblNewLabel_1.setBounds(64, 230, 110, 15);
		contentPane.add(lblNewLabel_1);
	}
	
	private void settimefield () {
		Integer hour = timslider.getValue() / 6;
		Integer minute = timslider.getValue() % 6 * 10;
		if(minute == 0) timeField.setText(hour.toString() + "시간"); 
		else timeField.setText(hour.toString() + "시간" + minute.toString() + "분");
	}
	
	private void adminRegiCar() {
		String pArea = parkingAreaCombo.getSelectedItem().toString();
		String cNum = carNumField.getText();
		Integer cNredu = reductionCombo.getSelectedIndex() + 1;
		Integer eTime = timslider.getValue();
		Long cEntra = System.currentTimeMillis() - eTime.longValue()*600000;
		
		ParkingArea area = dao.readArea(pArea, 2);
		if(area.getpCheck() == 1) {
			JOptionPane.showMessageDialog(parentComponent, "주차중인 구역입니다.");
		}
		else {
			if(carNumField.getText().equals("")) {
				JOptionPane.showMessageDialog(contentPane, "차량번호를 입력해주세요.", 
						"경고", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			ParkingInfo pInfo = ParkingInfo.builder().cNum(cNum).cEntra(cEntra).cNredu(cNredu)
					.cExit(null).pTime(null).cPfee(null).build();
			ParkingArea Area = ParkingArea.builder().pArea(pArea).pCheck(1).cNum(cNum).build();
			int resultInfo = dao.regiInfo(pInfo);
			
			
			if(resultInfo == 2 ) {
				JOptionPane.showMessageDialog(contentPane, 
						"이미 등록된 차량입니다.", "실패", JOptionPane.ERROR_MESSAGE);
			} else if(resultInfo == 1) {
				dao.updateArea(Area);
				
				JOptionPane.showMessageDialog(contentPane, 
						"입차 등록 완료!", "완료", JOptionPane.INFORMATION_MESSAGE);
				appAdmin.notifyAdminRegiSuccess();
				dispose();
			} else {
				JOptionPane.showMessageDialog(contentPane, 
						"입차 등록 실패!", "실패", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
}
