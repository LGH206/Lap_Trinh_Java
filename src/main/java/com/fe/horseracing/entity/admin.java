package com.fe.horseracing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class admin extends user {
	
	public admin() {
		super();
	}

}
