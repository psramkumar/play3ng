/**
 * Created by psramkumar on 9/30/2014.
 * Directory which holds all the available routs and common names
 * which can be accessed through out the application
 */
var appRoot = 'views/';

var STATICPATH = {
    app_asset_path: 'assets/',
    app_home_page: appRoot + 'index',
    app_user_page: appRoot + 'user/index'
};

var CONTROLLER = {
    USER_CTRL: "mainController",
    USER_INST_CTRL: "UserInstanceCtrl"
};

var JSONURLS = {
    app_doctor_information_json: STATICPATH.app_asset_path + 'data/countryInfo.json'
};

var APPSERVICEURLS = {
    app_get_model_url: '/getModelById',
    app_list_model_url: '/listModel',
    app_save_model_url: '/saveModel',
    app_remove_model_url: '/removeModel',
    app_configurations: '/appConfigurations'
};

var APPMODELS = {
    app_user: 'User'
};