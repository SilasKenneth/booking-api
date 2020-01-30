package com.assessment.booking.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.util.UUID;

public class Fake {
    public static void main(String[] args) {
        String url = "postgres://username:password@localhost:5432/d4kqugvqm4ccqs";
        String[] parts = url.split("@");
        String[] parts2 = parts[0].split("//");
        String[] usernamePassword = parts2[1].split(":");
        String username = usernamePassword[0];
        String password = usernamePassword[1];
        String real = "jdbc:"+parts2[0]+"//"+parts[1];
        System.out.println(real);

        System.out.println(UUID.randomUUID());
        System.out.println(Instant.now());
    }
}
