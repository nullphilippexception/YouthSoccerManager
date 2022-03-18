package com.example.youthsoccermanager.dataclasses.personnel;

import com.example.youthsoccermanager.dataclasses.attributeenums.EAttitude;

/**
 *  Personnel is the superclass for all the different kinds of people that can be employed by a soccer team
 *  (excluding the players), like head coaches, assistant coaches, trainers, doctors etc.
 * @author Philipp S.
 */
public abstract class Personnel {
    private String name;
    private int age;
    private int salary;
    private int contract_length;
    private String jobTitle;
    private String experience;
    private int morale;
    private EAttitude attitude;
    private int availableTime;
}
