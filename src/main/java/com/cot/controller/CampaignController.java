package com.cot.controller;

import com.cot.domain.Campaign;
import com.cot.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaign")
@AllArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping(value = "/{campaignId}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable Long campaignId) {
        return new ResponseEntity<>(campaignService.findById(campaignId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Campaign>> getCampaigns() {
        return new ResponseEntity<>(campaignService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Campaign> create(@RequestBody Campaign campaign) {
        return new ResponseEntity<>(campaignService.save(campaign), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{campaignId}")
    public ResponseEntity<Campaign> update(@RequestBody Campaign campaign) {
        return new ResponseEntity<>(campaignService.save(campaign), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{campaignId}")
    public ResponseEntity<Void> delete(@PathVariable Long campaignId) {
        campaignService.delete(campaignId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
