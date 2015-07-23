package com.triadic.nexgeno.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.triadic.nexgeno.models.User;
import com.triadic.nexgeno.services.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import play.libs.Json;

import java.util.HashMap;
import java.util.Map;

import static com.triadic.nexgeno.common.AppConstants.errorResponse;
import static com.triadic.nexgeno.common.AppConstants.modelNameMap;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static play.Logger.debug;
import static play.libs.Json.toJson;

@Controller
public class Application extends play.mvc.Controller {

    @Autowired
    private ApplicationServices applicationServices;

    public play.mvc.Result index() {
        //User u = new User("Ramkumar", "password", true, Arrays.asList("ROLE","NEW"));
        //u.setId(DateTime.now().toDateTimeISO().toString("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        //applicationServices.save(u);*/

        return ok(views.html.index.render("Your new application is ready."));
    }

    public play.mvc.Result appConfigurations(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("modelNameMap", modelNameMap);
        return ok(toJson(map));
    }

    public play.mvc.Result getModelList(String modelType){
        JsonNode response = toJson(errorResponse);
        //In this place you can also use UserRepository
        if(equalsIgnoreCase(User.modelName, modelType)) {
            response = toJson(applicationServices.findAll(User.class));
        }
        return ok(response);
    }

    public play.mvc.Result saveModel(){
        JsonNode source = request().body().asJson();
        System.out.println(source);

        if(null == source){
            return ok("{status: notOk }");
        }

        debug(source.toString());

        String modelType = source.get("modelName").asText();

        ObjectNode obj =(ObjectNode) source;
        obj.remove("modelName");

        if(equalsIgnoreCase(User.modelName, modelType)) {
            User  model = Json.fromJson(source, User.class);
            applicationServices.saveUpdateModel(model);
        }
        return getModelList(modelType);
    }

    public play.mvc.Result getModelById(String modelType, String id){
        JsonNode response = toJson(errorResponse);
        if(equalsIgnoreCase(User.modelName, modelType)) {
            response = toJson(applicationServices.findById(id, User.class));
        }
        return ok(response);
    }

    public play.mvc.Result removeModel(){
        JsonNode source = request().body().asJson();
        System.out.println(source);

        if(null == source){
            return ok("{status: notOk }");
        }

        debug(source.toString());

        String modelType = source.get("modelName").asText();
        String id = source.get("id").asText();

        if(equalsIgnoreCase(User.modelName, modelType)) {
            applicationServices.removeModel(id, User.class);
        }
        return getModelList(modelType);
    }
}
