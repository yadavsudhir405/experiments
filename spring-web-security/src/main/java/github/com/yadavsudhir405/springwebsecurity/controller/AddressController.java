package github.com.yadavsudhir405.springwebsecurity.controller;

import github.com.yadavsudhir405.springwebsecurity.domain.Address;
import github.com.yadavsudhir405.springwebsecurity.domain.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:8:00 AM
 *         Project:spring-web-security
 */
@RestController
@RequestMapping(path = "/addresses")
public class AddressController {
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostMapping
    public Address addAddress(@RequestBody Address address){
                return addressRepository.save(address);
    }
    @GetMapping
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }
    @DeleteMapping
    public void delete(@RequestBody Address address){
        addressRepository.delete(address);
    }
}
