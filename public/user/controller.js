/*global myApp, CONTROLLER */

(function () {
    'use strict';
    myApp.controller(CONTROLLER.USER_CTRL, ['$scope', 'UserService', APPMODELS.app_user, '$modal', function ($scope, UserService, User, $modal) {

        $scope.userList = [];

        UserService.listAllFor(APPMODELS.app_user, function(response){
            $scope.userList = response.data;
        });

        $scope.userRoles = [{name: 'Admin User', value: "ADMIN"},
            {name: 'Normal User', value: "NORMAL"},
            {name: 'Internal User', value: "INTERNAL"},
            {name: 'Guest User', value: "GUEST"}];


        $scope.open = function (size, obj) {
            $scope.user = angular.copy(User);
            if(obj){
                $scope.user = obj;
                $scope.user.modelName = APPMODELS.app_user;
            }
            var modalInstance = $modal.open({
                templateUrl: 'user_template.html',
                controller: CONTROLLER.USER_INST_CTRL,
                size: size,
                resolve: {
                    scopeVar: function () {
                        return {
                            user: $scope.user,
                            userList: $scope.userList,
                            userRoles: $scope.userRoles
                        }
                    }
                }
            });

            modalInstance.result.then(function (selectedItem) {
                $scope.selected = selectedItem;
                console.log(selectedItem);
                UserService.save(selectedItem, function(response){
                    $scope.userList = response.data;
                });
            }, function () {
                console.log('Modal dismissed at: ' + new Date());
            });
        };

    }]);

    myApp.controller(CONTROLLER.USER_INST_CTRL, function ($scope, $modalInstance, scopeVar) {

        $scope.user = scopeVar.user;
        $scope.userList = scopeVar.userList;
        $scope.userRoles = scopeVar.userRoles;

        $scope.thisGroup = "";

        $scope.addThis = function(){
            if(!$scope.thisGroup) return;
            var exist = false;
            for(var i=0;i < $scope.user.roles.length;i++){
                if($scope.user.roles[i].value === $scope.thisGroup.value){
                    exist = true;
                }
            }
            if(exist) return;

            $scope.user.roles.push($scope.thisGroup);
            $scope.thisGroup = "";
            console.log($scope.user.roles);
        };

        $scope.removeThis = function(removethis){
            for(var i=0;i < $scope.user.roles.length;i++){
                if($scope.user.roles[i].value === removethis.value){
                    $scope.user.roles.splice(i);
                }
            }
        };

        $scope.addNow = function(){
            $modalInstance.close($scope.user);
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    });
}());