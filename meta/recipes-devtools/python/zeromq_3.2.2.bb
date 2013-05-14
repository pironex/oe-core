SUMMARY = "ZeroMQ - Intelligent Transport Layer"
HOMEPAGE = " http://github.com/zeromq/pyzmq/"
SECTION = "devel/python"
LICENSE = "LGPL-3.0 + EXCEPTION"
LIC_FILES_CHKSUM = " \
                    file://COPYING.LESSER;md5=ad8c3bd15d88ea9d4509fc89bebc915c \
                   "
#
# libpthread  --  libc
# libuuid     --  util-linux
#
DEPENDS = "util-linux "
RDEPENDS_${PN} = "util-linux "

PR = "r1"

SRC_URI = " \
  http://download.zeromq.org/${PN}-${PV}.tar.gz \
"
SRC_URI[md5sum] = "df68431d9300da84a1a5f9a2784e33de"
SRC_URI[sha256sum] = "2b4eeda60fe47a9fa0804d53d76f656665c5f84dab7e63a1d496d9430b554f99"

inherit autotools binconfig pkgconfig

