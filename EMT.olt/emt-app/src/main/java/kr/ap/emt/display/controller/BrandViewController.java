/*
 * This software is the confidential and proprietary information of
 * UZEN Co.,Ltd., Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with UZEN.
 */
package kr.ap.emt.display.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ap.comm.config.interceptor.PageTitle;
import kr.ap.comm.support.common.AbstractController;
import kr.ap.comm.support.constants.APConstant;
import kr.ap.emt.display.vo.RequestBrand;
import kr.ap.emt.display.vo.SupportersRequesterInfo;

/**
 * @author Ria@g1project.net
 * @since {version}
 */
@Controller
@RequestMapping("/display")
public class BrandViewController extends AbstractController {

	/**
	 * 브랜드 메인 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @return
	 */
	@RequestMapping("/brand")
    @PageTitle(title = "브랜드")
    public String brand(Model model, String displayMenuId) {
		
		String pageName=""; 
        //Mobile
        if (isMobileDevice()) {
        	pageName = "M02_brand_m"; 
        }

        //PC
        if (isPcDevice()) {
        	pageName = "M02_brand_p"; 
        }
        
        //PageInfo pageInfo = displayApi.getMenuPageInfo(APConstant.EH_DISPLAY_MENU_SET_ID, displayMenuId);

        model.addAttribute("displayMenuId", displayMenuId);
        
		return "display/"  + pageName;//+ pageInfo.getMenuPageFileId();

    }
	
	
	/**
	 * 매장안내 메인 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping({"/l_store_location", "/store_location"})
    @PageTitle(title = "매장찾기")
    public String store_location(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		
		displayMenuId = "store_location";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/brand-store-find";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/brand-store-find-01";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_store_location";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	/**
	 * 매장칭찬하기 탭 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/store_review")
    @PageTitle(title = "매장칭찬")
    public String store_review(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/brand-store-find-03";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/brand-store-find-04";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_store_location";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	/**
	 * 매장칭찬 작성하기 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @param storeEvalSn
	 * @return
	 */
	@RequestMapping("/store_review_write")
    @PageTitle(title = "매장칭찬")
    public String store_review_write(Model model, String displayMenuId, String categoryType, String groupId, Long storeEvalSn) {
        //Mobile
        if (isMobileDevice()) {
        }

        //PC
        if (isPcDevice()) {
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_store_location";
        
        if(storeEvalSn != null && storeEvalSn > 0) {
        	/*StoreEvalEx storeEvalEx = storeApi.getStoreEval( storeEvalSn, getMemberSn());
        	model.addAttribute("storeEvalEx", storeEvalEx);*/
        }
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
        //model.addAttribute("storeEvalSn", storeEvalSn);
        
        return "display/brand-store-find-07";
    }
	
	/**
	 * 매장개설문의 탭 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/store_opening")
    @PageTitle(title = "매장개설문의")
    public String store_opening(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/brand-store-find-02";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/brand-store-find-03";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_store_location";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	/**
	 * 스윗샷캠페인 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/sweet_shot")
    @PageTitle(title = "스윗샷캠페인")
    public String sweet_shot(Model model, String displayMenuId, String categoryType, String groupId) {
		//PageInfo pageInfo = displayApi.getMenuPageInfo(APConstant.EH_DISPLAY_MENU_SET_ID, displayMenuId);
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "sweet_shot";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return "display/" ; //+ pageInfo.getMenuPageFileId();
    }
	
	/**
	 * 브랜드 소개 메인 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping({"/brand_etudehouse", "/l_brand_etudehouse"})
    @PageTitle(title = "에뛰드 하우스")
    public String brand_etudehouse(Model model, String displayMenuId, String categoryType, String groupId) {
        
		displayMenuId = "brand_etudehouse";
		
		//Mobile
        if (isMobileDevice()) {
        }

        //PC
        if (isPcDevice()) {
        }
        
        //PageInfo pageInfo = displayApi.getMenuPageInfo(APConstant.EH_DISPLAY_MENU_SET_ID, displayMenuId);
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_etude_story";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_brand_etudehouse";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return "display/" ;//+ pageInfo.getMenuPageFileId();
    }
	
	/**
	 * 브랜드 히스토리 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/brand_history")
    @PageTitle(title = "브랜드 히스토리")
    public String brand_history(Model model, String displayMenuId, String categoryType, String groupId) {
        
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/brand-history";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/brand-history";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_etude_story";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_brand_etudehouse";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	/**
	 * 에뛰드 모델 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/brand_etudemodel")
    @PageTitle(title = "에뛰드 모델")
    public String brand_etudemodel(Model model, String displayMenuId, String categoryType, String groupId) {
        
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/etude-model";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/etude-model";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_etude_story";
        
        if(groupId == null || "".equals(groupId)) groupId = "brand_etudemodel";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	/**
	 * 뷰티즌 메인 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping({"/beautizen", "/l_beautizen"})
    @PageTitle(title = "뷰티즌이란?")
    public String beautizen(Model model, String displayMenuId, String categoryType, String groupId) {
		
		displayMenuId = "beautizen";
		//Mobile
		String pageFileName = "";
        if (isMobileDevice()) {
        	pageFileName = "display/M02_beautizen_m";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/M02_beautizen_p";
        }

		//PageInfo pageInfo = displayApi.getMenuPageInfo(APConstant.EH_DISPLAY_MENU_SET_ID, displayMenuId);
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_beautizen";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
        
        return pageFileName ;// + pageInfo.getMenuPageFileId();
    }
	
	/**
	 * 뷰티즌 모집 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/beautizen_recruit")
    @PageTitle(title = "뷰티즌 모집")
    public String beautizen_recruit(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/beautizen.2";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/beautizen-02";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_beautizen";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
        
        return pageFileName;
    }
	
	/**
	 * 뷰티즌 신청 작성 페이지
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/beautizen_regist")
    @PageTitle(title = "뷰티즌 신청작성")
    public String beautizen_regist(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		
		//if(isLoggedIn()) { // 로그인 임시 주석 201807009
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/beautizen.2.1";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/beautizen-03";
        }
         
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_beautizen";

        //지역 local 
        
        //SupportersRequesterInfo sriInfo = bbsApi.getSupportersRequester(getMemberSn()); //
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
        //model.addAttribute("supportersInfo" , sriInfo); 
        
        
	
	//	}

		return pageFileName;
		
    }
	
	/**
	 * 뷰티즌 자기소개서 작성 페이지
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/beautizen_introduce")
    @PageTitle(title = "뷰티즌 자기소개작성")
    public String beautizen_introduce(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		
        if (isMobileDevice()) {
        	pageFileName = "display/beautizen.2.2";
        }

    //    약관
        /*SupportersRequesterInfo suppoters = bbsApi.getSupportersRequester(getMemberSn());
        
        List<Terms> beautizenTerm1=  termsApi.getTerms("ET009");
        List<Terms> beautizenTerm2 = termsApi.getTerms("ET010");
        List<Terms> beautizenTerm3 = termsApi.getTerms("ET011");*/
        
         
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_beautizen";
        
       /* model.addAttribute("beautizenTerm1", beautizenTerm1.get(0));
        model.addAttribute("beautizenTerm2", beautizenTerm2.get(0));
        model.addAttribute("beautizenTerm3", beautizenTerm3.get(0));
        */
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
      //  model.addAttribute("suppoters", suppoters);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	/**
	 * 뷰티즌 수정페이지 
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/beautizen_update")
    @PageTitle(title = "뷰티즌 수정")
    public String beautizen_update(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
				
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/beautizen.2.1";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/beautizen-03";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_beautizen";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
        
        return pageFileName;
    }
	
	/**
	 * 뷰티즌 프로필 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/beautizen_list")
    @PageTitle(title = "뷰티즌 프로필")
    public String beautizen_list(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/beautizen.3";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/beautizen-profile-18";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_beautizen";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
        
        return pageFileName;
    }
	
	/**
	 * 컬러팩토리 메인 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping({"/l_color_factory_info", "/color_factory_info"})
    @PageTitle(title = "컬러 팩토리")
    public String color_factory_info(Model model, String displayMenuId, String categoryType, String groupId) {
		
		displayMenuId = "color_factory_info";
		//PageInfo pageInfo = displayApi.getMenuPageInfo(APConstant.EH_DISPLAY_MENU_SET_ID, displayMenuId);
		
        //Mobile
        if (isMobileDevice()) {
        }

        //PC
        if (isPcDevice()) {
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_color_factory_info";
        
       // StoreResult storeResult = storeApi.getStores(null, "N", APConstant.EH_FO_EVENT_CD_COLOR_FACTORY, null, null, null, null, null, null, 0, 0, null);
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
        //model.addAttribute("storeResult", storeResult);

        return "display/" ;//+ pageInfo.getMenuPageFileId();
    }
	
	/**
	 * 컬러팩토리 예약 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/color_factory_reserve")
    @PageTitle(title = "컬러 팩토리 예약")
    public String color_factory_reserve(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/color-factory-02";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/color-factory-02";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_color_factory_info";
        
        //StoreResult storeResult = storeApi.getStores(null, "N", APConstant.EH_FO_EVENT_CD_COLOR_FACTORY, null, null, null, null, null,null, 0, 0, null);
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
        //model.addAttribute("storeResult", storeResult);

        return pageFileName;
    }
	
	/**
	 * 컬러펙토리 예약하기 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/color_factory_reserve_regist")
    @PageTitle(title = "컬러 팩토리 예약")
    public String color_factory_reserve_regist(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		if(displayMenuId== null) displayMenuId= "color_factory_reserve"; 
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/color-factory-03";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/color-factory-03";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_color_factory_info";
        
        getStoreEventScheduleInfo(model);
        
        /*List<Terms> terms1 = termsApi.getTerms("ET007"); // ET007: 개인정보 수집 이용 동의 (필수)
        List<Terms> terms2 = termsApi.getTerms("ET008"); // ET008: 개인정보 취급 위탁에 대한 동의 (필수)
*/
		/*model.addAttribute("terms1", terms1.get(0));
		model.addAttribute("terms2", terms2.get(0));*/
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	/**
	 * 컬러팩토리 예약 확인
	 * 
	 * @param model
	 * @param requestBrand
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/color_factory_reserve_complete")
    @PageTitle(title = "컬러 팩토리 예약")
    public String color_factory_reserve_complete(Model model, RequestBrand requestBrand, String displayMenuId, String categoryType, String groupId) {
		
		if(displayMenuId== null) displayMenuId= "color_factory_reserve"; 
		//Mobile
        if (isMobileDevice()) {
        }

        //PC
        if (isPcDevice()) {
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_color_factory_info";

        //예약한 시간 하루 전까지 취소 가능할 경우 add에 1로 세팅 (cancelAvailDt.add(Calendar.DATE, 1))
		Calendar cancelAvailDt = Calendar.getInstance();
		cancelAvailDt.add(Calendar.DATE, 1);

     //   StoreEventRequesterEx storeEventRequesterEx = storeApi.getStoreEventRequester(requestBrand.getReserveNo(), cancelAvailDt.getTime());
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
      //  model.addAttribute("storeEventRequesterEx", storeEventRequesterEx);

        return "display/color-factory-04";
    }
	
	/**
	 *  컬러팩토리 예약 확인 목록
	 * 
	 * @param model
	 * @param requestBrand
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/color_factory_reserve_confirm")
    @PageTitle(title = "컬러 팩토리 예약")
    public String color_factory_reserve_confirm(Model model, RequestBrand requestBrand, String displayMenuId, String categoryType, String groupId) {
		
		
		//Mobile
        if (isMobileDevice()) {
        }

        //PC
        if (isPcDevice()) {
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_color_factory_info";
        
       // StoreEventRequestersResult storeEventRequestersResult = new StoreEventRequestersResult();

      //예약한 시간 하루 전까지 취소 가능할 경우 add에 1로 세팅 (cancelAvailDt.add(Calendar.DATE, 1))
		Calendar cancelAvailDt = Calendar.getInstance();
		cancelAvailDt.add(Calendar.DATE, 1);
        
        //비회원일 경우
		if( requestBrand.getReserveNo() != null) {
		//StoreEventRequesterEx storeEventRequesterEx = storeApi.getStoreEventRequester(requestBrand.getReserveNo(), cancelAvailDt.getTime());
			
			Integer totalCount = 0;
			Integer offset = 0;
			Integer limit = 0;
			
			
			
		}else { //회원일 경우
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			
		}
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return "display/color-factory-05";
    }
	
	/**
	 * 컬러팩토리 서비스매장보기 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/color_factory_store")
    @PageTitle(title = "서비스 매장보기")
    public String color_factory_store(Model model, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/color-factory-04";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/color-factory-06";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_color_factory_info";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	/**
	 * 컬러팩토리 예약하기 매장 일정정보 조회
	 * 
	 * @param model
	 */
	public void getStoreEventScheduleInfo(Model model) {
		DateFormat dateFormat = new SimpleDateFormat("Z");
		
	}
	/**
	 * 청춘강연 메인 페이지 이동_메이크업유어드림
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 *//*
	@RequestMapping({"/l_makeup_your_dream", "/makeup_your_dream"})
    @PageTitle(title = "MAKEUP YOUR DREAM")
    public String makeup_your_dream(Model model, String displayMenuId, String categoryType, String groupId) {
		
		displayMenuId = "makeup_your_dream";
		PageInfo pageInfo = displayApi.getMenuPageInfo(APConstant.EH_DISPLAY_MENU_SET_ID, displayMenuId);
		
        //Mobile
        if (isMobileDevice()) {
        }

        //PC
        if (isPcDevice()) {
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_makeup_your_dream";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return "display/" + pageInfo.getMenuPageFileId();
//        return "display/makeup-dream-01";
    }
	
	*//**
	 * 청춘강연 페이지 이동_청춘강연
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 *//*
	@RequestMapping("/makeup_your_dream_lecture")
    @PageTitle(title = "청춘강연")
    public String makeup_your_dream_lecture(Model model, String displayMenuId, String categoryType, String groupId) {
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/makeup-dream-02";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/makeup-your-dream-02";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_makeup_your_dream";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	*//**
	 * 청춘강연 페이지 이동_청춘강연
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 *//*
	@RequestMapping("/makeup_your_dream_apply")
    @PageTitle(title = "청춘강연")
	
    public String makeup_your_dream_apply(Model model, String displayMenuId, String categoryType, String groupId) {
		String pageFileName = "";
				
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/makeup-dream-03";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/makeup-your-dream-03";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_makeup_your_dream";
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
		
	*//**
	 * 청춘강연 신청하기 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 *//*
	@RequestMapping("/makeup_your_dream_reserve_regist")
    @PageTitle(title = "청춘강연 신청")
    public String makeup_your_dream_reserve_regist(Model model, String displayMenuId, String categoryType, String groupId) {
		
		displayMenuId = "makeup_your_dream";
		
		String pageFileName = "";
		
		//Mobile
        if (isMobileDevice()) {
        	pageFileName = "display/makeup-dream-04";
        }

        //PC
        if (isPcDevice()) {
        	pageFileName = "display/makeup-your-dream-04";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_makeup_your_dream";
        
        List<Terms> terms1 = termsApi.getTerms("ET012"); //  [필수] 개인정보 수집 및 이용동의
        List<Terms> terms2 = termsApi.getTerms("ET013"); //  [필수] 사진 및 동영상 촬영 및 활용 동의

		model.addAttribute("terms1", terms1.get(0));
		model.addAttribute("terms2", terms2.get(0));
        
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);

        return pageFileName;
    }
	
	*//**
	 * 청춘강연 신청하기 페이지 이동
	 * 
	 * @param model
	 * @param displayMenuId
	 * @param categoryType
	 * @param groupId
	 * @return
	 *//*
	@RequestMapping("/makeup_your_dream_reserve")
    @PageTitle(title = "청춘강연 신청결과")
	
    public String makeup_your_dream_reserve(Model model, RequestBrand requestBrand, String displayMenuId, String categoryType, String groupId) {
		
		String pageFileName =""; 
	
        //PC
        if (isPcDevice()) {
        	pageFileName = "display/makeup-your-dream-05";
        }
        
        if(categoryType == null || "".equals(categoryType)) categoryType = "l_community";
        
        if(groupId == null || "".equals(groupId)) groupId = "l_makeup_your_dream";
        
       
        model.addAttribute("displayMenuId", displayMenuId);
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("groupId", groupId);
        model.addAttribute("result", requestBrand);   
        
        return pageFileName;
    }*/
	
}
