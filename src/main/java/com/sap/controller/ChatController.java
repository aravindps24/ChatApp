package com.sap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String hello() {

		return "index";
	}

	@RequestMapping(path = "/chatPage", method = RequestMethod.GET)
	public String chat() {

		return "chatPage";
	}
}
