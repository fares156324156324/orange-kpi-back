package com.example.backend_jenkins_app.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Field("id")
    private String groupId; // Use String type for auto-generated IDs

    private GroupName groupname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
    @ToString.Exclude
    private List<User> users;
}
