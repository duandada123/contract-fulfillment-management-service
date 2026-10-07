package com.zdph.contract.fulfillment.domain.workorder.repository;

import com.sinogale.jpa.support.BaseRepository;
import com.zdph.contract.fulfillment.domain.workorder.Dispatch;
import org.springframework.data.repository.Repository;

interface DispatchRepository extends BaseRepository<Dispatch, Long> {

}