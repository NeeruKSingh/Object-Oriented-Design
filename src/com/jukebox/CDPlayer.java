package com.jukebox;

public class CDPlayer {
	private Playlist playlist;
	private CD cd;

	public CDPlayer(CD c, Playlist p) {
		this.playlist = p;
		this.cd = c;
	}

	public CDPlayer(Playlist p) {
		this.playlist = p;
	}

	public CDPlayer(CD c) {
		this.cd = c;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist p) {
		this.playlist = p;
	}

	public CD getCD() {
		return cd;
	}

	public void setCD(CD c) {
		this.cd = c;
	}

	public void playSong(Song song) {
	}
}
