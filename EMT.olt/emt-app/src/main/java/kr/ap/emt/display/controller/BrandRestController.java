/*
 * This software is the confidential and proprietary information of
 * UZEN Co.,Ltd., Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with UZEN.
 */
package kr.ap.emt.display.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ap.comm.support.common.AbstractController;
import kr.ap.comm.util.UploadingFile;
import kr.ap.emt.display.vo.EmbeddableAddress;
import kr.ap.emt.display.vo.EmbeddableTel;
import kr.ap.emt.display.vo.RequestBrand;
import kr.ap.emt.display.vo.RequesterHist;
import kr.ap.emt.display.vo.SupportersRequester;

/**
 * @author Ria@g1project.net
 * @since {version}
 */
@Controller
@RequestMapping("/display")
public class BrandRestController extends AbstractController {

	
	/**
	 *  매장찾기 목록 조회
	 * @param requestBrand
	 * @return
	 */
	@RequestMapping("/stores")
    @ResponseBody
    public ResponseEntity<?> stores( RequestBrand requestBrand) {
      
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        try {
        	
        	Long memberSn = null;
        	
        	if(0L != getMemberSn()) {
        		memberSn = getMemberSn();
        	}
        	
        	/*StoreResult storeResult = storeApi.getStores(memberSn, requestBrand.getRegularStoreYn(), requestBrand.getFoStoreEventCode(), requestBrand.getKeyword(), requestBrand.getAddressDiv(), requestBrand.getAddressDetailDiv(), requestBrand.getLatitude(), requestBrand.getLogitude(), requestBrand.getRadius(), requestBrand.getOffset(), requestBrand.getLimit(), requestBrand.getSortBy());
            result.put("storeResult", storeResult);*/
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
        	result.put("errorData", e);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
        }

    }
	
