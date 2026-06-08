package com.fe.horseracing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "raceReferee")
public class raceReferee extends user {

	public raceReferee() {
		super();
	}
}
