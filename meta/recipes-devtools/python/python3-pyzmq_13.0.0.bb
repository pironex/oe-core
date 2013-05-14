SUMMARY = "Python Bindings for ZeroMQ."
HOMEPAGE = " http://github.com/zeromq/pyzmq/"
SECTION = "devel/python"
LICENSE = "BSD LGPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING.BSD;md5=11c65680f637c3df7f58bbc8d133e96e \
                    file://COPYING.LESSER;md5=a9339599829a9d0eb1b314ef43365ab5 \
                   "

DEPENDS = "python3 zeromq"
RDEPENDS_${PN} = " \
                   python3-codecs \
                   python3-core \
                   python3-ctypes \
                   python3-datetime \
                   python3-fcntl \
                   python3-io \
                   python3-logging \
                   python3-math \
                   python3-netclient \
                   python3-threading \
                   zeromq \
                 "
SRCNAME = "pyzmq"

SRC_URI = "\
  http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
  file://0001-Fixed-just-zmq-detection.patch \
"
SRC_URI[md5sum] = "1325ab6819f7a087eee84aaa951b6f0c"
SRC_URI[sha256sum] = "31d8ededdb707f97ffe22963d3f9a721c2330e50904a647cb8d97ec38db43476"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools3
# using linux-${TARGET_ARCH} is wrong here since TARGET_ARCH does not tranlate to
# whatever setup.py expects but we only need to differentiate here between cross and
# native case, and its correct linux-x86_64 for native case so all failed matches will mean
# cross compile which is fine in our case
DISTUTILS_BUILD_ARGS += "--zmq=${STAGING_EXECPREFIXDIR}"

do_compile_prepend () {
        echo "[bdist_egg]" > ${S}/setup.cfg
        echo "plat-name = linux-${TARGET_ARCH}" >> ${S}/setup.cfg
        echo "[global]" >> ${S}/setup.cfg
        echo "skip_check_zmq = True" >> ${S}/setup.cfg
}
