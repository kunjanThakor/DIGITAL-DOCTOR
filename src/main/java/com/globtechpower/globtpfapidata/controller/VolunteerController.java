/*package com.globtechpower.globtpfapidata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import com.globtechpower.globtpfapidata.model.Volunteer;
import com.globtechpower.globtpfapidata.model.VolunteerImage;
import com.globtechpower.globtpfapidata.repository.VolunteerRepository;
import com.globtechpower.globtpfapidata.service.VolunteerServices;

@RestController
@CrossOrigin(origins = "*")
public class VolunteerController {

    @Autowired
    VolunteerServices volunteerServices;

    @PostMapping(value = { "/createVolunteer" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public List<Volunteer> addVolunteer(@RequestPart("volunteer") Volunteer volunteer,
                                        @RequestPart("image") MultipartFile image) {
        try {
            // Handle image upload
            VolunteerImage img = uploadImage(image);
            volunteer.setVolunteerImages(Set.of(img));
            return volunteerServices.addData(volunteer);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
            return null;
        }
    }

    @GetMapping("sec/showVolunteer")
    public List<Volunteer> getAllVolunteers() {
        return volunteerServices.showData();
    }

    public VolunteerImage uploadImage(MultipartFile multipartFile) throws IOException {
        // Create VolunteerImage object from MultipartFile
        VolunteerImage volunteerImg = new VolunteerImage(multipartFile.getOriginalFilename(),
                                                         multipartFile.getContentType(),
                                                         multipartFile.getBytes());
        return volunteerImg;
    }
}
*/


package com.globtechpower.globtpfapidata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.globtechpower.globtpfapidata.model.Volunteer;
import com.globtechpower.globtpfapidata.model.VolunteerImage;
import com.globtechpower.globtpfapidata.service.VolunteerServices;

@RestController
//@CrossOrigin(origins = "*",allowedHeaders = "*",exposedHeaders = "*")
public class VolunteerController {

    @Autowired
    VolunteerServices volunteerServices;

    @PostMapping(value = { "/createVolunteer" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<List<Volunteer>> addVolunteer(@RequestPart("volunteer") Volunteer volunteer,
                                                        @RequestPart("image") MultipartFile image) {
        try {
            // Handle image upload
            VolunteerImage img = uploadImage(image);
            volunteer.setVolunteerImages(Set.of(img));
            List<Volunteer> result = volunteerServices.addData(volunteer);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("sec/showVolunteer")
    public ResponseEntity<List<Volunteer>> getAllVolunteers() {
        List<Volunteer> volunteers = volunteerServices.showData();
        return new ResponseEntity<>(volunteers, HttpStatus.OK);
    }

    public VolunteerImage uploadImage(MultipartFile multipartFile) throws IOException {
        // Create VolunteerImage object from MultipartFile
        VolunteerImage volunteerImg = new VolunteerImage(multipartFile.getOriginalFilename(),
                                                         multipartFile.getContentType(),
                                                         multipartFile.getBytes());
        return volunteerImg;
    }
}
