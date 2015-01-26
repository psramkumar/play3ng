/*global angular, STATICPATH, CONTROLLER, JSONURLS, APPSERVICEURLS */

var APP_MODULE_NAME = "webApp";

var myApp = angular.module(APP_MODULE_NAME,
    ['ngRoute', 'ngResource', 'ui.bootstrap']);
myApp.controller(CONTROLLER.MAIN_CTRL, ['$scope', '$http', function ($scope, $http) {
    'use strict';

    $scope.message = "";

}]);

(function () {
    'use strict';
    myApp.controller("menus", ['$scope', function ($scope) {

        $scope.appMenu = {home: 'active', ticket: '', favorite: '', admin: ''};

        $scope.setActive = function (menuName){
            $scope.appMenu = [];
            $scope.appMenu[menuName] =  'active';
        };
    }]);
}());

myApp.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    'use strict';
    var resolveRootScope = function ($args) {
        return ["$rootScope", function ($rootScope) {
            $rootScope.pageName = $args;
            return true;
        }];
    };

    $routeProvider
        .when("/", {
            templateUrl: STATICPATH.app_dash_page,
            controller: CONTROLLER.DASH_CTRL,
            resolve: {onload: resolveRootScope('home')}
        })
        .when("/user", {
            templateUrl: STATICPATH.app_user_page,
            controller: CONTROLLER.USER_CTRL,
            resolve: {onload: resolveRootScope('User Home')}
        })
        .otherwise({redirectTo: '/'});

    // use the HTML5 History API
    $locationProvider.html5Mode(false);
}]);

myApp.run(function ($rootScope, $http) {
    'use strict';
    $rootScope.isLoggedin = true;
    $rootScope.baseURL = STATICPATH.app_asset_path;

    $rootScope.appMenu = [];

    $http.get(JSONURLS.app_geo_information_json).then(function (response) {
        $rootScope.countryInfo = response.data.geonames;
        $rootScope.stateInfo = response.data.US;
    });

    $http.get(APPSERVICEURLS.app_configurations).then(function (response) {
        $rootScope.modelMap = response.data.modelNameMap;
    });
});
