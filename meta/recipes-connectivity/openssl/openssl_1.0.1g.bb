require openssl.inc

# For target side versions of openssl enable support for OCF Linux driver
# if they are available.
DEPENDS += "ocf-linux"

CFLAG += "-DHAVE_CRYPTODEV -DUSE_CRYPTODEV_DIGESTS"

LIC_FILES_CHKSUM = "file://LICENSE;md5=f9a8f968107345e0b75aa8c2ecaa7ec8"

export DIRS = "crypto ssl apps engines"
export OE_LDFLAGS="${LDFLAGS}"

SRC_URI += "file://configure-targets.patch \
            file://shared-libs.patch \
            file://oe-ldflags.patch \
            file://engines-install-in-libdir-ssl.patch \
            file://openssl-fix-link.patch \
            file://debian/version-script.patch \
            file://debian/pic.patch \
            file://debian/c_rehash-compat.patch \
            file://debian/ca.patch \
            file://debian/make-targets.patch \
            file://debian/no-rpath.patch \
            file://debian/man-dir.patch \
            file://debian/man-section.patch \
            file://debian/no-symbolic.patch \
            file://debian/debian-targets.patch \
            file://openssl_fix_for_x32.patch \
            file://openssl-fix-doc.patch \
            file://fix-cipher-des-ede3-cfb1.patch \
            file://openssl-avoid-NULL-pointer-dereference-in-EVP_DigestInit_ex.patch \
            file://openssl-avoid-NULL-pointer-dereference-in-dh_pub_encode.patch \
            file://0001-Add-bit-sliced-AES-for-ARM-NEON.-This-initial-versio.patch \
            file://0002-bsaes-armv7.pl-change-preferred-contact.patch \
            file://0003-bsaes-armv7.pl-optmize-Sbox-and-key-conversion.patch \
            file://0004-bsaes-armv7.pl-minor-performance-squeeze-on-Snapdrag.patch \
            file://0005-bsaes-armv7.pl-even-closer-shave.patch \
            file://0006-bsaes-armv7.pl-closest-shave.-While-0.3-cpb-improvem.patch \
            file://0007-bsaes-armv7.pl-take-it-into-build-loop.patch \
            file://0008-bsaes-armv7.pl-add-bsaes_cbc_encrypt-and-bsaes_ctr32.patch \
            file://0009-Added-support-for-ARM-NEON-based-bit-sliced-AES-in-X.patch \
            file://0010-bsaes-armv7.pl-remove-byte-order-dependency-and-mino.patch \
            file://0011-bsaes-armv7.pl-remove-partial-register-operations-in.patch \
            file://find.pl \
            file://openssl-fix-des.pod-error.patch \
            file://Makefiles-ptest.patch \
            file://run-ptest \
           "

SRC_URI[md5sum] = "de62b43dfcd858e66a74bee1c834e959"
SRC_URI[sha256sum] = "53cb818c3b90e507a8348f4f5eaedb05d8bfe5358aabb508b7263cc670c3e028"

PACKAGES =+ " \
	${PN}-engines \
	${PN}-engines-dbg \
	"

FILES_${PN}-engines = "${libdir}/ssl/engines/*.so ${libdir}/engines"
FILES_${PN}-engines-dbg = "${libdir}/ssl/engines/.debug"

PARALLEL_MAKE = ""
PARALLEL_MAKEINST = ""

do_configure_prepend() {
  cp ${WORKDIR}/find.pl ${S}/util/find.pl
}
