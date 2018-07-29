package kr.ap.comm.api;

import feign.RequestLine;
import kr.ap.comm.api.vo.WebDBResultVo;
import kr.ap.comm.api.vo.WebDBSignupVo;

public interface WebDBApiService {

	@RequestLine(value = "api/member/join.do")
	WebDBResultVo createWebDBUser(WebDBSignupVo webDBSignupVo);
}
