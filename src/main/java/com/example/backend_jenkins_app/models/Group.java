package com.example.backend_jenkins_app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "groups")
public class Group {

    public enum GroupName {
        SMC,
        INFRA,
        B2B,
        IP,
        CORE,
        DRS,
        ARCHITECTURE_DIMENSIONNEMNT,
        UAS,
        INJ
    }

    @Id
    private String id;

    @Indexed(unique = true)
    private GroupName groupname;
    
    @DBRef
    private List<User> users;
}