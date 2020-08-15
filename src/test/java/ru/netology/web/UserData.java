package ru.netology.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserData {
    private final String name;
    private final String phoneNumber;
    private final String city;
}
