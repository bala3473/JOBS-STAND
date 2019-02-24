package emp.enq.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user_jobs")
public class User {
	@Id
	private String email;
	@Column(nullable=false)
	private String possword;
	@Column(nullable=false)
   private String role;
   private String firstname;
   private String lastname;
   @Column(unique=true)
   private String phonenumber;
   @Column(name="online_status")
   private boolean online;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPossword() {
	return possword;
}
public void setPossword(String possword) {
	this.possword = possword;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public boolean isOnline() {
	return online;
}
public void setOnline(boolean online) {
	this.online = online;
}
   
}
