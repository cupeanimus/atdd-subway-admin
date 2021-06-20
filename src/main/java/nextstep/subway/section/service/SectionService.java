package nextstep.subway.section.service;

import nextstep.subway.section.domain.Section;
import nextstep.subway.section.domain.SectionRepository;
import nextstep.subway.station.application.StationService;
import nextstep.subway.station.domain.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectionService {
    private final StationService stationService;
    private final SectionRepository sectionRepository;

    public SectionService(StationService stationService, SectionRepository sectionRepository) {
        this.stationService = stationService;
        this.sectionRepository = sectionRepository;
    }

    public Section saveSection(long upStationId, long downStationId, int distance) {
        Station upStation = stationService.findStation(upStationId);
        Station downStation = stationService.findStation(downStationId);
        return save(Section.of(upStation, downStation, distance));
    }

    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    public void delete(Section deletableSection) {
        sectionRepository.delete(deletableSection);
    }
}
