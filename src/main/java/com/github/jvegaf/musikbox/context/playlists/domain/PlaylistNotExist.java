package com.github.jvegaf.musikbox.context.playlists.domain;

import com.github.jvegaf.musikbox.shared.domain.DomainError;

public final class PlaylistNotExist extends DomainError {

    public PlaylistNotExist(PlaylistId id) {
        super("playlist_not_exist", String.format("Playlist with id <%s> does not exist", id.value()));
    }
}
