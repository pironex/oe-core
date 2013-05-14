DESCRIPTION = "Testing Tools for Python."
HOMEPAGE = "http://readthedocs.org/docs/nose/"
SECTION = "devel/python"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://lgpl.txt;md5=a6f89e2100d9b6cdffcea4f398e37343"

DEPENDS = "python3"
RDEPENDS_${PN} = " \
                   python3-codecs \
                   python3-core \
                   python3-debugger \
                   python3-difflib \
                   python3-doctest \
                   python3-io \
                   python3-logging \
                   python3-pickle \
                   python3-re \
                   python3-textutils \
                   python3-threading \
                   python3-unittest \
                 "
SRCNAME = "nose"
PR = "r1"

SRC_URI = "\
  http://pypi.python.org/packages/source/n/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "735e3f1ce8b07e70ee1b742a8a53585a"
SRC_URI[sha256sum] = "2171e9202d118d302d5db1decb52dd862b79e2a626ca19653a6914574a6ca7d9"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools3