	/**
	 * 매장칭찬 목록 조회
	 * @param requestBrand
	 * @return
	 */
	@RequestMapping("/storeEvals")
    @ResponseBody
    public ResponseEntity<?> storeEvals( RequestBrand requestBrand) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
        	/*StoreEvalsResult storeEvalsResult = storeApi.getStoreEvals(requestBrand.getSearchTypeCode(), requestBrand.getKeyword(), requestBrand.getTopStoreEvalYn(), getMemberSn(), requestBrand.getOffset(), requestBrand.getLimit());
            result.put("storeEvalsResult", storeEvalsResult);*/
	        
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
        }
    }
	
	/**
	 * 매장칭찬상세
	 * @param requestBrand
	 * @return
	 */
	@RequestMapping("/storeEval")
    @ResponseBody
    public ResponseEntity<?> storeEval( RequestBrand requestBrand) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
        	/*StoreEvalEx storeEvalEx = storeApi.getStoreEval( requestBrand.getStoreEvalSn(), getMemberSn());
            result.put("storeEvalEx", storeEvalEx);
	        */
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
		}

    }
	
	/**
	 * 매장칭찬등록
	 */
	@RequestMapping("/registStoreEval")
    @ResponseBody
    public ResponseEntity<?> registStoreEval( MultipartFile[] picture, HttpServletRequest req) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
		        	
        	List<File> files = new ArrayList<File>();

        	for(int i=0; picture != null && i<picture.length; i++) {
                String filePath = getRequest().getSession().getServletContext().getRealPath("upload");
                File file =  MultiPartToFile(picture[i], filePath);
                files.add(file);
            }
            
            File[] images = files.toArray(new File[files.size()]);
            
           /* storeEvalInfo.setMemberSn( getMemberSn());
            
            BooleanResult booleanResult = fileUploadApi.postStoreEval(storeEvalInfo, images);
            result.put("booleanResult", booleanResult);*/
	        
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}

    }
	
	/**
	 * 매장칭찬수정
	 */
	@RequestMapping("/updateStoreEval")
    @ResponseBody
    public ResponseEntity<?> updateStoreEval(Long storeEvalSn, MultipartFile[] picture, HttpServletRequest req) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
		        	
	        	List<File> files = new ArrayList<File>();

	        	for(int i=0; picture != null && i<picture.length; i++) {
                    String filePath = getRequest().getSession().getServletContext().getRealPath("upload");
                    File file =  MultiPartToFile(picture[i], filePath);
                    files.add(file);
                }
                
                File[] images = files.toArray(new File[files.size()]);
                
          /*      
                storeEvalPutInfo.setMemberSn( getMemberSn());
                
                BooleanResult booleanResult = fileUploadApi.updateStoreEval(storeEvalSn, storeEvalPutInfo, images);
                result.put("booleanResult", booleanResult);
	        */
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}

    }
	
	/**
	 * 매장칭찬삭제
	 * @param requestBrand
	 * @return
	 */
	@RequestMapping("/removeStoreEval")
    @ResponseBody
    public ResponseEntity<?> removeStoreEval( RequestBrand requestBrand) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			/*BooleanResult booleanResult = storeApi.removeStoreEval(requestBrand.getStoreEvalSn(), getMemberSn());
            result.put("booleanResult", booleanResult);
	        */
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
		}

    }
	
	/**
	 * 매장개설문의등록
	 * @param 
	 * @return
	 */
	@RequestMapping("/postStoreOpenInquiry")
    @ResponseBody
    public ResponseEntity<?> postStoreOpenInquiry( String preName, String prePhoneNo) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			
			/*EmbeddableName embeddableName = new EmbeddableName();
			embeddableName.setName1(preName);
			
			EmbeddableTel embeddableTel = new EmbeddableTel();
			embeddableTel.setPhoneNo(prePhoneNo);
			
			storeOpenInquiry.setName(embeddableName);
			storeOpenInquiry.setPhoneNo(embeddableTel);
			
            BooleanResult booleanResult = bbsApi.postStoreOpenInquiry(storeOpenInquiry);
            result.put("booleanResult", booleanResult);*/
	        
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}

    }
	
	/**
	 * 컬러팩토리 예약 확인 // 비회원경우 
	 * @param requestBrand
	 * @return
	 */
	@RequestMapping("/storeEventRequester")
    @ResponseBody
    public ResponseEntity<?> storeEventRequester( RequestBrand requestBrand) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			//예약한 시간 하루 전까지 취소 가능할 경우 add에 1로 세팅 (cancelAvailDt.add(Calendar.DATE, 1))
			Calendar cancelAvailDt = Calendar.getInstance();
			cancelAvailDt.add(Calendar.DATE, 1);
