package nextstep.subway.station.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.subway.common.BaseEntity;
import nextstep.subway.section.domain.Section;

import javax.persistence.*;

@Entity
public class Station extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
    private List<Section> sections = new ArrayList<>();

    public Station() {
    }

    public Station(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
