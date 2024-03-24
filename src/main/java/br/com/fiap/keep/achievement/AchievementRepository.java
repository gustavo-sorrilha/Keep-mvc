package br.com.fiap.keep.achievement;

import br.com.fiap.keep.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}

