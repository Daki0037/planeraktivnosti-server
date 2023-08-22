package me.danilo.planeraktivnosti.controller;

import me.danilo.planeraktivnosti.model.Activity;
import me.danilo.planeraktivnosti.repository.ActivityRepostitory;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    private ActivityRepostitory activityRepostitory;

    @Autowired
    public ActivityController(ActivityRepostitory activityRepostitory) {
        this.activityRepostitory = activityRepostitory;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addNewActivity(@RequestBody Activity activity) {
        activityRepostitory.save(activity);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public List<Activity> getActivityFromUser(@PathVariable int userId) {
        return activityRepostitory.findActivityByUserId(userId);
    }

    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateActivity(@RequestBody Activity activity) {
        activityRepostitory.save(activity);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> deleteActivity(@RequestBody Activity activity) {
        activityRepostitory.delete(activity);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
