package main.java.com.dev.course;

import main.java.com.dev.course.controller.ApiController;

import java.sql.SQLException;

public class App {
	public static void main(String[] args) throws SQLException {
		ApiController apiController = new ApiController();
		apiController.startServerAndExposeEndpoints();
	}
}
