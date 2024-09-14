package com.load.demo.controller;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.load.demo.model.shipment;
import com.load.demo.model.shipmentUpdateRequest;
import com.load.demo.service.LoadService;

@RestController
@RequestMapping("api")
public class LoadController {

    @Autowired
    LoadService loadService;

    @PostMapping("load")
    public ResponseEntity<String> addLoad(@RequestBody shipment shipment) {
        return loadService.addLoad(shipment);
    }

    @GetMapping("alload")
    public ResponseEntity<List<shipment>> getAllLoad() {
        return loadService.getAllLoad();
    }

    // getbyshipperid
    @GetMapping("load")
    public ResponseEntity<List<shipment>> getLoadByShipperId(@RequestParam String shipperID) {
        return loadService.getLoadByShipperId(shipperID);
    }

    // update
    @PutMapping("load/{id}")
    public ResponseEntity<String> updateLoadById(@PathVariable Integer id, @RequestBody shipmentUpdateRequest request) {
        try {
            boolean isUpdated = loadService.updateShipment(id, request);
            if (isUpdated) {
                return new ResponseEntity<>("Shipment update sucessfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Shipment not found", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>("Failed to update shipment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete
    @DeleteMapping("load/{id}")
    public ResponseEntity<String> deleteLoadById(@PathVariable Integer id) {
        return loadService.deleteLoadById(id);
    }
}
