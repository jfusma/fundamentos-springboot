package com.platzi.springboot.fundamentos.component;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Component;

@Component
public class MyFirstComponentImpl implements MyFirstComponent {


    @Override
    public void sayHello() {
        System.out.println("say hello from my first component implementation");
    }
}
