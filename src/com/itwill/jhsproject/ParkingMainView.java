package com.itwill.jhsproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.itwill.jhsproject.ParkingAdjuFrame.AdjuNotify;
import com.itwill.jhsproject.ParkingAdminFrame.AdminNotify;
import com.itwill.jhsproject.ParkingRegiFrame.RegiNotify;

public class ParkingMainView implements RegiNotify, AdjuNotify, AdminNotify {

	private JFrame frmHsParkingV;
	private JTextField cNumField;
	private JLayeredPane layeredPane;
	private JButton btn1f01;
	private JLabel lblNewLabel;
	private JButton btn1f02;
	private JButton btn1f04;
	private JButton btn1f03;
	private JLabel lblNewLabel_2;
	private JButton btnExitCar;
	private JButton btnAdmin;
	
	private ParkingDao dao;
	private JButton btn1f06;
	private JButton btn1f05;
	private JButton btn1f12;
	private JButton btn1f11;
	private JButton btn1f10;
	private JButton btn1f09;
	private JButton btn1f08;
	private JButton btn1f07;
	private JLabel lblParkingAreaCounting;
	private JButton btnSearchArea;
	private JButton btn2f01;
	private JButton btn2f02;
	private JButton btn2f03;
	private JButton btn2f04;
	private JButton btn2f05;
	private JButton btn2f06;
	private JButton btn2f12;
	private JButton btn2f11;
	private JButton btn2f10;
	private JButton btn2f09;
	private JButton btn2f08;
	private JButton btn2f07;
	private JButton btn3f01;
	private JButton btn3f02;
	private JButton btn3f03;
	private JButton btn3f04;
	private JButton btn3f05;
	private JButton btn3f06;
	private JButton btn3f12;
	private JButton btn3f11;
	private JButton btn3f10;
	private JButton btn3f09;
	private JButton btn3f08;
	private JButton btn3f07;
	private JButton btnB1;
	private JButton btnB2;
	private JButton btnB3;
	private JLabel lblFloor;
	private JLabel lblParkingFee;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingMainView window = new ParkingMainView();
					window.frmHsParkingV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ParkingMainView() {
		dao = ParkingDao.INSTANCE;
		initialize();
		initializeMain();
	}

