package com.cot.inmemory.repository;

import com.cot.inmemory.model.CampaignHash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignHashRepository extends JpaRepository<CampaignHash, Long> {
}
