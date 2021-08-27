package com.manosoft.datastructures.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manosoft.datastructures.model.SortResponse;
import com.manosoft.datastructures.sort.BubbleSort;

@RestController
@RequestMapping("datastructures/sort")
public class SortController {
    
    @PutMapping(value = "sort", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SortResponse<Integer>> sort(@RequestParam(name = "algorithm") String algorithm, @RequestBody List<Integer> values) {
        
        if(algorithm != null && algorithm.equalsIgnoreCase("BubbleSort")){
            BubbleSort<Integer> bubbleSort = new BubbleSort<>(values.toArray(new Integer[values.size()])); 
            SortResponse<Integer> resp = bubbleSort.sort();
            //Integer[] result = bubbleSort.getSortedArray();
            return new ResponseEntity<SortResponse<Integer>>(resp, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        
        
    }

    
}
