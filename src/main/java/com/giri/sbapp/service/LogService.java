//package com.giri.sbapp.service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import com.giri.sbapp.model.Log;
//
//public interface LogService {
//	
//	    Log createLog(Log log);
//	    Log updateLog(Log log);
//	    void deleteLog(Long id);
//	    Log getLogById(Long id);
//	    List<Log> getAllLogs();
//	    List<Log> getLogsByACUnitAndDate(Long acUnitId, LocalDateTime fromTime, LocalDateTime toTime);
//
//}

package com.giri.sbapp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.giri.sbapp.model.Log;

public interface LogService {
    Log createLog(Log log);
    Log updateLog(Log log);
    void deleteLog(Long id);
    Log getLogById(Long id);
    List<Log> getAllLogs();
    List<Log> getLogsByACUnitAndDate(Long acUnitId, LocalDate date);
}
