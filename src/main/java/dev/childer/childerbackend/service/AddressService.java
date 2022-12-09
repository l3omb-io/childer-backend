package dev.childer.childerbackend.service;

import dev.childer.childerbackend.models.AddressModel;
import dev.childer.childerbackend.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressModel> findAllAddress(){
        return this.addressRepository.findAll();
    }

    public Optional<AddressModel> findAddressByID(Long id){
        return this.addressRepository.findById(id);
    }

    public AddressModel saveAddress(AddressModel address){
        return this.addressRepository.save(address);
    }

    public Optional<AddressModel> updateAddress(Long id,AddressModel newAddress){
        return addressRepository.findById(id).map(address -> {
            address.setHouseNumber(newAddress.getHouseNumber());
            address.setMoo(newAddress.getMoo());
            address.setTambon(newAddress.getTambon());
            address.setProvince(newAddress.getProvince());
            address.setDistrict(newAddress.getDistrict());

            return addressRepository.save(address);
        });
    }

    public void deleteByID(Long id){
        this.addressRepository.deleteById(id);
    }
}