	private void initialize() {
		frmHsParkingV = new JFrame();
		frmHsParkingV.setTitle("HS Parking v0.1");
		frmHsParkingV.setBounds(100, 100, 1103, 735);
		frmHsParkingV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHsParkingV.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(30, 30, 600, 600);
		frmHsParkingV.getContentPane().add(layeredPane);
		
		btn1f01 = new JButton("주차가능");
		btn1f01.addActionListener(e -> regiCar("1f01"));
		btn1f01.setBorderPainted(false);
		btn1f01.setBackground(SystemColor.activeCaption);
		btn1f01.setForeground(new Color(255, 255, 255));
		btn1f01.setFont(new Font("D2Coding", Font.BOLD, 20));
		layeredPane.setLayer(btn1f01, 2);
		btn1f01.setBounds(24, 25, 179, 87);
		layeredPane.add(btn1f01);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\java157\\workspaces\\jhsproject\\Parking_image.jpg"));
		layeredPane.setLayer(lblNewLabel, 1);
		lblNewLabel.setBounds(0, 0, 600, 600);
		layeredPane.add(lblNewLabel);
		
		btn1f02 = new JButton("주차가능");
		layeredPane.setLayer(btn1f02, 2);
		btn1f02.addActionListener(e -> regiCar("1f02"));
		btn1f02.setForeground(Color.WHITE);
		btn1f02.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f02.setBorderPainted(false);
		btn1f02.setBackground(SystemColor.activeCaption);
		btn1f02.setBounds(24, 119, 179, 87);
		layeredPane.add(btn1f02);
		
		btn1f04 = new JButton("주차가능");
		layeredPane.setLayer(btn1f04, 2);
		btn1f04.addActionListener(e -> regiCar("1f04"));
		btn1f04.setDisplayedMnemonicIndex(2);
		btn1f04.setForeground(Color.WHITE);
		btn1f04.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f04.setBorderPainted(false);
		btn1f04.setBackground(SystemColor.activeCaption);
		btn1f04.setBounds(24, 305, 179, 87);
		layeredPane.add(btn1f04);
		
		btn1f03 = new JButton("주차가능");
		layeredPane.setLayer(btn1f03, 2);
		btn1f03.addActionListener(e -> regiCar("1f03"));
		btn1f03.setDisplayedMnemonicIndex(2);
		btn1f03.setForeground(Color.WHITE);
		btn1f03.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f03.setBorderPainted(false);
		btn1f03.setBackground(SystemColor.activeCaption);
		btn1f03.setBounds(24, 212, 179, 87);
		layeredPane.add(btn1f03);
		
		btn1f05 = new JButton("주차가능");
		layeredPane.setLayer(btn1f05, 2);
		btn1f05.addActionListener(e -> regiCar("1f05"));
		btn1f05.setForeground(Color.WHITE);
		btn1f05.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f05.setDisplayedMnemonicIndex(2);
		btn1f05.setBorderPainted(false);
		btn1f05.setBackground(SystemColor.activeCaption);
		btn1f05.setBounds(24, 397, 179, 87);
		layeredPane.add(btn1f05);
		
		btn1f06 = new JButton("주차가능");
		layeredPane.setLayer(btn1f06, 2);
		btn1f06.addActionListener(e -> regiCar("1f06"));
		btn1f06.setForeground(Color.WHITE);
		btn1f06.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f06.setDisplayedMnemonicIndex(2);
		btn1f06.setBorderPainted(false);
		btn1f06.setBackground(SystemColor.activeCaption);
		btn1f06.setBounds(24, 490, 179, 87);
		layeredPane.add(btn1f06);
		
		btn1f07 = new JButton("주차가능");
		layeredPane.setLayer(btn1f07, 2);
		btn1f07.addActionListener(e -> regiCar("1f07"));
		btn1f07.setForeground(Color.WHITE);
		btn1f07.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f07.setBorderPainted(false);
		btn1f07.setBackground(SystemColor.activeCaption);
		btn1f07.setBounds(396, 25, 179, 87);
		layeredPane.add(btn1f07);
		
		btn1f08 = new JButton("주차가능");
		layeredPane.setLayer(btn1f08, 2);
		btn1f08.addActionListener(e -> regiCar("1f08"));
		btn1f08.setForeground(Color.WHITE);
		btn1f08.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f08.setBorderPainted(false);
		btn1f08.setBackground(SystemColor.activeCaption);
		btn1f08.setBounds(396, 119, 179, 87);
		layeredPane.add(btn1f08);
		
		btn1f10 = new JButton("주차가능");
		layeredPane.setLayer(btn1f10, 2);
		btn1f10.addActionListener(e -> regiCar("1f10"));
		btn1f10.setForeground(Color.WHITE);
		btn1f10.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f10.setDisplayedMnemonicIndex(2);
		btn1f10.setBorderPainted(false);
		btn1f10.setBackground(SystemColor.activeCaption);
		btn1f10.setBounds(396, 305, 179, 87);
		layeredPane.add(btn1f10);
		
		btn1f09 = new JButton("주차가능");
		layeredPane.setLayer(btn1f09, 2);
		btn1f09.addActionListener(e -> regiCar("1f09"));
		btn1f09.setForeground(Color.WHITE);
		btn1f09.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f09.setDisplayedMnemonicIndex(2);
		btn1f09.setBorderPainted(false);
		btn1f09.setBackground(SystemColor.activeCaption);
		btn1f09.setBounds(396, 212, 179, 87);
		layeredPane.add(btn1f09);
		
		btn1f11 = new JButton("주차가능");
		layeredPane.setLayer(btn1f11, 2);
		btn1f11.addActionListener(e -> regiCar("1f11"));
		btn1f11.setForeground(Color.WHITE);
		btn1f11.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f11.setDisplayedMnemonicIndex(2);
		btn1f11.setBorderPainted(false);
		btn1f11.setBackground(SystemColor.activeCaption);
		btn1f11.setBounds(396, 397, 179, 87);
		layeredPane.add(btn1f11);
		
		btn1f12 = new JButton("주차가능");
		layeredPane.setLayer(btn1f12, 2);
		btn1f12.addActionListener(e -> regiCar("1f12"));
		btn1f12.setForeground(Color.WHITE);
		btn1f12.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn1f12.setDisplayedMnemonicIndex(2);
		btn1f12.setBorderPainted(false);
		btn1f12.setBackground(SystemColor.activeCaption);
		btn1f12.setBounds(396, 490, 179, 87);
		layeredPane.add(btn1f12);
		
		btn2f01 = new JButton("주차가능");
		btn2f01.setVisible(false);
		layeredPane.setLayer(btn2f01, 2);
		btn2f01.addActionListener(e -> regiCar("2f01"));
		btn2f01.setForeground(Color.WHITE);
		btn2f01.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f01.setBorderPainted(false);
		btn2f01.setBackground(SystemColor.activeCaption);
		btn2f01.setBounds(24, 25, 179, 87);
		layeredPane.add(btn2f01);
		
		btn2f02 = new JButton("주차가능");
		btn2f02.setVisible(false);
		layeredPane.setLayer(btn2f02, 2);
		btn2f02.addActionListener(e -> regiCar("2f02"));
		btn2f02.setForeground(Color.WHITE);
		btn2f02.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f02.setBorderPainted(false);
		btn2f02.setBackground(SystemColor.activeCaption);
		btn2f02.setBounds(24, 119, 179, 87);
		layeredPane.add(btn2f02);
		
		btn2f03 = new JButton("주차가능");
		btn2f03.setVisible(false);
		layeredPane.setLayer(btn2f03, 2);
		btn2f03.addActionListener(e -> regiCar("2f03"));
		btn2f03.setForeground(Color.WHITE);
		btn2f03.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f03.setDisplayedMnemonicIndex(2);
		btn2f03.setBorderPainted(false);
		btn2f03.setBackground(SystemColor.activeCaption);
		btn2f03.setBounds(24, 212, 179, 87);
		layeredPane.add(btn2f03);
		
		btn2f04 = new JButton("주차가능");
		btn2f04.setVisible(false);
		layeredPane.setLayer(btn2f04, 2);
		btn2f04.addActionListener(e -> regiCar("2f04"));
		btn2f04.setForeground(Color.WHITE);
		btn2f04.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f04.setDisplayedMnemonicIndex(2);
		btn2f04.setBorderPainted(false);
		btn2f04.setBackground(SystemColor.activeCaption);
		btn2f04.setBounds(24, 305, 179, 87);
		layeredPane.add(btn2f04);
		
		btn2f05 = new JButton("주차가능");
		btn2f05.setVisible(false);
		layeredPane.setLayer(btn2f05, 2);
		btn2f05.addActionListener(e -> regiCar("2f05"));
		btn2f05.setForeground(Color.WHITE);
		btn2f05.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f05.setDisplayedMnemonicIndex(2);
		btn2f05.setBorderPainted(false);
		btn2f05.setBackground(SystemColor.activeCaption);
		btn2f05.setBounds(24, 397, 179, 87);
		layeredPane.add(btn2f05);
		
		btn2f06 = new JButton("주차가능");
		btn2f06.setVisible(false);
		layeredPane.setLayer(btn2f06, 2);
		btn2f06.addActionListener(e -> regiCar("2f06"));
		btn2f06.setForeground(Color.WHITE);
		btn2f06.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f06.setDisplayedMnemonicIndex(2);
		btn2f06.setBorderPainted(false);
		btn2f06.setBackground(SystemColor.activeCaption);
		btn2f06.setBounds(24, 490, 179, 87);
		layeredPane.add(btn2f06);
		
		btn2f12 = new JButton("주차가능");
		btn2f12.setVisible(false);
		layeredPane.setLayer(btn2f12, 2);
		btn2f12.addActionListener(e -> regiCar("2f12"));
		btn2f12.setForeground(Color.WHITE);
		btn2f12.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f12.setDisplayedMnemonicIndex(2);
		btn2f12.setBorderPainted(false);
		btn2f12.setBackground(SystemColor.activeCaption);
		btn2f12.setBounds(396, 490, 179, 87);
		layeredPane.add(btn2f12);
		
		btn2f11 = new JButton("주차가능");
		btn2f11.setVisible(false);
		layeredPane.setLayer(btn2f11, 2);
		btn2f11.addActionListener(e -> regiCar("2f11"));
		btn2f11.setForeground(Color.WHITE);
		btn2f11.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f11.setDisplayedMnemonicIndex(2);
		btn2f11.setBorderPainted(false);
		btn2f11.setBackground(SystemColor.activeCaption);
		btn2f11.setBounds(396, 397, 179, 87);
		layeredPane.add(btn2f11);
		
		btn2f10 = new JButton("주차가능");
		btn2f10.setVisible(false);
		layeredPane.setLayer(btn2f10, 2);
		btn2f10.addActionListener(e -> regiCar("2f10"));
		btn2f10.setForeground(Color.WHITE);
		btn2f10.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f10.setDisplayedMnemonicIndex(2);
		btn2f10.setBorderPainted(false);
		btn2f10.setBackground(SystemColor.activeCaption);
		btn2f10.setBounds(396, 305, 179, 87);
		layeredPane.add(btn2f10);
		
		btn2f09 = new JButton("주차가능");
		btn2f09.setVisible(false);
		layeredPane.setLayer(btn2f09, 2);
		btn2f09.addActionListener(e -> regiCar("2f09"));
		btn2f09.setForeground(Color.WHITE);
		btn2f09.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f09.setDisplayedMnemonicIndex(2);
		btn2f09.setBorderPainted(false);
		btn2f09.setBackground(SystemColor.activeCaption);
		btn2f09.setBounds(396, 212, 179, 87);
		layeredPane.add(btn2f09);
		
		btn2f08 = new JButton("주차가능");
		btn2f08.setVisible(false);
		layeredPane.setLayer(btn2f08, 2);
		btn2f08.addActionListener(e -> regiCar("2f08"));
		btn2f08.setForeground(Color.WHITE);
		btn2f08.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f08.setBorderPainted(false);
		btn2f08.setBackground(SystemColor.activeCaption);
		btn2f08.setBounds(396, 119, 179, 87);
		layeredPane.add(btn2f08);
		
		btn2f07 = new JButton("주차가능");
		btn2f07.setVisible(false);
		layeredPane.setLayer(btn2f07, 2);
		btn2f07.addActionListener(e -> regiCar("2f07"));
		btn2f07.setForeground(Color.WHITE);
		btn2f07.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn2f07.setBorderPainted(false);
		btn2f07.setBackground(SystemColor.activeCaption);
		btn2f07.setBounds(396, 25, 179, 87);
		layeredPane.add(btn2f07);
		
		btn3f01 = new JButton("주차가능");
		btn3f01.setVisible(false);
		layeredPane.setLayer(btn3f01, 2);
		btn3f01.addActionListener(e -> regiCar("3f01"));
		btn3f01.setForeground(Color.WHITE);
		btn3f01.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f01.setBorderPainted(false);
		btn3f01.setBackground(SystemColor.activeCaption);
		btn3f01.setBounds(24, 25, 179, 87);
		layeredPane.add(btn3f01);
		
		btn3f02 = new JButton("주차가능");
		btn3f02.setVisible(false);
		layeredPane.setLayer(btn3f02, 2);
		btn3f02.addActionListener(e -> regiCar("3f02"));
		btn3f02.setForeground(Color.WHITE);
		btn3f02.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f02.setBorderPainted(false);
		btn3f02.setBackground(SystemColor.activeCaption);
		btn3f02.setBounds(24, 119, 179, 87);
		layeredPane.add(btn3f02);
		
		btn3f03 = new JButton("주차가능");
		btn3f03.setVisible(false);
		layeredPane.setLayer(btn3f03, 2);
		btn3f03.addActionListener(e -> regiCar("3f03"));
		btn3f03.setForeground(Color.WHITE);
		btn3f03.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f03.setDisplayedMnemonicIndex(2);
		btn3f03.setBorderPainted(false);
		btn3f03.setBackground(SystemColor.activeCaption);
		btn3f03.setBounds(24, 212, 179, 87);
		layeredPane.add(btn3f03);
		
		btn3f04 = new JButton("주차가능");
		btn3f04.setVisible(false);
		layeredPane.setLayer(btn3f04, 2);
		btn3f04.addActionListener(e -> regiCar("3f04"));
		btn3f04.setForeground(Color.WHITE);
		btn3f04.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f04.setDisplayedMnemonicIndex(2);
		btn3f04.setBorderPainted(false);
		btn3f04.setBackground(SystemColor.activeCaption);
		btn3f04.setBounds(24, 305, 179, 87);
		layeredPane.add(btn3f04);
		
		btn3f05 = new JButton("주차가능");
		btn3f05.setVisible(false);
		layeredPane.setLayer(btn3f05, 2);
		btn3f05.addActionListener(e -> regiCar("3f05"));
		btn3f05.setForeground(Color.WHITE);
		btn3f05.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f05.setDisplayedMnemonicIndex(2);
		btn3f05.setBorderPainted(false);
		btn3f05.setBackground(SystemColor.activeCaption);
		btn3f05.setBounds(24, 397, 179, 87);
		layeredPane.add(btn3f05);
		
		btn3f06 = new JButton("주차가능");
		btn3f06.setVisible(false);
		layeredPane.setLayer(btn3f06, 2);
		btn3f06.addActionListener(e -> regiCar("3f06"));
		btn3f06.setForeground(Color.WHITE);
		btn3f06.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f06.setDisplayedMnemonicIndex(2);
		btn3f06.setBorderPainted(false);
		btn3f06.setBackground(SystemColor.activeCaption);
		btn3f06.setBounds(24, 490, 179, 87);
		layeredPane.add(btn3f06);
		
		btn3f12 = new JButton("주차가능");
		btn3f12.setVisible(false);
		layeredPane.setLayer(btn3f12, 2);
		btn3f12.addActionListener(e -> regiCar("3f12"));
		btn3f12.setForeground(Color.WHITE);
		btn3f12.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f12.setDisplayedMnemonicIndex(2);
		btn3f12.setBorderPainted(false);
		btn3f12.setBackground(SystemColor.activeCaption);
		btn3f12.setBounds(396, 490, 179, 87);
		layeredPane.add(btn3f12);
		
		btn3f11 = new JButton("주차가능");
		btn3f11.setVisible(false);
		layeredPane.setLayer(btn3f11, 2);
		btn3f11.addActionListener(e -> regiCar("3f11"));
		btn3f11.setForeground(Color.WHITE);
		btn3f11.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f11.setDisplayedMnemonicIndex(2);
		btn3f11.setBorderPainted(false);
		btn3f11.setBackground(SystemColor.activeCaption);
		btn3f11.setBounds(396, 397, 179, 87);
		layeredPane.add(btn3f11);
		
		btn3f10 = new JButton("주차가능");
		btn3f10.setVisible(false);
		layeredPane.setLayer(btn3f10, 2);
		btn3f10.addActionListener(e -> regiCar("3f10"));
		btn3f10.setForeground(Color.WHITE);
		btn3f10.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f10.setDisplayedMnemonicIndex(2);
		btn3f10.setBorderPainted(false);
		btn3f10.setBackground(SystemColor.activeCaption);
		btn3f10.setBounds(396, 305, 179, 87);
		layeredPane.add(btn3f10);
		
		btn3f09 = new JButton("주차가능");
		btn3f09.setVisible(false);
		layeredPane.setLayer(btn3f09, 2);
		btn3f09.addActionListener(e -> regiCar("3f09"));
		btn3f09.setForeground(Color.WHITE);
		btn3f09.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f09.setDisplayedMnemonicIndex(2);
		btn3f09.setBorderPainted(false);
		btn3f09.setBackground(SystemColor.activeCaption);
		btn3f09.setBounds(396, 212, 179, 87);
		layeredPane.add(btn3f09);
		
		btn3f08 = new JButton("주차가능");
		btn3f08.setVisible(false);
		layeredPane.setLayer(btn3f08, 2);
		btn3f08.addActionListener(e -> regiCar("3f08"));
		btn3f08.setForeground(Color.WHITE);
		btn3f08.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f08.setBorderPainted(false);
		btn3f08.setBackground(SystemColor.activeCaption);
		btn3f08.setBounds(396, 119, 179, 87);
		layeredPane.add(btn3f08);
		
		btn3f07 = new JButton("주차가능");
		btn3f07.setVisible(false);
		layeredPane.setLayer(btn3f07, 2);
		btn3f07.addActionListener(e -> regiCar("3f07"));
		btn3f07.setForeground(Color.WHITE);
		btn3f07.setFont(new Font("D2Coding", Font.BOLD, 20));
		btn3f07.setBorderPainted(false);
		btn3f07.setBackground(SystemColor.activeCaption);
		btn3f07.setBounds(396, 25, 179, 87);
		layeredPane.add(btn3f07);
		
		lblFloor = new JLabel("B1");
		lblFloor.setForeground(new Color(255, 255, 255));
		lblFloor.setFont(new Font("D2Coding", Font.BOLD, 50));
		lblFloor.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(lblFloor, 3);
		lblFloor.setBounds(241, 264, 114, 52);
		layeredPane.add(lblFloor);
		
		lblNewLabel_2 = new JLabel("남은 주차 자리수");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblNewLabel_2.setBounds(721, 376, 277, 38);
		frmHsParkingV.getContentPane().add(lblNewLabel_2);
		
		cNumField = new JTextField();
		cNumField.setFont(new Font("D2Coding", Font.PLAIN, 35));
		cNumField.setHorizontalAlignment(SwingConstants.CENTER);
		cNumField.setActionCommand("");
		cNumField.setName("");
		cNumField.setToolTipText("");
		cNumField.setBounds(721, 497, 277, 73);
		frmHsParkingV.getContentPane().add(cNumField);
		cNumField.setColumns(10);
		
		btnExitCar = new JButton("출차정산");
		btnExitCar.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnExitCar.addActionListener(e -> exitCar());
		btnExitCar.setBounds(865, 580, 133, 50);
		frmHsParkingV.getContentPane().add(btnExitCar);
		
		btnAdmin = new JButton("관리자");
		btnAdmin.addActionListener(e -> ParkingAdminFrame.showParkingAdminFrame(frmHsParkingV, ParkingMainView.this));
		btnAdmin.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnAdmin.setBounds(974, 658, 113, 38);
		frmHsParkingV.getContentPane().add(btnAdmin);
		
		lblParkingAreaCounting = new JLabel("#/#");
		lblParkingAreaCounting.setHorizontalAlignment(SwingConstants.CENTER);
		lblParkingAreaCounting.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblParkingAreaCounting.setBounds(721, 417, 277, 70);
		frmHsParkingV.getContentPane().add(lblParkingAreaCounting);
		
		btnSearchArea = new JButton("위치찾기");
		btnSearchArea.addActionListener(e -> searchArea());
		btnSearchArea.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnSearchArea.setBounds(720, 580, 133, 50);
		frmHsParkingV.getContentPane().add(btnSearchArea);
		
		btnB1 = new JButton("B1");
		btnB1.setBorder(UIManager.getBorder("Button.border"));
		btnB1.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnB1.addActionListener(e -> changeFloor(btnB1));
		btnB1.setBounds(220, 640, 69, 46);
		frmHsParkingV.getContentPane().add(btnB1);
		
		btnB2 = new JButton("B2");
		btnB2.setBorder(UIManager.getBorder("Button.border"));
		btnB2.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnB2.addActionListener(e -> changeFloor(btnB2));
		btnB2.setBounds(301, 640, 69, 46);
		frmHsParkingV.getContentPane().add(btnB2);
		
		btnB3 = new JButton("B3");
		btnB3.setBorder(UIManager.getBorder("Button.border"));
		btnB3.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnB3.addActionListener(e -> changeFloor(btnB3));
		btnB3.setBounds(382, 640, 69, 46);
		frmHsParkingV.getContentPane().add(btnB3);
		
		lblParkingFee = new JLabel("");
		lblParkingFee.setIcon(new ImageIcon("C:\\java157\\workspaces\\jhsproject\\Parking_fee_image.jpg"));
		lblParkingFee.setBounds(642, 30, 427, 343);
		frmHsParkingV.getContentPane().add(lblParkingFee);
	}
	
