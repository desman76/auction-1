package io.khasang.auction.controller;

import io.khasang.auction.entity.Bird;
import io.khasang.auction.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bird")
public class BirdController {
    @Autowired
    private BirdService birdService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8" )

    @ResponseBody
    public Bird addBird(@RequestBody Bird bird){
         birdService.add(bird);
         return bird;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Bird getBirdById(@PathVariable(value = "id") long id){
        return birdService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Bird> getAllBirds(){
        return birdService.getAll();
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Bird updateBird(@RequestBody Bird bird){
        return birdService.update(bird);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Bird deleteBird(@PathVariable(value = "id") long id){
        return birdService.delete(id);
    }
}
