package it.sdeluca.microuser.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the USER database table.
 * 
 */
@Data
@NoArgsConstructor
public class MicroUser {
	private Integer id;
	private String lastName;
	private String name;
	private MultipartFile multipartFile;
}