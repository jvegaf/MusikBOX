package com.github.jvegaf.musikbox.context.playlists.infrastructure.persistence;

import com.github.jvegaf.musikbox.context.playlists.domain.Playlist;
import com.github.jvegaf.musikbox.context.playlists.domain.PlaylistId;
import com.github.jvegaf.musikbox.context.playlists.domain.PlaylistRepository;
import com.github.jvegaf.musikbox.shared.domain.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public final class InMemoryPlaylistRepository implements PlaylistRepository {

    private final List<Playlist> playlists = new ArrayList<>();

    @Override
    public void save(Playlist playlist) {
        this.playlists.add(playlist);
    }

    @Override
    public Optional<Playlist> search(PlaylistId id) {
        return playlists.stream()
                        .filter(playlist -> playlist.id()
                                                    .equals(id))
                        .findFirst();
    }

    @Override
    public List<Playlist> matching(Criteria criteria) {
        return playlists;
    }

}