/*
			StoreEventRequesterEx storeEventRequesterEx = storeApi.getStoreEventRequester(requestBrand.getReserveNo(), cancelAvailDt.getTime());
            result.put("storeEventRequesterEx", storeEventRequesterEx);
*/	        
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
        }
    }
	
	/**
	 * 컬러팩토리 예약 확인 목록 // 회원인경우 
	 * @param requestBrand
	 * @return
	 */
	@RequestMapping("/storeEventRequesters")
    @ResponseBody
    public ResponseEntity<?> storeEventRequesters( RequestBrand requestBrand) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		/*StoreEventRequestersResult storeEventRequestersResult = new StoreEventRequestersResult();*/
		
		try {

			//예약한 시간 하루 전까지 취소 가능할 경우 add에 1로 세팅 (cancelAvailDt.add(Calendar.DATE, 1))
			Calendar cancelAvailDt = Calendar.getInstance();
			cancelAvailDt.add(Calendar.DATE, 1);
			
			//비회원일 경우
			if( requestBrand.getReserveNo() != null && !"".equals(requestBrand.getReserveNo())) {
				//StoreEventRequesterEx storeEventRequesterEx = storeApi.getStoreEventRequester(requestBrand.getReserveNo(), cancelAvailDt.getTime());
				
				Integer totalCount = 0;
				Integer offset = 0;
				Integer limit = 0;
				
				/*if(storeEventRequesterEx != null) {
					totalCount = 1;
				}
				
				storeEventRequestersResult.setTotalCount(totalCount);
				storeEventRequestersResult.setOffset(offset);
				storeEventRequestersResult.setLimit(limit);
				
				List <StoreEventRequesterEx> storeEventRequesterExList = new ArrayList <StoreEventRequesterEx> ();
				storeEventRequesterExList.add( storeEventRequesterEx);
				storeEventRequestersResult.setStoreEventRequesterExList( storeEventRequesterExList);*/
				
			}else { //회원일 경우
			
			/*	Calendar cal = Calendar.getInstance();
		        cal.add(Calendar.MONTH, -1);
		        
		        storeEventRequestersResult = storeApi.getStoreEventRequesters(getMemberSn(), cal.getTime(), requestBrand.getReserveCancelYn(),cancelAvailDt.getTime(), requestBrand.getOffset(), requestBrand.getLimit(), requestBrand.getSortBy());*/
			}
			
			//result.put("storeEventRequestersResult", storeEventRequestersResult);
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
        }
    }
	
	/**
	 * 컬러팩토리 예약 - 휴대폰인증
	 * @param 
	 * @return
	*/ 
	@RequestMapping("/requestMobileVerification")
    @ResponseBody
    public ResponseEntity<?> apMobileVerificationResult() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			//ApMobileVerificationResult apMobileVerificationResult = verifApi.requestMobileVerification(mobileVerificationRequestInfo);
         //   result.put("apMobileVerificationResult", apMobileVerificationResult);
	        
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
    }
    
	
	/**
	 * 컬러팩토리 예약 등록
	 * @param 
	 * @return
	 */
	@RequestMapping("/postStoreEventRequester")
    @ResponseBody
    public ResponseEntity<?> postStoreEventRequester( String preName, String cellNum) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			/*EmbeddableName embeddableName = new EmbeddableName();
			embeddableName.setName1(preName);
			
			EmbeddableTel embeddableTel = new EmbeddableTel();
			embeddableTel.setPhoneNo(cellNum);
			
			storeEventRequesterPost.setName(embeddableName);
			storeEventRequesterPost.setPhoneNo1(embeddableTel);
			
			Long memberSn = getMemberSn();

			if(memberSn != 0L) {
				storeEventRequesterPost.setMemberYn("Y");
				storeEventRequesterPost.setMemberSn(memberSn);
			}
			
			StoreEventRequesterResult storeEventRequesterResult = storeApi.postStoreEventRequester( storeEventRequesterPost);
            result.put("storeEventRequesterResult", storeEventRequesterResult);*/
	        
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}

    }
	
	/**
	 * 컬러팩토리 일정정보
	 * @param requestBrand
	 * @return
	 */
	@RequestMapping("/storeEventScheduleInfo")
    @ResponseBody
    public ResponseEntity<?> storeEventScheduleInfo( RequestBrand requestBrand) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			
			DateFormat dateFormat = new SimpleDateFormat("Z");
			String timeZone = dateFormat.format(new Date());
			
			/*StoreEventScheduleInfo storeEventScheduleInfo = storeApi.getStoreEventScheduleInfoByfoStoreEventCode(requestBrand.getFoStoreEventCode(), timeZone);
			
			List <StoreEventDetailScheduleEx> storeEvtDtlSchExList = storeEventScheduleInfo.getStoreEventDetailScheduleExList();
			
			Map <Long, Object> scheduleListbyStoreSnMap = new HashMap <Long, Object> ();
			
			for(int i=0; i<storeEvtDtlSchExList.size(); i++) {
				
				StoreEventDetailScheduleEx storeEventDetailScheduleEx = storeEvtDtlSchExList.get(i);
				
				if( !scheduleListbyStoreSnMap.containsKey( storeEventDetailScheduleEx.getStoreSn())) {
					
					Map <String, Object> compStoreScheMap = new HashMap <String, Object> ();
					
					List <Map <String, Object>> scheduleList = new ArrayList <Map <String, Object>> ();
					
					for(int j=0; j<storeEvtDtlSchExList.size(); j++) {
						StoreEventDetailScheduleEx storeEventDetailScheduleEx2 = storeEvtDtlSchExList.get(j);
						
						if(storeEventDetailScheduleEx.getStoreSn().equals(storeEventDetailScheduleEx2.getStoreSn())) {
							Map <String, Object> scheduleMap = new HashMap <String, Object> ();
							scheduleMap.put("storeSn", storeEventDetailScheduleEx2.getStoreSn());
							scheduleMap.put("storeEventSn", storeEventDetailScheduleEx2.getStoreEventSn());
							scheduleMap.put("storeEventDetailScheduleSn", storeEventDetailScheduleEx2.getStoreEventDetailScheduleSn());
							scheduleMap.put("reservePossibleDate8", storeEventDetailScheduleEx2.getReservePossibleDate8());
							scheduleMap.put("fromReservePossibleTime4", storeEventDetailScheduleEx2.getFromReservePossibleTime4());
							scheduleMap.put("toReservePossibleTime4", storeEventDetailScheduleEx2.getToReservePossibleTime4());
							scheduleMap.put("reservePossibleYn", storeEventDetailScheduleEx2.getReservePossibleYn());
							scheduleMap.put("scheFromDate", StringUtils.join(storeEventDetailScheduleEx2.getReservePossibleDate8(), storeEventDetailScheduleEx2.getFromReservePossibleTime4()));
							
							scheduleList.add(scheduleMap);
						}
					}
					
					scheduleList.sort(new Comparator<Map<String, Object>>() {
					    @Override
					    public int compare(Map<String, Object> m1, Map<String, Object> m2) {
					    	
					    	long srcDate =  Long.parseLong( (String) m1.get("scheFromDate"));
					    	long tgtDate =  Long.parseLong( (String) m2.get("scheFromDate"));
					    	
					        if(srcDate == tgtDate){
					            return 0;
					        }
					        return srcDate < tgtDate ? -1 : 1;
					     }
					});
					
					Map <String, String> possDateMap = new HashMap<String, String>();
					for(int j=0; j< scheduleList.size(); j++) {
						Map <String, Object> scheduleMap = scheduleList.get(j);
						String reservePossibleDate8 = (String) scheduleMap.get("reservePossibleDate8");
						String reservePossibleYn = (String) scheduleMap.get("reservePossibleYn");
						
						if(!possDateMap.containsKey(reservePossibleDate8)) {
							possDateMap.put(reservePossibleDate8, reservePossibleYn);
						}else if("Y".equals(reservePossibleYn)) {
							possDateMap.put(reservePossibleDate8, reservePossibleYn);
						}
					}
					
					compStoreScheMap.put("possDateMap", possDateMap);
					compStoreScheMap.put("scheduleList", scheduleList);
					scheduleListbyStoreSnMap.put(storeEventDetailScheduleEx.getStoreSn(), compStoreScheMap);
				}
			}*/
			
           // result.put("storeEventScheduleInfo", storeEventScheduleInfo);
         //   result.put("storeSnMap", scheduleListbyStoreSnMap);
	        
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
        }
    }
	
	/**
	 * 컬러팩토리 예약취소
	 * @param requestBrand
	 * @return
	 */
	@RequestMapping("/cancelScheduleInfo")
    @ResponseBody
    public ResponseEntity<?> cancelScheduleInfo( RequestBrand requestBrand) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			
			/*BooleanResult booleanResult = storeApi.cancelStoreEventRequester(requestBrand.getReserveNo());
			
            result.put("booleanResult", booleanResult);
	        */
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
        }
    }
	
	/**
	 * 청춘강연신청
	 * @param 
	 * @return
	 */
	@RequestMapping("/requestYouthLecture")
   @ResponseBody
   public ResponseEntity<?> requestYouthLecture(String preName, String prePhnNo, String preCpnName, String preCpnPhnNo) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			
			long youthLectureSn = 0;  // param 형식을 맞춰야해서 0으로 넘겨줌 
			
			/*EmbeddableName requesterName = new EmbeddableName(); // 예약자 
			requesterName.setName1(preName);
			
			EmbeddableTel requesterPhoneNo = new EmbeddableTel(); // 예약자 전화번호
			requesterPhoneNo.setPhoneNo(prePhnNo);
			
			EmbeddableName companionName = new EmbeddableName(); // 동반자 이름
			companionName.setName1(preCpnName);
			
			EmbeddableTel companionPhoneNo = new EmbeddableTel();  // 동반자 전화번호
			companionPhoneNo.setPhoneNo(preCpnPhnNo);
			
			requestInfo.setRequesterName(requesterName);
			requestInfo.setRequesterPhoneNo(requesterPhoneNo);
			requestInfo.setCompanionName(companionName);
			requestInfo.setCompanionPhoneNo(companionPhoneNo);
			requestInfo.setTermsAgreeYn("Y");
			YouthLectureReturn  youthLectureReturn = bbsApi.requestYouthLecture(youthLectureSn, requestInfo); 
             result.put("youthLectureReturn", youthLectureReturn);*/
	        
	        return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.put("errorData", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}

   }
	
	
	/**
	 * 뷰티즌 신청
	 * @param 
	 * @return
	 */
	@RequestMapping("/requestBeautizen")
   @ResponseBody
   public ResponseEntity<?> requestBeautizen(SupportersRequester supportersRequester,  MultipartFile[] picture, HttpServletRequest req) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			
			long supportersSn = 0;  // param 형식을 맞춰야해서 0으로 넘겨줌 
			
			List<UploadingFile> uploadingFiles = new ArrayList<UploadingFile>(); 
		
			//List<File> files = new ArrayList<File>();

        	for(int i=0; picture != null && i<picture.length; i++) {
        		
        		if(!("").equals(picture[i].getOriginalFilename())) {
        			uploadingFiles = imageSettingList(picture);
        		}
            }
        	
            EmbeddableAddress address = new EmbeddableAddress(); 
            address.setAddress1(req.getParameter("preLocal"));         
            supportersRequester.setRequesterAddress(address); // 지역 setting
           
            EmbeddableTel tel = new EmbeddableTel(); 
            tel.setPhoneNo(req.getParameter("prePhoneNo"));
            supportersRequester.setRequesterPhoneNo(tel); // phone setting 
          
            supportersRequester.setMemberId(""); //
            supportersRequester.setMemberName(""); //
            supportersRequester.setMemberSn(""); //
            
            supportersRequester.setFiles(uploadingFiles);

            List<RequesterHist> requesterHist = new ArrayList<RequesterHist>();
            
            String activityType[] = {req.getParameter("activityType")};
            String activityName[] = {req.getParameter("activityName")};
            String activityBodyText[] = {req.getParameter("activityBodyText")};
            String activityStartDate[] = {req.getParameter("activityStartDate")};
            String activityEndDate[] = {req.getParameter("activityEndDate")};
            
            logger.info(req.getParameter("activityStartDate"));; 
                        
            for(int i =0; i < activityStartDate.length; i++) {
            	RequesterHist requester = new RequesterHist(); 
            	
            	SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMdd");
        
            	requester.setActivityType(activityType[i]);
            	requester.setActivityName(activityName[i]);
            	requester.setActivityBodyText(activityBodyText[i]);
            	requester.setActivityStartDate(sFormat.parse(activityStartDate[i]));
            	requester.setActivityEndDate(sFormat.parse(activityEndDate[i]));
            	requesterHist.add(i, requester);
            }
            supportersRequester.setSupportersRequesterHist(requesterHist);
            
	        //BooleanResult booleanResult = bbsApi.requestSupporters(supportersSn, supportersRequester); 
	        result.put("booleanResult", "result:true");
             
 	        return ResponseEntity.ok(result);
 	        
 		} catch (Exception e) {
 			result.put("errorData", e);
 			e.printStackTrace();
 			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
 		}
   }
	
	//private method
    private File MultiPartToFile(MultipartFile mul, String filePath) {
        File convF = new File(filePath + mul.getOriginalFilename());
        try {
            mul.transferTo(convF);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return convF;
    }
    
    
    

    	
    
	
}
