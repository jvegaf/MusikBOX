package com.github.jvegaf.musikbox.context.playlists.application;

import com.github.jvegaf.musikbox.shared.domain.bus.query.Response;

import java.util.List;

public final class PlaylistsResponse implements Response {

    private final List<PlaylistResponse> playlists;

    public PlaylistsResponse(List<PlaylistResponse> playlists) {this.playlists = playlists;}

    public List<PlaylistResponse> playlists() {return playlists;}
}
