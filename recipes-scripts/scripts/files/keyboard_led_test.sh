#! /bin/bash

for (( i=0 ; i<=3 ; i++ ))
do
    for (( j=1 ; j>=0 ; j-- ))
    do
        echo $j | tee '/sys/class/leds/input0::numlock/brightness'
        sleep 0.05
        echo $j | tee '/sys/class/leds/input0::capslock/brightness'
        sleep 0.05
        echo $j | tee '/sys/class/leds/input0::scrolllock/brightness'
    done
done

chmod +x /opt/CAN-Tester/scripts/can-tester-start.sh