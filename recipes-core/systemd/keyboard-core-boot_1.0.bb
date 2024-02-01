DESCRIPTION = "Keyboard Core booting service"
LICENSE = "CLOSED"

inherit systemd
inherit allarch

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "keyboard-core-boot.service"

SRC_URI = "file://keyboard-core-boot.service"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/keyboard-core-boot.service ${D}${systemd_system_unitdir}
}

FILES:${PN} = "\
    ${systemd_system_unitdir}/keyboard-core-boot.service \
"

RDEPENDS_${PN} += "bash"