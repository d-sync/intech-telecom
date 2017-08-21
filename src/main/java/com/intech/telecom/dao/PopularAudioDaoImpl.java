package com.intech.telecom.dao;

import com.intech.telecom.models.content.PopularAudio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class PopularAudioDaoImpl implements PopularAudioDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public long getPopularAudioAmount() {
		return entityManager.createQuery("SELECT COUNT (a.id) " +
				"FROM PopularAudio a", Long.class)
				.getSingleResult();
	}

	@Override
	public PopularAudio getByPid(long pid) {
		return entityManager.createQuery("FROM PopularAudio a " +
				"WHERE a.pid=:pid", PopularAudio.class)
				.setParameter("pid", pid)
				.getSingleResult();
	}

	@Override
	public void persist(PopularAudio entity) {
		entityManager.persist(entity);
	}

	@Override
	public PopularAudio getByKey(Long id) {
		return entityManager.find(PopularAudio.class, id);
	}

	@Override
	public List<PopularAudio> getAll() {
		return entityManager.createQuery("FROM PopularAudio", PopularAudio.class).getResultList();
	}

	@Override
	public void update(PopularAudio group) {
		entityManager.merge(group);
	}

}
