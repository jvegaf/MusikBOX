package me.jvegaf.musikbox.context.tracks.infrastructure.persistence;

import me.jvegaf.musikbox.context.tracks.domain.Track;
import me.jvegaf.musikbox.context.tracks.domain.TrackId;
import me.jvegaf.musikbox.context.tracks.domain.TrackRepository;
import me.jvegaf.musikbox.shared.domain.Service;
import me.jvegaf.musikbox.shared.domain.criteria.Criteria;
import me.jvegaf.musikbox.shared.infrastructure.persistence.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("musikbox-transaction_manager")
public class SQLiteTrackRepository extends HibernateRepository<Track> implements TrackRepository {
    public SQLiteTrackRepository(@Qualifier("musikbox-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Track.class);
    }

    @Override
    public void save(Track Track) {
        persist(Track);
    }

    @Override
    public Optional<Track> search(TrackId id) {
        return byId(id);
    }

    @Override
    public List<Track> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
