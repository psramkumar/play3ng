package com.triadic.nexgeno.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "User")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model {

    @Transient
    public static final String modelName = "User";

    @Indexed
    String userName;
    String password;
    boolean isActive;
    String name;
    String firstName;
    String lastName;
    String description;
    List<String> roles;
    String email;
}
