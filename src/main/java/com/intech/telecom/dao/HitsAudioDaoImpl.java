package com.intech.telecom.dao;

import com.intech.telecom.models.content.HitsAudio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class HitsAudioDaoImpl implements HitsAudioDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void persist(HitsAudio entity) {
		entityManager.persist(entity);
	}

	@Override
	public HitsAudio getByKey(Long id) {
		return entityManager.find(HitsAudio.class, id);
	}

	@Override
	public List<HitsAudio> getAll() {
		return entityManager.createQuery("FROM HitsAudio").getResultList();
	}

	@Override
	public void update(HitsAudio group) {
		entityManager.merge(group);
	}

	@Override
	public HitsAudio getHitsAudioByPid(Long pid) {
		return entityManager.createQuery("FROM HitsAudio WHERE pid=:pid", HitsAudio.class).setParameter("pid", pid).getSingleResult();
	}

	@Override
	public long getHitsAudioAmount() {
		return entityManager.createQuery("SELECT COUNT(1) FROM HitsAudio", Long.class).getSingleResult();
	}
}
