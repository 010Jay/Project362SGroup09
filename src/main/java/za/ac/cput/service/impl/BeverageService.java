package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Beverage;
import za.ac.cput.repository.BeverageRepository;
import za.ac.cput.service.IBeverageService;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class BeverageService implements IBeverageService {
    @Autowired
    private BeverageRepository repository;
    private static BeverageService service=null;

    public static BeverageService getService() {
        if(service==null) {service= new BeverageService();}

        return service;
    }
    @Override
    public Set<Beverage> getBeverageList()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