	private void regiCar(String btn) {
		ParkingRegiFrame.showParkingRegiFrame(frmHsParkingV , btn, ParkingMainView.this);
	}
	
	private void changeFloor(JButton btnFloor) {
		JButton[] btnFloors = {btnB1, btnB2, btnB3};
		JButton[][] buttons = {
				{btn1f01, btn1f02, btn1f03, btn1f04, btn1f05, btn1f06, btn1f07, btn1f08, btn1f09, btn1f10, btn1f11, btn1f12},
				{btn2f01, btn2f02, btn2f03, btn2f04, btn2f05, btn2f06, btn2f07, btn2f08, btn2f09, btn2f10, btn2f11, btn2f12},
				{btn3f01, btn3f02, btn3f03, btn3f04, btn3f05, btn3f06, btn3f07, btn3f08, btn3f09, btn3f10, btn3f11, btn3f12}};
		for(int i=0 ; i<btnFloors.length; i++) {
			if(btnFloors[i] == btnFloor) {
				for(int j=0 ; j<buttons[i].length; j++) {
					buttons[i][j].setVisible(true);
				}
			} else {
				for(int j=0 ; j<buttons[i].length; j++) {
					buttons[i][j].setVisible(false);
				}
			}
		}
		lblFloor.setText(btnFloor.getText());
		initializeMain();
	}
	
