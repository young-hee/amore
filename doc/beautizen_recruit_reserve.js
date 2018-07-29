/**
 * 뷰티즌 신청하기 
 *
 * @Method:
 * setData
 *
 */

;(function ( $ ) {
	'use strict';

	var BeautizenRecruitReserve = $B.Class.extend({
		initialize: function () {
			this._$target = $( '#ap_container .beautizen_recruit_reserve' );
			this._data = null;
			this._setEvent();	
			this._clkBtn = null;
			this._htmlTag = null;
			this._count = 0; 
			
		},
		
		/** =============== Public Methods ================ */
		
		setData:function(data){
			
			this._data = data;
			console.log(AP.DISPLAY_MENU_ID); //: "beautizen_introduce"
			console.log(this._data);
			//console.log(this._$target.find( 'form.validate')); 
			// alert(this._data); 
			 //map.put("user_id", "atspeed");
			 console.log(this._data);
			var formData = new FormData(this._$target.find( 'form.validate')[0]); 
			
			$.each(this._data, function( index, value ) {
				
			if(index === 'images'){
					//console.log(index + ',' + value); 
				$('.img .attach').load('<img src="http://img.etnews.com/news/article/2016/01/13/article_13182538904561.jpg">'); 
				console.log($('.img .attach'));
				console.log(value.fileUrl);
				}
				
				//this._$target.find( 'form.validate').set(''+ index + '', '' + value +''); 
				  
				  console.log(''+ index + '', '' + value +''); 
				});
			
			
			for(var temps  of formData.entries()){
				console.log(temps[0] + ',' +temps[1]);
			}
		},
		
		/** =============== Private Methods =============== */
		
		
		_setEvent: function () {
			
			//대외 활동 추가  히스토리 저장하는 방법 확인
			this._$target.find( '.btn_add' ).on( 'click', function (e) {

				this._setCopyData(this._$target.find('.activities_history')[0].innerHTML);
				this._$target.find('.activities_history').after(this._htmlTag);
								
			}.bind( this ));
		
			// 대외활동 삭제 
			this._$target.on( 'click', '.btn_remove', function (e) {
				 
				var id = ''+e.target.id+''; 
				this._$target.find('div '+'#'+e.target.id+'.copy').remove();
				
			}.bind(this));
			
			// 기본정보 입력에서 임시저장 클릭시 
			this._$target.find( '.form_btns .temp' ).on( 'click', function (e) {
			
				var beautizenForm = this._$target.find('form.validate');
				var formData = new FormData(beautizenForm[0]);
				formData.append('requestState', 'Temp'); // 임시 저장 
				this._submit(formData,'Temp');
				
				
			}.bind( this ));
			
			// 기본정보 입력화면에서 다음버튼저장
			this._$target.find( '.form_btns .nextConfirm' ).on( 'click', function (e) {
				
				AP.modal.confirm( '임시저장후 다음으로 이동하시겠습니까?' ).addListener( 'modal-close', function (e) {
					if ( e.closeType == 'confirm' ) {
						
						this._$target.find('form.validate').submit();  
							
					}
				}.bind( this ));
				
			}.bind( this ));
			
			// 자기소개 입력 정보화면에서 임시 버튼 클릭시 
			this._$target.find( '.form_btns .nextTemp' ).on( 'click', function (e) {
				// 자기소개 임시 저장
				var beautizenForm = this._$target.find('form.validate');
				var formData = new FormData(beautizenForm[0]);
				formData.append('requestState', 'Temp'); // 임시 저장 
				 
				this._submit(formData,'Temp'); 
				
			}.bind( this ));
			
			// 자기소개 제출 _ 최종저장
			this._$target.find( '.form_btns .confirm' ).on( 'click', function (e) {
			
				AP.modal.confirm( '최종 제출 하시겠습니까?' ).addListener( 'modal-close', function (e) {
					if ( e.closeType == 'confirm' ) {
						
						this._$target.find('form.validate').submit();
					}
				
				}.bind( this ));
				
					
			}.bind( this ));
		
			// submit
			this._$target.find( 'form.validate' ).validate({
				
				submitHandler: function (form, e) {
					
					var formData = new FormData(form);
					
					if(AP.DISPLAY_MENU_ID === 'beautizen_regist'){
						this._submit(formData, 'nextConfirm'); 
					}
					if(AP.DISPLAY_MENU_ID === 'beautizen_introduce'){
						this._submit(formData, 'confirm');
					}
					
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
		
		_setCopyData :function(data){
				this._htmlTag = null; 
			// 버튼을 누르면 복사할 태그를 저장해둔다 .
				this._htmlTag = '<div class="copy" id="count_'+this._count+'"><button type="button" class="btn_remove" id="count_'+this._count+'">삭제하기<i class="ico_trash"></i></button>'; 
				this._htmlTag += $B.object.clone(data);
				this._htmlTag += '</div>';
				this._count += 1; 
		},
		
		_submit : function(data, submitState){
			
			console.log(submitState); 
		
			//AP.login().done( function () { // 로그인으로 
				this._api = AP.api.requestBeautizen( {}, data ).done(function (result) {
					
					console.log(result.booleanResult);
					
					if(result.booleanResult === 'true'){ // 잘 저장되었으면 
						
						if(submitState === 'Temp'){ // 임시 저장 
							AP.modal.alert( '임시 저장되었습니다.');
						}else if(submitState === 'nextConfirm'){// 임시저장후 자기소개로 이동 
							
							this.dispatch( 'reserve-introduce' );
							
						}else if (submitState === 'Complite'){ // 최종제출이면 처음 화면으로 이동
							
							this.dispatch( 'reserve-complite' ); 
						}
					}
				}.bind( this )).fail(function ( xhr ) {
					console.log( 'error' );
					this._$modal.find( '.form_btns button' ).prop( 'disabled', false );
					this._modal.close();
					if ( xhr.errorCode === 'EAPI004' ) {
						//존재하지 않는 회원
						AP.login({
							trigger: true
						});
					}
				}.bind( this ));
			//}.bind( this ));
		}
		
	});

	AP.beautizenRecruitReserve = new BeautizenRecruitReserve();
})( jQuery );