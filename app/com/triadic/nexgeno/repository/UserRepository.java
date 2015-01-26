package com.triadic.nexgeno.repository;

import com.triadic.nexgeno.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface UserRepository extends MongoRepository<User, String> {

    @Slf4j
    public class UserListner extends AbstractMongoEventListener<User> {
        @Override
        public void onBeforeConvert(User bean){
            log.debug("Introspect for update date");
            bean.setCreateDate(bean.getCreateDate() == null ? new Date() : bean.getCreateDate());
            bean.setUpdateDate(bean.getUpdateDate() == null ? new Date() : bean.getUpdateDate());
        }
    }
}

