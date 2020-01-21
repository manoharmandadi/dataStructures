package com.manosoft.datastructures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manosoft.datastructures.linear.Stack;
import com.manosoft.datastructures.model.Person;

@RestController
@RequestMapping("stack")
public class StackController {

    private static final Logger logger = LoggerFactory.getLogger(StackController.class);
    
    @Value("${app.name: dataStructures}")
    private String appName;
    
    private Stack stack = new Stack(10);
    
    @PostMapping(path = "push", consumes = MediaType.APPLICATION_JSON_VALUE )
    public void push(@RequestBody Person person) {
        logger.debug(appName+ " Stack.Push:" + person.getFirstName());
        stack.push(person);
    }

    @GetMapping(path = "pop" )
    public Object pop() {
        logger.info("Stack.Pop:" );
        return stack.pop();
    }
}
