package com.pickspot.pickspot.controller;

import com.pickspot.pickspot.dto.PickRequest;
import com.pickspot.pickspot.dto.PickResponse;
import com.pickspot.pickspot.service.PickerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;



@RestController

public class PickController {


    private final PickerService picker;

    public PickController(PickerService picker) {
        this.picker = picker;
    }

    @PostMapping("/pickSpot")
    public ResponseEntity<?> pick(@RequestBody PickRequest req) {
        return picker.chooseBestSlot(req.container, req.yardMap)
                .<ResponseEntity<?>>map(s -> ok(new PickResponse(req.container.id, s.x, s.y)))
                .orElseGet(() ->  ResponseEntity.badRequest().body(Map.of("error", "no suitable slot")));
    }
}







