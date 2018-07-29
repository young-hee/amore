this["AP"] = this["AP"] || {};
this["AP"]["handlebars"] = this["AP"]["handlebars"] || {};
this["AP"]["handlebars"]["cart"] = this["AP"]["handlebars"]["cart"] || {};

this["AP"]["handlebars"]["cart"]["location-auth"] = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<dl class=\"layer\">\n	<dt class=\"layer_title\">위치기반 서비스 이용동의</dt>\n	<dd class=\"layer_cont\">\n		<div class=\"login\">\n			<p class=\"text\"><b>에뛰드하우스 서비스의 위치정보 수집 및 이용에 대한 약관동의</b></p>\n			<br>\n			<div class=\"policy_wrap\">\n				<div class=\"policy\" tabindex=\"0\">\n<pre>[위치기반 서비스 이용약관]\n\n1.수집하는 개인정보의항목: 성명, 주소, (휴대)전화번호, 이메일,결제정보(은행계좌정보등)\n2.개인정보 수집 및 이용목적: 제품구매 및 배송, 결제 진행, 반품/환불 처리\n3.개인정보의 보유 및 이용기간: 전자상거래소비자보호법에 따른 개인정보 보유\n    *계약 또는 처약철회 등에 따른 기록 : 5년\n    * 대금결제 및 재화 등의 공급에 관한 기록 : 5년\n    * 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년\n    - 소비자기본법에 따른 A/S 처리기간에 따른 개인정보 보유\n    - 제조물책임법에 따른 손해배상청구 기간에 따른 개인정보 보유\n4. 고객님은 위 개인정보의 수집, 이용에 대한 동의를 거부할 수 있습니다.\n	단, 거부 시 비회원구매 서비스를 이용하실 수 없습니다.</pre>\n				</div>\n				<ul class=\"list_bullet_dot\">\n					<li>위치 기반 서비스 이용약관에 동의하시면 내 위치 주변에 가까운 매장을 찾아보실 수 있습니다.</li>\n					<li>동의하지 않으실 경우 서비스를 제공받으실 수 없습니다.</li>\n				</ul>\n				<div class=\"policy_agree clear mgt20\">\n					<p class=\"text\">해당 내용에 동의하십니까?</p>\n					<div class=\"check_set\">\n						<span class=\"check_wrap\"><input type=\"radio\" name=\"agree\" id=\"agree1\" checked><label for=\"agree1\">동의</label></span>\n						<span class=\"check_wrap\"><input type=\"radio\" name=\"agree\" id=\"agree2\"><label for=\"agree2\">미동의</label></span>\n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\"page_btns\">\n			<button class=\"btn_lg_secondary\" type=\"button\" id=\"cancel\">취소</button>\n			<button class=\"btn_lg_neutral\" type=\"button\" id=\"ok\">확인</button>\n		</div>\n	</dd>\n</dl>\n<button class=\"layer_close\" type=\"button\">레이어 닫기</button>\n";
},"useData":true});