package com.example.backend_jenkins_app.models;

import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
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
        INJ,
        Radio
    }

    public Group(GroupName groupname) {
        this.groupname = groupname;
        setKPIForGroupname(groupname);
    }

    public void setKPIForGroupname(GroupName groupname) {
        switch (groupname) {
            case SMC:
                KPI = "Default, Facebook, Tiktok";
                break;
            case INFRA:
                KPI = "Google/Youtube, Amazon, TUNIS02.1_Gi";
                break;
            case CORE:
                KPI = "Xviideos, Instagram, TUNIS02.2_Gi";
                break;
            case B2B:
                KPI = "Youtube_TLS, Facebook_Steaming, Netflix";
                break;
            case IP:
                KPI = "NR, 6G, TUNIS01.1_Gi";
                break;
            case ARCHITECTURE_DIMENSIONNEMNT:
                KPI = "NB_IOT, LTE-M, TUNIS01.4_Gi";
                break;
            case DRS:
                KPI = "LTE, Virtual, TUNIS01.2_Gi";
                break;
            case Radio:
                KPI = "GAN, HSPA, TUNIS03.1_Gi";
                break;
            case UAS:
                KPI = "2G, IWLAN, TUNIS03.1_Gi";
                break;
            case INJ:
                KPI = "Unknown, 3G, TUNIS03.2_Gi";
                break;
        }
    }

    @Id
    private String id;

    @Indexed(unique = true)
    private GroupName groupname;

    private String KPI;

    @JsonBackReference
    @DBRef
    private List<User> users = List.of();
}
