package kr.ap.comm.api.vo;

public class CicuedCuChIdVo {
	private String chcsNo;
	private String chcsCount;
	private String chCd;
	/**
	 * 성공시 2021 리턴.<br>
	 * 실패시 모름.
	 */
	private String rsltCd;
	private String reltMsg;
	
	public String getChcsNo() {
		return chcsNo;
	}
	public void setChcsNo(String chcsNo) {
		this.chcsNo = chcsNo;
	}
	public String getChcsCount() {
		return chcsCount;
	}
	public void setChcsCount(String chcsCount) {
		this.chcsCount = chcsCount;
	}
	public String getRsltCd() {
		return rsltCd;
	}
	public void setRsltCd(String rsltCd) {
		this.rsltCd = rsltCd;
	}
	public String getReltMsg() {
		return reltMsg;
	}
	public void setReltMsg(String reltMsg) {
		this.reltMsg = reltMsg;
	}
	public String getChCd() {
		return chCd;
	}
	public void setChCd(String chCd) {
		this.chCd = chCd;
	}
	
}
