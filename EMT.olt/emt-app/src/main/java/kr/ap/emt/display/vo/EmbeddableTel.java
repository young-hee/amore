package kr.ap.emt.display.vo;


import java.io.Serializable;

public class EmbeddableTel implements Serializable {

    /**
	 * ������ȣ
	 */
    private String countryNo;

    /**
	 * ��ȭ��ȣ
	 */
    private String phoneNo;

    /**
	 * ������ȣ
	 */
    public String getCountryNo() {
        return countryNo;
    }

    /**
	 * ������ȣ
	 */
    public void setCountryNo(String countryNo) {
        this.countryNo = countryNo;
    }

    /**
	 * ��ȭ��ȣ
	 */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
	 * ��ȭ��ȣ
	 */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
