package kr.ap.emt.display.vo;


import java.io.Serializable;

public class EmbeddableAddress implements Serializable {

    /**
	 * �����ڵ�
	 */
    private String countryCode;

    /**
	 * �����ȣ
	 */
    private String zipCode;

    /**
	 * �ּ�1
	 */
    private String address1;

    /**
	 * �ּ�2
	 */
    private String address2;

    /**
	 * �ּ�3
	 */
    private String address3;

    /**
	 * �ּ�4
	 */
    private String address4;

    /**
	 * �����ڵ�
	 */
    public String getCountryCode() {
        return countryCode;
    }

    /**
	 * �����ڵ�
	 */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
	 * �����ȣ
	 */
    public String getZipCode() {
        return zipCode;
    }

    /**
	 * �����ȣ
	 */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
	 * �ּ�1
	 */
    public String getAddress1() {
        return address1;
    }

    /**
	 * �ּ�1
	 */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
	 * �ּ�2
	 */
    public String getAddress2() {
        return address2;
    }

    /**
	 * �ּ�2
	 */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
	 * �ּ�3
	 */
    public String getAddress3() {
        return address3;
    }

    /**
	 * �ּ�3
	 */
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    /**
	 * �ּ�4
	 */
    public String getAddress4() {
        return address4;
    }

    /**
	 * �ּ�4
	 */
    public void setAddress4(String address4) {
        this.address4 = address4;
    }
}
