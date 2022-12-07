package dev.childer.childerbackend.controller;

import dev.childer.childerbackend.models.AddressModel;
import dev.childer.childerbackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<AddressModel>> getAllAddress(){
        return new ResponseEntity<>(this.addressService.findAllAddress(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<AddressModel> getOneAddress(@PathVariable Long id){
        return new ResponseEntity<>(this.addressService.findAddressByID(id), HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<AddressModel> postAddress(@RequestBody AddressModel address){
        return new ResponseEntity<>(this.addressService.saveAddress(address), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<AddressModel> putAddress(@PathVariable Long id,@RequestBody AddressModel address){
        return new ResponseEntity<>(this.addressService.updateAddress(id,address), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteAddress(@PathVariable Long id){
        this.addressService.deleteByID(id);
        return new ResponseEntity<>(String.format("has delete."),HttpStatus.OK);
    }
}
