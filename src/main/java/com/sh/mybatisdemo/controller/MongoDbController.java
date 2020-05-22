package com.sh.mybatisdemo.controller;

import com.mongodb.client.result.UpdateResult;
import com.sh.mybatisdemo.dao.BookRepository;
import com.sh.mybatisdemo.entity.Book;
import com.sh.mybatisdemo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By Sunhu At 2020/5/21 19:24
 *
 * @author Sun
 */
@RestController
@RequestMapping("/mongoDb")
public class MongoDbController {


    @Autowired
    private MongoService mongoService;


    @Autowired
    BookRepository bookRepository;

    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Book book)
    {
        return mongoService.saveBook(book);
    }



    @GetMapping("/findAll")
    public List<Book> findAll()
    {
        return mongoService.findAll();
    }


    @GetMapping("/findById")
    public Book findById(@RequestParam(name = "id") String id){
        return mongoService.findById(id);
    }

    @GetMapping("/findByName")
    public Book findByName(String name)
    {
        return bookRepository.findBookByName(name);
    }

    //@GetMapping("/updateBook")
    //public String updateBook(@Req){
    //
    //}

    //@GetMapping("/findLikes")
    //public List<Book> findLikes(@RequestParam String search){
    //    return mongoService.findLikes(search);
    //}

    @PostMapping("/updateOne")
    public UpdateResult updateOne( Book book)
    {
        return mongoService.updateOne(book);
    }

    //
    //@PostMapping("/updatePrice")
    //public String updatePrice(String id,String price)
    //{
    //    return mongoService.updatePrice(price);
    //}
}
