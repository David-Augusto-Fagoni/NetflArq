package model;

public class Serie {
	String major_genre = "";
	String title = "";
	String subgenre = "";
	int premire_year;
	String episodes = "";
	String status = "";
	int imdb_rating;
	


	public void Serie (String major_genre,String title,String subgenre,int premire_year,String episodes,String status,int imdb_rating) {
		this.major_genre = major_genre;
		this.title = title;
		this.subgenre = subgenre;
		this.premire_year = premire_year;
		this.episodes = episodes;
		this.status = status;
		this.imdb_rating = imdb_rating;
	}
	public String getMajor_genre() {
		return major_genre;
	}

	public String getTitle() {
		return title;
	}

	private String getSubgenre() {
		return subgenre;
	}

	public int getPremire_year() {
		return premire_year;
	}

	public String getEpisodes() {
		return episodes;
	}

	public String getStatus() {
		return status;
	}

	public int getImdb_rating() {
		return imdb_rating;
	}
}
