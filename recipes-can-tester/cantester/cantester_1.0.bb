SUMMARY = "CAN-Tester python application copy to rootfs"
DESCRIPTION = "Copy all python files required for CAN-Tester"
LICENSE = "CLOSED"

LIC_FILES_CHKSUM = ""
BB_STRICT_CHECKSUM = "0"

inherit allarch
inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "can-tester-boot.service"

SRCREV = "${AUTOREV}" 
#repo address
SRC_URI = "git://github-am.geo.conti.de/ADAS-ICSolutions-GV/CANTester_MultiChannel.git;protocol=https;branch=dev \
            file://can-tester-boot.service \
"

S = "${WORKDIR}/git"

MY_DESTINATION = "/opt"

do_install:append(){
        install -d -m 0755 ${D}${MY_DESTINATION}
        cp -r ${S} ${D}${MY_DESTINATION}
	mv ${D}/opt/git/ ${D}/opt/CANTester/
        
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/can-tester-boot.service ${D}${systemd_system_unitdir}

        chmod +x ${D}/opt/CANTester/scripts/can-tester-start.sh
}

FILES:${PN} += "\
        ${MY_DESTINATION}/CANTester \
        ${systemd_system_unitdir}/can-tester-boot.service \
"

# As it likely to be a different arch from the Yocto build, disable checking by adding "arch" to INSANE_SKIP
INSANE_SKIP:${PN} += "arch"
INSANE_SKIP:${PN} += "file-rdeps"

