package webadv.s162031.demo.repository;

import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.StudyAbroad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyAbroadRepository extends JpaRepository<StudyAbroad,Long> {
    List<StudyAbroad> findAllBySchoolmanage(Schoolmanage schoolmanage);
}
