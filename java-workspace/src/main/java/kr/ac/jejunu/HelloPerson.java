package kr.ac.jejunu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by SeungChan on 2017-05-12.
 */
@Component
public class HelloPerson implements Hello {
    @Value("김승찬")
    private String name;
    @Autowired
    @Qualifier("HelloPerson")
    private Hello hello;

    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
