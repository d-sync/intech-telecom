package com.intech.telecom.dao;

import com.intech.telecom.models.content.Audio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AudioDaoimpl implements AudioDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void persist(Audio entity) {
		entityManager.persist(entity);
	}

	@Override
	public Audio getByKey(Long id) {
		return entityManager.find(Audio.class, id);
	}

	@Override
	public List<Audio> getAll() {
		return entityManager.createQuery("FROM Audio", Audio.class).getResultList();
	}

	@Override
	public void update(Audio group) {
		entityManager.merge(group);
	}

	@Override
	public Audio getNextAudioInAccount(String msisdn, Long id) {
		List<Audio> audios = entityManager.createQuery("SELECT a FROM User u " +
				"JOIN u.audios a " +
				"WHERE u.msisdn=:msisdn " +
				"AND a.id >:id " +
				"ORDER BY a.id", Audio.class)
				.setParameter("msisdn", msisdn)
				.setParameter("id", id)
				.setMaxResults(1)
				.getResultList();
		if (audios.isEmpty()) {
			audios = entityManager.createQuery("SELECT a FROM User u " +
					"JOIN u.audios a " +
					"WHERE u.msisdn=:msisdn " +
					"AND a.id >:id " +
					"ORDER BY a.id", Audio.class)
					.setParameter("msisdn", msisdn)
					.setParameter("id", 0L)
					.setMaxResults(1)
					.getResultList();
		}
		if (audios.isEmpty()) {
			return null;
		}
		return audios.get(0);
	}

	@Override
	public Audio getNextPopularAudio(Long id) {
		List<Audio> audios = entityManager.createQuery("FROM Audio a " +
				"WHERE a.id>:id " +
				"AND a.isPopular=true " +
				"ORDER BY a.id", Audio.class)
				.setParameter("id", id)
				.setMaxResults(1)
				.getResultList();

		if (audios.isEmpty()) {
			audios = entityManager.createQuery("FROM Audio a " +
					"WHERE a.id>:id " +
					"AND a.isPopular=true " +
					"ORDER BY a.id", Audio.class)
					.setParameter("id", 0L)
					.setMaxResults(1)
					.getResultList();
		}
		if (audios.isEmpty()) {
			return null;
		}
		return audios.get(0);
	}

	@Override
	public Audio getNextHitsAudio(Long id) {
		List<Audio> audios = entityManager.createQuery("FROM Audio a " +
				"WHERE a.id>:id " +
				"AND a.isHit=true " +
				"ORDER BY a.id", Audio.class)
				.setParameter("id", id)
				.setMaxResults(1)
				.getResultList();

		if (audios.isEmpty()) {
			audios = entityManager.createQuery("FROM Audio a " +
					"WHERE a.id>:id " +
					"AND a.isHit=true " +
					"ORDER BY a.id", Audio.class)
					.setParameter("id", 0L)
					.setMaxResults(1)
					.getResultList();
		}
		if (audios.isEmpty()) {
			return null;
		}
		return audios.get(0);
	}

	@Override
	public Audio getNexNewesttAudio(Long id) {
		List<Audio> audios = entityManager.createQuery("FROM Audio a " +
				"WHERE a.id>:id " +
				"AND a.isNew=true " +
				"ORDER BY a.id", Audio.class)
				.setParameter("id", id)
				.setMaxResults(1)
				.getResultList();

		if (audios.isEmpty()) {
			audios = entityManager.createQuery("FROM Audio a " +
					"WHERE a.id>:id " +
					"AND a.isNew=true " +
					"ORDER BY a.id", Audio.class)
					.setParameter("id", 0L)
					.setMaxResults(1)
					.getResultList();
		}
		if (audios.isEmpty()) {
			return null;
		}
		return audios.get(0);
	}


}
