# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

IMAGE_INSTALL:append = " \ 
			nano \
			cantester \
			scripts \
			python3 \
			python3-pip \
			rpi-gpio \
			python3-psutil \
			python3-pillow \
"

IMAGE_FEATURES += "x11-base x11-sato hwcodecs"

# Define a variable to hold the list of systemd unit config files to be modified.
# Modify the video console config files.
LOCAL_GETTY := " \
     ${IMAGE_ROOTFS}${systemd_system_unitdir}/getty@.service \
"
# Define a function that modifies the systemd unit config files with the autologin arguments
local_autologin () {
	sed -i -e 's/^\(ExecStart *=.*getty \)/\1--autologin root /' ${LOCAL_GETTY}
}

# Add the function so that it is executed after the rootfs has been generated
ROOTFS_POSTPROCESS_COMMAND += "local_autologin; "