package com.intech.telecom.dao;


import com.intech.telecom.models.members.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class RoleDaoImpl  implements RoleDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void persist(Role entity) {
		entityManager.persist(entity);
	}

	@Override
	public Role getByKey(Long id) {
		return entityManager.find(Role.class, id);
	}

	@Override
	public List<Role> getAll() {
		return entityManager.createQuery("FROM Role", Role.class).getResultList();
	}

	@Override
	public void update(Role group) {
		entityManager.merge(group);
	}
}
