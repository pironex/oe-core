SUMMARY = "Basic desktop integration functions"

DESCRIPTION = "The xdg-utils package is a set of simple scripts that provide basic \
desktop integration functions for any Free Desktop, such as Linux. \
They are intended to provide a set of defacto standards. \
The following scripts are provided at this time: \
xdg-desktop-icon \     
xdg-desktop-menu \  
xdg-email \ 
xdg-icon-resource \
xdg-mime \       
xdg-open \     
xdg-screensaver \ 
"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a5367a90934098d6b05af3b746405014"

SRC_URI = "git://anongit.freedesktop.org/xdg/xdg-utils \
           file://0001-enable-xdg-terminal.patch"
SRCREV = "869b22b75fc6e7c9e29ba5367bd97ebf7ce76cb3"

S = "${WORKDIR}/git"

inherit autotools

RDEPENDS_${PN} += "xprop"
