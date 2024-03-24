package com.ho.mythymleaf;

/**
 * packageName    : com.ho.mythymleaf
 * fileName       : Holoman
 * author         : AD2108029P01
 * date           : 2024-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-24        AD2108029P01       최초 생성
 */
public class Holoman {
	String name;
	int howLong;

	@Override
	public String toString() {
		return "Holoman{" +
				"name='" + name + '\'' +
				", howLong=" + howLong +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHowLong() {
		return howLong;
	}

	public void setHowLong(int howLong) {
		this.howLong = howLong;
	}
}
