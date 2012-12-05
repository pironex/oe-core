MAJOR_VERSION = "2.22"
PR = "r2"
require util-linux.inc

SRC_URI += "file://util-linux-ng-replace-siginterrupt.patch \
            file://util-linux-ng-2.16-mount_lock_path.patch \
            file://uclibc-__progname-conflict.patch \
	    file://configure-sbindir.patch \
	    file://fix-configure.patch \
"

SRC_URI[md5sum] = "cad23c41a014af766d467b86628bd0fd"
SRC_URI[sha256sum] = "4297ea2a560f8839d7b3cde72a5955d1458dbad38fe0e3d99ccb1fde3df751b2"

CACHED_CONFIGUREVARS += "scanf_cv_alloc_modifier=as"
EXTRA_OECONF_virtclass-native += "--disable-fallocate --disable-use-tty-group"
