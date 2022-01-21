package me.jvegaf.musikbox.context.playlists.application.find;

import me.jvegaf.musikbox.context.playlists.application.PlaylistResponse;
import me.jvegaf.musikbox.context.playlists.domain.PlaylistId;
import me.jvegaf.musikbox.context.playlists.domain.PlaylistNotExist;
import me.jvegaf.musikbox.context.playlists.domain.PlaylistRepository;
import me.jvegaf.musikbox.shared.domain.Service;

@Service
public final class PlaylistFinder {

    private final PlaylistRepository repository;

    public PlaylistFinder(PlaylistRepository repository) {
        this.repository = repository;
    }

    public PlaylistResponse find(PlaylistId id) throws PlaylistNotExist {
        return repository.search(id).map(PlaylistResponse::fromAggregate).orElseThrow(() -> new PlaylistNotExist(id));
    }
}
