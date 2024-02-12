do_deploy:append() {
    echo "# Disable Wi-Fi" >> $CONFIG
    echo "dtoverlay=disable-wifi" >> $CONFIG

    echo "# Disable Bluetooth" >> $CONFIG
    echo "dtoverlay=disable-bt" >> $CONFIG
}