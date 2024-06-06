package com.globtechpower.globtpfapidata.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.globtechpower.globtpfapidata.model.ReasonImage;
import com.globtechpower.globtpfapidata.model.Reasons;
import com.globtechpower.globtpfapidata.repository.ReasonRepository;
import com.globtechpower.globtpfapidata.service.ReasonServices;

@RestController
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
//@CrossOrigin(origins = "http://localhost:4200")
public class ReasonController {

    @Autowired
    ReasonServices reasonService;
    
    @Autowired
    ReasonRepository reasonRep;

   /* @PostMapping(value = "sec/createreason", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<List<Reasons>> addReason(@RequestPart("reasons") Reasons reason,
            @RequestPart("image") MultipartFile image) {
        try {
            // Handle image upload
            ReasonImage img = uploadImage(image);
            reason.getReasonImages().add(img);
            List<Reasons> addedReasons = reasonService.addReasons(reason);
            return ResponseEntity.ok(addedReasons);
        } catch (IOException e) {
            e.printStackTrace(); // Log the error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Return appropriate error response
        }
    }*/
    
    @PostMapping(value = "sec/createreason", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<List<Reasons>> addReason(@RequestPart("reasons") Reasons reason,
            @RequestPart("image") MultipartFile image) {
        try {
            // Initialize reasonImages if it is null
            if (reason.getReasonImages() == null) {
                reason.setReasonImages(new HashSet<>());
            }

            // Handle image upload
            ReasonImage img = uploadImage(image);
            reason.getReasonImages().add(img);
            List<Reasons> addedReasons = reasonService.addReasons(reason);
            return ResponseEntity.ok(addedReasons);
        } catch (IOException e) {
            e.printStackTrace(); // Log the error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Return appropriate error response
        }
    }


    private ReasonImage uploadImage(MultipartFile multipartFile) throws IOException {
        // Create ReasonImage object from MultipartFile
        return new ReasonImage(multipartFile.getOriginalFilename(), multipartFile.getContentType(),
                multipartFile.getBytes());
    }

    @GetMapping("/showreasons")
    public List<Reasons> showReasons() {
        return reasonService.showReasons();
    }
    
    @GetMapping("deletereason/{id}")
    public void deleteReason(@PathVariable Long id) {
    	reasonRep.deleteById(id);
    }
    
    @GetMapping("/viewmore/{title}")
    public List<Reasons> viewmore(@PathVariable String title){
    	return reasonService.getReasonByTitile(title);
    }
}
