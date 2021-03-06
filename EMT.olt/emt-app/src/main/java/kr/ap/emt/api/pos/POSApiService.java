package kr.ap.emt.api.pos;

import java.util.Date;

import kr.ap.emt.api.pos.vo.*;

import feign.Param;
import feign.RequestLine;

public interface POSApiService {

	/**
	 * 뷰티포인트 통합번호로 온오프/경로고객번호 조회 
	 * @param ucstmId
	 * @return
	 * @throws ApiException
	 */
	@RequestLine(value = "epl/getposcstminfo/v0.50")
	@SuccessCode(rsltCd = "SUCC")
	PosCstmInfo getPosCstmInfo(@Param("ucstmId") String ucstmId);
	
	/**
	 * 에뛰드등업예상 안내
	 * @param cstmId
	 * @return
	 * @throws ApiException
	 */
	@RequestLine(value = "epl/getcustcstmamt/v1.00")
	@SuccessCode(rsltCd = "SUCC")
	CustCstmAmt getCustCstmAmt(@Param("cstmId") String cstmId);
	
	/**
	 * 쿠션포인트거래내역조회
	 * @param cstmId
	 * @return
	 * @throws ApiException
	 */
	@RequestLine(value = "epl/getcustcushinusedetaillist/v1.00")
	@SuccessCode(rsltCd = "SUCC")
	CustCushinUseList getCustCushinUseDetailList(@Param("cstmId") String cstmId, @Param("startDt") Date startDt, @Param("endDt") Date endDt, @Param("startNo") int startNo, @Param("endNo") int endNo);
	
	/**
	 * 회원등급산정내역
	 * @param cstmId, startDt, endDt, searchGbn
	 * @return
	 * @throws ApiException
	 */
	@RequestLine(value = "epl/getcustgradedetaillist/v1.00")
	@SuccessCode(rsltCd = "SUCC")
	CustGradeDetail getCustGradeDetailList(@Param("cstmId") String cstmId, @Param("startDt") Date startDt, @Param("endDt") Date endDt, @Param("searchGbn") GBN searchGbn);
	
	/**
	 * 회원가입
	 * @param PosChannelInfo
	 * @return
	 * @throws ApiException
	 */
	@RequestLine(value = "epl/createposchannelinfo/v1.00")
	@SuccessCode(rsltCd = "SUCC")
	POSResultVo createPosChannelInfo(PosChannelInfo posChannelInfo);
}
