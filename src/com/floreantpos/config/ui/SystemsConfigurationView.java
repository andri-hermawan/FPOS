package com.floreantpos.config.ui;

import javax.swing.JCheckBox;

import net.miginfocom.swing.MigLayout;

import com.floreantpos.main.Application;
import com.floreantpos.model.Restaurant;
import com.floreantpos.model.Systems;
import com.floreantpos.model.dao.RestaurantDAO;
import com.floreantpos.model.dao.SystemsDAO;
import com.floreantpos.swing.FixedLengthTextField;
import com.floreantpos.ui.dialog.POSMessageDialog;
import com.floreantpos.util.POSUtil;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SystemsConfigurationView extends ConfigurationView {
	private SystemsDAO dao;
	private Systems system;
	
	private JTextField tfDeviceip = new FixedLengthTextField(15);
	private JTextField tfGateway = new FixedLengthTextField(15);
	private JTextField tfServerip = new FixedLengthTextField(15);
	private JTextField tfStorage = new FixedLengthTextField(15);
	private JTextField tfBanner = new FixedLengthTextField(15);
	private JTextField tfMerchantname = new FixedLengthTextField(15);
        private JComboBox cbMerchanttype = new JComboBox();
	private JTextField tfAddress = new FixedLengthTextField(15);
	private JComboBox cbArea = new JComboBox();
	private JTextField tfMerchantid = new FixedLengthTextField(15);
	private JTextField tfDeviceid = new FixedLengthTextField(15);
	private JTextField tfNameuser = new FixedLengthTextField(15);
	private JTextField tfEmail = new FixedLengthTextField(15);
	private JTextField tfCellnumber = new FixedLengthTextField(15);
	private JTextField tfUsername = new FixedLengthTextField(15);
	private JTextField tfPassword = new FixedLengthTextField(15);
	
	
	public SystemsConfigurationView() {
		setLayout(new MigLayout("align 50% 50%"));
		cbMerchanttype = new JComboBox();
                cbMerchanttype.addItem("Restaurant");
                cbMerchanttype.addItem("Hotel");
                cbMerchanttype.addItem("Entertainment");
                cbArea = new JComboBox();
                cbArea.addItem("Radio Dalam");
                cbArea.addItem("Gandaria 8");
		addRow(com.floreantpos.POSConstants.DEVICE_IP, tfDeviceip, "w 150");
		addRow(com.floreantpos.POSConstants.GATEWAY, tfGateway, "w 150");
		addRow(com.floreantpos.POSConstants.SERVER_IP, tfServerip, "w 150");
		addRow(com.floreantpos.POSConstants.STORAGE, tfStorage, "w 150");
		add(new JLabel(com.floreantpos.POSConstants.BANNER + ":"), "grow");
                tfBanner = new JTextField(20); 
                add(tfBanner,"wrap");
                addRow(com.floreantpos.POSConstants.MERCHANT_NAME, tfMerchantname, "w 150");
		addRow(com.floreantpos.POSConstants.MERCHANT_TYPE, cbMerchanttype);
		addRow(com.floreantpos.POSConstants.ADDRESS, tfAddress, "w 150");
		addRow(com.floreantpos.POSConstants.AREA, cbArea);
		addRow(com.floreantpos.POSConstants.MERCHANT_ID, tfMerchantid, "w 150");
		addRow(com.floreantpos.POSConstants.DEVICE_ID, tfDeviceid, "w 150");
		addRow(com.floreantpos.POSConstants.NAME_USER, tfNameuser, "w 150");
		addRow(com.floreantpos.POSConstants.EMAIL, tfEmail, "w 150");
		addRow(com.floreantpos.POSConstants.CELL_NUMBER, tfCellnumber, "w 150");
		addRow(com.floreantpos.POSConstants.USERNAME, tfUsername, "w 150");
		add(new JLabel(com.floreantpos.POSConstants.PASSWORD + ":"), "grow");
                tfPassword = new JTextField(20); 
                add(tfPassword,"wrap");
        }

	@Override
	public boolean save() throws Exception {
		if(!isInitialized()) {
			return true;
		}
		
		String deviceip = null;
		String gateway = null;
		String serverip = null;
		String storage = null;
		String banner = null;
		String merchantname = null;
		String merchanttype = null;
		String address = null;
		String area = null;
		String merchantid = null;
		String deviceid = null;
		String nameuser = null;
		String email = null;
		String username = null;
		String password = null;
		
                int cellnumber = 74;
		
		deviceip = tfDeviceip.getText();
		gateway = tfGateway.getText();
		serverip = tfServerip.getText();
		storage = tfStorage.getText();
		banner = tfBanner.getText();
		merchanttype = tfMerchantname.getText();
                merchantname = cbMerchanttype.getSelectedItem().toString();
		address = tfAddress.getText();
		area = cbArea.getSelectedItem().toString();
		merchantid = tfMerchantid.getText();
		deviceid = tfDeviceid.getText();
		nameuser = tfNameuser.getText();
		email = tfEmail.getText();
		username = tfUsername.getText();
		password = tfPassword.getText();
		
		
                try {
			cellnumber = Integer.parseInt(tfCellnumber.getText());
		} catch (Exception e) {
			POSMessageDialog.showError(this, com.floreantpos.POSConstants.NUMBER_OF_TABLES_IS_NOT_VALID);
			return false;
		}
		
		

		system.setDeviceip(deviceip);
		system.setGateway(gateway);
		system.setServerip(serverip);
                system.setStorage(storage);
                system.setBanner(banner);
                system.setMerchantname(merchantname);
                system.setMerchanttype(merchanttype);
                system.setAddress(address);
                system.setArea(area);
                system.setMerchantid(merchantid);
                system.setDeviceid(deviceid);
                system.setNameuser(nameuser);
                system.setEmail(email);
                system.setCellnumber(cellnumber);
                system.setUsername(username);
                system.setPassword(password);
		
		
		dao.saveOrUpdate(system);
		
		Application.getInstance().refreshRestaurant();
		
		return true;
	}
	
	@Override
	public void initialize() throws Exception {
		dao = new SystemsDAO();
		system = dao.get(Integer.valueOf(1));

		tfDeviceip.setText(system.getDeviceip());
		tfGateway.setText(system.getGateway());
		tfServerip.setText(system.getServerip());
		tfStorage.setText(system.getStorage());
		tfBanner.setText(system.getBanner());
                tfMerchantname.setText(system.getMerchanttype());
		cbMerchanttype.setSelectedItem(system.getMerchantname());
		tfAddress.setText(system.getAddress());
		cbArea.setSelectedItem(system.getArea());
		tfMerchantid.setText(system.getMerchantid());
		tfDeviceid.setText(system.getDeviceid());
		tfNameuser.setText(system.getNameuser());
		tfEmail.setText(system.getEmail());
		tfCellnumber.setText(String.valueOf(system.getCellnumber()));
                tfUsername.setText(system.getUsername());
		tfPassword.setText(system.getPassword());
		
		
		setInitialized(true);
	}
	
	@Override
	public String getName() {
		return "System";
	}
}
