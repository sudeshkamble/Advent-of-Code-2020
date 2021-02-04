package com.sb.demo;

public class PasswordDetails {
	int min;
	int max;
	String letter;
	String password;
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "PasswordDetails [min=" + min + ", max=" + max + ", letter=" + letter + ", password=" + password + "]";
	}
	
}
