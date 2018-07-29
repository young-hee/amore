package kr.ap.emt.api.pos.vo;

public class Cushin {
	private String useDate;		//사용일자.
	private String storNm;		//사옹처(매장명)
	private String ptrSn;		//주문번호.
	private String purQty;		//구매수량.
	private String purAmt;		//구매금액.
	private String accumptPoint;//적립포인트.
	private String rdmptPoint;	//사용포인트.
	private String expireDt;
	
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
	public String getStorNm() {
		return storNm;
	}
	public void setStorNm(String storNm) {
		this.storNm = storNm;
	}
	public String getPtrSn() {
		return ptrSn;
	}
	public void setPtrSn(String ptrSn) {
		this.ptrSn = ptrSn;
	}
	public String getPurQty() {
		return purQty;
	}
	public void setPurQty(String purQty) {
		this.purQty = purQty;
	}
	public String getPurAmt() {
		return purAmt;
	}
	public void setPurAmt(String purAmt) {
		this.purAmt = purAmt;
	}
	public String getAccumptPoint() {
		return accumptPoint;
	}
	public void setAccumptPoint(String accumptPoint) {
		this.accumptPoint = accumptPoint;
	}
	public String getRdmptPoint() {
		return rdmptPoint;
	}
	public void setRdmptPoint(String rdmptPoint) {
		this.rdmptPoint = rdmptPoint;
	}
	public String getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(String expireDt) {
		this.expireDt = expireDt;
	}
	
	
	
	
}
