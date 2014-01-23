MAJOR_VERSION = "2.23"
require util-linux.inc

# To support older hosts, we need to patch and/or revert
# some upstream changes.  Only do this for native packages.
OLDHOST = ""
OLDHOST_class-native = "file://util-linux-native.patch"

SRC_URI += "file://util-linux-ng-replace-siginterrupt.patch \
            file://util-linux-ng-2.16-mount_lock_path.patch \
            file://uclibc-__progname-conflict.patch \
            file://configure-sbindir.patch \
            file://fix-configure.patch \
            ${OLDHOST} \
"

SRC_URI[md5sum] = "b39fde897334a4858bb2098edcce5b3f"
SRC_URI[sha256sum] = "7c4042bd91f621250d7b3b2f34e3b11921a32c7f080c149dcc0c7ce62a8a7cac"

CACHED_CONFIGUREVARS += "scanf_cv_alloc_modifier=as"
EXTRA_OECONF_class-native = "${SHARED_EXTRA_OECONF} \
                             --disable-fallocate --disable-use-tty-group \
"
EXTRA_OECONF_class-nativesdk = "${SHARED_EXTRA_OECONF} \
                                --disable-fallocate --disable-use-tty-group \
"

BBCLASSEXTEND = "native nativesdk"

