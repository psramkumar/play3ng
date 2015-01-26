/*global angular, APP_MODULE_NAME, app_list_nearby_doctors*/

(function () {
    'use strict';
    angular.module(APP_MODULE_NAME).service('UserService', ["db", "$http", function (db, $http) {

        return {
            listAllFor: function (modelName) {
                return db.list(modelName, function(resp){
                    return resp.data;
                });
            },
            save: function (model, callback) {
                return db.save(model, callback);
            },
            remove: function(id, modelName) {
                return db.remove(id, modelName, function(response) {
                    return response.data;
                })
            },
            get: function (id, callback) {
                return db.save(id, modelName, callback);
            }
        };
    }]);
}());