#! /bin/bash

echo 1 | sudo tee '/sys/class/leds/input0::capslock/brightness'
sleep 1
echo 0 | sudo tee '/sys/class/leds/input0::capslock/brightness'