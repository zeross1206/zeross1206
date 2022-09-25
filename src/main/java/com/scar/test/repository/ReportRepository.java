package com.scar.test.repository;

import com.scar.test.domain.Report;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Report entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query("select report from Report report where report.user_report.login = ?#{principal.username}")
    List<Report> findByUser_reportIsCurrentUser();
}
