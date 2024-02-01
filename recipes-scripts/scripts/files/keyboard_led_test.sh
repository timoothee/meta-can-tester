#! /bin/bash

echo 1 | tee '/sys/class/leds/input0::capslock/brightness'
sleep 1
echo 0 | tee '/sys/class/leds/input0::capslock/brightness'
sleep 1
echo 1 | tee '/sys/class/leds/input0::capslock/brightness'
sleep 1
echo 0 | tee '/sys/class/leds/input0::capslock/brightness'
sleep 1
echo 0 | tee '/sys/class/leds/input0::capslock/brightness'
sleep 1
echo 1 | tee '/sys/class/leds/input0::capslock/brightness'
sleep 1
echo 0 | tee '/sys/class/leds/input0::capslock/brightness'