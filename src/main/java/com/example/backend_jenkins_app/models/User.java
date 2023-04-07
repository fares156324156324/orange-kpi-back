package com.example.backend_jenkins_app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor 
@ToString
@Table(name="user")
public class User{


    @Id
	@Column(name="user_id")
	private int userId;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_email")
	private String email;

	@Column(name="password")
	private String password;

	@Enumerated(EnumType.STRING)
	private String role;

    public int getUserId() {
        return this.userId;
    }

    @ManyToOne
	private Group group;

}
