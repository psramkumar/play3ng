/*global angular, myApp */

(function () {
    'use strict';
    myApp.factory('db', ['$http', '$rootScope', 'appConfig', function ($http, $rootScope, config) {
        return {
            list: function (modelType, callMeBack) {
                $http.get(config.APPSERVICEURLS.app_list_model_url, {
                    params: {
                        modelType: modelType
                    },
                    headers: {
                        'Content-type': 'application/json'
                    }
                }).then(callMeBack);
            },
            get: function (id, modelType, callMeBack) {
                $http.get(config.APPSERVICEURLS.app_get_model_url, {
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
                $http.post(config.APPSERVICEURLS.app_save_model_url, model).then(callMeBack);
            },
            remove: function (id, modelType, callMeBack) {
                $http.post(config.APPSERVICEURLS.app_remove_model_url, {
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