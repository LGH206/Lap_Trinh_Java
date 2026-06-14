package com.fe.horseracing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jockeys")
public class Jockey extends User {

	public Jockey() {
		super();
	}
}
