package dev.childer.childerbackend.service;

import dev.childer.childerbackend.models.AddressModel;
import dev.childer.childerbackend.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressModel> findAllAddress(){
        return this.addressRepository.findAll();
    }

    public AddressModel findAddressByID(Long id){
        return this.addressRepository.getReferenceById(id);
    }

    public AddressModel saveAddress(AddressModel address){
        return this.addressRepository.save(address);
    }

    public AddressModel updateAddress(Long id,AddressModel address){
        AddressModel a = findAddressByID(id);

        a.setHouseNumber(address.getHouseNumber());
        a.setMoo(address.getMoo());
        a.setTambon(address.getTambon());
        a.setProvince(address.getProvince());
        a.setDistrict(address.getDistrict());

        addressRepository.save(a);
        return a;
    }

    public void deleteByID(Long id){
        this.addressRepository.deleteById(id);
    }
}
