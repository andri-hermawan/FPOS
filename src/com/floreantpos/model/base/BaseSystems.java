package com.floreantpos.model.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the RESTAURANT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYSTEM"
 */

public abstract class BaseSystems  implements Comparable, Serializable {

	public static String REF = "System";
	public static String PROP_DEVICEIP = "deviceip";
	public static String PROP_GATEWAY = "gateway";
	public static String PROP_SERVERIP = "serverip";
	public static String PROP_STORAGE = "storage";
	public static String PROP_MERCHANTNAME = "merchantname";
	public static String PROP_MERCHANTTYPE = "merchanttype";
	public static String PROP_ADDRESS = "addresss";
	public static String PROP_AREA = "area";
	public static String PROP_MERCHANTID = "merchantid";
	public static String PROP_DEVICEID = "deviceid";
	public static String PROP_NAMEUSER = "nameuser";
	public static String PROP_EMAIL= "email";
	public static String PROP_CELLNUMBER = "cellnumber";
	public static String PROP_USERNAME = "username";
	public static String PROP_PASSWORD = "password";
	public static String PROP_BANNER = "banner";
	public static String PROP_WIFI = "wifi";
	public static String PROP_ETHERNET = "ethernet";
	public static String PROP_CELULLAR1 = "celullar1";
	public static String PROP_BRAND1 = "brand1";
	public static String PROP_CELULLAR2 = "celullar2";
	public static String PROP_BRAND2 = "brand2";
	public static String PROP_BLUETOOTH = "bluetooth";
	public static String PROP_ID = "id";

    public String getDeviceip() {
        return deviceip;
    }

    public void setDeviceip(String deviceip) {
        this.deviceip = deviceip;
    }
    public String getServerip() {
        return serverip;
    }

    public void setServerip(String serverip) {
        this.serverip = serverip;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public String getMerchanttype() {
        return merchanttype;
    }

    public void setMerchanttype(String merchanttype) {
        this.merchanttype = merchanttype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCellnumber() {
        return cellnumber == null ? Integer.valueOf(0) : cellnumber;
    }

    public void setCellnumber(java.lang.Integer cellnumber) {
        this.cellnumber = cellnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getEthernet() {
        return ethernet;
    }

    public void setEthernet(String ethernet) {
        this.ethernet = ethernet;
    }

    public String getCelullar1() {
        return celullar1;
    }

    public void setCelullar1(String celullar1) {
        this.celullar1 = celullar1;
    }

    public String getCelullar2() {
        return celullar2;
    }

    public void setCelullar2(String celullar2) {
        this.celullar2 = celullar2;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getBrand1() {
        return brand1;
    }

    public void setBrand1(String brand1) {
        this.brand1 = brand1;
    }

    public String getBrand2() {
        return brand2;
    }

    public void setBrand2(String brand2) {
        this.brand2 = brand2;
    }
    
    
    
    
    

	// constructors
	public BaseSystems () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSystems (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String deviceip;
	private java.lang.String gateway;
	private java.lang.String serverip;
	private java.lang.String storage;
	private java.lang.String merchantname;
	private java.lang.String merchanttype;
	private java.lang.String address;
	private java.lang.String area;
	private java.lang.String merchantid;
	private java.lang.String deviceid;
	private java.lang.String nameuser;
	private java.lang.String email;
	private java.lang.Integer cellnumber;
	private java.lang.String username;
	private java.lang.String password;
	private java.lang.String banner;
	private java.lang.String wifi;
	private java.lang.String ethernet;
	private java.lang.String celullar1;
	private java.lang.String brand1;
	private java.lang.String celullar2;
	private java.lang.String brand2;
	private java.lang.String bluetooth;
        
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}





	/**
	 * Return the value associated with the column: ADDRESS_LINE1
	 */
	public java.lang.String getGateway () {
			return gateway;
	}

	/**
	 * Set the value related to the column: ADDRESS_LINE1
	 * @param addressLine1 the ADDRESS_LINE1 value
	 */
	public void setGateway (java.lang.String gateway) {
		this.gateway = gateway;
	}



	/**
	 * Return the value associated with the column: ADDRESS_LINE2
	 */
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.floreantpos.model.Systems)) return false;
		else {
			com.floreantpos.model.Systems system = (com.floreantpos.model.Systems) obj;
			if (null == this.getId() || null == system.getId()) return false;
			else return (this.getId().equals(system.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}