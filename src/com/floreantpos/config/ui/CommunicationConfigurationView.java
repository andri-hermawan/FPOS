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

public class CommunicationConfigurationView extends ConfigurationView {
	private SystemsDAO dao;
	private Systems system;
	
        private JComboBox cbWifi = new JComboBox();
        private JComboBox cbEthernet = new JComboBox();
	private JTextField tfDeviceip = new FixedLengthTextField(40);
	private JTextField tfGateway = new FixedLengthTextField(20);
	private JTextField tfServerip = new FixedLengthTextField(20);
	private JTextField tfStorage = new FixedLengthTextField(20);
   
        private JComboBox cbCelullar1 = new JComboBox();
        private JComboBox cbBrand1 = new JComboBox();
        private JComboBox cbCelullar2 = new JComboBox();
        private JComboBox cbBrand2 = new JComboBox();
	private JComboBox cbBluetooth = new JComboBox();
	
	
	
	public CommunicationConfigurationView() {
		setLayout(new MigLayout("align 50% 50%"));
                cbWifi = new JComboBox();
                cbWifi.addItem("Enable");
                cbWifi.addItem("Disable");
                cbEthernet = new JComboBox();
                cbEthernet.addItem("Enable");
                cbEthernet.addItem("Disable");
                cbCelullar1 = new JComboBox();
                cbCelullar1.addItem("GSM");
                cbCelullar1.addItem("CDMA");
                cbBrand1 = new JComboBox();
                cbBrand1.addItem("Huawei");
                cbBrand1.addItem("TRI");
                cbCelullar2 = new JComboBox();
                cbCelullar2.addItem("GSM");
                cbCelullar2.addItem("CDMA");
                cbBrand2 = new JComboBox();
                cbBrand2.addItem("Huawei");
                cbBrand2.addItem("TRI");
                cbBluetooth = new JComboBox();
                cbBluetooth.addItem("Enable");
                cbBluetooth.addItem("Disable");
		
                addRow(com.floreantpos.POSConstants.WIFI, cbWifi);
		addRow(com.floreantpos.POSConstants.ETHERNET, cbEthernet);
		addRow(com.floreantpos.POSConstants.DEVICE_IP, tfDeviceip, "w 150");
		addRow(com.floreantpos.POSConstants.GATEWAY, tfGateway, "w 150");
		addRow(com.floreantpos.POSConstants.SERVER_IP, tfServerip, "w 150");
		addRow(com.floreantpos.POSConstants.STORAGE, tfStorage, "w 150");
		addRow(com.floreantpos.POSConstants.CELULLAR1, cbCelullar1);
		add(new JLabel(com.floreantpos.POSConstants.BRAND1 + ":"), "grow");
                add(cbBrand1,"wrap");
		addRow(com.floreantpos.POSConstants.CELULLAR2, cbCelullar2);
		add(new JLabel(com.floreantpos.POSConstants.BRAND2 + ":"), "grow");
                add(cbBrand2,"wrap");
		addRow(com.floreantpos.POSConstants.BLOOTOTH, cbBluetooth);
		
        }

	@Override
	public boolean save() throws Exception {
		if(!isInitialized()) {
			return true;
		}
		
		String wifi = null;
		String ethernet = null;
		String deviceip = null;
		String gateway = null;
		String serverip = null;
		String storage = null;
		String celullar1 = null;
		String brand1 = null;
		String celullar2 = null;
		String brand2 = null;
		String bluetooth = null;		

		wifi = cbWifi.getSelectedItem().toString();
		ethernet = cbEthernet.getSelectedItem().toString();
		deviceip = tfDeviceip.getText();
		gateway = tfGateway.getText();
		serverip = tfServerip.getText();
		storage = tfStorage.getText();
		celullar1 = cbCelullar1.getSelectedItem().toString();
		brand1 = cbBrand1.getSelectedItem().toString();
		celullar2 = cbCelullar2.getSelectedItem().toString();
		brand2 = cbBrand2.getSelectedItem().toString();
		bluetooth = cbBluetooth.getSelectedItem().toString();
		
                system.setWifi(wifi);
                system.setEthernet(ethernet);
                system.setDeviceip(deviceip);
		system.setGateway(gateway);
		system.setServerip(serverip);
                system.setStorage(storage);
                system.setCelullar1(celullar1);
                system.setBrand1(brand1);
                system.setCelullar2(celullar2);
                system.setBrand2(brand2);
                system.setBluetooth(bluetooth);

		dao.saveOrUpdate(system);
		Application.getInstance().refreshRestaurant();
		return true;
	}
	
	@Override
	public void initialize() throws Exception {
		dao = new SystemsDAO();
		system = dao.get(Integer.valueOf(1));

		cbWifi.setSelectedItem(system.getWifi());
		cbEthernet.setSelectedItem(system.getEthernet());
		tfDeviceip.setText(system.getDeviceip());
		tfGateway.setText(system.getGateway());
		tfServerip.setText(system.getServerip());
		tfStorage.setText(system.getStorage());
		cbCelullar1.setSelectedItem(system.getCelullar1());
		cbBrand1.setSelectedItem(system.getBrand1());
		cbCelullar2.setSelectedItem(system.getCelullar2());
		cbBrand2.setSelectedItem(system.getBrand2());
		cbBluetooth.setSelectedItem(system.getBluetooth());
                
		
		setInitialized(true);
	}
	
	@Override
	public String getName() {
		return "Communication";
        }
        }