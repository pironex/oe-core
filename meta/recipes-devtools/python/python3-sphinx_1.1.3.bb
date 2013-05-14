SUMMARY = "Sphinx Documentation System."
HOMEPAGE = "http://sphinx-doc.org/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d06c6f6aa1fbbe0b4752370d26c065eb"

DEPENDS = "python3"

# sqlalchemy jinja docutils
RDEPENDS_${PN} = " \
                   python3-codecs \
                   python3-compression \
                   python3-core \
                   python3-docutils \
                   python3-image \
                   python3-io \
                   python3-jinja \
                   python3-logging \
                   python3-netclient \
                   python3-pickle \
                   python3-pydoc \
                   python3-re \
                   python3-shell \
                   python3-textutils \
                   python3-threading \
                 "
SRCNAME = "Sphinx"
PR = "r1"

SRC_URI = "\
  http://pypi.python.org/packages/source/S/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "8f55a6d4f87fc6d528120c5d1f983e98"
SRC_URI[sha256sum] = "34dc95b70a2b07a61b5d61034c34b05f82514aab54ad27adedb49cee911bb8e9"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools3
