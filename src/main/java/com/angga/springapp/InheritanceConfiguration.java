package com.angga.springapp;

import com.angga.springapp.data.UserServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = UserServiceImpl.class)
public class InheritanceConfiguration {
}
