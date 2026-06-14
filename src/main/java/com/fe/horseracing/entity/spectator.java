package com.fe.horseracing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spectator")
public class Spectator extends User {

	public Spectator() {
		super();
	}
}
