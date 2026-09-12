package com.manosoft.datastructures.web.controller;

import com.manosoft.datastructures.sort.BubbleSort;
import com.manosoft.datastructures.web.dto.SortResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("datastructures/sort")
public class SortController {

    @PutMapping(value = "sort", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SortResponse<Integer>> sort(@RequestParam(name = "algorithm") String algorithm, @RequestBody List<Integer> values) {

        if(algorithm != null && algorithm.equalsIgnoreCase("BubbleSort")){
            BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>(values.toArray(new Integer[values.size()]));
            SortResponse<Integer> resp = bubbleSort.sort();
            return new ResponseEntity<SortResponse<Integer>>(resp, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }


    }
}
