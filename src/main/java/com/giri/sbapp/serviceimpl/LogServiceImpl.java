//package com.giri.sbapp.serviceimpl;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.giri.sbapp.model.Log;
//import com.giri.sbapp.repo.LogRepo;
//import com.giri.sbapp.service.LogService;
//
//@Service
//public class LogServiceImpl implements LogService {
//
//	    @Autowired
//	    private LogRepo logRepo;
//
//	    @Override
//	    public Log createLog(Log log) {
//	        return logRepo.save(log);
//	    }
//
//	    @Override
//	    public Log updateLog(Log log) {
//	        return logRepo.save(log);
//	    }
//
//	    @Override
//	    public void deleteLog(Long id) {
//	        logRepo.deleteById(id);
//	    }
//
//	    @Override
//	    public Log getLogById(Long id) {
//	        return logRepo.findById(id).orElse(null);
//	    }
//
//	    @Override
//	    public List<Log> getAllLogs() {
//	        return logRepo.findAll();
//	    }
//
//	    @Override
//	    public List<Log> getLogsByACUnitAndDate(Long acUnitId, LocalDateTime fromTime, LocalDateTime toTime) {
//	        return logRepo.findLogsByACUnitAndDate(acUnitId, fromTime, toTime);
//	    }
//
//}

package com.giri.sbapp.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.sbapp.model.Log;
import com.giri.sbapp.repo.LogRepo;
import com.giri.sbapp.service.LogService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepo logRepo;

    @Override
    public Log createLog(Log log) {
        return logRepo.save(log);
    }

    @Override
    public Log updateLog(Log log) {
        return logRepo.save(log);
    }

    @Override
    public void deleteLog(Long id) {
        logRepo.deleteById(id);
    }

    @Override
    public Log getLogById(Long id) {
        return logRepo.findById(id).orElse(null);
    }

    @Override
    public List<Log> getAllLogs() {
        return logRepo.findAll();
    }

    @Override
    public List<Log> getLogsByACUnitAndDate(Long acUnitId, LocalDate date) {
        return logRepo.findLogsByACUnitAndDate(acUnitId, date);
    }
}

