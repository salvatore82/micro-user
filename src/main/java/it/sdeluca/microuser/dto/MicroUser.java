package it.sdeluca.microuser.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the USER database table.
 * 
 */
@Data
@NoArgsConstructor
public class MicroUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String lastName;
	private String name;
	private MultipartFile multipartFile;
}