/**
 * 뷰티즌 신청하기 
 *
 * @Method:
 * setData
 *
 */

;(function ( $ ) {
	'use strict';

	var BeautizenRecruit = $B.Class.extend({
		initialize: function () {
			this._$target = $( '#ap_container .beautizen-recruit' );
			this._data = null;
			this._setEvent();
			this._load();
			this._setMobileVerification();
			this._mobileVerifSn = '';
		},
		
		/** =============== Public Methods ================ */
		
		setData:function(data){
		this._data = data;
		
			console.log(AP.DISPLAY_MENU_ID);
			
			if(AP.DISPLAY_MENU_ID === 'beautizen_update' ){
				
				this._loading_modify(this._data); 
			}; // 수정화면으로 진입
		
		},
		
		/** =============== Private Methods =============== */
		
		//휴대폰 인증 
		_setMobileVerification: function () {
			
			var $phoneSelect = this._$target.find( '#phoneCorp' ),
			$phoneNo = this._$target.find( 'input[name="prePhoneNo"]' ),
			$snsNum = this._$target.find( '#smsNum' );
			// 인증번호 요청
			var timer = new AP.common.timeCountDown(3);
			
			this._$target.find( '#certBtn' ).on( 'click', function (e) {
				
				if ( $phoneSelect.valid() && $phoneNo.valid() ) {
					AP.mobileVerification.request( $phoneSelect.val(), $phoneNo.val() );
					$( e.target ).hide();
					$( e.target ).siblings( '#reCertBtn' ).show();
					timer.start();
				} else {
					if ( !$phoneSelect.valid() ) {
						AP.modal.alert( $phoneSelect.data( 'msg-required' ));
						return;
					}
					if ( !$phoneNo.valid() ) {
						AP.modal.alert( $phoneNo.data( 'msg-required' ));
					}
				}
			}.bind( this ));

			// 인증번호 재요청
			this._$target.find( '#reCertBtn' ).on( 'click', function (e) {
			
				if ( $phoneSelect.valid() && $phoneNo.valid() ) {
					AP.mobileVerification.reRequest( this._mobileVerifSn );
					$( e.target ).siblings( '#reCertBtn' ).show();
					timer.start();
				} else {
					if ( !$phoneSelect.valid() ) {
						AP.modal.alert( $phoneSelect.data( 'msg-required' ));
						return;
					}
					if ( !$phoneNo.valid() ) {
						AP.modal.alert( $phoneNo.data( 'msg-required' ));
					}
				}
			}.bind( this ));

			// 인증번호 받기
			AP.mobileVerification.addListener( 'request-verify-no', function (e) {
				this._mobileVerifSn = e.data.mobileVerifSn;
				this._$target.find( '.certification_btn' ).prop( 'disabled', false );
			}.bind( this ));

			// 재전송 인증번호 받기
			AP.mobileVerification.addListener( 're-request-verify-no', function (e) {
				this._mobileVerifSn = e.data.mobileVerifSn;
				timer.stop();
				timer.start();
			}.bind( this ));

			// 인증 확인
			this._$target.find( '.certification_btn' ).on( 'click', function (e) {
				if ( $snsNum.valid() ) {
					AP.mobileVerification.confirm( this._mobileVerifSn, $snsNum.val() );
				} else {
					AP.modal.alert( $snsNum.data( 'msg-required' ));
				}
			}.bind( this ));

			AP.mobileVerification.addListener( 'confirm-verify-no', function (e) {
				if ( e.data.result == true ) {
					this._$target.find( 'input[name=verifyCertification]' ).val( 'Y' );
					AP.modal.alert( $snsNum.data( '인증 되었습니다.' ));
				} else {
					AP.modal.alert( e.data.errorMessage );
				}
			}.bind( this ));
		},
		
		_setEvent: function () {
			
			// 초기화
			this._$target.find('button#reset').on('click', function (e){
				
				console.log('test'); 
				
			}.bind(this));
			
			// sns 등록 팝업
			this._$target.find('.snsUrl ').on('click', function (e){
			
				 this._openSnsModal();
				
			}.bind(this));
			
			//대외 활동 추가  히스토리 저장하는 방법 확인
			this._$target.find( '.btn_add' ).on( 'click', function (e) {
				
				this._setCopyData(this._$target.find('.activities_history')[0].innerHTML);
				
				this._$target.find('.activities_history').after(this._htmlTag);
								
			}.bind( this ));
		
			// 대외활동 삭제 
			this._$target.on( 'click', '.btn_remove', function (e) {
				
				console.log(e.target.id);
				
				console.log(this._$target.find('div').className === e.target.id); 
				var id = ''+e.target.id+''; 
		
					console.log(this._$target.find('div '+'#'+e.target.id+'.copy'));  
		
					this._$target.find('div '+'#'+e.target.id+'.copy').remove();
				
			}.bind(this));
			
			// 임시 저장  validate noCheck
			this._$target.find( '.form_btns #Temp' ).on( 'click', function (e) {  
				  
				this._submit(this._$target.find( 'form.validate' )[0], 'Temp'); 
				
			}.bind( this ));
			
			// 최종 제출하기 validate Check
			this._$target.find( '.form_btns #Complete' ).on( 'click', function (e) {
				this._$target.find( 'input[name=verifyCertification]' ).val( 'Y' );
				this._$target.find( 'form.validate' ).submit(); 
				
			}.bind( this ));
						
			// submit
			this._$target.find( 'form.validate' ).validate({
				
				submitHandler: function ( form, e ) {
				 	
					var confirmModal = AP.modal.info({
						title: '제출하기',
						contents: '지원하시겠습니까?',
						confirmLabel: '확인',
						cancelLabel: '취소'
					}).addListener( 'modal-close', function (e) {}.bind(this)) ; 
					
					var $confirmModal = confirmModal.getElement();

					$confirmModal.find( '.btn_lg_secondary' ).on( 'click', function (e) { // 취소
						confirmModal.close();
					}.bind(this)); 
					
					$confirmModal.find( '.btn_lg_neutral' ).on( 'click', function (e) { // 확인
						 
						confirmModal.close();
						 this._submit(form, 'Complete');
 
					}.bind(this));
					
				}.bind( this) 		
				
			}); 
			
			// 전체 동의
			this._$target.find( 'input#check_all' ).on( 'change', function (e) {
				if ( $( e.target ).prop('checked') ) {
					$( e.target ).closest( '.relative' ).find( 'input' ).prop( 'checked', true );
				}else {
					$( e.target ).closest( '.relative' ).find( 'input' ).prop( 'checked', false );
				}
			}.bind( this ));
			
			
			
		},
		/** =============== function Methods =============== */
		
		// 대외활동 추가 레이어 
		_setCopyData :function(historyHtml){
				this._htmlTag = null; 
				
			// 버튼을 누르면 복사할 태그를 저장해둔다 .
				this._htmlTag = '<div class="copy" id="count_'+this._count+'"><button type="button" class="btn_remove" id="count_'+this._count+'">삭제하기<i class="ico_trash"></i></button>'; 
				this._htmlTag += $B.object.clone(historyHtml);
				this._htmlTag += '</div>';
				this._count += 1; 
		},
		
		_submit : function(paramData, btEvent){
			console.log(paramData); 
			
			var formData = new FormData(paramData); 
			formData.append('requestStatus', btEvent);
			 
			console.log(formData);  
		
			 AP.login().done( function () { // 로그인으로 
				 
				this._api = AP.api.requestBeautizen( {}, formData ).done(function (result) {

					if(result.booleanResult){ // 잘 저장되었으면 
						if(btEvent === 'Temp'){ // 임시면 
							AP.modal.alert( '지원서가 임시저장 되었습니다.');
						}else if(btEvent === 'Complete'){
							
							//AP.modal.alert( '최종제출 완료  되었습니다.');
							this.dispatch('reserve-complete'); 
						}
					}
				}.bind( this )).fail(function ( xhr ) {
					AP.modal.alert(xhr.errorMassage);
					if ( xhr.errorCode === 'EAPI004' ) {
						//존재하지 않는 회원
						AP.login({
							trigger: true
						});
					}
				}.bind( this ));
			}.bind( this ));
		},
		
			//모달 띄우기
		_openSnsModal: function(){
			
			var snsModal= AP.modal.info({
	            
				title: '페이스북 등록 방법',
	                contents : {
	                	  templateKey : 'display.brand.beautizen-sns-modal' // display/brand/beautizen-sns-modal.js
	                }
				}).addListener( 'modal-close', function (e) {
					
			}.bind(this));
			
			var $snsModal = snsModal.getElement();

			$snsModal.find( '.btn_lg_secondary' ).on( 'click', function (e) { // 취소
				snsModal.close();
			}.bind(this)); 
			
			$snsModal.find( '.btn_lg_neutral' ).on( 'click', function (e) { // 확인
				 
				 var snsUrl  = $snsModal.find('.form .input_wrap #blog_url').val();
				 snsModal.close();
				 this._$target.find('.input_wrap input#sns_url').val(snsUrl).placeholder('updated'); 
				
			}.bind(this));
		},
		// 수정화면 로딩( 이전에 입력한 데이터가 있는 경우 
		_loading_modify :function(supporters){
			
			
			var html = AP.common.getTemplate( 'display.brand.beautizen-modify', supporters);
			
			
			
			this._$target.find('div.clear').html(html); 
			this._setEvent();
			this._load();
			this._setMobileVerification();
			
			//preLocal, academic04, academic05, academic01
			var selectBoxs = this._$target.find('select'); 
			
			$.each(selectBoxs, function(index, select){
				var selectsId = select.id;

				$.each(supporters, function ( key, value ){
					
					$.each(select, function(index, option){
						
						if(option.value === value){
							this.selected = true; 
						}else{
							this.selected = false ; 
						} 
						
					});
					$(this).selectBox('updated');  
				}); 

			});
 
		},
	
		// 셀렉트박스 셋팅
		_load : function(){

			var phoneCorp = ['SKT','KT','LG U+','SKT 알뜰폰','KT 알뜰폰','LG U+ 알뜰폰']; // 통신사  
			var preLocal = ['강원도', '경기도', '경상남도', '경상북도', '광주광역시', '대구광역시', '대전광역시', '부산광역시', '서울특별시', '세종특별자치시', '울산광역시', 
				'인천광역시', '전라남도', '전라북도', '제주특별자치도', '충청남도', '충청북도']; // 지역
			var academic04 = ['1','2','3','4']; // 학년
			var	academic05 = ['1','2','3','4','5','6','7','8','9','10'];// 이수 학기
			var	activity01 = ['대학생 프로그램','공모전','기타대외활동','학생회','동아리'];// 대외활동 유형 
			
			var selectBoxs = this._$target.find('select'); 
			
			var selectNames = [];
			
			$.each(selectBoxs, function(index, object){
				
				selectNames[index] = selectBoxs[index].id;
			}); 
			
			$.each(selectBoxs , function(index , object){
				
				if(object.id === selectNames[index]){ 
					
					$(this).selectBox();
					
					$.each( eval(object.id) , function(index, value){
						 
						$(object).append($('<option>',{value:value, id: index , text:value}));
						
					});

					$(this).selectBox('updated'); 
				
				}
				
			}); 
			
		}
	});

	AP.beautizenRecruit = new BeautizenRecruit();
})( jQuery );