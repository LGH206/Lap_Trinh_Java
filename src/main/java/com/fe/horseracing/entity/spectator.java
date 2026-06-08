package com.fe.horseracing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spectator")
public class spectator extends user {

	public spectator() {
		super();
	}
}
