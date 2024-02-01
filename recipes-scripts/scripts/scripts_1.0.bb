SUMMARY = "Useful Scripts"
DESCRIPTION = "Copy all scripts that can be used by the user."
LICENSE = "CLOSED"

LIC_FILES_CHKSUM = ""
BB_STRICT_CHECKSUM = "0"

# file location
SRC_URI = "file://keyboard_led_test.sh"

S = "${WORKDIR}"

MY_DESTINATION = "/home/root/scripts"

inherit allarch

do_install:append(){
        install -d -m 0755 ${D}${MY_DESTINATION}
        cp ${S}/keyboard_led_test.sh ${D}${MY_DESTINATION}
}

FILES:${PN} += "${MY_DESTINATION}"
# As it likely to be a different arch from the Yocto build, disable checking by adding "arch" to INSANE_SKIP
INSANE_SKIP:${PN} += "arch"
INSANE_SKIP:${PN} += "file-rdeps"
