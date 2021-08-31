package com.example.budjet_spring.services;

import com.example.budjet_spring.entity.Month;
import com.example.budjet_spring.entity.Year;

import java.time.YearMonth;
import java.util.List;

/**
 * Created by .
 */
public interface YearService {
    List<Year> getAllYear(Long budget);

    List<Month> getAllMonth(Long idYear);

    void addMonth(YearMonth yearMonth, Long idYear);

    void deleteMonth(Long idYear);

    boolean existMonth(Long idYear,YearMonth yearMonth);
}
