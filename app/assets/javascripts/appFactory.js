/*global angular, APP_MODULE_NAME, APPSERVICEURLS */

(function () {
    'use strict';
    angular.module(APP_MODULE_NAME).factory('db', ['$http', '$rootScope', function ($http, $rootScope) {
        return {
            list: function (modelType, callMeBack) {
                $http.get(APPSERVICEURLS.app_list_model_url, {
                    params: {
                        modelType: modelType
                    }
                }).then(callMeBack);
            },
            get: function (id, modelType, callMeBack) {
                $http.get(APPSERVICEURLS.app_get_model_url, {
                    params: {
                        id: id,
                        modelType: modelType
                    }
                }).then(callMeBack);
            },
            save: function (model, callMeBack) {
                if (!model.id) {
                    model.id = new Date().toISOString();
                }
                $http.post(APPSERVICEURLS.app_save_model_url, model).then(callMeBack);
            },
            remove: function (id, modelType, callMeBack) {
                $http.post(APPSERVICEURLS.app_remove_model_url, {
                    params: {
                        id: id,
                        modelType: modelType
                    }
                }).then(callMeBack);
            },
            getModelMap : function (modelName) { return $rootScope.modelMap[modelName]; }
        };
    }]);
}());