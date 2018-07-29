package kr.ap.emt.main.vo;

import java.util.List;

public class DisplayMenu {

	private String displayMenuId;

	private List<DisplayMenu> submenus = null; 
	
	public String getDisplayMenuId() {
		return displayMenuId;
	}

	public void setDisplayMenuId(String displayMenuId) {
		this.displayMenuId = displayMenuId;
	}

	public List<DisplayMenu> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(List<DisplayMenu> submenus) {
		this.submenus = submenus;
	}

	
	
}
