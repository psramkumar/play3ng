/*global angular, myApp, CONTROLLER */

(function () {
    'use strict';
    
    myApp.controller(CONTROLLER.MAIN_CTRL, ['$scope', '$http', function ($scope, $http) {
        $scope.message = "";
    }]);
    
    myApp.controller("menus", ['$scope', function ($scope) {

        $scope.appMenu = {home: 'active', ticket: '', favorite: '', admin: ''};

        $scope.setActive = function (menuName) {
            $scope.appMenu = [];
            $scope.appMenu[menuName] =  'active';
        };
    }]);
}());