package kz.ablati.transport.repository;

import kz.ablati.transport.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {

}
