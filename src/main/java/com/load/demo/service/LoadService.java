package com.load.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.load.demo.dao.LoadDao;
import com.load.demo.model.shipment;
import com.load.demo.model.shipmentUpdateRequest;

@Service
public class LoadService {

    @Autowired
    LoadDao loadDao;

    public ResponseEntity<String> addLoad(shipment shipment) {
        try {
            loadDao.save(shipment);
            return new ResponseEntity<>("added shipment", HttpStatus.CREATED);
        } catch (Exception e) {

            e.printStackTrace();

        }

        return new ResponseEntity<>("failed adding the shipment", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<shipment>> getAllLoad() {
        try {
            return new ResponseEntity<>(loadDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<shipment>> getLoadByShipperId(String shipperId) {
        try {
            return new ResponseEntity<>(loadDao.findByshipperid(shipperId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteLoadById(Integer id) {
        try {
            loadDao.deleteById(id);
            return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("unable to delete load", HttpStatus.BAD_REQUEST);
    }

    public boolean updateShipment(Integer id, shipmentUpdateRequest request) {
        try {
            Optional<shipment> shipmentOpt = loadDao.findById(id);
            System.out.println(shipmentOpt);
            if (shipmentOpt.isPresent()) {
                shipment updatedShipment = shipmentOpt.get();

                if (request.getLoadingpoint() != null) {
                    updatedShipment.setLoadingpoint(request.getLoadingpoint());
                }

                if (request.getUnloadingpoint() != null) {
                    updatedShipment.setUnloadingpoint(request.getUnloadingpoint());
                }

                if (request.getProducttype() != null) {
                    updatedShipment.setProducttype(request.getProducttype());
                }

                if (request.getTrucktype() != null) {
                    updatedShipment.setTrucktype(request.getTrucktype());
                }

                if (request.getNooftrucks() != null) {
                    updatedShipment.setNooftrucks(request.getNooftrucks());
                }

                if (request.getWeight() != null) {
                    updatedShipment.setWeight(request.getWeight());
                }

                if (request.getComment() != null) {
                    updatedShipment.setComment(request.getComment());
                }

                if (request.getShipperid() != null) {
                    updatedShipment.setShipperid(request.getShipperid());
                }

                // Uncomment if shipment date is part of the update and is not null
                // if (request.getShipmentdate() != null) {
                // updatedShipment.setShipmentdate(LocalDate.parse(request.getShipmentdate()));
                // }

                loadDao.save(updatedShipment);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
