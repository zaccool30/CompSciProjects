#pragma config(Sensor, dgtl8,  sonarSensor,         sensorSONAR_cm)
#pragma config(Motor,  port2,           rightMotor,    tmotorNormal, openLoop, reversed)
#pragma config(Motor,  port3,           leftMotor,     tmotorNormal, openLoop)
//
//  sonar.c
//  
//
//  Created by Zac Schulwolf on 7/29/14.
//
//
task main()
{
    wait1Msec(2000);  // Robot waits for 2000 milliseconds before executing program
    
    while(SensorValue(sonarSensor) > 20  || SensorValue(sonarSensor) == -1)  // Loop while robot's Ultrasonic sensor is further than 20 cm away from an object
    {                                                                        // || (or) it is '-1'.  (-1 is the value returned when nothing is in it's visable range)
        motor[rightMotor] = 63;  // Motor on port2 is run at half (63) power forward
        motor[leftMotor]  = 63;  // Motor on port3 is run at half (63) power forward
    }
}