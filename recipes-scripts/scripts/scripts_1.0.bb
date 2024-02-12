SUMMARY = "Useful Scripts"
DESCRIPTION = "Copy all scripts that can be used by the user."
LICENSE = "CLOSED"

LIC_FILES_CHKSUM = ""
BB_STRICT_CHECKSUM = "0"

inherit allarch
inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "keyboard-core-boot.service"

# file location
SRC_URI = "\
        file://keyboard_led_test.sh \
        file://keyboard-core-boot.service \
"

S = "${WORKDIR}"

MY_DESTINATION = "/home/root/scripts"

do_install:append(){
        install -d -m 0755 ${D}${MY_DESTINATION}
        cp ${S}/keyboard_led_test.sh ${D}${MY_DESTINATION}
        
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/keyboard-core-boot.service ${D}${systemd_system_unitdir}
}

FILES:${PN} += "\
        ${MY_DESTINATION} \
        ${systemd_system_unitdir}/keyboard-core-boot.service \
"

# As it likely to be a different arch from the Yocto build, disable checking by adding "arch" to INSANE_SKIP
INSANE_SKIP:${PN} += "arch"
INSANE_SKIP:${PN} += "file-rdeps"
