package com.load.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.load.demo.model.shipment;

@Repository
public interface LoadDao extends JpaRepository<shipment, Integer> {

    List<shipment> findByshipperid(String shipperid);

}
