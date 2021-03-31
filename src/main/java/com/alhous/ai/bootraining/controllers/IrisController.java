package com.alhous.ai.bootraining.controllers;

import com.alhous.ai.bootraining.dataview.DatasetViewer;
import com.alhous.ai.bootraining.iris.IrisService;
import com.alhous.ai.bootraining.iris.ModelConfig;

import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 

@Controller
public class IrisController {
    @Autowired 
    private IrisService service;

    @Autowired 
    private ModelConfig mConfig;

    @Autowired 
    private DatasetViewer dataview;

    

    @GetMapping({"/","/index"})
    public String home(Model model) {
        model.addAttribute("irisData", dataview.iridData(dataview.irisIterator()));
        return "index";
    }
}
