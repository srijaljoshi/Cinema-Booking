package app.models;

public class Role {

	private int actorID;
	private int movieID;
	private String character;
	
	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
	
	public int getActorID() {
		return actorID;
	}
	
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	
	public int getMovieID() {
		return movieID;
	}
	
	public void setCharacter(String character) {
		this.character = character;
	}
	
	public String getCharacter() {
		return character;
	}
}
