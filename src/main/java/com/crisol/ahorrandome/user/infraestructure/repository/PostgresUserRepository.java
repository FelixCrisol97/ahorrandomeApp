package com.crisol.ahorrandome.user.infraestructure.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.crisol.ahorrandome.user.domain.User;
import com.crisol.ahorrandome.user.domain.UserRepository;
import com.crisol.ahorrandome.user.infraestructure.entity.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class PostgresUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(User user) {
        UserEntity entity = UserEntity.fromDomain(user);
        entityManager.persist(entity);
    }

    @Override
    public User findById(UUID id) {
        UserEntity entity = entityManager.find(UserEntity.class, id);
        return entity != null ? entity.toDomain() : null;
    }

    @Override
    public User findByEmail(String email) {
        var query = entityManager.createQuery(
                "SELECT u FROM UserEntity u WHERE u.email = :email",
                UserEntity.class);
        query.setParameter("email", email);
        var result = query.getResultStream().findFirst();
        return result.map(UserEntity::toDomain).orElse(null);
    }

    @Override
    public boolean existsByEmail(String email) {
        var query = entityManager.createQuery(
                "SELECT COUNT(u) FROM UserEntity u WHERE u.email = :email",
                Long.class);
        query.setParameter("email", email);
        Long count = query.getSingleResult();
        return count > 0;
    }

}