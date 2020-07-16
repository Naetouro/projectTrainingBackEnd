package com.projecttraining.repositories;

import com.projecttraining.data.objects.MuscleDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMuscleRepository extends JpaRepository<MuscleDO, Integer> {
}
