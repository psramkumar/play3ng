/*global angular, STATICPATH, CONTROLLER, JSONURLS, APPSERVICEURLS */
var APP_MODULE_NAME = "webApp";

var myApp = angular.module(APP_MODULE_NAME, ['ngRoute', 'ngResource', 'ui.bootstrap']);

(function () {
    'use strict';
    
    myApp.constant('appConfig', {
        appRoot: 'views/',
        STATICPATH : {
            app_asset_path: 'assets/',
            app_home_page: 'views/' + 'index',
            app_user_page: 'views/' + 'user/index'
        },
        CONTROLLER: {
            USER_CTRL: "mainController",
            USER_INST_CTRL: "UserInstanceCtrl"
        },
        JSONURLS: {
            app_country_information_json: 'assets/' + 'data/countryInfo.json'
        },
        APPSERVICEURLS: {
            app_get_model_url: '/getModelById',
            app_list_model_url: '/listModel',
            app_save_model_url: '/saveModel',
            app_remove_model_url: '/removeModel',
            app_configurations: '/appConfigurations'
        },
        APPMODELS: {
            app_user: 'User'
        }
    });

    myApp.config(['$routeProvider', '$locationProvider', 'appConfig', function ($routeProvider, $locationProvider, config) {
        var resolveRootScope = function ($args) {
            return ["$rootScope", function ($rootScope) {
                $rootScope.pageName = $args;
                return true;
            }];
        };

        $routeProvider
            .when("/", {
                templateUrl: config.STATICPATH.app_dash_page,
                controller: config.CONTROLLER.DASH_CTRL,
                resolve: {onload: resolveRootScope('home')}
            })
            .when("/user", {
                templateUrl: config.STATICPATH.app_user_page,
                controller: config.CONTROLLER.USER_CTRL,
                resolve: {onload: resolveRootScope('User Home')}
            })
            .otherwise({redirectTo: '/'});

        // use the HTML5 History API
        $locationProvider.html5Mode(false);
    }]);
    
    myApp.run(function ($rootScope, $http, appConfig) {
        $rootScope.isLoggedin = true;
        $rootScope.baseURL = appConfig.STATICPATH.app_asset_path;

        $rootScope.appMenu = [];

        $http.get(appConfig.JSONURLS.app_country_information_json).then(function (response) {
            $rootScope.countryInfo = response.data.geonames;
            $rootScope.stateInfo = response.data.US;
        });

        $http.get(appConfig.APPSERVICEURLS.app_configurations).then(function (response) {
            $rootScope.modelMap = response.data.modelNameMap;
        });
    });
    
}());
