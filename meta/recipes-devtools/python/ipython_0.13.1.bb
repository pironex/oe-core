SUMMARY = "Enhanced Python Shell"
DESCRIPTION = "Enhanced Python Shell -- A really great shell."
HOMEPAGE = "http://ipython.org/"
SECTION = "devel/python"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://docs/source/about/license_and_copyright.txt;md5=3311a509e946df2ddf84507563e7b504"

RPROVIDES_${PN} = "ipython"
DEPENDS = "less"
RDEPENDS_${PN} = " \
                  python-core \
                  python-codecs \
                  python-crypt \
                  python-datetime \
                  python-debugger \
                  python-distribute \
                  python-distutils \
                  python-io \
                  python-json \
                  python-lang \
                  python-misc \
                  python-modules \
                  python-netclient \
                  python-pickle \
                  python-pkgutil \
                  python-pprint \
                  python-pydoc \
                  python-resource \
                  python-shell \
                  python-stringold \
                  python-subprocess \
                  python-terminal \
                  python-textutils \
                  python-threading \
                  python-unixadmin \
                "

SRC_URI = "http://archive.ipython.org/release/${PV}/ipython-${PV}.tar.gz \
           file://001-completer-across-raw-types.patch \
          "

inherit setuptools

FILES_${PN} = "/"

SRC_URI[md5sum] = "ca7e75f7c802afc6aaa0a1ea59846420"
SRC_URI[sha256sum] = "3bbf1095c4fd1fbf0a0871d9e26571a1ce3c4113d83ee3b688fa58e7e917f8c0"
