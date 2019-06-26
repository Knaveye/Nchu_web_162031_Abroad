package webadv.s162031.demo.repository;

import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.StudyAnnounce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyAnnounceRepository extends JpaRepository<StudyAnnounce,Long> {
    List<StudyAnnounce> findAllBySchoolmanage(Schoolmanage schoolmanage);
}
