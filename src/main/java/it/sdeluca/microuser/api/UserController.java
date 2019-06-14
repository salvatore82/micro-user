package it.sdeluca.microuser.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.sdeluca.microuser.dto.MicroUser;
import it.sdeluca.microuser.service.UserService;

@RestController
@RequestMapping(path = "/users")
@Api(value = "User management")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ObjectMapper objectMapper;

	@ApiOperation("Create user and return id")
	@PostMapping
	public Integer createUser(
			@ApiParam(value = "JSON object with user data (name, lastname)", required = true) @RequestPart(value = "user") String user,
			@ApiParam(value = "Identity document file", required = true) @RequestPart(value = "document") MultipartFile document)
			throws Exception {
		MicroUser microUser = objectMapper.readValue(user, MicroUser.class);
		microUser.setMultipartFile(document);
		return userService.saveUser(microUser).getId();
	}
}