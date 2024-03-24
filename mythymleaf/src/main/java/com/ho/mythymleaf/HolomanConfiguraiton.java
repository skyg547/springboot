package com.ho.mythymleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.ho.mythymleaf
 * fileName       : HolomanConfiguraiton
 * author         : AD2108029P01
 * date           : 2024-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-24        AD2108029P01       최초 생성
 */

@Configuration
public class HolomanConfiguraiton {

	@Bean
	public Holoman holoman() {
		Holoman holoman = new Holoman();
		holoman.setHowLong(5);
		holoman.setName("Ho");
		return holoman;

	}
}
