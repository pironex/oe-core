SUMMARY = "Pure Python Templating System."
HOMEPAGE = " http://jinja.pocoo.org/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=782689a6f9cc3482c3b8b39c552f1cf8"

DEPENDS = "python3"

RDEPENDS_${PN} = " \
                   python3-codecs \
                   python3-core \
                   python3-re \
                 "
SRCNAME = "Jinja"
PR = "r1"

SRC_URI = "\
  http://pypi.python.org/packages/source/J/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "1235a005ade00b213800ff1e798c0241"
SRC_URI[sha256sum] = "36252f3d0356008a31a537a31cfba189f7b5898b8e2da454f72ea5f987db8b31"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools3 python3native

do_sanitize() {

    # it seems that the installer is not ready for python3.  Upconvert...
    ${STAGING_BINDIR_NATIVE}/${PYTHON_PN}-native/${PYTHON_PN} ${STAGING_BINDIR_NATIVE}/${PYTHON_PN}-native/2to3 -w .

    # this looks like a broken 2to3 fixer.  Help it out.
    sed -E -i'.tweak' -e 's/__nonzero__/__bool__/g' jinja/datastructure.py
}

FILES_${PN}-doc += "${datadir}/docs"

addtask sanitize after do_unpack before do_patch
