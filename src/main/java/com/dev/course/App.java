package main.java.com.dev.course;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class App {
	public static void main(String[] args) {

		get("/hello", (request, response) -> {
			response.type("application/json");
			Map locations = new HashMap<>();
			locations.put("name", "Adrian");
			locations.put("surname", "Santa");

			return new Gson().toJson(locations);
		});
	}
}
