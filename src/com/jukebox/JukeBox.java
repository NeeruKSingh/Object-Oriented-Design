package com.jukebox;

import java.util.Set;

public class JukeBox {
	private CDPlayer cdPlayer;
	private User user;
	private Set<CD> cdCollection;
	private SongSelector songSelector;

	public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts) {
		super();
		this.cdPlayer = cdPlayer;
		this.user = user;
		this.cdCollection = cdCollection;
		this.songSelector = ts;
	}

	public Song getCurrentSong() {
		return songSelector.getCurrentSong();
	}

	public void setUser(User u) {
		this.user = u;
	}

	public CDPlayer getCdPlayer() {
		return cdPlayer;
	}

	public void setCdPlayer(CDPlayer cdPlayer) {
		this.cdPlayer = cdPlayer;
	}

	public Set<CD> getCdCollection() {
		return cdCollection;
	}

	public void setCdCollection(Set<CD> cdCollection) {
		this.cdCollection = cdCollection;
	}

	public SongSelector getTs() {
		return songSelector;
	}

	public void setTs(SongSelector ts) {
		this.songSelector = ts;
	}

	public User getUser() {
		return user;
	}

}
