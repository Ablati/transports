package kz.ablati.transport.service;


import kz.ablati.transport.entity.Truck;
import kz.ablati.transport.repository.TruckRepository;
import kz.ablati.transport.utility.ConflictException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TrucksService {
    @Autowired
    private TruckRepository truckRepository;


    public Map<String, Object> getAllTruсks() {
        Map<String, Object> response = new HashMap<>();

        List<Truck> trucks = truckRepository.findAll();
        if(trucks.isEmpty()){
            throw new ConflictException("В базе нет транстпортов!");
        }
        response.put("trucks", trucks);
        response.put("status", 200);
        return response;
    }

    public Map<String, Object> getTruck(Long id) {
        Map<String, Object> response = new HashMap<>();
        if(id == null){
            throw new ConflictException("Укажите id транспорта!");
        }
        Optional<Truck> truck = truckRepository.findById(id);
        checkTruck(truck);
        response.put("truck", truck.get());
        response.put("status", 200);
        return response;
    }

    public Map<String, Object> createTruck(Truck truck) {
        Map<String, Object> response = new HashMap<>();

        if(StringUtils.isBlank(truck.getName()) || truck.getPrice() == null){
            throw new ConflictException("Заполните все поля!");
        }
        truckRepository.save(truck);
        response.put("status", 200);
        return response;
    }

    public Map<String, Object> updateTruck(Long id, Truck truck) {
        Map<String, Object> response = new HashMap<>();
        if(id == null){
            throw new ConflictException("Укажите id транспорта!");
        }
        if(StringUtils.isBlank(truck.getName()) || truck.getPrice() == null){
            throw new ConflictException("Заполните все поля!");
        }

        Optional<Truck> truckOld = truckRepository.findById(id);
        checkTruck(truckOld);


        truckOld.get().setComment(truck.getComment());
        truckOld.get().setPrice(truck.getPrice());
        truckOld.get().setName(truck.getName());
        truckRepository.save(truckOld.get());
        response.put("status", 200);
        return response;
    }



    public Map<String, Object> deleteAllTrucks() {
        Map<String, Object> response = new HashMap<>();
        truckRepository.deleteAll();
        response.put("status", 200);
        return response;
    }

    public Map<String, Object> deleteTruck(Long id) {
        Map<String, Object> response = new HashMap<>();
        if(id == null){
            throw new ConflictException("Укажите id транспорта!");
        }
        Optional<Truck> truck = truckRepository.findById(id);
        checkTruck(truck);
        truckRepository.deleteById(id);
        response.put("status", 200);
        return response;
    }

    private void checkTruck(Optional<Truck> truck) {
        if (!truck.isPresent()) {
            throw new ConflictException("В базе нет транстпорта с указанным id!");

        }
    }
}
