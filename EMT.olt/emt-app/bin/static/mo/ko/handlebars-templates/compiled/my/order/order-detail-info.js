this["AP"] = this["AP"] || {};
this["AP"]["handlebars"] = this["AP"]["handlebars"] || {};
this["AP"]["handlebars"]["my"] = this["AP"]["handlebars"]["my"] || {};
this["AP"]["handlebars"]["my"]["order"] = this["AP"]["handlebars"]["my"]["order"] || {};

this["AP"]["handlebars"]["my"]["order"]["order-detail-info"] = Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "		<dl class=\"table_layout\">\n			<dt>온라인 주문</dt>\n			<dd><em>"
    + container.escapeExpression((helpers.ordStatusCheck || (depth0 && depth0.ordStatusCheck) || helpers.helperMissing).call(depth0 != null ? depth0 : (container.nullContext || {}),(depth0 != null ? depth0.type : depth0),((stack1 = (depth0 != null ? depth0.ordEx : depth0)) != null ? stack1.ordDetailStatusCode : stack1),{"name":"ordStatusCheck","hash":{},"data":data}))
    + "</em></dd>\n		</dl>\n";
},"3":function(container,depth0,helpers,partials,data) {
    return "    	<dl class=\"table_layout\">\n    		<dt>테이크 아웃</dt>\n    		<dd><em>주문접수</em></dd>\n    		<dd class=\"align_right\">\n    			<button type=\"button\" class=\"btn_take_out\"><img src=\"@{/images/my/btn_barcode.gif}\" alt=\"테이크아웃바코드 보기\"></button>\n    		</dd>\n    	</dl>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, alias1=container.escapeExpression, alias2=depth0 != null ? depth0 : (container.nullContext || {}), alias3=helpers.helperMissing;

  return "<div class=\"title table_layout\">\n	<div><b class=\"font_lg\">주문정보</b></div>\n</div>\n<div class=\"cont\">\n	<dl class=\"table_layout\">\n		<dt>주문 번호</dt>\n		<dd><strong class=\"num\">"
    + alias1(container.lambda(((stack1 = (depth0 != null ? depth0.ordEx : depth0)) != null ? stack1.ordNo : stack1), depth0))
    + "</strong></dd>\n	</dl>\n	<dl class=\"table_layout\">\n		<dt>주문 일시</dt>\n\n		<dd><span class=\"num color_gray2\">"
    + alias1((helpers.dateFormat || (depth0 && depth0.dateFormat) || alias3).call(alias2,((stack1 = (depth0 != null ? depth0.ordEx : depth0)) != null ? stack1.ordReceivedDt : stack1),"YYYY-MM-DD HH:MM:SS",{"name":"dateFormat","hash":{},"data":data}))
    + "</span></dd>\n	</dl>\n"
    + ((stack1 = (helpers.xif || (depth0 && depth0.xif) || alias3).call(alias2,(depth0 != null ? depth0.onlineCnt : depth0),">",0,{"name":"xif","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = (helpers.xif || (depth0 && depth0.xif) || alias3).call(alias2,(depth0 != null ? depth0.storeCnt : depth0),">",0,{"name":"xif","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</div>";
},"useData":true});