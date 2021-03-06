package com.github.jvegaf.musikbox.context.tracks.infrastructure.persistence;

import com.github.jvegaf.musikbox.context.tracks.domain.Track;
import com.github.jvegaf.musikbox.context.tracks.domain.TrackId;
import com.github.jvegaf.musikbox.context.tracks.domain.TrackRepository;
import com.github.jvegaf.musikbox.shared.domain.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public final class InMemoryTrackRepository implements TrackRepository {

    private final List<Track> tracks = new ArrayList<>();

    @Override
    public void save(Track track) {
        tracks.removeIf(t -> t.id()
                              .equals(track.id()));
        tracks.add(track);
    }

    @Override
    public Optional<Track> search(TrackId id) {
        return tracks.stream()
                     .filter(track -> track.id()
                                           .equals(id))
                     .findFirst();
    }

    @Override
    public List<Track> matching(Criteria criteria) {
        return tracks;
    }
}
