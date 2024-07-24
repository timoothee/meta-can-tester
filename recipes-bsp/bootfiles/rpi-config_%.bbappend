do_deploy:append() {
    echo "# Disable Bluetooth" >> $CONFIG
    echo "dtoverlay=disable-bt" >> $CONFIG

    echo "# Enable SPI" >> $CONFIG
    echo "dtparam=spi=on" >> $CONFIG

    echo "# Enable Seeed CAN Hat " >> $CONFIG
    echo "dtoverlay=seeed-can-fd-hat-v2" >> $CONFIG

    echo "# Enable USB interface " >> $CONFIG
    echo "dtoverlay=dwc2" >> $CONFIG
    echo "dr_mode=host" >> $CONFIG

    echo "# Display Resolution" >> $CONFIG
    echo "[pi4]" >> $CONFIG
    echo "hdmi_force_hotplug=1" >> $CONFIG
    echo "# Sets display to 1920 x 1080 resolution, 60Hz, 16:9" >> $CONFIG
    echo "hdmi_cvt=1920 1080 60 3" >> $CONFIG
    echo "hdmi_group:0=2" >> $CONFIG
    echo "hdmi_mode:0=87" >> $CONFIG
    echo "[all]" >> $CONFIG
}