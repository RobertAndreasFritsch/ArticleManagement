package de.robfri.articles.data;

import java.util.*;

public class Articles {

	public static Article fromCSV(String csv) throws IllegalArgumentException {

		return fromArgs(csv.split(","));
	}

	public static String toCSV(Article article) {

		return String.format("%s,%s,%s,%s",
				article.getId(),
				article.getName(),
				article.getDescription(),
				article.getPrice());
	}

	public static Article fromArgs(String... values) throws IllegalArgumentException {

		if (values.length != 4) {
			
			throw new IllegalArgumentException("values: " + Arrays.toString(values) + " has a wrong format!");
		}

		Long id            = Long.valueOf(values[0]);
		String name        = values[1];
		String description = values[2];
		Double price       = Double.valueOf(values[3]);

		return new Article(id, name, description, price);
	}
}
