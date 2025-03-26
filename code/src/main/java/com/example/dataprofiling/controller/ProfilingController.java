
package com.example.dataprofiling.controller;

import com.example.dataprofiling.model.ProfilingResult;
import com.example.dataprofiling.service.ProfilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/profiling")
public class ProfilingController {

    @Autowired
    private ProfilingService profilingService;

    @PostMapping("/upload")
    public List<ProfilingResult> handleFileUpload(@RequestParam("file") MultipartFile file) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return profilingService.generateProfilingRules(data);
    }
}
