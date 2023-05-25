package com.example.firebasecrudspringboot;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class CRUDController {

    public CRUDService crudService;

    public CRUDController(CRUDService crudService) {
        this.crudService = crudService;
    }

    @PostMapping("/create")
    public String create(@RequestBody CRUD crud) throws InterruptedException, ExecutionException {
        return crudService.create(crud);
    }

    @GetMapping("/get")
    public CRUD get(@RequestParam String documentId) throws InterruptedException, ExecutionException {
        return crudService.get(documentId);
    }

    @PutMapping("/update")
    public String get(@RequestBody CRUD crud) throws InterruptedException, ExecutionException {
        return crudService.update(crud);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String documentId) throws InterruptedException, ExecutionException {
        return crudService.delete(documentId);
    }

}
