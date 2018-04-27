package de.robfri.articles.data;

public class Article {

	private Long id;
	private String name;
	private String description;
	private Double price;

	/**
	 * The standard constructor fills its
	 * fields with standard values
	 */
	public Article() {

        // Notice that the zero values are explicit
        // marked as a Long and Double value using
        // the L and D characters
        //
        // if you are using also a Float value the initializing
        // value must be marked using the F character
        // 
        // This is forced by the Object-Data-Types
        // if you are using long instead of Long
        // and double instead of Double this is not forced
        // but recommended
		
		this.id = 0L;
		this.name = "";
		this.description = "";
		this.price = 0.0D;
	}
	
	/**
	 * The copy constructor copies the values
	 * of the fields from the passed article
	 * into its own fields
	 */
	public Article(Article article) {
		
		this.id = article.id;
		this.name = article.name;
		this.description = article.description;
		this.price = article.price;
	}
	
	/**
	 * The initializing constructor fills
	 * its fields with the passed values
	 */
	public Article(Long id, String name, String description, Double price) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		
		this.id = id;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public String getDescription() {
		
		return description;
	}

	public void setDescription(String description) {
		
		this.description = description;
	}

	public Double getPrice() {
		
		return price;
	}

	public void setPrice(Double price) {
		
		this.price = price;
	}
}
