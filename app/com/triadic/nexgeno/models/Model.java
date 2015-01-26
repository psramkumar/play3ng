package com.triadic.nexgeno.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

/**
 * Created by psramkumar on 9/25/14.
 *
 */
@Data
public abstract class Model {

    @Id
    String id;
    @Indexed
    String key;
    Date createDate = new Date();
    Date updateDate;
    Boolean enabled = Boolean.TRUE;

    @Transient
    String modelName;

    int version = 0;
}
