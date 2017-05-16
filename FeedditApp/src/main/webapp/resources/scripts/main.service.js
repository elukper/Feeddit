'use strict';

angular.module('feedditApp').factory('LoginResolver',function($resource){
		return {
			Authenticate: $resource('authenticateuser',{},{
				auth: {method: 'POST',
						transformResponse: function(data, headers) {
							var result = data;
							result.$headers = headers;
							return result;
						}
			},
				start: {method: 'GET'}
			})
		};
	});