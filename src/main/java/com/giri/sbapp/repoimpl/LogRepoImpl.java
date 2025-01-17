//package com.giri.sbapp.repoimpl;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.giri.sbapp.model.Log;
//import com.giri.sbapp.repo.LogRepo;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
//import jakarta.persistence.TypedQuery;
//import jakarta.transaction.Transactional;
//@Repository
//@Transactional
//public class LogRepoImpl implements LogRepo {
//	
//	@Autowired
//	EntityManager em;
//
//	@Override
//    public Log save(Log log) {
//        if (log.getId() == null) {
//            em.persist(log);
//            return log;
//        } else {
//            return em.merge(log);
//        }
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        Log log = em.find(Log.class, id);
//        if (log != null) {
//            em.remove(log);
//        }
//    }
//
//    @Override
//    public java.util.Optional<Log> findById(Long id) {
//        return java.util.Optional.ofNullable(em.find(Log.class, id));
//    }
//
//    @Override
//    public List<Log> findAll() {
//        TypedQuery<Log> query = em.createQuery("SELECT l FROM Log l", Log.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<Log> findLogsByACUnitAndDate(Long acUnitId, LocalDateTime fromTime, LocalDateTime toTime) {
//        TypedQuery<Log> query = em.createQuery(
//            "SELECT l FROM Log l WHERE l.acUnit.id = :acUnitId AND l.fromTime BETWEEN :fromTime AND :toTime", Log.class);
//        query.setParameter("acUnitId", acUnitId);
//        query.setParameter("fromTime", fromTime);
//        query.setParameter("toTime", toTime);
//        return query.getResultList();
//    }
//
//}

package com.giri.sbapp.repoimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giri.sbapp.model.Log;
import com.giri.sbapp.repo.LogRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class LogRepoImpl implements LogRepo {

	 @PersistenceContext
    private EntityManager em;

    @Override
    public Log save(Log log) {
        if (log.getId() == null) {
            em.persist(log);
            return log;
        } else {
            return em.merge(log);
        }
    }

    @Override
    public void deleteById(Long id) {
        Log log = em.find(Log.class, id);
        if (log != null) {
            em.remove(log);
        }
    }

    @Override
    public java.util.Optional<Log> findById(Long id) {
        return java.util.Optional.ofNullable(em.find(Log.class, id));
    }

    @Override
    public List<Log> findAll() {
        TypedQuery<Log> query = em.createQuery("SELECT l FROM Log l", Log.class);
        return query.getResultList();
    }

    @Override
    public List<Log> findLogsByACUnitAndDate(Long acUnitId, LocalDate date) {
        LocalDateTime from = date.atStartOfDay();
        LocalDateTime to = date.atTime(23, 59, 59);
        TypedQuery<Log> query = em.createQuery(
            "SELECT l FROM Log l WHERE l.acUnit.id = :acUnitId AND l.date = :date", Log.class);
        query.setParameter("acUnitId", acUnitId);
        query.setParameter("date", date);
        return query.getResultList();
    }
}
