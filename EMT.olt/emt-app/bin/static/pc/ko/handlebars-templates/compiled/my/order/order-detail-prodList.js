this["AP"] = this["AP"] || {};
this["AP"]["handlebars"] = this["AP"]["handlebars"] || {};
this["AP"]["handlebars"]["my"] = this["AP"]["handlebars"]["my"] || {};
this["AP"]["handlebars"]["my"]["order"] = this["AP"]["handlebars"]["my"]["order"] || {};

this["AP"]["handlebars"]["my"]["order"]["order-detail-prodList"] = Handlebars.template({"1":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, alias1=container.lambda, alias2=container.escapeExpression, alias3=depth0 != null ? depth0 : (container.nullContext || {}), alias4=helpers.helperMissing;

  return "		<div class=\"panel_box\">\n			<div class=\"product\">\n				<div class=\"check_wrap check_only\">\n					<input type=\"checkbox\" id=\"check_"
    + alias2(alias1((depth0 != null ? depth0.onlineProdSn : depth0), depth0))
    + "\" name=\"onlineProd\" value=\""
    + alias2((helpers.json || (depth0 && depth0.json) || alias4).call(alias3,depth0,{"name":"json","hash":{},"data":data}))
    + "\" data-oProdSn=\""
    + alias2(alias1((depth0 != null ? depth0.onlineProdSn : depth0), depth0))
    + "\">\n					<label for=\"check_"
    + alias2(alias1((depth0 != null ? depth0.onlineProdSn : depth0), depth0))
    + "\">\n						<span class=\"sr_only\">선택</span>\n					</label>\n				</div>\n				<div class=\"thumb\"><img src=\""
    + alias2(alias1((depth0 != null ? depth0.onlineProdImgUrl : depth0), depth0))
    + "\" alt=\"\"></div>\n				<div class=\"info\">\n					<div class=\"align_left\">\n						<p class=\"name\">"
    + alias2(alias1((depth0 != null ? depth0.onlineProdName : depth0), depth0))
    + "</p>\n					</div>\n					<div class=\"align_right\">\n"
    + ((stack1 = helpers["if"].call(alias3,(helpers.eq || (depth0 && depth0.eq) || alias4).call(alias3,(depth0 != null ? depth0.ordHistProdStatusCode : depth0),"ProdCancel",{"name":"eq","hash":{},"data":data}),{"name":"if","hash":{},"fn":container.program(2, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "						<p><strong class=\"num\">"
    + alias2((helpers.currencyFormat || (depth0 && depth0.currencyFormat) || alias4).call(alias3,(depth0 != null ? depth0.finalOnlineSaleAmtPcurSum : depth0),{"name":"currencyFormat","hash":{},"data":data}))
    + "</strong></p>\n					</div>\n				</div>\n			</div>\n"
    + ((stack1 = helpers.each.call(alias3,(depth0 != null ? depth0.ordHistProdList : depth0),{"name":"each","hash":{},"fn":container.program(4, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "			<!-- <div class=\"freebies\">\n				<div class=\"thumb\"><img ap:src=\"@{/images/dummy/650001018_IM_01.png}\" alt=\"\"></div>\n				<div class=\"info\">\n					<div class=\"align_left\">\n						<p class=\"name\">중력타파 거미줄 리프팅 마스크</p>\n						<p class=\"flag\">증정사은품</p>\n					</div>\n					<div class=\"align_right\">\n						<p><strong class=\"num\">10</strong>개<span class=\"gap\">/</span><strong class=\"num\">0</strong>원</p>\n					</div>\n				</div>\n			</div> -->\n"
    + ((stack1 = (helpers.xif || (depth0 && depth0.xif) || alias4).call(alias3,(depths[1] != null ? depths[1].step : depths[1]),"==","one",{"name":"xif","hash":{},"fn":container.program(8, data, 0, blockParams, depths),"inverse":container.program(11, data, 0, blockParams, depths),"data":data})) != null ? stack1 : "")
    + "		</div>\n";
},"2":function(container,depth0,helpers,partials,data) {
    return "						<p><em>취소완료</em></p>\n";
},"4":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, alias1=container.lambda, alias2=container.escapeExpression, alias3=depth0 != null ? depth0 : (container.nullContext || {}), alias4=helpers.helperMissing;

  return "				<div class=\"prd_option\">\n					<div class=\"set\">\n						<div class=\"check_wrap check_only\">\n							<input type=\"checkbox\" id=\"prod_"
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.ordProdEx : depth0)) != null ? stack1.prodSn : stack1), depth0))
    + "\" name=\"prod_"
    + alias2(alias1((depths[1] != null ? depths[1].onlineProdSn : depths[1]), depth0))
    + "\" value=\""
    + alias2((helpers.json || (depth0 && depth0.json) || alias4).call(alias3,depth0,{"name":"json","hash":{},"data":data}))
    + "\" data-oProdSn=\""
    + alias2(alias1((depths[1] != null ? depths[1].onlineProdSn : depths[1]), depth0))
    + "\">\n							<label for=\"prod_"
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.ordProdEx : depth0)) != null ? stack1.prodSn : stack1), depth0))
    + "\">\n								<span class=\"sr_only\">선택</span>\n							</label>\n						</div>\n						<div class=\"thumb\"><span style=\"background-color: #c1373e;\"><img src=\"\" alt=\"\"></span></div>\n						<div class=\"info\">\n							<p class=\"name\">"
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.ordProdEx : depth0)) != null ? stack1.prodNameBlang : stack1), depth0))
    + "</p>\n						</div>\n						<div class=\"align_right\">\n							<span>"
    + alias2(alias1((depth0 != null ? depth0.ordQty : depth0), depth0))
    + "개 / "
    + alias2((helpers.currencyFormat || (depth0 && depth0.currencyFormat) || alias4).call(alias3,(depth0 != null ? depth0.finalOnlineSaleAmtPcur : depth0),{"name":"currencyFormat","hash":{},"data":data}))
    + " </span>\n"
    + ((stack1 = helpers["if"].call(alias3,(helpers.ne || (depth0 && depth0.ne) || alias4).call(alias3,(depth0 != null ? depth0.ordHistProdStatusCode : depth0),"ProdCancel",{"name":"ne","hash":{},"data":data}),{"name":"if","hash":{},"fn":container.program(5, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "						</div>\n					</div>\n				</div>\n";
},"5":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, alias1=depth0 != null ? depth0 : (container.nullContext || {}), alias2=helpers.helperMissing;

  return ((stack1 = helpers["if"].call(alias1,(helpers.or || (depth0 && depth0.or) || alias2).call(alias1,(helpers.eq || (depth0 && depth0.eq) || alias2).call(alias1,(depths[2] != null ? depths[2].statusCode : depths[2]),"OrdReceivedWaiting",{"name":"eq","hash":{},"data":data}),(helpers.eq || (depth0 && depth0.eq) || alias2).call(alias1,(depths[2] != null ? depths[2].statusCode : depths[2]),"OrdReceivedComplete",{"name":"eq","hash":{},"data":data}),{"name":"or","hash":{},"data":data}),{"name":"if","hash":{},"fn":container.program(6, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"6":function(container,depth0,helpers,partials,data) {
    var stack1, alias1=container.lambda, alias2=container.escapeExpression;

  return "									<button class=\"btn_sm_neutral\" type=\"button\" onclick=\"changeOption("
    + alias2(alias1((depth0 != null ? depth0.ordHistProdSn : depth0), depth0))
    + ", '"
    + alias2(alias1((depth0 != null ? depth0.ordHistProdNo : depth0), depth0))
    + "', "
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.ordProdEx : depth0)) != null ? stack1.prodSn : stack1), depth0))
    + ")\">옵션변경</button>\n";
},"8":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, alias1=container.lambda, alias2=container.escapeExpression;

  return "				<div class=\"reason\" id=\"reason_"
    + alias2(alias1((depth0 != null ? depth0.onlineProdSn : depth0), depth0))
    + "\">\n					<div class=\"input_group\">\n						<div class=\"ui_select w20p\" data-not-label-change=\"false\">\n							<input type=\"hidden\" name=\"claimReasonSn\" id=\"reasonSn_"
    + alias2(alias1((depth0 != null ? depth0.onlineProdSn : depth0), depth0))
    + "\">\n							<button type=\"button\">"
    + alias2(alias1((depth0 != null ? depth0.title : depth0), depth0))
    + "사유 선택</button>\n							<ul class=\"select_options\">\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : (container.nullContext || {}),((stack1 = (depths[1] != null ? depths[1].reason : depths[1])) != null ? stack1.claimReasonExList : stack1),{"name":"each","hash":{},"fn":container.program(9, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "							</ul>\n						</div>\n						<span class=\"gap\">&nbsp;</span>\n						<div class=\"input_wrap\">\n							<input type=\"text\" placeholder=\"사유를 입력해주세요\" value=\""
    + alias2(alias1((depth0 != null ? depth0.claimReason : depth0), depth0))
    + "\">\n						</div>\n					</div>\n				</div>\n";
},"9":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var alias1=container.lambda, alias2=container.escapeExpression;

  return "									<li class=\"select_option\">\n										<code class=\"label_markup\" style=\"display:none\">\n											<span class=\"slt_color_name\">"
    + alias2(alias1((depth0 != null ? depth0.reasonName : depth0), depth0))
    + "</span>\n										</code>\n										<a data-value=\""
    + alias2(alias1((depth0 != null ? depth0.claimReasonSn : depth0), depth0))
    + "\" data-onlineProdSn=\""
    + alias2(alias1((depths[1] != null ? depths[1].onlineProdSn : depths[1]), depth0))
    + "\">\n											<span class=\"color_name\">"
    + alias2(alias1((depth0 != null ? depth0.reasonName : depth0), depth0))
    + "</span>\n										</a>\n									</li>\n";
},"11":function(container,depth0,helpers,partials,data) {
    var alias1=container.lambda, alias2=container.escapeExpression;

  return "				<div class=\"reason gray\">\n					<dl>\n						<dt>교환 사유</dt>\n						<dd>"
    + alias2(alias1((depth0 != null ? depth0.claimReasonName : depth0), depth0))
    + "</dd>\n					</dl>\n					<dl>\n						<dt>교환 내용</dt>\n						<dd>"
    + alias2(alias1((depth0 != null ? depth0.claimReason : depth0), depth0))
    + "</dd>\n					</dl>\n				</div>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return "<dt class=\"on\"><button type=\"button\">온라인 주문 상품 (<em>"
    + container.escapeExpression(container.lambda((depth0 != null ? depth0.cnt : depth0), depth0))
    + "</em>개)</button></dt>\n<dd>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : (container.nullContext || {}),(depth0 != null ? depth0.list : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</dd>";
},"useData":true,"useDepths":true});