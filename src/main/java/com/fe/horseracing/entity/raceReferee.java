package com.fe.horseracing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "raceReferee")
public class RaceReferee extends User {

	public RaceReferee() {
		super();
	}
}
