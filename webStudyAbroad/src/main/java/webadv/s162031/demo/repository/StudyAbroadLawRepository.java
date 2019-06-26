package webadv.s162031.demo.repository;

import org.springframework.data.jpa.repository.Query;
import webadv.s162031.demo.entity.StudyAbroadLaw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyAbroadLawRepository extends JpaRepository<StudyAbroadLaw,Long> {
    @Query(value="select rule from StudyAbroadLaw rule where rule.content='normal'")
    List<StudyAbroadLaw> findAllRule();

    @Query(value="select rule from StudyAbroadLaw rule where rule.content='foreign'")
    List<StudyAbroadLaw> findAllForeignRule();

}
