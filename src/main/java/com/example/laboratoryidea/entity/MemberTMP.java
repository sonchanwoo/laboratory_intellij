package com.example.laboratoryidea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NamedQuery(
	name = "MemberTMP.findByUsername",
	query="select m from Member m where m.username = :username"
)
@NoArgsConstructor
//@NamedEntityGraph(name = "Member.all", attributeNodes = @NamedAttributeNode("team"))
public class MemberTMP extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;
	private String username;
	private int age;
/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

	public MemberTMP(String username) {
		this.username = username;
	}

	public MemberTMP(String username, int age, Team team) {
		this.username = username;
		this.age = age;
		if (team != null) {
			changeTeam(team);
		}
	}

	public MemberTMP(String username, int age) {
		this.username = username;
		this.age = age;
	}

	public void changeTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}*/
}