	private void searchArea() {
		String cNum = cNumField.getText();
		if(cNum.equals("")) {
			JOptionPane.showMessageDialog(frmHsParkingV, "차량번호를 입력해주세요.");
			return;
		}
		ParkingArea area = dao.readArea(cNum, 1);
		if(cNum.equals(area.getcNum())) JOptionPane.showMessageDialog(frmHsParkingV, String.format("[ %s ] 구역에 주차중입니다.", area.getpArea()));
		else JOptionPane.showMessageDialog(frmHsParkingV, "등록된 차량이 없습니다.");
	}
	
	private void exitCar() {
		ParkingInfo pInfo = new ParkingInfo();
		String content = cNumField.getText();
		
		pInfo = dao.readInfo(content);
		if(content.equals("")) JOptionPane.showMessageDialog(frmHsParkingV, "차량번호를 입력해주세요.");
		else if(pInfo.getcNum() == null) JOptionPane.showMessageDialog(frmHsParkingV, "등록되지 않은 차량입니다.");
		else {
			int check = JOptionPane.showConfirmDialog(frmHsParkingV, "정산하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
			if(check == JOptionPane.OK_OPTION) {
				dao.updateInfo(pInfo);
				
				ParkingAdjuFrame.showParkingAdjuFrame(frmHsParkingV, pInfo, ParkingMainView.this);
			}
		}
	}
	
	public void initializeMain() {
		List<ParkingArea> pAreas = dao.readArea();
		JButton[][] buttons = {
				{btn1f01, btn1f02, btn1f03, btn1f04, btn1f05, btn1f06, btn1f07, btn1f08, btn1f09, btn1f10, btn1f11, btn1f12},
				{btn2f01, btn2f02, btn2f03, btn2f04, btn2f05, btn2f06, btn2f07, btn2f08, btn2f09, btn2f10, btn2f11, btn2f12},
				{btn3f01, btn3f02, btn3f03, btn3f04, btn3f05, btn3f06, btn3f07, btn3f08, btn3f09, btn3f10, btn3f11, btn3f12}};
		
		int totParking = 0;
		int notParking = 0;
		for(int i=0 ; i < buttons.length ; i++) {
			for(int j=0 ; j < buttons[i].length ; j++) {
				ParkingArea a = pAreas.get(j+(i*buttons[i].length));
				if(a.getpCheck() == 1) {
					buttons[i][j].setText("주차중");
					buttons[i][j].setOpaque(false);
					buttons[i][j].setEnabled(false);
				} else {
					buttons[i][j].setText("주차가능");
					buttons[i][j].setOpaque(true);
					buttons[i][j].setEnabled(true);
					notParking++;
				}
				totParking++;
			}
			
		}
		lblParkingAreaCounting.setText(String.format("%s / %s", notParking, totParking));
		cNumField.setText("");
	}
	
	@Override
	public void notifyRegiSuccess() {
		initializeMain();
	}
	
	@Override
	public void notifyAdjuSuccess() {
		initializeMain();
	}
	@Override
	public void notifyAdminSuccess() {
		initializeMain();
	}
	
}
