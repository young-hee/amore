/**
 * 리뷰 리스트 (상품상세)
 */
;(function ( $ ) {
	'use strict';

	var ReviewList = $B.Class.extend({

		/**
		 * @param {jQuery}	$target		대상영역
		 * @param {Object}	params		api 호출에 필요한 params
		 */
		initialize: function ( $target, params ) {
			this._$target = $target;
			this._params = {};
			this.reset( params );
		},

		/** =============== Public Methods =============== */

		/**
		 * 리스트 재설정 후 그리기
		 * @param {Object}	params	api param data
		 */
		reset: function ( params ) {
			this._params = $B.object.extend( this._params, params );
			this._getData( 0 );
		},


		/** =============== Private Methods =============== */

		_setEvents: function (e) {
			//slide resize
			AP.responsiveWidth.addListener( 'resize', function (e) {
				this._$target.ixSlideMax( 'resize' );
			}.bind(this));
		},

		_getData: function ( offset ) {
			if ( this._api ) this._api.abort();

			this._api = AP.api.getReviewList( null, $B.object.extend(this._params, {offset: offset}, false) )
				.done( function ( result ) {
					var data = result.prodReviewListInfo;
					this._draw( data );
				}.bind(this))
				.fail( function ( xhr ) {
					//
				}.bind(this));
		},

		_draw: function ( data ) {
			var html = AP.common.getTemplate( 'common.review-list', $B.object.extend(data, {topReviewOnlyYn: this._params.topReviewOnlyYn}) );

			//remove
			this._$target.find( '.pagination' ).paging( 'clear' ).off( 'paging-change' );
			this._$target.find( '.review_detail' ).off( 'click' );

			//draw
			this._$target.html( html ).show();

			//리뷰가 없으면 감추기
			if ( this._params.topReviewOnlyYn === 'Y' && !data.totalCount ) {
				this._$target.hide();
			}

			this._$target.find( '.pagination' ).paging({
				offset: data.offset,
				limit: data.limit,
				totalCount: data.totalCount
			}).on( 'paging-change', function (e) {
				this._getData( e.offset );
			}.bind(this));

			//상세보기
			this._$target.find( '.review_detail' ).on( 'click', function (e) {
				this._openDetail( data, $(e.currentTarget).data('prod-review-sn') );
			}.bind(this));

			if ( this._params.topReviewOnlyYn === 'Y' ) {
				this._$target.ixSlideMax( 'clear' ).ixSlideMax();
			}
		},

		_openDetail: function ( data, prodReviewSn ) {
			AP.modal.full({
				title: '리뷰/후기',
				contents: {
					templateKey: 'common.review-detail-modal',
					templateModel: _.findWhere( data.prodReviewList, {prodReviewSn: prodReviewSn} )
				},
				containerClass: 'review'
			});
		}

	});


	AP.ReviewList = ReviewList;
})( jQuery );