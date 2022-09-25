package com.scar.test.service;

import com.scar.test.domain.Report;
import com.scar.test.repository.ReportRepository;
import com.scar.test.service.dto.ReportDTO;
import com.scar.test.service.mapper.ReportMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Report}.
 */
@Service
@Transactional
public class ReportService {

    private final Logger log = LoggerFactory.getLogger(ReportService.class);

    private final ReportRepository reportRepository;

    private final ReportMapper reportMapper;

    public ReportService(ReportRepository reportRepository, ReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
    }

    /**
     * Save a report.
     *
     * @param reportDTO the entity to save.
     * @return the persisted entity.
     */
    public ReportDTO save(ReportDTO reportDTO) {
        log.debug("Request to save Report : {}", reportDTO);
        Report report = reportMapper.toEntity(reportDTO);
        report = reportRepository.save(report);
        return reportMapper.toDto(report);
    }

    /**
     * Partially update a report.
     *
     * @param reportDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ReportDTO> partialUpdate(ReportDTO reportDTO) {
        log.debug("Request to partially update Report : {}", reportDTO);

        return reportRepository
            .findById(reportDTO.getId())
            .map(existingReport -> {
                reportMapper.partialUpdate(existingReport, reportDTO);

                return existingReport;
            })
            .map(reportRepository::save)
            .map(reportMapper::toDto);
    }

    /**
     * Get all the reports.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ReportDTO> findAll() {
        log.debug("Request to get all Reports");
        return reportRepository.findAll().stream().map(reportMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one report by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ReportDTO> findOne(Long id) {
        log.debug("Request to get Report : {}", id);
        return reportRepository.findById(id).map(reportMapper::toDto);
    }

    /**
     * Delete the report by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Report : {}", id);
        reportRepository.deleteById(id);
    }
}
