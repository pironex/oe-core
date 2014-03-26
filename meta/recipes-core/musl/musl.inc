# Copyright (C) 2014 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "An implementation of the standard library for Linux-based systems"
DESCRIPTION = "A new standard library to power a new generation of Linux-based devices. \
musl is lightweight, fast, simple, free, and strives to be correct in the sense of \
standards-conformance and safety."

HOMEPAGE = "http://www.musl-libc.org/"
LICENSE = "MIT"
SECTION = "libs"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=044b3bd05ab46fe2f59ab615153adeb9"

PATH_prepend = "${STAGING_BINDIR_TOOLCHAIN}.${STAGINGCC}:"
TOOLCHAIN_OPTIONS = " --sysroot=${STAGING_DIR_TCBOOTSTRAP}"

INHIBIT_DEFAULT_DEPS = "1"

STAGINGCC = "gcc-cross-initial"
STAGINGCC_class-nativesdk = "gcc-crosssdk-initial"

SRCREV = "c3d9d172b1fcd56c4d356798f4e3b4653076bcc3"
PV = "1.1.0+git${SRCPV}"

SRC_URI = "git://git.musl-libc.org/musl \
           file://0001-bits-socket.h-Define-SO_RCVBUFFORCE-for-mips.patch \
           file://0003-stddef-Define-max_align_t.patch \
          "
S = "${WORKDIR}/git"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/lib*${SOLIBSDEV}"
INSANE_SKIP_${PN} = "dev-so"

