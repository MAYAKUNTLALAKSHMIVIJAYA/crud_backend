package com.klu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppController {
    
    @Autowired
    Service s;

    // Root landing page
    @GetMapping("/")
    public String home() {
        return "✅ SpringApp1 is running! Available endpoints: "
                + "[/insert - POST], "
                + "[/display - GET], "
                + "[/update - PUT]";
    }

    @PostMapping("/insert")
    public String insert(@RequestBody Product p) {
        return s.insertData(p);
    }

    @GetMapping("/display")
    public List<Product> display() {
        return s.displayData();
    }

    @PutMapping("/update")
    public String update(@RequestBody Product p) {
        return s.updateData(p);
    }

    /*
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return s.deleteData(id);
    }
    */
}
