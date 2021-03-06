package com.github.jvegaf.musikbox.context.tracks.application;

import com.github.jvegaf.musikbox.shared.domain.TrackResponse;
import com.github.jvegaf.musikbox.shared.domain.bus.query.Response;

import java.util.List;

public final class TracksResponse implements Response {

    private final List<TrackResponse> tracks;

    public TracksResponse(List<TrackResponse> tracks) {this.tracks = tracks;}

    public List<TrackResponse> tracks() {return tracks;}
}
