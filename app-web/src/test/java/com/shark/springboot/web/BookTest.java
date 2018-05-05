package com.shark.springboot.web;

import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by tuze on 2017/12/4.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookTest {


    @Test
    public void readDocument(){
        String json = "{ \"store\": { \"book\": [ { \"category\": \"reference\", \"author\": \"Nigel Rees\", \"title\": \"Sayings of the Century\", \"price\": 8.95 }, { \"category\": \"fiction\", \"author\": \"Evelyn Waugh\", \"title\": \"Sword of Honour\", \"price\": 12.99 }, { \"category\": \"fiction\", \"author\": \"Herman Melville\", \"title\": \"Moby Dick\", \"isbn\": \"0-553-21311-3\", \"price\": 8.99 }, { \"category\": \"fiction\", \"author\": \"J. R. R. Tolkien\", \"title\": \"The Lord of the Rings\", \"isbn\": \"0-395-19395-8\", \"price\": 22.99 } ], \"bicycle\": { \"color\": \"red\", \"price\": 19.95 } }, \"expensive\": 10 }";
        List<String> read = JsonPath.read(json, "$.store.book[*].author");
        log.info("{}", read);
    }

    @Test
    public void readFile() throws IOException {

        InputStream resourceAsStream = this.getClass().getResourceAsStream("/book.json");
        String read = JsonPath.read(resourceAsStream, "$.store.book[1].author");
        log.info("{}", read);

    }


}
