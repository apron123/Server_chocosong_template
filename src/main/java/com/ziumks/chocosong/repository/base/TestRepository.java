package com.ziumks.chocosong.repository.base;

import com.ziumks.chocosong.model.entity.base.SystemMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Entity, JpaRepository 상속받아 간단하게 구현.
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
@Repository("testRepository")
public interface TestRepository extends JpaRepository<SystemMonitoring, String>, TestRepositoryCustom {

}
