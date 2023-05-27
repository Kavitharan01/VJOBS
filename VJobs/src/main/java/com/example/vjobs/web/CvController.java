package com.example.vjobs.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.vjobs.model.Cv;
import com.example.vjobs.repository.CvRepository;

@Controller
public class CvController {

    @Autowired
    private CvRepository cvRepository;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("regNo") String regNo, @RequestParam("file") MultipartFile file) {
        try {
            Cv cv = new Cv();
            cv.setName(file.getOriginalFilename());
            cv.setData(file.getBytes());
            cv.setRegNo(regNo);
            cvRepository.save(cv);
            return "redirect:/?success";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/?error";
        }
    }

    @GetMapping("/cv")
    public String adminPage(Model model) {
        List<Cv> cvList = cvRepository.findAll();
        model.addAttribute("cvList", cvList);
        return "cv";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("id") Long id) {
        Optional<Cv> cvOptional = cvRepository.findById(id);
        if (cvOptional.isPresent()) {
            Cv cv = cvOptional.get();
            ByteArrayResource resource = new ByteArrayResource(cv.getData());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", cv.getName());
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .body(resource.getByteArray());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


