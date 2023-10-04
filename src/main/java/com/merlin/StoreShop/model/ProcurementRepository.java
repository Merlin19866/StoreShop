package com.merlin.StoreShop.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProcurementRepository extends CrudRepository<Procurement, Integer>
{
    Procurement save(Procurement procurement);
    List<Procurement>findAllByOrderById();
    void delete(Procurement procurement);
}
