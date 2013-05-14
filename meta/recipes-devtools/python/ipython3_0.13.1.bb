SUMMARY = "Enhanced Python Shell - Python3"
DESCRIPTION = "Enhanced Python3 Shell -- A really great shell."
HOMEPAGE = "http://ipython.org/"
SECTION = "devel/python"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://docs/source/about/license_and_copyright.txt;md5=3311a509e946df2ddf84507563e7b504"

SRCNAME = "ipython"
RPROVIDES_${PN} = "ipython3"
DEPENDS = "less"
RDEPENDS_${PN} = " \
                  python3-compression \
                  python3-core \
                  python3-codecs \
                  python3-ctypes \
                  python3-crypt \
                  python3-datetime \
                  python3-debugger \
                  python3-distribute \
                  python3-distutils \
                  python3-doctest \
                  python3-io \
                  python3-json \
                  python3-lang \
                  python3-logging \
                  python3-math \
                  python3-misc \
                  python3-modules \
                  python3-netclient \
                  python3-pickle \
                  python3-pkgutil \
                  python3-pprint \
                  python3-pydoc \
                  python3-re \
                  python3-readline \
                  python3-resource \
                  python3-shell \
                  python3-stringold \
                  python3-subprocess \
                  python3-terminal \
                  python3-textutils \
                  python3-threading \
                  python3-unittest \
                  python3-unixadmin \
                "
RRECOMMENDS_${PN} = " \
                  python3-nose \
                  python3-pyzmq \
                  "

SRC_URI = "http://archive.ipython.org/release/${PV}/ipython-${PV}.tar.gz \
           file://001-completer-across-raw-types.patch \
          "

# pick up the v3 toolset
inherit setuptools3

FILES_${PN} = "/"

SRC_URI[md5sum] = "ca7e75f7c802afc6aaa0a1ea59846420"
SRC_URI[sha256sum] = "3bbf1095c4fd1fbf0a0871d9e26571a1ce3c4113d83ee3b688fa58e7e917f8c0"

S = "${WORKDIR}/${SRCNAME}-${PV}"

#do_unpackpost() {
#  echo "PYTHON_BASEVERSION is " ${PYTHON_BASEVERSION}
#  mv ${S}/../ipython-${PV}/* ${S}
#}

#addtask unpackpost after do_unpack before do_patch
