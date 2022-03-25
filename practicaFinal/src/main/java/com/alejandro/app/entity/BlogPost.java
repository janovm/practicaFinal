package com.alejandro.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class BlogPost {

	@Id
	@GeneratedValue
	private Long id;

	private String titulo;

	private String cuerpo;

	@ManyToOne
	private User2 user2;

	// getters and setters
}
