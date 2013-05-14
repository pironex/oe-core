DESCRIPTION = "Python Documentation Utilities."
HOMEPAGE = "http://docutils.sourceforge.net/"
SECTION = "devel/python"
LICENSE = "Python BSD GPL3"
LIC_FILES_CHKSUM = " \
   file://licenses/python-2-1-1.txt;md5=e698000816f962cbe2532d8f555b645d \
   file://licenses/BSD-2-Clause.txt;md5=a8243e503f772119249d1e6a35fd9211 \
   file://licenses/gpl-3-0.txt;md5=d32239bcb673463ab874e80d47fae504 \
"

DEPENDS = "python3"

RDEPENDS_${PN} = " \
                   python3-compression \
                   python3-codecs \
                   python3-core \
                   python3-io \
                   python3-netclient \
                   python3-pickle \
                   python3-pprint \
                   python3-re \
                   python3-textutils \
                   python3-xml \
                 "
SRCNAME = "docutils"
PR = "r1"

SRC_URI = "\
  http://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "d8d4660c08302c791b2d71a155a2f4bc"
SRC_URI[sha256sum] = "370624e61b6773da2f2fb17cc2a4eaea4bb596c3585d13f75ff193c1c738603e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools3
