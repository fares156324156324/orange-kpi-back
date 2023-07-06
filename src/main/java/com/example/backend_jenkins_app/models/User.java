package com.example.backend_jenkins_app.models;

import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "users")
public class User {
    
    @Id
    private String id;

    private String userName;
    private String email;
    private String password;
    
    private String role;


    @JsonBackReference
    @DBRef
    private Group group;

    @Transient
    private String groupName;

    // Getter and setter for groupName field

    public String getGroupName() {
        if (group != null) {
            return group.getGroupname().toString();
        }
        return null;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

