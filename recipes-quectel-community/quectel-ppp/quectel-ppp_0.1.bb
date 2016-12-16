#
# Copy the ppp script files for Quectel chips to the target filesystem
# These files are based on the details provided in 
# Quectel_WCDMA&LTE_Linux_USB_Driver_User_Guide_V1.5.pdf and are shared
# as part of this layer with their permissoin.  
#

SUMMARY = "PPP Scripts for Basic Quectel Chip Operation"
SECTION = "net"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DESCRIPTION = "A set of Linux PPP scripts that provide connect, disconnect and other basic Point-to-Point Protocol functionality for Quectel wireless modems.  "

RDEPENDS_${PN} = "ppp"

SRC_URI += "file://quectel-ppp"
SRC_URI += "file://quectel-chat-connect"
SRC_URI += "file://quectel-chat-disconnect"

S = "${WORKDIR}"

inherit allarch

# Install script on target's root filesystem
do_install () {
    # Install init script and default settings
    # ${sysconfdir}
    install -d ${D}${sysconfdir}/
    install -d ${D}${sysconfdir}/ppp
    install -d ${D}${sysconfdir}/ppp/peers
    install -m 0755 ${S}/quectel-ppp ${D}${sysconfdir}/ppp/peers/
    install -m 0755 ${S}/quectel-chat-connect ${D}${sysconfdir}/ppp/peers/
    install -m 0755 ${S}/quectel-chat-disconnect ${D}${sysconfdir}/ppp/peers/
}

# Mark the files which are part of this package
FILES_${PN} += "{sysconfdir}/ppp/"
FILES_${PN} += "{sysconfdir}/ppp/peers/"
FILES_${PN} += "{sysconfdir}/ppp/peers/quectel-ppp"
FILES_${PN} += "{sysconfdir}/ppp/peers/quectel-chat-connect"
FILES_${PN} += "{sysconfdir}/ppp/peers/quectel-chat-disconnect"

