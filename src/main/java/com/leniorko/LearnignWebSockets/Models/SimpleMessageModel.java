package com.leniorko.LearnignWebSockets.Models;

import lombok.Data;

@Data
public class SimpleMessageModel {
	Integer id;
	String name;
	String message;
	Integer nextID;
}
