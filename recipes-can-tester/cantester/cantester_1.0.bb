SUMMARY = "CAN-Tester python application copy to rootfs"
DESCRIPTION = "Copy all python files required for CAN-Tester"
LICENSE = "CLOSED"

LIC_FILES_CHKSUM = ""
BB_STRICT_CHECKSUM = "0"

SRCREV = "${AUTOREV}" 
#repo address
SRC_URI = "git://github-am.geo.conti.de/ADAS-ICSolutions-GV/CANTester.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

MY_DESTINATION = "/home/root"

inherit allarch

do_install:append(){
        install -d -m 0755 ${D}${MY_DESTINATION}
        cp -r ${S} ${D}${MY_DESTINATION}
		mv ${D}/home/root/git/ ${D}/home/root/CAN-Tester/
}
FILES:${PN} += "${MY_DESTINATION}"
# As it likely to be a different arch from the Yocto build, disable checking by adding "arch" to INSANE_SKIP
INSANE_SKIP:${PN} += "arch"
INSANE_SKIP:${PN} += "file-rdeps"
