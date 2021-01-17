package kz.ablati.transport.controller;


import kz.ablati.transport.entity.Truck;
import kz.ablati.transport.service.TrucksService;
import kz.ablati.transport.utility.ConflictException;
import kz.ablati.transport.utility.ExceptionResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TrucksController {

    @Autowired
    private TrucksService trucksService;

    @GetMapping("/trucks")
    ResponseEntity<Map<String, Object>> getAllTrucks() {
        try {
            Map<String, Object> response = trucksService.getAllTruсks();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ConflictException ext) {
            return new ResponseEntity<>(ExceptionResponseBase.create(ext.getMessage(), ext.getStatus()), HttpStatus.valueOf(ext.getStatus()));
        } catch (Exception exc) {
            return new ResponseEntity<>(ExceptionResponseBase.create(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.FORBIDDEN);
        }
    }


    @GetMapping("/trucks/{id}")
    ResponseEntity<Map<String, Object>> getAllTrucks(@PathVariable(value = "id") Long id) {
        try {
            Map<String, Object> response = trucksService.getTruck(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ConflictException ext) {
            return new ResponseEntity<>(ExceptionResponseBase.create(ext.getMessage(), ext.getStatus()), HttpStatus.valueOf(ext.getStatus()));
        } catch (Exception exc) {
            return new ResponseEntity<>(ExceptionResponseBase.create(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/trucks")
    ResponseEntity<Map<String, Object>> createTruck(@RequestBody Truck truck) {
        try {
            Map<String, Object> response = trucksService.createTruck(truck);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ConflictException ext) {
            return new ResponseEntity<>(ExceptionResponseBase.create(ext.getMessage(), ext.getStatus()), HttpStatus.valueOf(ext.getStatus()));
        } catch (Exception exc) {
            return new ResponseEntity<>(ExceptionResponseBase.create(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/trucks/{id}")
    ResponseEntity<Map<String, Object>> updateTruck(@PathVariable(value = "id") Long id,
                                                     @RequestBody Truck truck) {
        try {
            Map<String, Object> response = trucksService.updateTruck(id, truck);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ConflictException ext) {
            return new ResponseEntity<>(ExceptionResponseBase.create(ext.getMessage(), ext.getStatus()), HttpStatus.valueOf(ext.getStatus()));
        } catch (Exception exc) {
            return new ResponseEntity<>(ExceptionResponseBase.create(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/trucks")
    ResponseEntity<Map<String, Object>> deleteAllTrucks() {
        try {
            Map<String, Object> response = trucksService.deleteAllTrucks();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ConflictException ext) {
            return new ResponseEntity<>(ExceptionResponseBase.create(ext.getMessage(), ext.getStatus()), HttpStatus.valueOf(ext.getStatus()));
        } catch (Exception exc) {
            return new ResponseEntity<>(ExceptionResponseBase.create(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/trucks/{id}")
    ResponseEntity<Map<String, Object>> deleteTruck(@PathVariable(value = "id") Long id) {
        try {
            Map<String, Object> response = trucksService.deleteTruck(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ConflictException ext) {
            return new ResponseEntity<>(ExceptionResponseBase.create(ext.getMessage(), ext.getStatus()), HttpStatus.valueOf(ext.getStatus()));
        } catch (Exception exc) {
            return new ResponseEntity<>(ExceptionResponseBase.create(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.FORBIDDEN);
        }
    }



}
