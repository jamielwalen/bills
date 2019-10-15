package org.launchcode.bills.Models.Data;

import org.launchcode.bills.Models.Bills;
import org.launchcode.bills.Models.Records;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RecordsDao extends CrudRepository<Records, Integer> {
}
