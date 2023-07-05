package repository.Impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Person;
import entity.Vote;
import org.hibernate.Session;
import repository.PersonRepository;
import repository.VoteRepository;

public class VoteRepositoryImpl extends BaseRepositoryImpl<Vote,Long>
        implements VoteRepository {
private Session session;

    public VoteRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public Class<Vote> getEnityClass() {
        return Vote.class;
    }
}
