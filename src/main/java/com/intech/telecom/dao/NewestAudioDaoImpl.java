package com.intech.telecom.dao;

import com.intech.telecom.models.content.NewestAudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class NewestAudioDaoImpl implements NewestAudioDao {

	@PersistenceContext
	EntityManager entityManager;


	@Override
	public void persist(NewestAudio entity) {
		entityManager.persist(entity);
	}

	@Override
	public NewestAudio getByKey(Long id) {
		return entityManager.find(NewestAudio.class, id);
	}

	@Override
	public List<NewestAudio> getAll() {
		return entityManager.createQuery("FROM NewestAudio", NewestAudio.class).getResultList();
	}

	@Override
	public void update(NewestAudio group) {
		entityManager.merge(group);
	}

	@Override
	public NewestAudio getNewestAudioByPid(Long pid) {
		return entityManager.createQuery("FROM NewestAudio WHERE pid=:pid", NewestAudio.class).setParameter("pid", pid).getSingleResult();
	}

	@Override
	public long getNewestAudioAmount() {
		return entityManager.createQuery("SELECT COUNT(1) FROM NewestAudio", Long.class).getSingleResult();
	}
}
