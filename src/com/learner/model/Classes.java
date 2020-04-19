package com.learner.model;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="CLASSES")
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="CLASS_ID")
	private int classId;
	@Column(name ="CLASS_NAME")
	private String className;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "CLASSES_STUDENT" , joinColumns ={ @JoinColumn(name ="CLASS_ID")}, inverseJoinColumns = {@JoinColumn(name="STUDENT_ID")})
	private List<Student> student;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable(name = "CLASSES_SUBJECT" , joinColumns ={ @JoinColumn(name = "CLASS_ID") } , inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID") })
	private List<Subject> subject ;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "CLASSES_TEACHER" , joinColumns ={ @JoinColumn(name = "CLASS_ID") } , inverseJoinColumns = { @JoinColumn(name = "TEACHER_ID") })
	private List<Teacher> teacher;
	
	public Classes() {
		
	}
	
	public Classes(String className, List<Student> student, List<Subject> subject, List<Teacher> teacher) {
		this.className = className;
		this.student = student;
		this.subject = subject;
		this.teacher = teacher;
	}
	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
		
	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", student=" + student + ", subject="
				+ subject + ", teacher=" + teacher + "]";
	}

}