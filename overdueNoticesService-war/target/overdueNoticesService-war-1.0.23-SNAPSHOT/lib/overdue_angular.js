/**
 * 
 */

var app = angular.module("overdueService", []);
app.run(function($rootScope) {
    $rootScope.library = $location.search().library;
});
app.controller("readOverdueNotices", function($scope){
		
	$http.get("/overdue/rest/data/report/" + library)
    .then(function(response) {
        $scope.notices = response.data;
    });
});

app.service("noticePresentation", function(){
	var library = $location.search().library;
	
	this.presentation = function(barcode){
		$http.get("/overdue/rest/data/presentation/" + library + "/" + barcode)
	    .then(function(response) {
	        $scope.presentation = response.data;
	    });
	}
	
})

app.filter("overdueNoticePresentation", ["noticePresentation", function(noticePresentation){
	
	return function(barcode){
		return noticePresentation(barcode);
	};
	
}]);

