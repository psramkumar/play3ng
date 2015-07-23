/*global angular, APP_MODULE_NAME, APPMODELS */

(function () {
    'use strict';
    angular.module(APP_MODULE_NAME).factory(APPMODELS.app_user, [function () {
        return {
            id: '',
            modelName: APPMODELS.app_user,
            name: '',
            firstName: "",
            lastName: "",
            userName: '',
            password: '',
            active: true,
            email: '',
            description: '',
            roles: []
        };
    }]);
}());