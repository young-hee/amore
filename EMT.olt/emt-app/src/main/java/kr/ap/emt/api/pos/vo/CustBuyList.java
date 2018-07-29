package kr.ap.emt.api.pos.vo;

import java.util.List;

public class CustBuyList extends POSResultVo {
	private String buyCnt;
	private List<BuyProd> buyProdList;
	
	public String getBuyCnt() {
		return buyCnt;
	}
	public void setBuyCnt(String buyCnt) {
		this.buyCnt = buyCnt;
	}
	public List<BuyProd> getBuyProdList() {
		return buyProdList;
	}
	public void setBuyProdList(List<BuyProd> buyProdList) {
		this.buyProdList = buyProdList;
	}
	
	
}
