DESCRIPTION = "Video auto login for root user"
LICENSE = "CLOSED"

# Define a variable to hold the list of systemd unit config files to be modified.
# Modify the video console config files.
LOCAL_GETTY := " \
     ${IMAGE_ROOTFS}${systemd_system_unitdir}/getty@.service \
"
# Define a function that modifies the systemd unit config files with the autologin arguments
local_autologin () {
    sed -i -e 's|ExecStart=-/sbin/agetty -o '-p -- \\u' --noclear - $TERM|ExecStart=-/sbin/agetty -o --autologin root '-f -p -- \\u' --noclear - $TERM|g' ${LOCAL_GETTY}
}

# Add the function so that it is executed after the rootfs has been generated
ROOTFS_POSTPROCESS_COMMAND += "local_autologin; "