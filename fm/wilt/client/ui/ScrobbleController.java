package fm.wilt.client.ui;

import fm.wilt.client.jwilt.Api;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ScrobbleController {
	
	@FXML private TextField song;
	@FXML private TextField artist;
	@FXML private TextField album;
	@FXML private Button scrobbleBtn;

	
	public void Scrobble(ActionEvent event) {
		Api.getInstance().postScrobble(getSong(), getArtist(), getAlbum());
	}
	
	/**
	 * Returns song title from <song> input field
	 * @return Song
	 */
	public String getSong() {
		return song.getText();
	}
	
	/**
	 * Returns artist name from <artist> input field
	 * @return Artist
	 */
	public String getArtist() {
		return artist.getText();
	}
	
	/**
	 * Returns album title from <album> input field
	 * @return Album
	 */
	public String getAlbum() {
		return album.getText();
	}
}
