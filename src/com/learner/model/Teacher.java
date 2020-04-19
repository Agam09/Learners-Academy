package com.learner.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TEACHER")
	public class Teacher {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "TEACHER_ID" )
		private int teacherId;
		@Column(name = "TEACHER_NAME")
		private String teacherName;
		
		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name = "SUBJECT_TEACHER" , joinColumns ={@JoinColumn(name="TEACHER_ID")}, inverseJoinColumns={@JoinColumn(name="SUBJECT_ID")})
		private List<Subject> subject;

		public Teacher() {
			
		}
		public Teacher(String teacherName) {
			this.teacherName = teacherName;
		}

		public List<Subject> getSubject() {
			return subject;
		}
		public void setSubject(List<Subject> subject) {
			this.subject = subject;
		}
		
		public int getTeacherId() {
			return teacherId;
		}
		public void setTeacherId(int teacherId) {
			this.teacherId = teacherId;
		}
		public String getTeacherName() {
			return teacherName;
		}
		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}

		@Override
		public String toString() {
			return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + "]";
		}
}
